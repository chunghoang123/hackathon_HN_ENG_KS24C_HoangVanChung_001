package re.edu.hackathon.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import re.edu.hackathon.dto.request.*;
import re.edu.hackathon.dto.response.BookResponseDto;
import re.edu.hackathon.entity.Book;
import re.edu.hackathon.exception.CustomException;
import re.edu.hackathon.repository.BookRepository;
import re.edu.hackathon.dto.request.BookPatchDto;

@Service
@RequiredArgsConstructor
public class BookServiceImpl
        implements BookService {

    private final BookRepository bookRepository;

    @Override
    public BookResponseDto create(
            BookRequestDto dto
    ) {

        Book book = Book.builder()
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .price(dto.getPrice())
                .status(dto.getStatus())
                .is_deleted(false)
                .build();

        bookRepository.save(book);

        return mapToDto(book);
    }

    @Override
    public Page<BookResponseDto> getAll(
            String keyword,
            int page,
            int size
    ) {

        Pageable pageable =
                PageRequest.of(page, size);

        return bookRepository
                .search(keyword, pageable)
                .map(this::mapToDto);
    }

    @Override
    public BookResponseDto update(
            Long id,
            BookRequestDto dto
    ) {

        Book book =
                bookRepository.findById(id)
                        .orElseThrow(() ->
                                new CustomException(
                                        "Book không tồn tại"
                                ));

        book.setPrice(dto.getPrice());
        book.setStatus(dto.getStatus());

        bookRepository.save(book);

        return mapToDto(book);
    }

    @Override
    public BookResponseDto patch(
            Long id,
            BookPatchDto dto
    ) {

        Book book =
                bookRepository.findById(id)
                        .orElseThrow(() ->
                                new CustomException(
                                        "Book không tồn tại"
                                ));

        if (dto.getTitle() != null) {
            book.setTitle(dto.getTitle());
        }

        if (dto.getAuthor() != null) {
            book.setAuthor(dto.getAuthor());
        }


        if (dto.getStatus() != null) {
            book.setStatus(dto.getStatus());
        }

        bookRepository.save(book);

        return mapToDto(book);
    }

    @Override
    public void delete(Long id) {

        Book book =
                bookRepository.findById(id)
                        .orElseThrow(() ->
                                new CustomException(
                                        "Book không tồn tại"
                                ));


        bookRepository.save(book);
    }

    private BookResponseDto mapToDto(
            Book medication
    ) {

        return BookResponseDto.builder()
                .id(medication.getId())
                .title(medication.getTitle())
                .author(medication.getAuthor())
                .price(medication.getPrice())
                .status(medication.getStatus())
                .build();
    }
}
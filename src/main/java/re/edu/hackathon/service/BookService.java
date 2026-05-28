package re.edu.hackathon.service;

import org.springframework.data.domain.Page;
import re.edu.hackathon.dto.request.*;
import re.edu.hackathon.dto.response.BookResponseDto;

public interface BookService {

    BookResponseDto create(
            BookRequestDto dto
    );

    Page<BookResponseDto> getAll(
            String keyword,
            int page,
            int size
    );

    BookResponseDto update(
            Long id,
            BookRequestDto dto
    );


    BookResponseDto patch(Long id, BookPatchDto dto);

    void delete(Long id);
}
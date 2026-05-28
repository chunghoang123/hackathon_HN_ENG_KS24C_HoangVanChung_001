package re.edu.hackathon.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import re.edu.hackathon.common.ApiResponse;
import re.edu.hackathon.dto.request.*;
import re.edu.hackathon.dto.response.BookResponseDto;
import re.edu.hackathon.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @PostMapping
    public ApiResponse<?> create(
            @Valid @RequestBody BookRequestDto dto
    ) {

        return ApiResponse.builder()
                .status(201)
                .message("Thêm thành công")
                .data(bookService.create(dto))
                .build();
    }

    @GetMapping
    public ApiResponse<Page<BookResponseDto>> getAll(
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {

        return ApiResponse.<Page<BookResponseDto>>builder()
                .status(200)
                .message("Lấy danh sách thành công")
                .data(
                        bookService.getAll(
                                keyword,
                                page,
                                size
                        )
                )
                .build();
    }

    @PutMapping("/{id}")
    public ApiResponse<?> update(
            @PathVariable Long id,
            @Valid @RequestBody BookRequestDto dto
    ) {

        return ApiResponse.builder()
                .status(200)
                .message("Cập nhật thành công")
                .data(
                        bookService.update(id, dto)
                )
                .build();
    }

    @PatchMapping("/{id}")
    public ApiResponse<?> patch(
            @PathVariable Long id,
            @RequestBody BookPatchDto dto
    ) {

        return ApiResponse.builder()
                .status(200)
                .message("Patch thành công")
                .data(
                        bookService.patch(id, dto)
                )
                .build();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<?> delete(
            @PathVariable Long id
    ) {

        bookService.delete(id);

        return ApiResponse.builder()
                .status(200)
                .message("Xóa thành công")
                .build();
    }
}
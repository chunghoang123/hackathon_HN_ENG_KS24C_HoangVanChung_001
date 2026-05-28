package re.edu.hackathon.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import re.edu.hackathon.entity.BookStatus;

@Getter
@Setter
public class BookRequestDto {
    @NotBlank(message = "Thể loại không được để trống")
    private String title;
    @NotBlank(message = "Tác giả không được để trống")
    private String author;
    @Min(value = 0, message = "Giá phải lớn hơn hoặc bằng 0")
    private double price;

    private BookStatus status;
}
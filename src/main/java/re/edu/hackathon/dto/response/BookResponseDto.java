package re.edu.hackathon.dto.response;

import lombok.*;
import re.edu.hackathon.entity.BookStatus;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookResponseDto {
    private Long id;

    private String title;

    private String author;

    private double price;

    private BookStatus status;
}
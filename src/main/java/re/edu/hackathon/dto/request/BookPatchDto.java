package re.edu.hackathon.dto.request;

import lombok.Getter;
import lombok.Setter;
import re.edu.hackathon.entity.BookStatus;

@Getter
@Setter
public class BookPatchDto {

    private String title;

    private String author;

    private double price;

    private BookStatus status;


}
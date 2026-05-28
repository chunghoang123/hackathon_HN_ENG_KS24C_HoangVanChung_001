package re.edu.hackathon.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "books")
@Builder
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private double price;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Column(name = "is_deleted")
    private boolean is_deleted = false;
}

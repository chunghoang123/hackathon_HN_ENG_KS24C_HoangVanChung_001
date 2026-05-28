package re.edu.hackathon.repository;

import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import re.edu.hackathon.entity.Book;

public interface BookRepository
        extends JpaRepository<Book, Long> {

    @Query("""
        select m from Book m
        where m.is_deleted = false
        and (
            lower(m.title) like lower(concat('%', :keyword, '%'))
            or
            lower(m.author) like lower(concat('%', :keyword, '%'))
        )
    """)
    Page<Book> search(
            @Param("keyword") String keyword,
            Pageable pageable
    );
}
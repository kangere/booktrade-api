package booktrade.api.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@IdClass(AuthorBookPK.class)
@Entity(name = "author_books")
public class AuthorBook {

    @Id
    private Long isbn;

    @Id
    @Column(name = "author_id")
    private Long authorId;

    public AuthorBook(){}

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }
}

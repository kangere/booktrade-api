package booktrade.api.entites;

import java.io.Serializable;

public class AuthorBookPK implements Serializable {


    private Long authorId;

    private Long isbn;

    public AuthorBookPK() {
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof AuthorBookPK)) return false;
        AuthorBookPK pk = (AuthorBookPK)obj;

        return pk.isbn.equals(isbn) && pk.authorId.equals(authorId);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode() + authorId.hashCode();
    }
}

package booktrade.api.entites;


import java.io.Serializable;


public class OwnedBooksPK implements Serializable {

    private String email;

    private Long isbn;

    public OwnedBooksPK(){}

    public OwnedBooksPK(String email, Long isbn){
        this.email = email;
        this.isbn = isbn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
        if (!(obj instanceof OwnedBooksPK)) return false;
        OwnedBooksPK pk = (OwnedBooksPK) obj;
        return pk.isbn.equals(isbn) && pk.email.equals(email);
    }


    @Override
    public int hashCode() {
        return  email.hashCode() + isbn.hashCode();
    }
}

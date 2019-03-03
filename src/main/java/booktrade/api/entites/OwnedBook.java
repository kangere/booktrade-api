package booktrade.api.entites;

import javax.persistence.*;

@IdClass(OwnedBooksPK.class)
@Entity(name = "owned_books")
public class OwnedBook {

    public enum BookCondition{
        USED,LIKE_NEW,NEW,DAMAGED
    }

    public enum TradeType{
        SELL,TRADE,TRADE_OR_SELL
    }

    @Id
    @Column(name = "book_isbn")
    private Long isbn;

    @Id
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "book_condition")
    private BookCondition bookCondition;

    @Column(name = "trade_type")
    @Enumerated(EnumType.STRING)
    private TradeType tradeType;

    @ManyToOne
    @JoinColumn(name = "book_isbn", referencedColumnName = "isbn",updatable = false,insertable = false)
    private Book book;

    public OwnedBook(){}

    public OwnedBook(Long isbn, String email, BookCondition bookCondition, TradeType tradeType, Book book) {
        this.isbn = isbn;
        this.email = email;
        this.bookCondition = bookCondition;
        this.tradeType = tradeType;
        this.book = book;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BookCondition getBookCondition() {
        return bookCondition;
    }

    public void setBookCondition(BookCondition bookCondition) {
        this.bookCondition = bookCondition;
    }

    public TradeType getTradeType() {
        return tradeType;
    }

    public void setTradeType(TradeType tradeType) {
        this.tradeType = tradeType;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}

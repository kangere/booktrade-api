package booktrade.api.entites;

import javax.persistence.*;
import java.math.BigDecimal;

@IdClass(OwnedBooksPK.class)
@Entity(name = "owned_books")
public class OwnedBook {

    public enum BookCondition{
        USED,LIKE_NEW,NEW,DAMAGED
    }

    public enum TradeType{
        SELL,TRADE,TRADE_OR_SELL
    }

    public enum Availability{
        True,False
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

    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Availability  available;




    @ManyToOne
    @JoinColumn(name = "book_isbn", referencedColumnName = "isbn",updatable = false,insertable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email",updatable = false,insertable = false)
    private User user;

    public OwnedBook(){}

    public OwnedBook(Long isbn, String email, BookCondition bookCondition, TradeType tradeType, BigDecimal price, Book book) {
        this.isbn = isbn;
        this.email = email;
        this.bookCondition = bookCondition;
        this.tradeType = tradeType;
        this.book = book;
        this.price =price;
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Availability getAvailable() {
        return available;
    }

    public void setAvailable(Availability available) {
        this.available = available;
    }
}

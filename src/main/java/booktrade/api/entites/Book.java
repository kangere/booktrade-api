package booktrade.api.entites;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;


@Entity(name = "books")
public class Book {

    @Id
    private Long isbn;

    private String title;

    @Column(name = "published_date")
    private Integer publishedDate;

    private String publisher;

    private String language;

    private String description;

    private String thumbnail;




    @Column(name = "external_link")
    private String externalLink;

    @OneToMany
    @JoinTable(
            name = "author_books",
            joinColumns = {@JoinColumn(name = "isbn",referencedColumnName = "isbn")},
            inverseJoinColumns = {@JoinColumn(name="author_id",referencedColumnName = "author_id")}
    )
    private List<Author> authors;



    public Book() {
    }

    public Book(Long isbn, String title, Integer publishedDate, String publisher, String language, String externalLink,
                String description, String thumbnail ) {
        this.isbn = isbn;
        this.title = title;
        this.publishedDate = publishedDate;
        this.publisher = publisher;
        this.language = language;
        this.externalLink = externalLink;
        this.description = description;
        this.thumbnail = thumbnail;
    }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Integer publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}

package booktrade.api.entites;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "requests")
public class Request {


    public enum RequestStatus{
        ACTIVE,DECLINED,RETRACTED,COMPLETED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "request_id")
    private Long requestId;

    @Column(name = "owner_email")
    private String ownerEmail;

    @Column(name = "owner_book")
    private Long ownerBook;

    @Column(name = "requester_email")
    private String requesterEmail;

    @Column(name = "requester_book")
    private Long requesterBook;

    @Enumerated(EnumType.STRING)
    private RequestStatus status;

    @Column(name = "created_at")
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "completed_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedAt;

    @ManyToOne
    @JoinColumn(name = "owner_book", referencedColumnName = "isbn",updatable = false,insertable = false)
    private Book ownedBook;

    @ManyToOne
    @JoinColumn(name = "requester_book", referencedColumnName = "isbn",updatable = false,insertable = false)
    private Book requestersBook;

    public Request(){}

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public Long getOwnerBook() {
        return ownerBook;
    }

    public void setOwnerBook(Long ownerBook) {
        this.ownerBook = ownerBook;
    }

    public String getRequesterEmail() {
        return requesterEmail;
    }

    public void setRequesterEmail(String requesterEmail) {
        this.requesterEmail = requesterEmail;
    }

    public Long getRequesterBook() {
        return requesterBook;
    }

    public void setRequesterBook(Long requesterBook) {
        this.requesterBook = requesterBook;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
    }

    public Book getOwnedBook() {
        return ownedBook;
    }

    public void setOwnedBook(Book ownedBook) {
        this.ownedBook = ownedBook;
    }

    public Book getRequestersBook() {
        return requestersBook;
    }

    public void setRequestersBook(Book requestersBook) {
        this.requestersBook = requestersBook;
    }
}

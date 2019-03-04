package booktrade.api.entites;


import javax.persistence.*;


@Entity(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", updatable = false)
    private Long authorId;


    @Column(name = "fname")
    private String Fname;

    @Column(name = "lname")
    private String Lname;

    @Column(name = "mname")
    private String Mname;


    public Author() {
    }

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        this.Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        this.Lname = lname;
    }


    public String getMname() {
        return Mname;
    }

    public void setMname(String mname) {
        Mname = mname;
    }
}

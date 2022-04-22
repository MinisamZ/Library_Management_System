package lib.model;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "author")
    private String author;
    @Column(name = "year")
    private String year;
    @Column(name = "genre")
    private String genre;
    @Column(name = "number_of_books")
    private int count;

    @OneToMany(targetEntity = LogEntry.class)
    private List logEntry;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String toBString() {
        return "\nBook " +
                "\nid=" + id +
                "\nname='" + name + '\'' +
                "\nauthor='" + author + '\'' +
                "\nyear='" + year + '\'' +
                "\ngenre='" + genre + '\'' +
                "\ncount='" + count + '\'';
    }
}

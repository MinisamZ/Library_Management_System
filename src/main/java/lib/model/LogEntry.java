package lib.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "borrowed_books")
public class LogEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "id_book")
    @JoinColumn(name = "id_book",referencedColumnName = "table_id")
    private Long idBook;
    @Column(name = "id_user")
    @JoinColumn(name = "id_user",referencedColumnName = "id")
    private Long idUser;
    @Column(name = "returned")
    private Boolean returned;
    @Column(name = "date")
    private String date;

    @ManyToOne
    private User user;
    @ManyToOne
    private Book book;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "LogEntry{" + "id=" + id + ", idBook=" + idBook + ", idUser=" + idUser + ", returned=" + returned + ", date='" + date + '\'' + '}';
    }
}

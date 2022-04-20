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
    private Long idBook;
    @Column(name = "id_user")
    private Long idName;
    @Column(name = "returned")
    private Boolean returned;
    @Column(name = "date")
    private String date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "LogEntry{" +
                "id=" + id +
                ", idBook=" + idBook +
                ", idName=" + idName +
                ", returned=" + returned +
                ", date='" + date + '\'' +
                '}';
    }
}

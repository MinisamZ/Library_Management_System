package lib.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long table_id;
    @Column(name = "first_name")
    private String first_name;
    @Column(name = "last_name")
    public String last_name;
    @Column(name="login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "date")
    public String dateLastUpdate;
}

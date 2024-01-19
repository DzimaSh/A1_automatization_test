package by.a1.supplies.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "logins")
@Data
public class Login {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "logins_id_seq"
    )
    @SequenceGenerator(name = "logins_id_seq",
            sequenceName = "logins_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "application")
    private String application;

    @Column(name = "appaccountname", unique = true)
    private String appAccountName;

    @Column(name = "isactive")
    private Boolean isActive;

    @Column(name = "jobtitle")
    private String jobTitle;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "user")
    private List<Posting> postings;
}

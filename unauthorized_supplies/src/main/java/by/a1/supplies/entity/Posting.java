package by.a1.supplies.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "postings")
@Data
public class Posting {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "postings_id_seq"
    )
    @SequenceGenerator(
            name = "postings_id_seq",
            sequenceName = "postings_id_seq",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "matdoc")
    private String matDoc;

    @Column(name = "item")
    private Integer item;

    @Column(name = "docdate")
    private Date docDate;

    @Column(name = "pstngdate")
    private Date pstngDate;

    @Column(name = "materialdescription")
    private String materialDescription;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "bun")
    private String bUn;

    @Column(name = "amountlc")
    private BigDecimal amountLC;

    @Column(name = "crcy")
    private String crcy;

    @Transient
    private String userName;

    @Column(name = "authorized")
    private Boolean authorized;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "appaccountname")
    @ToString.Exclude
    private Login user;
}

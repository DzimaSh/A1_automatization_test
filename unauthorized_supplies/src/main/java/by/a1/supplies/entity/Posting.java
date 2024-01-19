package by.a1.supplies.entity;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvNumber;
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
    @CsvBindByName(column = "Mat. Doc.")
    private String matDoc;

    @Column(name = "item")
    @CsvBindByName(column = "Item")
    private Integer item;

    @Column(name = "docdate")
    @CsvBindByName(column = "Doc. Date")
    @CsvDate(value = "dd.MM.yyyy")
    private Date docDate;

    @Column(name = "pstngdate")
    @CsvBindByName(column = "Pstng Date")
    @CsvDate(value = "dd.MM.yyyy")
    private Date pstngDate;

    @Column(name = "materialdescription")
    @CsvBindByName(column = "Material Description")
    private String materialDescription;

    @Column(name = "quantity")
    @CsvBindByName(column = "Quantity")
    private Integer quantity;

    @Column(name = "bun")
    @CsvBindByName(column = "BUn")
    private String bUn;

    @Column(name = "amountlc")
    @CsvBindByName(column = "Amount LC", locale = "de-DE")
    @CsvNumber(value = "0.0")
    private BigDecimal amountLC;

    @Column(name = "crcy")
    @CsvBindByName(column = "Crcy")
    private String crcy;

    @Transient
    @CsvBindByName(column = "User Name")
    private String userName;

    @Column(name = "authorized")
    private Boolean authorized;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "appaccountname")
    @ToString.Exclude
    private Login user;
}

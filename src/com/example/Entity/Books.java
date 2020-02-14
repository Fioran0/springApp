package com.example.Entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Table(name = "books", schema = "purchase")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Books implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

/*    @MapsId
    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @JoinColumn(name = "book_id", insertable = false, updatable = false)
    @ToString.Exclude
    @JsonIgnore
    @NotFound(action=NotFoundAction.IGNORE)
    private Purchase purchase;*/

    @Column(name = "name")
    private String bookName;

    @Column(name = "cost")
    private Double bookCost;

    @Column(name = "warehouse")
    private String bookWarehouse;

    @Column(name = "quantity")
    private Integer bookQuantity;


    public Books(String bookName, Double bookCost, String bookWarehouse, Integer bookQuantity) {
        this.bookName = bookName;
        this.bookCost = bookCost;
        this.bookWarehouse = bookWarehouse;
        this.bookQuantity = bookQuantity;
    }


}
package com.example.Entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;


@Table(name = "books", schema = "shop")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Books implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @MapsId
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @ToString.Exclude
    @JsonIgnore
    @NotFound(action=NotFoundAction.IGNORE)
    private Purchase purchase;

    @Column(name = "name")
    private String bookName;

    @Column(name = "cost")
    private Double bookCost;

    @Column(name = "warehouse")
    private String bookWarehouse;

    @Column(name = "quantity")
    private Integer bookQuantity;

    public Books(Integer id, String bookName, Double bookCost, String bookWarehouse, Integer bookQuantity) {
        this.id = id;
        this.purchase = new Purchase();
        this.bookName = bookName;
        this.bookCost = bookCost;
        this.bookWarehouse = bookWarehouse;
        this.bookQuantity = bookQuantity;
    }

    public Books(String bookName, Double bookCost, String bookWarehouse, Integer bookQuantity) {
        this.purchase = new Purchase();
        this.bookName = bookName;
        this.bookCost = bookCost;
        this.bookWarehouse = bookWarehouse;
        this.bookQuantity = bookQuantity;
    }

    public Books(String bookName, Double bookCost) {
        this.bookName = bookName;
        this.bookCost = bookCost;
    }

    public Books(String bookName, String bookWarehouse) {
        this.bookName = bookName;
        this.bookWarehouse = bookWarehouse;
    }

    public Books(String bookName, Integer bookQuantity) {
        this.bookName = bookName;
        this.bookQuantity = bookQuantity;
    }

    public Books(Double bookCost, String bookWarehouse) {
        this.bookCost = bookCost;
        this.bookWarehouse = bookWarehouse;
    }

    public Books(String bookName, Double bookCost, String bookWarehouse) {
        this.bookName = bookName;
        this.bookCost = bookCost;
        this.bookWarehouse = bookWarehouse;
    }

    public Books(String bookName, Double bookCost, Integer bookQuantity) {
        this.bookName = bookName;
        this.bookCost = bookCost;
        this.bookQuantity = bookQuantity;
    }

    public Books(Double bookCost, String bookWarehouse, Integer bookQuantity) {
        this.bookCost = bookCost;
        this.bookWarehouse = bookWarehouse;
        this.bookQuantity = bookQuantity;
    }

}
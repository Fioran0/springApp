package com.example.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


@Table(name = "purchase", schema = "purchase")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})

public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "purchase_id")
    private Integer id;

    @Column(name = "ordernumber")
    private Integer OrderNumber;

    @Column(name = "createdat")
    private Date Date;


//    @ManyToOne(optional = false, cascade = CascadeType.MERGE )
    @ManyToOne(optional = false, cascade = CascadeType.ALL )
    @JoinColumn(name = "id_seller")
    private Shop seller;

//    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @OneToMany( cascade = CascadeType.MERGE , fetch = FetchType.EAGER)
    @OneToMany( cascade = CascadeType.ALL , fetch = FetchType.EAGER)
    @ToString.Exclude
    private List<Books> Book;


//    @ManyToOne(optional = false, cascade = CascadeType.MERGE)
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_buyer")
    private Buyer buyer;

    @Column(name = "quantity")
    private Integer Quantity;

    @Column(name = "sum")
    private Double Sum;

    public Purchase(Integer orderNumber, java.sql.Date date, Shop seller, List<Books> book, Buyer buyer, Integer quantity, Double sum) {
        OrderNumber = orderNumber;
        Date = date;
        this.seller = seller;
        Book = book;
        this.buyer = buyer;
        Quantity = quantity;
        Sum = sum;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", OrderNumber=" + OrderNumber +
                ", Date=" + Date +
                ", Seller=" + seller +
                ", Buyer=" + buyer +
                ", Quantity=" + Quantity +
                ", Sum='" + Sum + '\'' +
                ", Book=" + Book +
                '}';
    }

}

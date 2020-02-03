package com.example.Entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.Collection;
import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Table(name = "purchase", schema = "shop")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Purchase implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", insertable = false, nullable = false)
    private Integer id;

    @Column(name = "ordernumber")
    private Integer OrderNumber;

    @Column(name = "date")
    private Date Date;

    //  @Column(name = "seller")
    @OneToOne(mappedBy = "purchase")
    @PrimaryKeyJoinColumn
    @ToString.Exclude
    private Shop Seller;


    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private Collection<Buyer> Buyer;

    public Purchase(Integer orderNumber) {
        OrderNumber = orderNumber;
    }

    @Column(name = "quantity")
    private Integer Quantity;

    @Column(name = "sum")
    private Double Sum;


    @OneToMany(mappedBy = "purchase", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @ToString.Exclude
//    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private Collection<Books> Book;

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", OrderNumber=" + OrderNumber +
                ", Date=" + Date +
                ", Seller=" + Seller +
                ", Buyer=" + Buyer +
                ", Quantity=" + Quantity +
                ", Sum='" + Sum + '\'' +
                ", Book=" + Book +
                '}';
    }

}

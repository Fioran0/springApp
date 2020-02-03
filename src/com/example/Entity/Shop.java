package com.example.Entity;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "shop", schema = "shop")
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //  @Column(name = "id", insertable = false, nullable = false)
    @MapsId
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @ToString.Exclude
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private Purchase purchase;

    @Column(name = "name")
    private String shopName;

    @Column(name = "locationarea")
    private String shopLocationArea;

    public Shop(String shopName) {
        this.shopName = shopName;
    }

    @Column(name = "commissionfee")
    private Double CommissionFee;

    public Shop(String shopName, String shopLocationArea, Double commissionFee) {
        this.shopName = shopName;
        this.shopLocationArea = shopLocationArea;
        CommissionFee = commissionFee;
    }

    public Shop(Purchase purchase, String shopName, String shopLocationArea, Double commissionFee) {
        this.purchase = purchase;
        this.shopName = shopName;
        this.shopLocationArea = shopLocationArea;
        CommissionFee = commissionFee;
    }
}

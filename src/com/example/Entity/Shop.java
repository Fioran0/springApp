package com.example.Entity;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "shop", schema = "purchase")
public class Shop implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "shop_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


//    @JoinColumn(name = "shop_id")
/*    @OneToMany(mappedBy = "seller", cascade = CascadeType.ALL)
    @ToString.Exclude
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private List<Purchase> purchase;*/

    @Column(name = "name")
    private String shopName;

    @Column(name = "locationarea")
    private String shopLocationArea;

    @Column(name = "commissionfee")
    private Double commissionFee;

    public Shop(String shopName, String shopLocationArea, Double commissionFee) {
        this.shopName = shopName;
        this.shopLocationArea = shopLocationArea;
        this.commissionFee = commissionFee;
    }

}

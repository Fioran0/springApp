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

@Table(name = "buyer", schema = "shop")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Buyer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @MapsId
//    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id")
    @ToString.Exclude
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private Purchase purchase;

    @Column(name = "surname")
    private String Surname;

    @Column(name = "residencearea")
    private String ResidenceArea;

    @Column(name = "discount")
    private Double Discount;

    public Buyer(String surname, String residenceArea, Double discount) {
        Surname = surname;
        ResidenceArea = residenceArea;
        Discount = discount;
    }

    public Buyer(Purchase purchase, String surname, String residenceArea, Double discount) {
        this.purchase = purchase;
        Surname = surname;
        ResidenceArea = residenceArea;
        Discount = discount;
    }
}
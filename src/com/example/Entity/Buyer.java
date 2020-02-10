package com.example.Entity;

import java.io.Serializable;
import java.util.ArrayList;
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

@Table(name = "buyer", schema = "purchase")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Buyer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column (name = "buyer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

/*    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    @ToString.Exclude
    @JsonIgnore
    @NotFound(action= NotFoundAction.IGNORE)
    private List<Purchase> purchases = new ArrayList<>();*/

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

}
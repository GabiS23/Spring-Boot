package com.dh.finalexamGabrielaFernandez.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
/**
 * Created by Gabi on 21/06/2017.
 */
@Entity(name = "RegistryCarSold")
@Table(name = "registry_car_sold")
public class RegistryCarSold {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "registry_car_sold_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "seller_id")
    @JsonIgnore
    private Seller seller;
    @ManyToOne
    @JoinColumn(name = "buyer_id")
    @JsonIgnore
    private Buyer buyer;
    @ManyToOne
    @JoinColumn(name = "car_id")
    @JsonIgnore
    private Car car;

    public RegistryCarSold() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

}
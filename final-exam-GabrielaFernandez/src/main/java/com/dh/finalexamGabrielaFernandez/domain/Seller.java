package com.dh.finalexamGabrielaFernandez.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * Created by Gabi on 21/06/2017.
 */
@Entity
public class Seller {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long Id;
    private String name;
    private int age;
    private String ci;
    private int numCarsSold;
    private String image;
    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = Id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public int getNumCarsSold() {
        return numCarsSold;
    }

    public void setNumCarsSold(int numCarsSold) {
        this.numCarsSold = numCarsSold;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}

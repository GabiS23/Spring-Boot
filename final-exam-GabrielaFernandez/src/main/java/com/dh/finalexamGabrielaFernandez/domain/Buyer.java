package com.dh.finalexamGabrielaFernandez.domain;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gabi on 21/06/2017.
 */
@Entity(name = "Buyer")
@Table(name = "buyer")

public class Buyer {
        @Id
        @GeneratedValue(strategy= GenerationType.AUTO)
        private Long Id;
        private String name;
        private String ci;
        private String profession;
        private String cellphone;
    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
    private List<RegistryCarSold> registryCarSolds;

    public Buyer(){
        registryCarSolds = new ArrayList<>();
    }
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

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public List<RegistryCarSold> getRegistryCarSolds() {
        return registryCarSolds;
    }

    public void setRegistryCarSolds(List<RegistryCarSold> registryCarSolds) {
        this.registryCarSolds = registryCarSolds;
    }
}

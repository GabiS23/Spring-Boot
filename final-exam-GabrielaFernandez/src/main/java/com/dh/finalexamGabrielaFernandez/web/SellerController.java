package com.dh.finalexamGabrielaFernandez.web;
import com.dh.finalexamGabrielaFernandez.domain.Seller;
import com.dh.finalexamGabrielaFernandez.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gabi on 21/06/2017.
 */
@RestController
@RequestMapping(value = "/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Seller> getAllSellers(){
        return sellerService.getAllSellers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addSeller(@RequestBody SellerRequestDTO seller){
        sellerService.addSeller(seller);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.PUT)
    public void updateSeller(@RequestBody SellerRequestDTO seller,@PathVariable Long id){
        sellerService.update(id,seller);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.DELETE)
    public void deleteSeller(@PathVariable long id){
        sellerService.delete(id);
    }

    public static class SellerRequestDTO{
        private String name;
        private String ci;
        private Integer age;
        private Integer numCarsSold;

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

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public Integer getNumCarsSold() {
            return numCarsSold;
        }

        public void setNumCarsSold(Integer numCarsSold) {
            this.numCarsSold = numCarsSold;
        }
    }
}

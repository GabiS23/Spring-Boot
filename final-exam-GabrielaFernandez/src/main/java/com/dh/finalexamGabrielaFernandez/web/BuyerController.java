package com.dh.finalexamGabrielaFernandez.web;
import com.dh.finalexamGabrielaFernandez.domain.Buyer;
import com.dh.finalexamGabrielaFernandez.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * Created by Gabi on 21/06/2017.
 */
@RestController
@RequestMapping(value = "/buyers")
public class BuyerController {
    @Autowired
    private BuyerService buyerService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Buyer> getAllBuyers(){
        return buyerService.getAllBuyers();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addBuyer(@RequestBody BuyerRequestDTO buyer){
        buyerService.addBuyer(buyer);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.PUT)
    public void updateBuyer(@RequestBody BuyerRequestDTO buyer,@PathVariable Long id){
        buyerService.update(id,buyer);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.DELETE)
    public void deleteBuyer(@PathVariable long id){
        buyerService.delete(id);
    }

    public static class BuyerRequestDTO{
        private String name;
        private String ci;
        private String profession;
        private String cellphone;

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
    }
}

package com.dh.finalexamGabrielaFernandez.service;

import com.dh.finalexamGabrielaFernandez.domain.Buyer;
import com.dh.finalexamGabrielaFernandez.repository.BuyerRepository;
import com.dh.finalexamGabrielaFernandez.web.BuyerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gabi on 21/06/2017.
 */
@Service
public class BuyerService {
    @Autowired
    private BuyerRepository buyerRepository;

    public List<Buyer> getAllBuyers(){
        return buyerRepository.findAll();
    }
    public void addBuyer(BuyerController.BuyerRequestDTO buyerRequestDTO){
        buyerRepository.save(changeDTOToObject(new Buyer(),buyerRequestDTO));
    }
    public void update(Long id,BuyerController.BuyerRequestDTO buyerRequestDTO){
        buyerRepository.save(changeDTOToObject(buyerRepository.findOne(id),buyerRequestDTO));
    }
    public void delete(long id){
        buyerRepository.delete(id);
    }

    private Buyer changeDTOToObject(Buyer temp , BuyerController.BuyerRequestDTO dto){
        temp.setName(dto.getName());
        temp.setCi(dto.getCi());
        temp.setProfession(dto.getProfession());
        temp.setCellphone(dto.getCellphone());
        return temp;
    }
}

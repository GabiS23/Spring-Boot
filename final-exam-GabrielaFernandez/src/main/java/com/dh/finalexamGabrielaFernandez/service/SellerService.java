package com.dh.finalexamGabrielaFernandez.service;
import com.dh.finalexamGabrielaFernandez.domain.Seller;
import com.dh.finalexamGabrielaFernandez.repository.SellerRepository;
import com.dh.finalexamGabrielaFernandez.web.SellerController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Gabi on 21/06/2017.
 */
@Service
public class SellerService {
    @Autowired
    private SellerRepository sellerRepository;

    public List<Seller> getAllSellers(){
        return sellerRepository.findAll();
    }

    public void addSeller(SellerController.SellerRequestDTO sellerRequestDTO){
        sellerRepository.save(changeDTOToObject(new Seller(),sellerRequestDTO));
    }

    public void update(Long id,SellerController.SellerRequestDTO sellerRequestDTO){
        sellerRepository.save(changeDTOToObject(sellerRepository.findOne(id),sellerRequestDTO));
    }

    public void delete(long id){
        sellerRepository.delete(id);
    }

    private Seller changeDTOToObject(Seller temp , SellerController.SellerRequestDTO dto){
        temp.setName(dto.getName());
        temp.setAge(dto.getAge());
        temp.setCi(dto.getCi());
        temp.setNumCarsSold(dto.getNumCarsSold());
        return temp;
    }
}

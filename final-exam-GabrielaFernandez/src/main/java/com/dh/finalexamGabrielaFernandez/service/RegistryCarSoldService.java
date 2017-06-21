package com.dh.finalexamGabrielaFernandez.service;
import com.dh.finalexamGabrielaFernandez.domain.RegistryCarSold;
import com.dh.finalexamGabrielaFernandez.domain.Seller;
import com.dh.finalexamGabrielaFernandez.repository.BuyerRepository;
import com.dh.finalexamGabrielaFernandez.repository.CarRepository;
import com.dh.finalexamGabrielaFernandez.repository.RegistryCarSoldRepository;
import com.dh.finalexamGabrielaFernandez.repository.SellerRepository;
import com.dh.finalexamGabrielaFernandez.web.RegistryCarSoldController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Gabi on 21/06/2017.
 */

@Service
public class RegistryCarSoldService {
    @Autowired
    private RegistryCarSoldRepository registryCarSoldRepository;

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private CarRepository carRepository;

    public List<RegistryCarSold> getAllRegistryCarSold(){
        return registryCarSoldRepository.findAll();
    }

    @Transactional
    public void addRegistryCarSold(RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSoldRequestDTO){
        registryCarSoldRepository.save(changeDTOToObject(new RegistryCarSold(),registryCarSoldRequestDTO));
        updateSellerAfterEvents(registryCarSoldRequestDTO.getSellerId());
    }

    @Transactional
    public void update(Long id,RegistryCarSoldController.RegistryCarSoldRequestDTO registryCarSoldRequestDTO){
        RegistryCarSold r = registryCarSoldRepository.findOne(id);
        registryCarSoldRepository.save(changeDTOToObject(r,registryCarSoldRequestDTO));
        updateSellerAfterEvents(r.getSeller().getId());
        updateSellerAfterEvents(registryCarSoldRequestDTO.getSellerId());
    }

    @Transactional
    public void delete(Long id){
        RegistryCarSold r = registryCarSoldRepository.findOne(id);
        registryCarSoldRepository.delete(id);
        updateSellerAfterEvents(r.getSeller().getId());
    }

    public Seller getCarsSoldBySeller(Long id){
        return sellerRepository.findOne(id);
    }

    public Integer getCarsSoldBySellerId(Long id){
        Seller t = sellerRepository.findOne(id);
        List<RegistryCarSold> list;
        list = registryCarSoldRepository.findAll().findAllRegistryCarSold(id);
        return list.size();
    }

    private RegistryCarSold changeDTOToObject(RegistryCarSold temp , RegistryCarSoldController.RegistryCarSoldRequestDTO dto){
        temp.setBuyer(buyerRepository.findOne(dto.getBuyerId()));
        temp.setCar(carRepository.findOne(dto.getCarId()));
        temp.setSeller(sellerRepository.findOne(dto.getSellerId()));
        return temp;
    }
    private void updateSellerAfterEvents(Long id){
        Seller seller = sellerRepository.findOne(id);
        seller.getNumCarsSold(registryCarSoldRepository.findAllRegistryCarSold(id).size());
        sellerRepository.save(seller);
    }
}

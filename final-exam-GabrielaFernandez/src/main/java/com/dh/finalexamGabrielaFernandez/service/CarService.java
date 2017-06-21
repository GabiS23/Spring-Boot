package com.dh.finalexamGabrielaFernandez.service;
import com.dh.finalexamGabrielaFernandez.domain.Buyer;
import com.dh.finalexamGabrielaFernandez.domain.Car;
import com.dh.finalexamGabrielaFernandez.repository.CarRepository;
import com.dh.finalexamGabrielaFernandez.web.BuyerController;
import com.dh.finalexamGabrielaFernandez.web.CarController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
/**
 * Created by Gabi on 21/06/2017.
 */
@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> getAllCars(){
        return carRepository.findAll();
    }

    public void addCar(CarController.CarRequestDTO car){
        carRepository.save(changeDTOToObject(new Car(),car));
    }
    public void update(Long id,CarController.CarRequestDTO car){
        carRepository.save(changeDTOToObject(carRepository.findOne(id),car));
    }
    public void delete(Long id){
        carRepository.delete(id);
    }

    private Car changeDTOToObject(Car temp , CarController.CarRequestDTO dto){
        temp.setMarca(dto.getMarca());
        temp.setModelo(dto.getModelo());
        temp.setColor(dto.getColor());
        temp.setAño(dto.getAño());
        temp.setImage(dto.getImage());


        return temp;
    }
}

package com.dh.finalexamGabrielaFernandez.web;
import com.dh.finalexamGabrielaFernandez.domain.Car;
import com.dh.finalexamGabrielaFernandez.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Gabi on 21/06/2017.
 */
@RestController
@RequestMapping(value = "/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody CarRequestDTO car){
        carService.addCar(car);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.PUT)
    public void updateCar(@RequestBody CarRequestDTO car,@PathVariable Long id){
        carService.update(id,car);
    }

    @RequestMapping(value ="{id}" ,method = RequestMethod.DELETE)
    public void deleteCar(@PathVariable long id){
        carService.delete(id);
    }

    public static class CarRequestDTO{
        private String marca;
        private String modelo;
        private String color;
        private Integer año;
        private String image;

        public String getMarca() {
            return marca;
        }

        public void setMarca(String marca) {
            this.marca = marca;
        }

        public String getModelo() {
            return modelo;
        }

        public void setModelo(String modelo) {
            this.modelo = modelo;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public Integer getAño() {
            return año;
        }

        public void setAño(Integer año) {
            this.año = año;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }
}

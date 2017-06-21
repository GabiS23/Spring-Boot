package com.dh.finalexamGabrielaFernandez.repository;

import com.dh.finalexamGabrielaFernandez.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Gabi on 21/06/2017.
 */
public interface CarRepository extends JpaRepository<Car, Long> {
}

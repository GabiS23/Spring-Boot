package com.dh.finalexamGabrielaFernandez.repository;

import com.dh.finalexamGabrielaFernandez.domain.RegistryCarSold;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Gabi on 21/06/2017.
 */
public interface RegistryCarSoldRepository extends JpaRepository<RegistryCarSold, Long> {

    @Query("select r from RegistryCarSold r where r.seller.id =:sellerId")
    default List<RegistryCarSold> findAllRegistryCarSold(@Param("sellerId") Long sellerId) {
        return null;
    }
}

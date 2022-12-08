package com.bookMyShowAPI.BMS.Repository;


import com.bookMyShowAPI.BMS.Model.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterRepository extends JpaRepository<TheaterEntity,Integer> {

}

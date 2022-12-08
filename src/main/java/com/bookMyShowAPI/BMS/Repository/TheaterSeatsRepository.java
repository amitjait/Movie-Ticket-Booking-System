package com.bookMyShowAPI.BMS.Repository;

import com.bookMyShowAPI.BMS.Model.TheaterSeatsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheaterSeatsRepository extends JpaRepository<TheaterSeatsEntity,Integer> {
}

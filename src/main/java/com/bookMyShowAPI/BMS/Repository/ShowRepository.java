package com.bookMyShowAPI.BMS.Repository;

import com.bookMyShowAPI.BMS.Model.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<ShowEntity,Integer> {
}

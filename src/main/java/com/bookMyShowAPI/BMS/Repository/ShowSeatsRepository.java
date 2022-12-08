package com.bookMyShowAPI.BMS.Repository;

import com.bookMyShowAPI.BMS.Model.ShowSeatsEntity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatsRepository extends JpaRepository<ShowSeatsEntity,Integer> {
}

package com.bookMyShowAPI.BMS.Repository;

import com.bookMyShowAPI.BMS.Model.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<MovieEntity,Integer> {

}

package com.bookMyShowAPI.BMS.Repository;

import com.bookMyShowAPI.BMS.Model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Integer> {


}

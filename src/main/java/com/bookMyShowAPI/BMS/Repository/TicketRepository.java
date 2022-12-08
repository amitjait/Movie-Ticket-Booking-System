package com.bookMyShowAPI.BMS.Repository;

import com.bookMyShowAPI.BMS.Model.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity,Integer> {
}

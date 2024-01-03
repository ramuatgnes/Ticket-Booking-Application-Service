package com.ticketbooking.repository;

import com.ticketbooking.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TanseportRepository extends JpaRepository<Transport,Integer> {
   public Transport findByVehicleNo(String vehicleNo);
}

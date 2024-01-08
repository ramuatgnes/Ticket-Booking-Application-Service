package com.ticketbooking.repository;

import com.ticketbooking.entity.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

@Repository
public interface TanseportRepository extends JpaRepository<Transport,Integer> {
   public Transport findByVehicleNo(String vehicleNo);

   public List<Transport> findByStartFromAndEndTo(String startFrom, String endTo);
}

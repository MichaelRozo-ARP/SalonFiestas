package com.SalonFiestas.Partyroom.repository.crudRepository;

import com.SalonFiestas.Partyroom.entities.Reservation;
import org.springframework.data.repository.CrudRepository;
public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {
}

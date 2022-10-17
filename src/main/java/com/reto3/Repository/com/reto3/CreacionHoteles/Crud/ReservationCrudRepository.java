package com.reto3.Repository.com.reto3.CreacionHoteles.Crud;

import com.reto3.com.reto3.CreacionHoteles.modelo.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation, Integer>{

    @Query("SELECT c.client, COUNT(c.client) from Reservation AS c GROUP BY c.client ORDER BY COUNT(c.client) DESC")
    public List<Object[]> countTotalReservationByClient();

    // SELECT * FROM Reservation WHERE startDate AFTER dateOne AND devolutionDate BEFORE dateTwo:
    public  List<Reservation> findAllByStartDateAfterAndDevolutionDateIsBefore(Date dateOne, Date dateTwo);

    //SELECT * FROM Reservation WHERE status = 'cancelled'
    public List<Reservation> findAllByStatus(String status);
}

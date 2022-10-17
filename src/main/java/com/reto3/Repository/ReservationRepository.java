package com.reto3.Repository;

import com.reto3.Repository.com.reto3.CreacionHoteles.Crud.ReservationCrudRepository;
import com.reto3.com.reto3.CreacionHoteles.modelo.Client;
import com.reto3.com.reto3.CreacionHoteles.modelo.DTOs.CountClient;
import com.reto3.com.reto3.CreacionHoteles.modelo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }

    public Optional<Reservation> getReservation(int id){
        return reservationCrudRepository.findById(id);
    }

    public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }

    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

    //Reto 5
    public List<CountClient> getTopClients(){
        List<CountClient> respuesta = new ArrayList<>();

        List<Object[]> reporte = reservationCrudRepository.countTotalReservationByClient();

        for(int i = 0; i<reporte.size(); i++){
            respuesta.add(new CountClient((Long) reporte.get(i)[1], (Client) reporte.get(i)[0]));
        }

        return respuesta;

    }

    public List<Reservation> getReservationPeriod(Date a, Date b){
        return reservationCrudRepository.findAllByStartDateAfterAndDevolutionDateIsBefore(a, b);
    }

    public List<Reservation> getReservationByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);
    }

}
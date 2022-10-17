package com.reto3.com.reto3.CreacionHoteles.Service;

import com.reto3.Repository.ReservationRepository;
import com.reto3.com.reto3.CreacionHoteles.modelo.DTOs.CountClient;
import com.reto3.com.reto3.CreacionHoteles.modelo.DTOs.CountStatus;
import com.reto3.com.reto3.CreacionHoteles.modelo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll(){
        return reservationRepository.getAll();
    }
    public Optional<Reservation>getReservation(int id){
        return reservationRepository.getReservation(id);
    }
    public Reservation save(Reservation reservation){
        if(reservation.getIdReservation() == null){
            return reservationRepository.save(reservation);
        }else{
            Optional<Reservation> aux = reservationRepository.getReservation(reservation.getIdReservation());
            if (aux.isPresent()){
                return reservation;
            }else{
                return reservationRepository.save(reservation);
            }
        }
    }
    public Reservation update(Reservation reservation){
        if (reservation.getIdReservation() != null){
            Optional<Reservation> c = reservationRepository.getReservation(reservation.getIdReservation());
            if(c.isPresent()){
                if (reservation.getStartDate() != null){
                    c.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate() != null){
                    c.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus() != null){
                    c.get().setStatus(reservation.getStatus());
                }
                if(reservation.getRoom() != null){
                    c.get().setRoom(reservation.getRoom());
                }
                if(reservation.getClient() != null){
                    c.get().setClient(reservation.getClient());
                }
                if(reservation.getScore() != null){
                    c.get().setScore(reservation.getScore());
                }
                reservationRepository.save(c.get());
                return c.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Reservation> c = reservationRepository.getReservation(id);
        if (c.isPresent()){
            reservationRepository.delete(c.get());
        }
        return flag;
    }


    //Reto 5
    public List<CountClient> getTopClients(){
        return reservationRepository.getTopClients();
    }

    public List<Reservation> getReservationPeriod(String dateA, String dateB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd"); //2022-06-21
        Date a = new Date();
        Date b = new Date();
        try {
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        } catch (ParseException exception) {
            exception.printStackTrace();
        }
        if (a.before(b)) {
            return reservationRepository.getReservationPeriod(a, b);
        } else {
            return new ArrayList<>();
        }

    }
        public CountStatus getReservationByStatus(){
            List<Reservation> completed = reservationRepository.getReservationByStatus("completed");

            List<Reservation> cancelled = reservationRepository.getReservationByStatus("cancelled");

            return new CountStatus(completed.size(), cancelled.size());
        }

}
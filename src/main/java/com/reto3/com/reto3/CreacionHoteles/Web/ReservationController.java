package com.reto3.com.reto3.CreacionHoteles.Web;

import com.reto3.com.reto3.CreacionHoteles.Service.ReservationService;
import com.reto3.com.reto3.CreacionHoteles.modelo.DTOs.CountClient;
import com.reto3.com.reto3.CreacionHoteles.modelo.DTOs.CountStatus;
import com.reto3.com.reto3.CreacionHoteles.modelo.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Reservation")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
   /* @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int id){
        return reservationService.getReservation(id);
    } */
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return reservationService.delete(id);
    }
    @GetMapping("/report-status")
    public CountStatus getReservationDescriptionAmount() {
        return reservationService.getReservationByStatus();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClient() {
        return reservationService.getTopClients();
    }
    @GetMapping("report-dates/{startDate}/{devolutionDate}")
    public List<Reservation> getReservationReport(@PathVariable("startDate") String startDateString, @PathVariable("devolutionDate") String devolutionDateString) {
        return reservationService.getReservationPeriod(startDateString, devolutionDateString);
    }

}
package com.usa.reto3.repository.interfaces;

import com.usa.reto3.model.Reservation;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author nbsc1
 */
public interface ReservationInterface extends CrudRepository<Reservation, Integer> {
//Realización de consulta
     // el objeto c es una reservacion, se va a hacer un conte de los clientes usados por reservacion
     //le estamos pidiendo un objeto cliente y un numero

    @Query("SELECT c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT (c.client) desc")
    public List<Object[]> countTotalReservationByClient();
    
    //QUERY METHODS!
    public List<Reservation> findAllByStartDateAfterAndStartDateBefore(Date dateOne,Date dateTwo);
    //public List<Reservations> findAllByStartBetween (Date dateOne, Date dateTwo);
    public List<Reservation> findAllByStatus (String statusAAA);
}

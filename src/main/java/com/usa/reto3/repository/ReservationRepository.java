package com.usa.reto3.repository;

import com.usa.reto3.model.Client;
import com.usa.reto3.repository.interfaces.ReservationInterface;
import com.usa.reto3.model.Reservation;
import com.usa.reto3.model.custome.CountClient;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nbsc1
 */
@Repository
public class ReservationRepository {
    
    @Autowired
     //metodos que van a llamar las acciones del crud repository
    private ReservationInterface crud4;

     // Consulta los elementos de la base y los entrega en una lista
    public List<Reservation> getAll() {
        return (List<Reservation>) crud4.findAll();
    }

    //Si el dato esta se entrega y si no existe el dato no ejecuta nada;
    // con ese Optional se evitan problemas con los null
    public Optional<Reservation> getReservation(int id) {
        return crud4.findById(id);
    }
    
    //Para guardar
    public Reservation save(Reservation reservation) {
        return crud4.save(reservation);
    }

     //Para eliminar
    public void delete(Reservation reservation) {
        crud4.delete(reservation);
    }
    
    //RETO5
    /**
     * METODOS QUERY
     */
    //
    public List<Reservation> getReservationByStatus (String status) {
        return crud4.findAllByStatus(status);
    }
    
    /**
     * Entrega una lista
     */
    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo ) {
        return crud4.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);
    }
    
    /**
     * Es el que se encarga de organizar la informacion
     */
    public List<CountClient> getTopClient(){
        List<CountClient> res=new ArrayList<>();

        List<Object[]> report=crud4.countTotalReservationByClient();
        for(int i=0;i<report.size();i++){
            /**
            Client cli=(Client) report.get(i)[0];
            Long cantidad=(Long) report.get(i)[1];
            CountClient cc=new CountClient(cantidad,cli);
            res.add(cc);
            */
            res.add(new CountClient((Long) report.get(i)[1],(Client)report.get(i)[0] ));
        }
        return res;
    }
    
}

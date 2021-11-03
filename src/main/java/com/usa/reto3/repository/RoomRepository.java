package com.usa.reto3.repository;

import com.usa.reto3.repository.interfaces.RoomInterface;
import com.usa.reto3.model.Room;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nbsc1
 */
@Repository
public class RoomRepository {

    @Autowired
    private RoomInterface crud;

    public List<Room> getAll() {
        return (List<Room>) crud.findAll();
    }

    public Optional<Room> getRoom(int id) {
        return crud.findById(id);
    }

    public Room save(Room room) {
        return crud.save(room);
    }

    public void delete(Room room) {
        crud.delete(room);
    }

}

package com.reto3.Repository;

import com.reto3.Repository.com.reto3.CreacionHoteles.Crud.RoomCrudRepository;
import com.reto3.com.reto3.CreacionHoteles.modelo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoomRepository {

    @Autowired
    private RoomCrudRepository roomCrudRepository;

    public List<Room> getAll(){

        return (List<Room>) roomCrudRepository.findAll();
    }

    public Optional<Room> getRoom(int id){

        return roomCrudRepository.findById(id);
    }

    public Room save(Room room){
        return roomCrudRepository.save(room);
    }

    public void delete(Room room){

        roomCrudRepository.delete(room);
    }

}
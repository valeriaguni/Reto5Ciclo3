package com.reto3.com.reto3.CreacionHoteles.Service;

import com.reto3.Repository.RoomRepository;
import com.reto3.com.reto3.CreacionHoteles.modelo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;

    public List<Room> getAll(){
        return roomRepository.getAll();
    }
    public Optional<Room> getRoom(int id){
        return roomRepository.getRoom(id);
    }
    public Room save(Room room){
        if(room.getId() == null){
            return roomRepository.save(room);
        }else{
            Optional<Room> aux = roomRepository.getRoom(room.getId());
            if (aux.isPresent()){
                return room;
            }else{
                return roomRepository.save(room);
            }
        }
    }
    public Room update(Room room){
        if (room.getId() != null){
            Optional<Room> c = roomRepository.getRoom(room.getId());
            if(c.isPresent()){
                if (room.getName() != null){
                    c.get().setName(room.getName());
                }
                if(room.getDeveloper() != null){
                    c.get().setDeveloper(room.getDeveloper());
                }
                if(room.getYear() != null){
                    c.get().setYear(room.getYear());
                }
                if(room.getDescription() != null){
                    c.get().setDescription(room.getDescription());
                }
                if(room.getCategory() != null){
                    c.get().setCategory(room.getCategory());
                }
                if(room.getMessages() != null){
                    c.get().setMessages(room.getMessages());
                }
                if(room.getReservations() != null){
                    c.get().setReservations(room.getReservations());
                }
                roomRepository.save(c.get());
                return c.get();
            }else{
                return room;
            }
        }else{
            return room;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Room> c = roomRepository.getRoom(id);
        if (c.isPresent()){
            roomRepository.delete(c.get());
        }
        return flag;
    }
}
package com.reto3.com.reto3.CreacionHoteles.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;


    @ManyToOne
    @JoinColumn(name="room_id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Room rooms;


    @ManyToOne
    @JoinColumn(name="client_id")
    @JsonIgnoreProperties({"messages", "reservations"})
    private Client client;


    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public Room getRooms() {
        return rooms;
    }

    public void setRooms(Room room) {
        this.rooms = room;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
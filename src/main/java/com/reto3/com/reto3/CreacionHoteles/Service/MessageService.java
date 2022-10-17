package com.reto3.com.reto3.CreacionHoteles.Service;

import com.reto3.Repository.MessageRepository;
import com.reto3.com.reto3.CreacionHoteles.modelo.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message>getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message message){
        if(message.getIdMessage() == null){
            return messageRepository.save(message);
        }else{
            Optional<Message> aux = messageRepository.getMessage(message.getIdMessage());
            if (aux.isPresent()){
                return message;
            }else{
                return messageRepository.save(message);
            }
        }
    }
    public Message update(Message message){
        if (message.getIdMessage() != null){
            Optional<Message> c = messageRepository.getMessage(message.getIdMessage());
            if(c.isPresent()){
                if (message.getMessageText() != null){
                    c.get().setMessageText(message.getMessageText());
                }
                if(message.getRooms() != null){
                    c.get().setRooms(message.getRooms());
                }
                if(message.getClient() != null){
                    c.get().setClient(message.getClient());
                }
                messageRepository.save(c.get());
                return c.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }

    public boolean delete(int id){
        boolean flag = false;
        Optional<Message> c = messageRepository.getMessage(id);
        if (c.isPresent()){
            messageRepository.delete(c.get());
        }
        return flag;
    }
}
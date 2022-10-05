package com.SalonFiestas.Partyroom.service;

import com.SalonFiestas.Partyroom.entities.Message;
import com.SalonFiestas.Partyroom.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MessageService {

    @Autowired
    private static MessageRepository messageRepository;

    public List<Message> getAll(){

        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(Integer idMessage){

        return messageRepository.getMessage(idMessage);
    }
    public static Message save(Message m){
        if(m.getIdMessage()==null){
            return messageRepository.save(m);
        }else{
            Optional<Message> msj = messageRepository.getMessage(m.getIdMessage());
            if(msj.isPresent()){
                return m;
            }else{
                return messageRepository.save(m);
            }
        }
    }
    public Message update(Message m){
        if(m.getIdMessage()!=null){
            Optional<Message> q = messageRepository.getMessage(m.getIdMessage());
            if(q.isPresent()){
                if(m.getMessageText()!=null){
                    q.get().setMessageText(m.getMessageText());
                }
                messageRepository.save(q.get());
                return q.get();
            }else{
                return m;
            }
        }else{
            return m;
        }
    }
    public boolean delete(Integer idMessage){
        boolean flag=false;
        Optional<Message>m= messageRepository.getMessage(idMessage);
        if(m.isPresent()) {
            messageRepository.delete(m.get());
            flag = true;
        }
        return flag;
    }
}

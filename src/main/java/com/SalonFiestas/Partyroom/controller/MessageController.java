package com.SalonFiestas.Partyroom.controller;


import com.SalonFiestas.Partyroom.entities.Message;
import com.SalonFiestas.Partyroom.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Message> getCategory(@PathVariable("id") Integer id){
        return messageService.getMessage(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message save(@RequestBody  Message p){
        return messageService.save(p);
    }
}

package com.example.restbackend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class MessagesController {

    private Messages messagesService = new Messages();

    @GetMapping("/messages")
    public List<Message> getAllMessages(){
        List<Message> result = messagesService.getMessages();
        return result;
    }

    @PostMapping(path = "/messages", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> addMessage(@RequestBody Message newMessage) {

        String newId = messagesService.addMessage(newMessage);

        if (newId == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(
                "/{id}").buildAndExpand(newMessage.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping(path = "/messages/{id}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Void> updateMessage(@RequestBody Message updatedMessage, @PathVariable String id){
        String updateId = messagesService.updateMessage(id, updatedMessage);

        if (updateId == null)
            return ResponseEntity.noContent().build();

        return ResponseEntity.status(204).build();
    }

    @DeleteMapping(path = "/messages/{id}")
    public ResponseEntity<Void> delMessage(@PathVariable String id){
        messagesService.deleteMessage(id);

        return ResponseEntity.ok().build();
    }





}
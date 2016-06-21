package me.south10.controller;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import me.south10.domain.MessageVO;
import me.south10.service.MessageService;

/**
 * Created by south10 on 2016-06-16.
 */
@RestController
@RequestMapping("/messages")
public class MessageController {
    @Inject
    private MessageService service;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> addMessage(@RequestBody MessageVO vo) {
        ResponseEntity<String> entity = null;

        try {
            service.addMessage(vo);
            entity = new ResponseEntity<>("SUCCESS", HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            entity = new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return entity;
    }
}

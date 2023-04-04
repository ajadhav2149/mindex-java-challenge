package com.mindex.challenge.controller;

import com.mindex.challenge.service.CompensationService;
import com.mindex.challenge.data.Compensation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class CompensationController {

    private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);

    @Autowired
    CompensationService compensationService;

    @PostMapping("/compensation")
    public ResponseEntity create(@RequestBody Compensation compensation){
        LOG.debug("Received compensation create request for [{}]", compensation);
        try{
            return ResponseEntity.status(HttpStatus.OK).body(compensationService.create(compensation) + "created successfully");

        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    @GetMapping("/compensation/{id}")
    public ResponseEntity read(@PathVariable String id){
        LOG.debug("Received compensation get request for id [{}]", id);
        try{
            Compensation compensation = compensationService.read(id);
            return ResponseEntity.status(HttpStatus.OK).body(compensation);
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

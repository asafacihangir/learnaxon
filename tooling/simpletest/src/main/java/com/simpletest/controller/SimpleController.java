package com.simpletest.controller;

import  com.simpletest.coreapi.SimpleCreateCommand;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/commands")
public class SimpleController{

    private CommandGateway commandGateway;

    public SimpleController(CommandGateway commandGateway){
        this.commandGateway = commandGateway;
    }

    /**
     * POST method for simple command data
     * @param commandData
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCommand(@RequestParam(name="commandData", required = true, defaultValue = "none") String commandData){
        String commandId = UUID.randomUUID().toString().toUpperCase();
        commandGateway.send(new SimpleCreateCommand(commandId,commandData));
    }
}
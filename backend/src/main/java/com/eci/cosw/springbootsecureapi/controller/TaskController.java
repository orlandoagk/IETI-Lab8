package com.eci.cosw.springbootsecureapi.controller;


import com.eci.cosw.springbootsecureapi.model.Task;
import com.eci.cosw.springbootsecureapi.service.TaskService;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @RequestMapping(value = "/getTasks",method = RequestMethod.GET)
    public ResponseEntity<?> getTasks(){
        try {
            return new ResponseEntity<>(taskService.getTasks(),HttpStatus.OK);
        } catch (UnirestException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }


    @RequestMapping(value = "/addTask",method = RequestMethod.POST)
    public ResponseEntity<?> addTask(@RequestBody Task task){
        try {
            taskService.addTask(task);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (UnirestException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

}

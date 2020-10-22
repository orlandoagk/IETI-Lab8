package com.eci.cosw.springbootsecureapi.service;

import com.eci.cosw.springbootsecureapi.model.Task;
import com.fasterxml.classmate.GenericType;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    public List<Task> getTasks() throws UnirestException {
        String tasks = Unirest.get("https://ieti-lab7-orlando.azurewebsites.net/api/add-task?code=D99RZ9uyb4bavwrR6s1c87KrRLnYPMr4f1gzkLgK3fGKV7oerQGTOg==")
                .asString().getBody();
        JSONArray jsonArray = new JSONArray(tasks);
        List<Task> tasksList = new ArrayList<>();
        System.out.println(tasks);
        for(int i = 0;i<jsonArray.length();i++){
            try {
                tasksList.add(new Task(jsonArray.getJSONObject(i)));
            } catch (JSONException exception){
                tasksList.add(new Task(new JSONObject(jsonArray.get(i))));
            }
        }

        return tasksList;

    }

    public void addTask(Task task) throws UnirestException {
        Unirest.post("https://ieti-lab7-orlando.azurewebsites.net/api/add-task?code=D99RZ9uyb4bavwrR6s1c87KrRLnYPMr4f1gzkLgK3fGKV7oerQGTOg==")
                .header("accept", "application/json")
                .body(new JSONObject(task.toString()))
                .asString();

    }
}

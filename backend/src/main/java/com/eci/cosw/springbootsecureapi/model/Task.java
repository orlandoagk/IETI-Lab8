package com.eci.cosw.springbootsecureapi.model;

import org.json.JSONObject;

public class Task {

    private long id;
    private String text, status, dueDate, responsible;

    public Task(){

    }

    public Task(JSONObject jsonObject){
        this.id = jsonObject.getLong("id");
        this.text = jsonObject.getString("text");
        this.status = jsonObject.getString("status");
        this.dueDate = jsonObject.getString("dueDate");
        this.responsible = jsonObject.getString("responsible");
    }


    public Task(long id, String text, String status, String dueDate, String responsible) {
        this.id = id;
        this.text = text;
        this.status = status;
        this.dueDate = dueDate;
        this.responsible = responsible;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getResponsible() {
        return responsible;
    }

    public void setResponsible(String responsible) {
        this.responsible = responsible;
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", text:'" + text + '\'' +
                ", status:'" + status + '\'' +
                ", dueDate:'" + dueDate + '\'' +
                ", responsible:'" + responsible + '\'' +
                '}';
    }
}

package com.spm.netgarage.dal.model.laptop;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("laptop_processor")
public class LaptopProcessorModel {

    @Id
    private String id;
    private String name;
    private String user;
    private LocalDateTime datetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public LaptopProcessorModel(String id, String name, String user, LocalDateTime datetime) {
        this.id = id;
        this.name = name;
        this.user = user;
        this.datetime = datetime;
    }

    public LaptopProcessorModel() {
    }
}

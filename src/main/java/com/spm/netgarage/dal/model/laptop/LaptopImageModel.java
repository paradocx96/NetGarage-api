package com.spm.netgarage.dal.model.laptop;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document("laptop_image")
public class LaptopImageModel {

    @Id
    private String id;
    private String lid;
    private List<String> link;
    private String user;
    private LocalDateTime datetime;

    public LaptopImageModel() {
    }

    public LaptopImageModel(
            String id,
            String lid,
            List<String> link,
            String user,
            LocalDateTime datetime) {
        this.id = id;
        this.lid = lid;
        this.link = link;
        this.user = user;
        this.datetime = datetime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public List<String> getLink() {
        return link;
    }

    public void setLink(List<String> link) {
        this.link = link;
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
}

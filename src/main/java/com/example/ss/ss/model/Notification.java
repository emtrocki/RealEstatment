package com.example.ss.ss.model;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;


@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    private String content;
    private String email;
    private String anwser;
    private String anwseredBy;
    private boolean isServed;

    public boolean isIsServed() {
        return isServed;
    }

    public void setIsServed(boolean served) {
        this.isServed = served;
    }

    public String getAnwser() {
        return anwser;
    }

    public void setAnwser(String anwser) {
        this.anwser = anwser;
    }

    public String getAnwseredBy() {
        return anwseredBy;
    }

    public void setAnwseredBy(String anwseredBy) {
        this.anwseredBy = anwseredBy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

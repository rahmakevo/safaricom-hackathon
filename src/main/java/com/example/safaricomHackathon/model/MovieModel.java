package com.example.safaricomHackathon.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class MovieModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String title;
    private String description;
    private String recommendation;
    private int rating;

    public MovieModel(String title, String description, String recommendation, int rating) {
        this.title = title;
        this.description = description;
        this.recommendation = recommendation;
        this.rating = rating;
    }
}

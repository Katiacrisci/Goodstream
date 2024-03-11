package crisci.caterina.goodstream.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
public class Review {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    private User user;

    private Integer rating;

    @ManyToOne
    private Title title;

    private LocalDate date;
}

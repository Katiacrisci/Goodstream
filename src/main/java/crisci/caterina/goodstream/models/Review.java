package crisci.caterina.goodstream.models;

import crisci.caterina.goodstream.DTO.ReviewDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
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


    public static Review fromDTO(ReviewDTO reviewDTO, User user) {
        Review review = new Review();
        review.user = user;
        review.rating = reviewDTO.rating();
        review.date = LocalDate.now();


    }
}



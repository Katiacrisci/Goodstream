package crisci.caterina.goodstream.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Title {
    @Id
    @GeneratedValue
    private UUID id;

    private TitleType titleType;

    @OneToMany
    private List<Review> reviews;
}

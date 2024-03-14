package crisci.caterina.goodstream.DTO;


import java.time.LocalDate;
import java.util.UUID;

public record ReviewDTO(UUID userId, Integer rating, UUID titleId, LocalDate date) {
}

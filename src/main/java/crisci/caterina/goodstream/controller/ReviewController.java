package crisci.caterina.goodstream.controller;

import crisci.caterina.goodstream.DTO.ReviewDTO;
import crisci.caterina.goodstream.DTO.UserDTO;
import crisci.caterina.goodstream.models.Review;
import crisci.caterina.goodstream.models.User;
import crisci.caterina.goodstream.repository.ReviewRepository;
import crisci.caterina.goodstream.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{id}")
    public Review getById(@PathVariable UUID id) {
        return reviewService.getById(id);
    }

    @PostMapping("")
    public Review save(@RequestBody ReviewDTO reviewDTO) {
        return reviewService.save(reviewDTO);
    }
}

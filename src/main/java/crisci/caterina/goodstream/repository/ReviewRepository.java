package crisci.caterina.goodstream.repository;

import crisci.caterina.goodstream.models.Review;
import crisci.caterina.goodstream.models.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReviewRepository extends JpaRepository<Review, UUID> {

    @Query("SELECT r FROM Review r WHERE r.title.id = :id")
    List<Review> findByTitleId(@Param("id") UUID titleId);

    @Query("SELECT r FROM Review r WHERE r.user.id = :id")
    List<Review> findByUserId(@Param("id") UUID userId);
}

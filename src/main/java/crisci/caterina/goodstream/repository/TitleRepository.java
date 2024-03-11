package crisci.caterina.goodstream.repository;

import crisci.caterina.goodstream.models.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TitleRepository extends JpaRepository<Title, UUID> {
}

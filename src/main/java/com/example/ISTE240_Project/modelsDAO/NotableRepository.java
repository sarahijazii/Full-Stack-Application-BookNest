package com.example.ISTE240_Project.modelsDAO;

import com.example.ISTE240_Project.Models.NotableSpeech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// repository interface for NotableSpeech entity, it enables interaction
// with the 'notable_speeches' table

@Repository
public interface NotableRepository extends JpaRepository<NotableSpeech, Long> {
}

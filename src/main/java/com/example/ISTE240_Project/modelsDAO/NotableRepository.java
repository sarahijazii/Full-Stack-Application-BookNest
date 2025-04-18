package com.example.nobel_prize.repository;

import com.example.nobel_prize.models.NotableSpeech;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotableRepository extends JpaRepository<NotableSpeech, Long> {
}

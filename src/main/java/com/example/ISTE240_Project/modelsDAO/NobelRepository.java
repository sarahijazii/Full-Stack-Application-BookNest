package com.example.nobel_prize.repository;

import com.example.nobel_prize.models.NobelPrize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NobelRepository extends JpaRepository<NobelPrize, Long> {

}

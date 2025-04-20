package com.example.ISTE240_Project.modelsDAO;

import com.example.ISTE240_Project.Models.NobelPrize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// this nobel repository class will extend JpaRepository
// to provide standard CRUD operations and query capabilities.

@Repository
public interface NobelRepository extends JpaRepository<NobelPrize, Long> {}
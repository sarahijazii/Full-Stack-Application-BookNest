package com.example.ISTE240_Project.modelsDAO;

import com.example.ISTE240_Project.Models.NobelBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository interface for NobelBook entity
@Repository
public interface NobelBookRepository extends JpaRepository<NobelBook, Long> {

}

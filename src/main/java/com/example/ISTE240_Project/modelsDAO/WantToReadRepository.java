package com.example.ISTE240_Project.modelsDAO;


import com.example.ISTE240_Project.Models.WantToRead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WantToReadRepository extends JpaRepository<WantToRead,Integer> {

    public List<WantToRead> findAllByEmail(String email);
    public void deleteById(int id);
}


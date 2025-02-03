package com.example.demo.repository;

import com.example.demo.entity.Tournoi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TournoiRepository extends JpaRepository<Tournoi, Long> {
    // Add custom query methods if needed
}
package com.FXTracker.repository;

import com.FXTracker.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PortfolioRepository extends JpaRepository<Portfolio, Long> {

    @Query("select p from Portfolio p where p.user.id=:id")
    Optional<Portfolio> findByUserId(Long id);
}

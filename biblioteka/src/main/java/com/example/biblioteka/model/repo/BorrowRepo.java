package com.example.biblioteka.model.repo;

import com.example.biblioteka.model.Borrow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepo extends JpaRepository<Borrow, Long> {
}

package com.example.job_portal.repository;

import com.example.job_portal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Repository for Job entity — handles DB operations like findAll(), save(), delete()
@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    // JpaRepository gives you all CRUD methods automatically
}

package com.example.job_portal.controller;


import com.example.job_portal.model.Job;
import com.example.job_portal.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;



import java.util.List;

// This class handles all incoming HTTP requests (e.g., GET, POST)
@RestController
@RequestMapping("/jobs")
@CrossOrigin(origins = "*") // allows requests from frontend or Postman
public class JobController {

    // Injecting JobRepository to access DB
    @Autowired
    private JobRepository jobRepository;

    // GET /jobs — list all jobs
    @GetMapping
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // POST /jobs — add new job
    @PostMapping
    public Job createJob(@RequestBody Job job) {
        return jobRepository.save(job);
    }

    // DELETE /jobs/{id} — delete job by id
    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable Long id) {
        jobRepository.deleteById(id);
    }
}

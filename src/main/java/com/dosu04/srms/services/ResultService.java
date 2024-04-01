package com.dosu04.srms.services;

import com.dosu04.srms.models.Result;
import com.dosu04.srms.repositories.ResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultService {

    private final ResultRepository resultRepository;

    public ResultService(ResultRepository resultRepository) {
        this.resultRepository = resultRepository;
    }

    public List<Result> getStudentResults() {
        // Implement logic to retrieve student results from the database
        return resultRepository.findAll(); // Example: Retrieve all results
    }

    public List<Result> getResultsByUsername(String username) {
        // Assuming you have a method in your repository to find results by username
        return resultRepository.findByUserUsername(username);
    }

    public void save(Result result) {
        resultRepository.save(result);
    }


    public List<Result> getAllResults() {
        return resultRepository.findAll();
    }


    public Optional<Result> findResultById(Long id) {
        return resultRepository.findById(id);
    }
}

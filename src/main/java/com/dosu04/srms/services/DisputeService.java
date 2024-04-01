package com.dosu04.srms.services;

import com.dosu04.srms.models.Dispute;
import com.dosu04.srms.repositories.DisputeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisputeService {

    private final DisputeRepository disputeRepository;

    @Autowired
    public DisputeService(DisputeRepository disputeRepository) {
        this.disputeRepository = disputeRepository;
    }

    public List<Dispute> getAllDisputes() {
        return disputeRepository.findAll();
    }

    public Optional<Dispute> getDisputeById(Long id) {
        return disputeRepository.findById(id);
    }

    public Dispute saveDispute(Dispute dispute) {
        return disputeRepository.save(dispute);
    }

    public void deleteDispute(Long id) {
        disputeRepository.deleteById(id);
    }
}
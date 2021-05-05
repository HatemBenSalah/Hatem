package com.hms.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.hms.entity.ClaimEntity;
import com.hms.entity.CommandeEntity;
import com.hms.entity.UserEntity;
import com.hms.repositories.ClaimRepository;
import com.hms.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.hms.exception.ResourceNotFoundException;
@RestController
@RequestMapping("/ClaimController")
public class ClaimController {
    @Autowired
    private ClaimRepository claimRepository;

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/getallClaim")
    public List<ClaimEntity> getAllClaim() {
        return claimRepository.findAll();
    }

    @PostMapping("/createClaim")
    public ClaimEntity createClaim(@Valid @RequestBody ClaimEntity claim) {
        return claimRepository.save(claim);
    }
    @GetMapping("/getClaim/{id}")
    public List<ClaimEntity> getClaimById(@PathVariable Long id) {
        UserEntity user = userRepository.getOne(id);
        System.out.println("claim:"+claimRepository.findbyuser(id));

        return claimRepository.findbyuser(id);

    }
    @PostMapping("/updateClaim")
    public Boolean updateReclamation(@Valid @RequestBody ClaimEntity ReclamationDetails) throws ResourceNotFoundException {
        ClaimEntity reclamation = claimRepository.findById(ReclamationDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Reclamation not found for this id :: "));
        try {
            reclamation.setEmail(ReclamationDetails.getEmail());
            reclamation.setLastName(ReclamationDetails.getLastName());
            reclamation.setFirstName(ReclamationDetails.getFirstName());
            reclamation.setPhone(ReclamationDetails.getPhone());
            reclamation.setAdresse(ReclamationDetails.getAdresse());
            reclamation.setNameservice(ReclamationDetails.getNameservice());
            reclamation.setClaimdescription(ReclamationDetails.getClaimdescription());
            reclamation.setState(ReclamationDetails.getState());
            reclamation.setDatedemmande(ReclamationDetails.getDatedemmande());
            claimRepository.save(reclamation);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @PostMapping("/deleteClaim")
    public Map<String, Boolean> deleteReclamation(@Valid @RequestBody Integer reclamationID)
            throws ResourceNotFoundException {
        ClaimEntity reclamation = claimRepository.findById(reclamationID)
                .orElseThrow(() -> new ResourceNotFoundException("reclamation not found for this id :: " + reclamationID));

        claimRepository.delete(reclamation);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

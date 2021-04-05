package com.template.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.template.entity.CommandeEntity;
import com.template.repositories.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/CommandeController")
public class CommandeController {

    @Autowired
    private CommandeRepository commandeRepository;

    @GetMapping("/getCommande")
    public List<CommandeEntity> getAllCommande() {
        return commandeRepository.findAll();
    }

    @GetMapping("/CommandeEntity/{id}")
    public ResponseEntity<CommandeEntity> getCommandebyid(@PathVariable(value = "id") Integer commandeId)
            throws ResourceNotFoundException {
        CommandeEntity commande = commandeRepository.findById(commandeId)
                .orElseThrow(() -> new ResourceNotFoundException("commande not found for this id :: " + commandeId));
        return ResponseEntity.ok().body(commande);
    }




    @PostMapping("/createCommande")
    public CommandeEntity createCommande(@Valid @RequestBody CommandeEntity commande) {
        return commandeRepository.save(commande);
    }

    @PostMapping("/updateCommande")
    public Boolean updateCommande(@Valid @RequestBody CommandeEntity CommandeDetails) throws ResourceNotFoundException {
        CommandeEntity commande = commandeRepository.findById(CommandeDetails.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Commande not found for this id :: "));
        try {
            commande.setEmail(CommandeDetails.getEmail());
            commande.setLastName(CommandeDetails.getLastName());
            commande.setFirstName(CommandeDetails.getFirstName());
            commande.setPhone(CommandeDetails.getPhone());
            commande.setAdresse(CommandeDetails.getAdresse());
            commande.setNameservice(CommandeDetails.getNameservice());
            commande.setPannedescription(CommandeDetails.getPannedescription());
            commandeRepository.save(commande);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @PostMapping("/deleteCommande")
    public Map<String, Boolean> deleteCommande(@Valid @RequestBody Integer commandeID)
            throws ResourceNotFoundException {
        CommandeEntity commande = commandeRepository.findById(commandeID)
                .orElseThrow(() -> new ResourceNotFoundException("commande not found for this id :: " + commandeID));

        commandeRepository.delete(commande);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
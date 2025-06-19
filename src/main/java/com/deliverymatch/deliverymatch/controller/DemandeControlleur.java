package com.deliverymatch.deliverymatch.controller;



import com.deliverymatch.deliverymatch.Dto.DemandeDto;
import com.deliverymatch.deliverymatch.service.DemandeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Demande")
@CrossOrigin(origins = "*")
public class DemandeControlleur {

    public DemandeService demandeService ;


    @PostMapping
    public DemandeDto AddDemande(@RequestBody DemandeDto demandeDto){
        return demandeService.AddDemande(demandeDto);
    }

    @GetMapping
    public List<DemandeDto> getAllDemandes(){
        return demandeService.getAllDemandes();
    }

    @GetMapping("/Demande/{id}")
    public DemandeDto getDemandeById(@PathVariable Long id){
        return demandeService.getDemandeById(id);
    }

    @PutMapping("/demande/{id}")
    public DemandeDto UpdateDemande(@RequestBody DemandeDto demandeDto ,@PathVariable Long id){
        return demandeService.UpdateDemande(demandeDto , id);
    }


    @DeleteMapping("supDemande/{id}")
    public void DeleteDemande (@PathVariable Long id){
        demandeService.deleteById(id);
    }


}
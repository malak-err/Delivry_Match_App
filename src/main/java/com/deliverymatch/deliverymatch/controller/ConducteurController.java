package com.deliverymatch.deliverymatch.controller;



import com.deliverymatch.deliverymatch.Dto.ConducteurDto;
import com.deliverymatch.deliverymatch.service.ConducteurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Conducteur")
@CrossOrigin(origins = "*")


public class ConducteurController {

    public ConducteurService conducteurService;

    @GetMapping
    public List<ConducteurDto> getAllConducteurS() {
        return conducteurService.getAllConducteurs();
    }

    @PostMapping
    public ConducteurDto AddConducteur(@RequestBody  ConducteurDto conducteurDto) {
        return conducteurService.create(conducteurDto);
    }

    @GetMapping("/Conducteur/{id}")
    public ConducteurDto getConducteurById(@PathVariable Long id) {
        return conducteurService.getConducteurById(id);
    }
    @PutMapping("/Conducteur/{id}")
    public ConducteurDto updateConducteur(@RequestBody ConducteurDto conducteurDto , @PathVariable Long id) {
        return conducteurService.updateConducteur(conducteurDto, id);
    }
    @DeleteMapping("/Conducteur/{id}")
    public void deleteConducteur(@PathVariable Long id) {
        conducteurService.deleteConducteur(id);
    }
}

package com.deliverymatch.deliverymatch.controller;


import com.deliverymatch.deliverymatch.Dto.ExpediteurDto;
import com.deliverymatch.deliverymatch.service.ExpediteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/api/Expediteur")
@CrossOrigin(origins = "*")
public class ExpediteurController {
    private final ExpediteurService expediteurService;

    @Autowired
    public ExpediteurController(ExpediteurService expediteurService) {
        this.expediteurService = expediteurService;
    }
    @GetMapping
    public List<ExpediteurDto> getExpediteurs() {
        return expediteurService.getAllExpediteur();
    }

    @PostMapping
    public ExpediteurDto AddExpediteur(@RequestBody ExpediteurDto expediteurDto) {
        return expediteurService.createExpediteur(expediteurDto);
    }

    @GetMapping("/Expediteur/{id}")
    public ExpediteurDto getExpediteurById(@PathVariable Long id) {
        return expediteurService.getExpediteurById(id);
    }

    @PutMapping("/Expediteur/{id}")
    public ExpediteurDto updateExpediteur(@RequestBody ExpediteurDto expediteurDto, @PathVariable Long id) {
        return expediteurService.updateEx(expediteurDto, id);
    }
    @DeleteMapping("/Expediteur/{id}")
    public void deleteExpediteur(@PathVariable Long id) {
        expediteurService.deleteExpediteur(id);
    }

}

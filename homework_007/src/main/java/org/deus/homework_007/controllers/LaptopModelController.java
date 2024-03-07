package org.deus.homework_007.controllers;

import org.deus.homework_007.models.LaptopModel;
import org.deus.homework_007.repositories.LaptopModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/laptop-model")
public class LaptopModelController {

    @Autowired
    private LaptopModelRepository laptopModelRepository;

    @GetMapping("/list")
    public List<LaptopModel> getAllLaptopModels() {
        return laptopModelRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<LaptopModel> getLaptopModelById(@PathVariable("id") Long id) {
        return laptopModelRepository.findById(id);
    }
}

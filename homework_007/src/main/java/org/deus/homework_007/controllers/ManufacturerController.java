package org.deus.homework_007.controllers;

import org.deus.homework_007.models.Manufacturer;
import org.deus.homework_007.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {

    @Autowired
    private ManufacturerRepository manufacturerRepository;

    @GetMapping("/list")
    public List<Manufacturer> getManufacturerInfo() {
        return manufacturerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Manufacturer> getManufacturerById(@PathVariable("id") Long id) {
        return manufacturerRepository.findById(id);
    }
}

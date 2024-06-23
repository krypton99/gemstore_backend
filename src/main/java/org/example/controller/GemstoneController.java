package org.example.controller;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Gemstone;
import org.example.model.Response;
import org.example.service.GemstoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/gemstone")
public class GemstoneController {
    @Autowired
    private GemstoneService gemstoneService;
    @GetMapping("/{id}")
    public ResponseEntity<Gemstone> getById(@PathVariable(value = "id") int id ) throws ResourceNotFoundException {
        Gemstone gemstone = gemstoneService.getGemstone(id);
        return ResponseEntity.ok(gemstone);
    }

    @GetMapping("")
    public ResponseEntity<List<Gemstone>> getAll() throws ResourceNotFoundException {
        List<Gemstone> tours = gemstoneService.getAllGemstones();
        return ResponseEntity.ok(tours);
    }

    @PostMapping("")
    public Response createGemstone(@Validated @RequestBody Gemstone gemstone) {
        return gemstoneService.addGemstone(gemstone);
    }

    @DeleteMapping("/{id}")
    public Response deleteGemstone(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        return gemstoneService.deleteGemstone(id);
    }
}

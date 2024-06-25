package org.example.controller;

import org.example.exception.ResourceNotFoundException;
import org.example.model.GemstoneDescription;
import org.example.model.Response;
import org.example.service.GemstoneDescriptionService;
import org.example.service.GemstoneDescriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/gemstone-description")
public class GemstoneDescriptionController {
    @Autowired
    GemstoneDescriptionService gemstoneDescriptionService;

    @GetMapping("/{id}")
    public ResponseEntity<GemstoneDescription> getById(@PathVariable(value="id") int id) throws ResourceNotFoundException {
        GemstoneDescription gemstoneDescription = gemstoneDescriptionService.getDescription(id);
        return ResponseEntity.ok(gemstoneDescription);
    }

    @PostMapping("")
    public Response createDescription(@RequestBody GemstoneDescription description) {
        return gemstoneDescriptionService.addGemstoneDescription(description);
    }

    @DeleteMapping("/{id}")
    public Response deleteDescription(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        return gemstoneDescriptionService.deleteGemstoneDescription(id);
    }


}

package org.example.controller;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Attribute;
import org.example.model.Response;
import org.example.service.AttributeService;
import org.example.service.AttributeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attribute")
public class AttributeController {
    @Autowired
    private AttributeService attributeService;

    @GetMapping("")
    public ResponseEntity<List<Attribute>> getAll() {
        List<Attribute> attributes = attributeService.findAll();
        return ResponseEntity.ok(attributes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Attribute> getById(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        return ResponseEntity.ok(attributeService.findById(id));
    }

    @PostMapping("")
    public Response createAttr(@RequestBody Attribute attribute) {
        return attributeService.createAttribute(attribute);
    }

    @DeleteMapping("/{id}")
    public Response deleteAttr(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        return attributeService.deleteById(id);
    }

    @PatchMapping("/{id}")
    public Response softDeleteAttr(@PathVariable(value = "id") int id) throws ResourceNotFoundException {
        return attributeService.softDeleteById(id);
    }
}

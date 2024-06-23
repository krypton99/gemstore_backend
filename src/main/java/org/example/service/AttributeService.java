package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Attribute;
import org.example.model.Response;

import java.util.List;

public interface AttributeService {
    public Response createAttribute(Attribute attribute);
    public Attribute findById(int id) throws ResourceNotFoundException;
    public List<Attribute> findAll();
    public Response deleteById(int id) throws ResourceNotFoundException;
    public Response softDeleteById(int id) throws ResourceNotFoundException;
}

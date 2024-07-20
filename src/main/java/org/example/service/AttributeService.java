package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Attribute;
import org.example.model.Response;

import java.util.List;

public interface AttributeService {
    public Response createAttribute(Attribute attribute);
    public Attribute findById(long id) throws ResourceNotFoundException;
    public List<Attribute> findAll();
    public Response deleteById(long id) throws ResourceNotFoundException;
    public Response softDeleteById(long id) throws ResourceNotFoundException;
}

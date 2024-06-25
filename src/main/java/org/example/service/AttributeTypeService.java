package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.AttributeType;
import org.example.model.Response;

import java.util.List;

public interface AttributeTypeService {
    public Response addAttrType(AttributeType attributeType);
    public AttributeType findById(int id) throws ResourceNotFoundException;
    public Response deleteById(int id) throws ResourceNotFoundException;
    public List<AttributeType> findAll() throws ResourceNotFoundException;
    public Response softDeleteById(int id) throws ResourceNotFoundException;
}

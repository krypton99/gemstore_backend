package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Response;
import org.example.model.Gemstone;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface GemstoneService {
    public Gemstone getGemstone(long id) throws ResourceNotFoundException;
    public Response addGemstone(Gemstone tour);
    public Response deleteGemstone(long id) throws ResourceNotFoundException;
    public List<Gemstone> getAllGemstones() throws ResourceNotFoundException;
    public Response softDeleteGemstone(long id) throws ResourceNotFoundException;
    public List<Gemstone> getAllDeletedGemstones();
    public Response restoreDeletedGemstone(long id) throws ResourceNotFoundException;
}

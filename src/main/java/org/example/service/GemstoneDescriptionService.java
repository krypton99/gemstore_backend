package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.GemstoneDescription;
import org.example.model.Response;

import java.util.Optional;

public interface GemstoneDescriptionService {
    public Response addGemstoneDescription(GemstoneDescription description);

    public GemstoneDescription getDescription(long id) throws ResourceNotFoundException;

    public Response deleteGemstoneDescription (long id) throws ResourceNotFoundException;
}

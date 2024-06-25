package org.example.service;

import org.example.model.HasAttribute;
import org.example.model.Response;
import org.example.repository.HasAttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HasAttributeServiceImpl implements HasAttributeService{
    @Autowired
    HasAttributeRepository hasAttributeRepository;
    @Override
    public Response hasAttribute(HasAttribute hasAttribute) {
        try {
            hasAttributeRepository.save(hasAttribute);
        } catch (Exception e) {
            return new Response(e.getMessage(), "FAILED");
        }
        return new Response("Thêm thành công thuộc tính " + hasAttribute.getAttribute().getName() + "cho " + hasAttribute.getGemstone().getName(), "OK");
    }
}

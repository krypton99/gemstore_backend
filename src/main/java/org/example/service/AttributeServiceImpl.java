package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Attribute;
import org.example.model.AttributeType;
import org.example.model.Response;
import org.example.repository.AttributeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService{
    @Autowired
    AttributeRepository attributeRepository;

    @Override
    public Response createAttribute(Attribute attribute) {
        try {
          attributeRepository.save(attribute);
        } catch (Exception e) {
            return new Response(e.getMessage(), "FAILED");
        }
        return new Response("Tạo mới thuộc tính thành công", "FAILED");
    }

    @Override
    public Attribute findById(int id) throws ResourceNotFoundException {
        return attributeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy thuộc tính có id = " + id));
    }

    @Override
    public List<Attribute> findAll() {
        return attributeRepository.findAll();
    }

    @Override
    public Response deleteById(int id) throws ResourceNotFoundException {
        try {
            findById(id);
            attributeRepository.deleteById(id);
        } catch (Exception e) {
            return new Response(e.getMessage(), "FAILED");
        }
        return new Response("Xóa thành công thuộc tính có id = " + id, "OK");
    }

    @Override
    public Response softDeleteById(int id) throws ResourceNotFoundException {
        try {
            findById(id);
            attributeRepository.softDeleteById(id);
        } catch (Exception e) {
            return new Response(e.getMessage(), "FAILED");
        }
        return new Response("Xóa thành công thuộc tính có id = " + id, "OK");
    }
}

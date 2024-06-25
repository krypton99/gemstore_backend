package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.AttributeType;
import org.example.model.Response;
import org.example.repository.AttributeTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AttributeTypeServiceImpl implements AttributeTypeService {
    private AttributeTypeRepository attributeTypeRepository;
    @Override
    public Response addAttrType(AttributeType attributeType) {
        try {
            attributeTypeRepository.save(attributeType);
        } catch (Exception e) {
            return new Response(e.getMessage(), "FAILED");
        }
        return new Response("Thêm loại thuộc tính thành công", "OK");
    }

    @Override
    public AttributeType findById(int id) throws ResourceNotFoundException {
        return attributeTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy loại thuộc tính có id = " + id));
    }

    @Override
    public Response deleteById(int id) throws ResourceNotFoundException {
        try {
            AttributeType attributeType = attributeTypeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy loại thuộc tính có id = " + id));
        } catch (Exception e) {
            return new Response(e.getMessage(), "FAILED");
        }
        return new Response("Xóa loại thuộc tính thành công", "OK");
    }

    @Override
    public List<AttributeType> findAll() throws ResourceNotFoundException {
        return attributeTypeRepository.findAll();
    }

    @Override
    public Response softDeleteById(int id) throws ResourceNotFoundException {
        try {
            findById(id);
            attributeTypeRepository.softDeleteById(id);
        } catch (Exception e) {
            return new Response(e.getMessage(), "FAILED");
        }
        return new Response("Xóa thành công loại thuộc tính có id = " + id, "OK");
    }
}

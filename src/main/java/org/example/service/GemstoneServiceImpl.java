package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Attribute;
import org.example.model.Response;
import org.example.model.Gemstone;
import org.example.repository.GemstoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GemstoneServiceImpl implements GemstoneService {
    @Autowired
    private GemstoneRepository gemstoneRepository;
    @Override
    public Gemstone getGemstone(int id) throws ResourceNotFoundException {
        return gemstoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy gemstone có id = " + id));
    }

    @Override
    public Response addGemstone(Gemstone gem) {
        try
        {
            gemstoneRepository.save(gem);
        } catch (Exception e) {
            return new Response("An error has occurred", "FAILED");
        }

        return new Response("Add successfully", "OK");
    }

    @Override
    public Response deleteGemstone(int id) throws ResourceNotFoundException {
        try
        {
            gemstoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy gemstone với id : " + id));
            gemstoneRepository.deleteById(id);
        } catch (Exception e) {
            return new Response("Có lỗi xảy ra", "FAILED");
        }
        return new Response("Loại bỏ gemstone thành công", "OK");
    }

    @Override
    public List<Gemstone> getAllGemstones() throws ResourceNotFoundException {
        return gemstoneRepository.findAll();
    }

    @Override
    public Response softDeleteGemstone(int id) throws ResourceNotFoundException {
        try
        {
            gemstoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy gemstone với id : " + id));
            gemstoneRepository.softDeleteById(id);
        } catch (Exception e) {
            return new Response(e.getMessage(), "FAILED");
        }
        return new Response("Xóa thành công gemstone có id = " + id, "OK");
    }

    @Override
    public List<Gemstone> getAllDeletedGemstones() {
        return gemstoneRepository.findAllDeletedGemstones();
    }

    @Override
    public Response restoreDeletedGemstone(int id) throws ResourceNotFoundException {
        try
        {
            gemstoneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy gemstone với id : " + id));
            gemstoneRepository.restoreDeletedGemstone(id);
        } catch (Exception e) {
            return new Response(e.getMessage(), "FAILED");
        }
        return new Response("Khôi phục thành công gemstone có id = " + id, "OK");
    }

}

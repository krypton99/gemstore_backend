package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.GemstoneDescription;
import org.example.model.Response;
import org.example.repository.GemstoneDescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GemstoneDescriptionServiceImpl implements GemstoneDescriptionService{
    private GemstoneDescriptionRepository gemstoneDescriptionRepository;
    @Override
    public Response addGemstoneDescription(GemstoneDescription description) {
        try {
            gemstoneDescriptionRepository.save(description);
        } catch (Exception e) {
            return new Response("Có lỗi xảy ra khi thêm mô tả cho gemstone có id: " + description.getGemstone().getId(), "OK");
        }
        return new Response("Thêm thành công", "OK");
    }

    @Override
    public GemstoneDescription getDescription(long id) throws ResourceNotFoundException{
        return gemstoneDescriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy mô tả với id : " + id));
    }

    @Override
    public Response deleteGemstoneDescription(long id) throws ResourceNotFoundException{
        try {
            GemstoneDescription gemstoneDescription = gemstoneDescriptionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy mô tả với id : " + id));
        } catch (Exception e) {
            return new Response("Có lỗi xảy ra", "FAILED");
        }
        return new Response("Xóa thành công", "OK");
    }
}

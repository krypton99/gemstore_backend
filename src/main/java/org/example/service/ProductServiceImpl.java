package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Product;
import org.example.model.Response;
import org.example.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductServiceImpl implements ProductService{
    @Autowired
    ProductRepository productRepository;
    @Override
    public Response addProduct(Product product) {
        try
        {
            productRepository.save(product);
        } catch (Exception e) {
            return new Response("An error has occurred", "FAILED");
        }

        return new Response("Add successfully", "OK");
    }

    @Override
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(long id) throws ResourceNotFoundException {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy product có id = " + id));
    }

    @Override
    public Response softDeleteById(long id) throws ResourceNotFoundException {
        try {
            productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy product có id = " + id));
            productRepository.softDeleteById(id);
        } catch (Exception e) {
            return new Response("An Error has occured!", "FAILED");
        }

        return new Response("Soft delete successfully!", "OK");
    }

    @Override
    public Response deleteById(long id) throws ResourceNotFoundException {
        try {
            productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy product có id = " + id));
            productRepository.deleteById(id);
        } catch (Exception e) {
            return new Response("An Error has occured!", "FAILED");
        }

        return new Response("Delete successfully!", "OK");
    }

    @Override
    public List<Product> getAllDeletedProduct() {
        return productRepository.findAllDeleted();
    }

    @Override
    public Response restoreDeletedById(long id) throws ResourceNotFoundException {
        try {
            productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy product có id = " + id));
            productRepository.restoreDeleted(id);
        } catch (Exception e) {
            return new Response("An Error has occured!", "FAILED");
        }
        return new Response("Restore product id=" + id + " successfully!", "OK");
    }
}

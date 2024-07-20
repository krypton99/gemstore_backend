package org.example.service;

import org.example.exception.ResourceNotFoundException;
import org.example.model.Gemstone;
import org.example.model.Product;
import org.example.model.Response;

import java.util.List;

public interface ProductService {
    Response addProduct(Product product);
    List<Product> getAllProduct();
    Product findById(long id) throws ResourceNotFoundException;
    Response softDeleteById(long id) throws ResourceNotFoundException;
    Response deleteById(long id) throws ResourceNotFoundException;
    List<Product> getAllDeletedProduct();
    Response restoreDeletedById(long id) throws ResourceNotFoundException;

}

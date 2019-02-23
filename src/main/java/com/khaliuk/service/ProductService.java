package com.khaliuk.service;

import com.khaliuk.model.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> getAll();
    Optional<Product> getById(Long id);
}

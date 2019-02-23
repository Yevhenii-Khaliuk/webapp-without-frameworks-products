package com.khaliuk.service;

import com.khaliuk.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {
    private static List<Product> products = new ArrayList<>();

    static {
        products = CategoryServiceImpl.getAllProducts();
    }

    @Override
    public List<Product> getAll() {
        return products;
    }

    @Override
    public Optional<Product> getById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }
}

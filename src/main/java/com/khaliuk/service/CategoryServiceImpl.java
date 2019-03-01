package com.khaliuk.service;

import com.khaliuk.model.Category;
import com.khaliuk.model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CategoryServiceImpl implements CategoryService {
    private static List<Category> categories = new ArrayList<>();

    static {
        List<Product> products1 = new ArrayList<>();
        products1.add(new Product("iPhone", "Apple product", 999.99));
        products1.add(new Product("Samsung", "Korean product", 699.99));
        products1.add(new Product("Xiaomi", "Chinese product", 449.99));
        Category category1 = new Category(1L,"Mobile Phones", "Best ever phones");
        category1.setProducts(products1);
        categories.add(category1);
        List<Product> products2 = new ArrayList<>();
        products2.add(new Product("Apple MacBook Pro", "Apple product", 2499.99));
        products2.add(new Product("Dell XPS",
                "Laptop with exceptional build quality, powerful features and security options",
                1999.99));
        products2.add(new Product("HP Envy",
                "Exceptional power in a sleek, stylish design", 1449.99));
        Category category2 =
                new Category(2L, "Laptops", "Best products for your business");
        category2.setProducts(products2);
        categories.add(category2);
        List<Product> products3 = new ArrayList<>();
        products3.add(new Product("LG OLED", "Home entertainment center", 2219.99));
        products3.add(new Product("Sony MASTER",
                "Pictures and sound in perfect harmony", 5999.99));
        products3.add(new Product("Philips NetTV",
                    "Instant access to  media portals", 1949.99));
        Category category3 = new Category(3L, "TVs", "Chinese TVs");
        category3.setProducts(products3);
        categories.add(category3);
    }

    @Override
    public List<Category> getAll() {
        return categories;
    }

    @Override
    public Optional<Category> getById(Long id) {
        return categories.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    public static List<Product> getAllProducts() {
        return categories.stream()
                .flatMap(category -> category.getProducts().stream())
                .collect(Collectors.toList());
    }
}

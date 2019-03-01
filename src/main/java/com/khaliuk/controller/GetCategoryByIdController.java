package com.khaliuk.controller;

import static java.util.Collections.emptyList;

import com.khaliuk.Request;
import com.khaliuk.ViewModel;
import com.khaliuk.service.CategoryService;

public class GetCategoryByIdController implements Controller {
    private final CategoryService categoryService;

    public GetCategoryByIdController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ViewModel process(Request req) {
        String param = req.getParam("c_id")[0];
        Long id = Long.parseLong(param);
        return categoryService.getById(id)
                .map(c -> ViewModel.of("category").withAttribute("category", c))
                .orElseGet(() -> ViewModel.of("category").withAttribute("category", emptyList()));
    }
}

package com.khaliuk.controller;

import static java.util.Collections.emptyList;

import com.khaliuk.Request;
import com.khaliuk.ViewModel;
import com.khaliuk.service.ProductService;

public class GetProductByIdController implements Controller {
    private final ProductService productService;

    public GetProductByIdController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ViewModel process(Request req) {
        String param = req.getParam("p_id")[0];
        Long id = Long.parseLong(param);
        return productService.getById(id)
                .map(p -> ViewModel.of("product").withAttribute("product", p))
                .orElseGet(() -> ViewModel.of("product").withAttribute("product", emptyList()));
    }
}

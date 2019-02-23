package com.khaliuk;

import com.khaliuk.controller.GetAllCategoriesController;
import com.khaliuk.controller.GetCategoryByIdController;
import com.khaliuk.controller.LoginUserController;
import com.khaliuk.service.CategoryService;
import com.khaliuk.service.CategoryServiceImpl;
import com.khaliuk.service.UserService;
import com.khaliuk.service.UserServiceImpl;

public class Factory {

    public static LoginUserController getLoginUserController(UserService userService) {
        return new LoginUserController(userService);
    }

    public static UserService getUserServiceImpl() {
        return new UserServiceImpl();
    }

    public static GetAllCategoriesController getGetAllCategoriesController(CategoryService categoryService) {
        return new GetAllCategoriesController(categoryService);
    }

    public static CategoryService getCategoryService() {
        return new CategoryServiceImpl();
    }

    public static GetCategoryByIdController getGetCategoryByIdController(CategoryService categoryService) {
        return new GetCategoryByIdController(categoryService);
    }
}

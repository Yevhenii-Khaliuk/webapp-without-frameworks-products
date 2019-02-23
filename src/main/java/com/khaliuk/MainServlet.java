package com.khaliuk;

import static com.khaliuk.Factory.getCategoryService;
import static com.khaliuk.Factory.getGetAllCategoriesController;
import static com.khaliuk.Factory.getGetCategoryByIdController;
import static com.khaliuk.Factory.getLoginUserController;
import static com.khaliuk.Factory.getUserServiceImpl;

import com.khaliuk.controller.Controller;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
    private static final Map<Request, Controller> controllerMap = new HashMap<>();

    static {
        controllerMap.put(Request.of("GET", "/servlet/login"), r -> ViewModel.of("login"));
        controllerMap.put(Request.of("POST", "/servlet/login"),
                getLoginUserController(getUserServiceImpl()));
        controllerMap.put(Request.of("GET", "/servlet/categories"),
                getGetAllCategoriesController(getCategoryService()));
        controllerMap.put(Request.of("GET", "/servlet/category"),
                getGetCategoryByIdController(getCategoryService()));
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Request request = Request.of(req.getMethod(), req.getRequestURI(), req.getParameterMap());
        Controller controller = controllerMap.getOrDefault(request, r -> ViewModel.of("404"));
        ViewModel vm = controller.process(request);
        processViewModel(vm, req, resp);
    }

    private void processViewModel(ViewModel vm, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        vm.getAttributes().forEach(req::setAttribute);
        req.getRequestDispatcher(vm.gerRedirectUri()).forward(req, resp);
    }
}

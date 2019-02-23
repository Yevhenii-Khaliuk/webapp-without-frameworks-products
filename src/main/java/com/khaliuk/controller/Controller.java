package com.khaliuk.controller;

import com.khaliuk.Request;
import com.khaliuk.ViewModel;

public interface Controller {
    ViewModel process(Request req);
}

package com.timzowen.thymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String productController(Model model){
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop","HP",120000));
        products.add(new Product("Table","mahogany",400000));
        products.add(new Product("pen","blue pen",56780));
        products.add(new Product("papers","white",7896765));
        model.addAttribute("products",products);
        return "product-item";
    }

}

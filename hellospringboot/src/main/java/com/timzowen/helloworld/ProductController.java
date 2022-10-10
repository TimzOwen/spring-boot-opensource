package com.timzowen.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/product")
    public Product getProduct(){
        return new Product("Radio","Nairobi");
    }

    // Return List of beans
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        products.add(new Product("Phone","Meru"));
        products.add(new Product("Table","Mombasa"));
        products.add(new Product("HeadPhones","London"));
        products.add(new Product("Laptop","United"));
        products.add(new Product("Plot","Eldoret"));
        return products;
    }

    // Path Variable
    @GetMapping("/product/{name}/{location}")
    public Product productPathVar(
            @PathVariable("name") String name,
            @PathVariable("location") String location){
        return new Product(name,location);
    }

    // Return query parameter
    @GetMapping("/product/query")
    public Product productParam(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "location") String location){
        return new Product(name,location);
    }

}

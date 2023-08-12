package com.timz.owen.controllers;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products-controller")
public class ProductsController {

    @GetMapping
    public ResponseEntity<String> springSecurity(){
        return ResponseEntity.ok("End point is secured!! ");
    }
}

package com.example.springsecurity.controller;

import com.example.springsecurity.dto.Product;
import com.example.springsecurity.entity.UserInfo;
import com.example.springsecurity.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/new")
    public String addNewUser(@RequestBody UserInfo userInfo) {
        return productService.addUser(userInfo);
    }


    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome onboard";
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/all")
    public List<Product> products() {
        return productService.getProducts();
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProduct(id);
    }

}

package com.demo.controller;

import com.demo.model.Product;
import com.demo.service.product.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private Services productService;

    @GetMapping("")
    public List<Product> getProduct() {
        return productService.fetchall();
    }
    @PostMapping("add")
    public Product addProduct(@RequestBody Product prod){
        return productService.add(prod);
    }
    @PutMapping("update")
    public Product updateProduct(@RequestBody Product prod){
        return productService.update(prod);
    }
    @DeleteMapping("delete")
    public String deleteProduct(@RequestParam String id){
        return productService.delete(Integer.parseInt(id));
    }
}

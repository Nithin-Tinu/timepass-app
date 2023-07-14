package com.demo.service.product;

import com.demo.model.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface Services{
    public Product add(Product prod);
    public List<Product> fetchall();
    public Product update(Product prod);
    public String delete(Integer id);
}

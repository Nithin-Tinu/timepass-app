package com.demo.service.product;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import com.demo.model.Product;

import java.util.List;

@Service
public class ProductServices implements Services {
    static ArrayList<Product> products = new ArrayList<Product>();

    @Autowired
    private ProductDbRepo dbRepo;
    static private int Count;
    static {
        Count =3;
        products.add(new Product(100, "Mobile", "CLK98123", 9000.00, 6));
        products.add(new Product(101, "Smart TV", "LGST09167", 60000.00, 3));
        products.add(new Product(102, "Washing Machine", "38753BK9", 9000.00, 7));
        products.add(new Product(103, "Laptop", "LHP29OCP", 24000.00, 1));
        products.add(new Product(104, "Air Conditioner", "ACLG66721", 30000.00, 5));
        products.add(new Product(105, "Refrigerator ", "12WP9087", 10000.00, 4));

    }

    @Override
    public List<Product> fetchall() {
        // returns a list of product
        return dbRepo.findAll();
    }

    @Override
    public Product add(Product prod) {
        prod.setId((int)dbRepo.count()+Count);
        return dbRepo.insert(prod);
    }

    @Override
    public Product update(Product prod){
        Product foundProd=dbRepo.findById(prod.getId()).get();
        foundProd.setPrice(prod.getPrice());
        foundProd.setNoofproduct(prod.getNoofproduct());
        
        return dbRepo.save(foundProd);
    }

    @Override
    public String delete(Integer id) {
        dbRepo.deleteById(id);
        Count+=1;
        return "done";
    }
}

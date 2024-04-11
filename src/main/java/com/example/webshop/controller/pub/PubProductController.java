package com.example.webshop.controller.pub;

import com.example.webshop.dao.ProductDAO;
import com.example.webshop.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/pub/products")
public class PubProductController {

    private final ProductDAO productDAO;

    public PubProductController(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        return ResponseEntity.ok(this.productDAO.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id){
        return ResponseEntity.ok(this.productDAO.getProductById(id));
    }

}

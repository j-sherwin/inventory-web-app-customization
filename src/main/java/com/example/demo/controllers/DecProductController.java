package com.example.demo.controllers;

import com.example.demo.domain.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DecProductController {

    // private ApplicationContext context;
    private ProductService productService;
    @Autowired
    public DecProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/buyProduct")
    public String submitPurchaseForm(@RequestParam("theId") int theId){
        Product tempProduct = productService.findById(theId);

        if (tempProduct.getInv() == 0) {
            return "purchaseFailed";
        }
        else {
            productService.decreaseInvById(theId);
            return "purchaseComplete";
        }
    }

}

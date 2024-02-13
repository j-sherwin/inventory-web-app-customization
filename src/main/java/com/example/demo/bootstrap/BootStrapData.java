package com.example.demo.bootstrap;

import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    int partCount = (int) partRepository.count();
    int productCount = (int) productRepository.count();

    if (partCount == 0 && productCount == 0) {
        OutsourcedPart part1 = new OutsourcedPart();
        part1.setCompanyName("Nvidia");
        part1.setName("Graphics Card");
        part1.setInv(3);
        part1.setPrice(499.99);
        part1.setId(100L);
        part1.setMaxInv(5);
        part1.setMinInv(1);
        outsourcedPartRepository.save(part1);

        OutsourcedPart part2 = new OutsourcedPart();
        part2.setCompanyName("AMD");
        part2.setName("Ryzen Processor");
        part2.setInv(10);
        part2.setPrice(299.99);
        part2.setId(101L);
        part2.setMaxInv(15);
        part2.setMinInv(2);
        outsourcedPartRepository.save(part2);

        OutsourcedPart part3 = new OutsourcedPart();
        part3.setCompanyName("G.Skill");
        part3.setName("8gb DDR4 Ram");
        part3.setInv(26);
        part3.setPrice(39.99);
        part3.setId(102L);
        part3.setMaxInv(40);
        part3.setMinInv(2);
        outsourcedPartRepository.save(part3);

        OutsourcedPart part4 = new OutsourcedPart();
        part4.setCompanyName("Western Digital");
        part4.setName("1TB M.2 SSD");
        part4.setInv(10);
        part4.setPrice(99.99);
        part4.setId(103L);
        part4.setMaxInv(15);
        part4.setMinInv(2);
        outsourcedPartRepository.save(part4);

        OutsourcedPart part5 = new OutsourcedPart();
        part5.setCompanyName("Gigabyte");
        part5.setName("Motherboard");
        part5.setInv(6);
        part5.setPrice(179.99);
        part5.setId(104L);
        part5.setMaxInv(10);
        part5.setMinInv(2);
        outsourcedPartRepository.save(part5);

        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        Product product1 = new Product("Gaming PC", 1999.99, 2);
        Product product2 = new Product("Office PC", 749.99, 1);
        Product product3 = new Product("Budget PC", 399.99, 5);
        Product product4 = new Product("Ultimate Gaming PC", 2999.99, 3);
        Product product5 = new Product("Used Desktop PC", 199.99, 8);
        productRepository.save(product1);
        productRepository.save(product2);
        productRepository.save(product3);
        productRepository.save(product4);
        productRepository.save(product5);
    }
    else {
        System.out.println("-- Products or Parts Inventory Already Loaded --");
    }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}

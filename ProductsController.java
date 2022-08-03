package kodlamaio.northwind.api.controllers;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@Getter
@Setter
public class ProductsController {
    private ProductService productService;

    @Autowired
    public ProductsController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/get-all")
    public DataResult<List<Product>> getAll() {
        return this.productService.getAll();
    }
    @PostMapping("/add")
    public Result add(@RequestBody Product product){
          return this.productService.add(product);
    }
    @GetMapping("/getByProductName")
    public DataResult<Product> getByProductName(@RequestParam String productName){
        return this.productService.getByProductName(productName);

    }
    @GetMapping("/getByProductNameAndCategoryId")
    public DataResult <Product>
    getByProductNameAndCategoryId
            (@RequestParam("productName") String productName,@RequestParam("categoryId") int categoryId){
        return this.productService.getByProductNameAndCategory(productName,categoryId);
    }
    @GetMapping("/getByProductNameContains")
    DataResult<List<Product>>getByProductNameContains(@RequestParam String productName){
        return this.productService.getByProductNameContains(productName);
    }
}

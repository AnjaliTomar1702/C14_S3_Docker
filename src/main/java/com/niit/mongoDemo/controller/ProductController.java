package com.niit.mongoDemo.controller;

import com.niit.mongoDemo.domain.Product;
import com.niit.mongoDemo.exception.ProductAlreadyExistsException;
import com.niit.mongoDemo.exception.ProductNotFoundException;
import com.niit.mongoDemo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/productservice/")
public class ProductController {

    private ResponseEntity responseEntity;
    private ProductService productService;


    @Autowired

    public ProductController(final ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("product")
    public ResponseEntity<?> saveCustomer(@RequestBody Product customer) throws ProductAlreadyExistsException {
        try {
            productService.addProduct(customer);
            responseEntity = new ResponseEntity(customer , HttpStatus.CREATED);
        } catch (ProductAlreadyExistsException e) {
            throw new ProductAlreadyExistsException();
        }
        catch (Exception e)
        {
            responseEntity = new ResponseEntity<>("Error  !!!Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
            System.out.println(e);
        }

        return responseEntity;
    }

    @DeleteMapping("product/{productId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable("customerId") int customerId) throws ProductNotFoundException {


        try {
            productService.deleteProduct(customerId);
            responseEntity = new ResponseEntity("Successfully deleted !!!", HttpStatus.OK);
        } catch (ProductNotFoundException e) {


            throw new ProductNotFoundException();
        }
        catch (Exception exception){
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @GetMapping("products")
    public ResponseEntity<?> getAllCustomer(@PathVariable int id){


        try{

            responseEntity = new ResponseEntity(productService.getProduct(id), HttpStatus.OK);

        }catch (Exception e){
            responseEntity = new ResponseEntity("Error !!! Try after sometime.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;

    }

}


//
//import java.util.List;
//import java.util.NoSuchElementException;
//@RestController
//public class ProductController {
//    private ResponseEntity responseEntity;
//    ProductImpl productService;
//
//    @Autowired
//    public ProductController(ProductImpl productService)
//
//    {
//        this.productService =productService;
//    }
//    @GetMapping("/product")
//    public ResponseEntity<?> getAllProduct()
//    {
//        List<Product> customerList= productService.findAllProducts();
//        return new ResponseEntity<>(customerList, HttpStatus.OK);
//    }
//    @PostMapping("/addproduct")
//    public ResponseEntity<?> addProduct(@RequestBody Product productdata) throws ProductAlreadyExistsException
//    {
////        Product product= productService.addProduct(productdata);
////        return new ResponseEntity<>(product, HttpStatus.OK);
//        try {
//            productService.addProduct(productdata);
//            responseEntity = new ResponseEntity(productdata , HttpStatus.CREATED);
//        } catch (ProductAlreadyExistsException e) {
//            throw new ProductAlreadyExistsException();
//        }
//        catch (Exception e)
//        {
//            responseEntity = new ResponseEntity<>("Error  !!!Try after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
//            System.out.println(e);
//        }
//
//        return responseEntity;
//
//}
//
//    @GetMapping("/product/{id}")
//    public ResponseEntity<?> getProduct(@PathVariable int id) throws Exception {
//        Product fetchedProduct=null;
//        ResponseEntity responseEntity=null;
//        try {
//            fetchedProduct = productService.getProduct(id);
//            return   responseEntity=new ResponseEntity<>("given data found", HttpStatus.OK);
//        } catch (NoSuchElementException e1) {
//            throw new Exception();
//        }
//    }
//    @DeleteMapping("/product/{id}")
//    public ResponseEntity<?> deleteProduct(@PathVariable int id) throws ProductNotFoundException {
//        productService.deleteProduct(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }
//
//    @GetMapping("/productname/{productName}")
//    public ResponseEntity<?> getProductName(@PathVariable String name)
//    {
//        List<Product> fetchCustomer= productService.findAllByName(name);
//        return new ResponseEntity<>(fetchCustomer, HttpStatus.OK);
//    }
//
//    @GetMapping("/productmaterial/{material}")
//    public ResponseEntity<?> getProductMaterial(@PathVariable String material)
//    {
//        List<Product> fetchProduct= productService.findAllByProductMaterial(material);
//        return new ResponseEntity<>(fetchProduct, HttpStatus.OK);
//    }
//}

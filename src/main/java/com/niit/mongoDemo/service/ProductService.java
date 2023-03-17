package com.niit.mongoDemo.service;
import com.niit.mongoDemo.domain.Product;
import com.niit.mongoDemo.exception.ProductAlreadyExistsException;
import com.niit.mongoDemo.exception.ProductNotFoundException;


import java.util.*;
public interface ProductService {

    Product addProduct(Product product) throws ProductAlreadyExistsException;
    List<Product> findAllProducts();
    Product getProduct(int id) throws Exception;
    boolean deleteProduct(int id) throws ProductNotFoundException;
    List<Product> findAllByName(String name);
    List<Product> findAllByProductMaterial(String material);
}
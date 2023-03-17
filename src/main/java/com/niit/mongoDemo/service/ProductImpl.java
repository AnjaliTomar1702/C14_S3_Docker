package com.niit.mongoDemo.service;
import com.niit.mongoDemo.domain.Product;
import com.niit.mongoDemo.exception.ProductNotFoundException;
import com.niit.mongoDemo.exception.ProductAlreadyExistsException;

import com.niit.mongoDemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ProductImpl implements ProductService{
    ProductRepository productRepository;
    @Autowired
    public ProductImpl(
            ProductRepository customerRepository) {
        this.productRepository = customerRepository;
    }


    @Override
    public Product addProduct(Product product) throws ProductAlreadyExistsException {
//        return productRepository.save(product);
        if(productRepository.findById(product.getProductId()).isPresent())
        {
            throw new ProductAlreadyExistsException();
        }
        return productRepository.save(product);
    }




    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();

    }

    @Override
    public Product getProduct(int id)throws Exception  {
        if(productRepository.findById(id).isEmpty()){
            throw new Exception();
        }

        return productRepository.findById(id).get();
    }
    @Override
    public boolean deleteProduct(int id) throws ProductNotFoundException {
        boolean flag = false;
        if(productRepository.findById(id).isEmpty())
        {
            throw new ProductNotFoundException();
        }
        else {
            productRepository.deleteById(id);
            flag = true;
        }
        return flag;

    }

    @Override
    public List<Product> findAllByName(String productName) {

        return productRepository.findByProductName(productName);

    }

    @Override
    public List<Product> findAllByProductMaterial(String productName) {
        return productRepository.findByMaterial(productName);

    }
}

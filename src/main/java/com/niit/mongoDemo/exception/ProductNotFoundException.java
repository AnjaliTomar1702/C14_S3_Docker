package com.niit.mongoDemo.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Product with specified id is not found")
public class ProductNotFoundException extends Exception{
    public ProductNotFoundException(){

    }
}

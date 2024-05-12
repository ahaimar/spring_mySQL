package com.Order.ApOrder.OrderExeption;

public class OrderNotFoundException extends RuntimeException{

    public OrderNotFoundException(int id){
        super("Could not found the Order with id "+ id);
    }
}

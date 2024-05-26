package com.javatechie.os.api.controller;

import com.javatechie.os.api.common.TransactionRequest;
import com.javatechie.os.api.common.TranscationResponse;
import com.javatechie.os.api.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping("/bookOrders")
    public TranscationResponse bookOrder(@RequestBody TransactionRequest transactionRequest){
     return service.saveOrder(transactionRequest);
    }
}

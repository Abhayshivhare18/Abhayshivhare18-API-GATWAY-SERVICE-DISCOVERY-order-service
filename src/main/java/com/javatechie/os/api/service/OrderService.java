package com.javatechie.os.api.service;

import com.javatechie.os.api.Entity.Order;
import com.javatechie.os.api.common.Payment;
import com.javatechie.os.api.common.TransactionRequest;
import com.javatechie.os.api.common.TranscationResponse;
import com.javatechie.os.api.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    @Autowired
    private RestTemplate template;

    public TranscationResponse saveOrder(TransactionRequest transactionRequest){
       String response="";
        Order order = transactionRequest.getOrder();
        Payment payment= transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        // rest call
       Payment paymentResponse= template.postForObject("http://payment-service/payment/doPayment",payment,Payment.class);
       response =paymentResponse.getPaymentStatus().equals("success")?"payment success":"payment fail";
       repository.save(order);
       return new TranscationResponse(order,paymentResponse.getTransactionId(),
               paymentResponse.getAmount(),response);
    }
}

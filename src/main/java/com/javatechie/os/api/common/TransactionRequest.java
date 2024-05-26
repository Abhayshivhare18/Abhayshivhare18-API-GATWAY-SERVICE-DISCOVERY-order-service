package com.javatechie.os.api.common;

import com.javatechie.os.api.Entity.Order;
import lombok.Data;

@Data
public class TransactionRequest {

    private Order order;
    private Payment payment;
}


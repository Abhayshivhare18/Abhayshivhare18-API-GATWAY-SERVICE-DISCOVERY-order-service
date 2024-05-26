package com.javatechie.os.api.common;

import com.javatechie.os.api.Entity.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TranscationResponse {

    private Order order;
    private String transactionId;

    private double amount;

    private String message;

}

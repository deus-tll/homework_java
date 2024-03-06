package org.deus.homework_006.requests;

import lombok.Data;

@Data
public class OrderRequest {
    private String pizzaName;
    private String customerName;
    private String phoneNumber;
    private String email;
    private String deliveryAddress;
}

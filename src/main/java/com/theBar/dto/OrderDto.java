package com.theBar.dto;

import com.theBar.dto.tm.CartTm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private String orderId;
    private LocalDate date;
    private String customerId;
    private String payment;
    private List<CartTm> cartTmList = new ArrayList<>();
}

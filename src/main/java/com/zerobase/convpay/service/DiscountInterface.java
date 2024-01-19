package com.zerobase.convpay.service;

import com.zerobase.convpay.DTO.PayRequest;

public interface DiscountInterface {
    Integer getDiscountedAmount(PayRequest payRequest);
}

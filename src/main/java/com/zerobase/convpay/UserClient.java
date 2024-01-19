package com.zerobase.convpay;

import com.zerobase.convpay.DTO.PayCancelRequest;
import com.zerobase.convpay.DTO.PayCancelResponse;
import com.zerobase.convpay.DTO.PayRequest;
import com.zerobase.convpay.DTO.PayResponse;
//import com.zerobase.convpay.config.ApplicationConfig;
import com.zerobase.convpay.config.ApplicationConfig;
import com.zerobase.convpay.service.ConveniencePayService;
import com.zerobase.convpay.type.ConvenienceType;
import com.zerobase.convpay.type.PayMethodType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserClient {
    public static void main(String[] args) {
        // `사용자` -> 편결이 -> 머니

        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(ApplicationConfig.class);

        ConveniencePayService conveniencePayService =
                applicationContext.getBean("conveniencePayService", ConveniencePayService.class);

        // 1. 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.CARD,
                ConvenienceType.G25, 1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);


        // 2. 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY,
                ConvenienceType.G25, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);

        System.out.println(payCancelResponse);
    }
}

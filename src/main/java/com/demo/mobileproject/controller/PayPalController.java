package com.demo.mobileproject.controller;

import com.braintreegateway.BraintreeGateway;
import com.demo.mobileproject.domain.PaypalClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping(value = "/paypal")
public class PayPalController {

    private final PaypalClient payPalClient;

    @Autowired
    PayPalController(PaypalClient payPalClient) {
        this.payPalClient = payPalClient;
    }

    //    @CrossOrigin(origins = "http://localhost:8088")
    @PostMapping(value = "/make/payment")
    public Map<String, Object> makePayment(@RequestParam("sum") String sum) {
        return payPalClient.createPayment(sum);
    }

    //    @CrossOrigin(origins = "http://localhost:8088")
    @PostMapping(value = "/complete/payment")
    public Map<String, Object> completePayment(HttpServletRequest request, @RequestParam("paymentId") String paymentId, @RequestParam("payerId") String payerId) {
        return payPalClient.completePayment(request);
    }


}

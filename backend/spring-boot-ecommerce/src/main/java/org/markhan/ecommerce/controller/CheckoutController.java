package org.markhan.ecommerce.controller;

import org.jboss.logging.Logger;
import org.markhan.ecommerce.dto.PaymentInfo;
import org.markhan.ecommerce.dto.Purchase;
import org.markhan.ecommerce.dto.PurchaseResponse;
import org.markhan.ecommerce.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

@CrossOrigin(origins ={"http://ecommerce-site-client.s3-website.us-east-2.amazonaws.com", "http://localhost:4200"}, maxAge = 3600, allowCredentials="true")
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	private CheckoutService checkoutService;
	
	@Autowired
	public CheckoutController(CheckoutService checkoutService) {
		this.checkoutService = checkoutService;
	}
	
	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		
		PurchaseResponse purchaseResponse = checkoutService.placeOrder(purchase);
		
		return purchaseResponse;
	}
	
	@PostMapping("/payment-intent")
	public ResponseEntity<String> createPaymentIntent(@RequestBody PaymentInfo paymentInfo) throws StripeException {
		
		logger.info("paymentInfo.amount: " + paymentInfo.getAmount());
		
		PaymentIntent paymentIntent = checkoutService.createPaymentIntent(paymentInfo);
		
		String paymentStr = paymentIntent.toJson();
		
		return new ResponseEntity<>(paymentStr, HttpStatus.OK);
	}
}

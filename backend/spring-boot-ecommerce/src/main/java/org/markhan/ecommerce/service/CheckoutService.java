package org.markhan.ecommerce.service;

import org.markhan.ecommerce.dto.PaymentInfo;
import org.markhan.ecommerce.dto.Purchase;
import org.markhan.ecommerce.dto.PurchaseResponse;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;

public interface CheckoutService {
	
	PurchaseResponse placeOrder(Purchase purchase);
	
	PaymentIntent createPaymentIntent(PaymentInfo paymentInfo) throws StripeException;

}

package org.markhan.ecommerce.dto;

import java.util.Set;

import org.markhan.ecommerce.entity.Address;
import org.markhan.ecommerce.entity.Customer;
import org.markhan.ecommerce.entity.Order;
import org.markhan.ecommerce.entity.OrderItem;

import lombok.Data;

@Data
public class Purchase {

	private Customer Customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;
}

package com.casestudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.casestudy.dto.OrderProduct;
import com.casestudy.dto.OrderStatus;
import com.casestudy.dto.Status.StatusType;
import com.casestudy.entity.Order;
import com.casestudy.exception.OrderException;
import com.casestudy.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/order")
	public OrderStatus purchaseProduct(@RequestBody OrderProduct prod) {
		try {
			int product_id=prod.getProductId();
			String username=prod.getUsername();
			int scheme=prod.getScheme();
			OrderStatus status=new OrderStatus();
			orderService.checkCardAmount(username, product_id);
			Order order=orderService.orderProduct(username, scheme, product_id);
			status.setStatus(StatusType.SUCCESS);
			status.setProduct_id(product_id);
			status.setOrder_id(order.getOrderId());
			status.setMessage("Order Dispatched");
			return status;

		}
		catch(OrderException e) {
			OrderStatus status=new OrderStatus();
			status.setStatus(StatusType.FAILED);
			status.setMessage("Insufficient Balance");
			return status;
		}
	}

}

package com.devsuperior.ds_order_system;

import com.devsuperior.ds_order_system.entities.Order;
import com.devsuperior.ds_order_system.services.OrderService;
import com.devsuperior.ds_order_system.services.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class DsOrderSystemApplication implements CommandLineRunner {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ShippingService shippingService;


	public static void main(String[] args) {
		SpringApplication.run(DsOrderSystemApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.US);

		int code = sc.nextInt();
		double basic = sc.nextDouble();
		double discount = sc.nextDouble();

		Order order = new Order(code, basic, discount);
		orderService.total(order);
		shippingService.shipment(order);
		System.out.println("Pedido código: " + order.getCode() + "\nValor total: " + order.getBasic());

		sc.close();
	}
}

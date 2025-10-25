package com.application.simpleorderingsystem.entities;

import com.application.simpleorderingsystem.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_orders")
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Long id;

	@Getter
	@Setter
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;

	private Integer orderStatus;

	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name = "client_id")
	private User client;

	@OneToMany(mappedBy = "id.order")
	@Getter
	private Set<OrderItem> items = new HashSet<>();

	@Getter
	@Setter
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;


	public Order() {
	}
	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}


	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus == null) {
			throw new IllegalArgumentException("Order status cannot be null");
		}
		this.orderStatus = orderStatus.getCode();
	}


	public Double getTotal() {
		Double sum = 0.0;
		for (OrderItem item : items) {
			sum += item.getSubTotal();
		}
		return sum;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null || getClass() != o.getClass()) return false;
		Order order = (Order) o;
		return Objects.equals(id, order.id);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}
}

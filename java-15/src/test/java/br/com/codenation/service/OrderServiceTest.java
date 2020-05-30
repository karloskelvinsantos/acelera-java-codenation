package br.com.codenation.service;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;

public class OrderServiceTest {

	private OrderService orderService = new OrderServiceImpl();

	@Test
	public void testCalculateOrderValue() {
		List<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		assertNotNull(this.orderService.calculateOrderValue(items));
	}

	@Test
	public void testCalculateOrderValueTotal() {
		List<OrderItem> items = new ArrayList();
		items.add(new OrderItem(1L, 3L));
		items.add(new OrderItem(2L, 2L));
		Assert.assertEquals(Double.valueOf(850.0), this.orderService.calculateOrderValue(items));
	}

	@Test
	public void testFindProductsById() {
		assertNotNull(this.orderService.findProductsById(Arrays.asList(1l, 2l, 3l, 4l, 5l)).size());
	}

	@Test
	public void testFindProductsByIdSize2() {
		Assert.assertEquals(2L, (long)this.orderService.findProductsById(Arrays.asList(1L, 2L, 9223372036854775807L)).size());
	}

	@Test
	public void testCalculateMultipleOrders() {
		List<OrderItem> items = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		List<OrderItem> items2 = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		List<OrderItem> items3 = new ArrayList<>();
		items.add(new OrderItem(1l, 3l));
		items.add(new OrderItem(2l, 2l));
		assertNotNull(this.orderService.calculateMultipleOrders(Arrays.asList(items, items2, items3)));
	}

	@Test
	public void testCalculateTotalValueMultipleOrdersWithSale() {
		List<OrderItem> items = new ArrayList();
		items.add(new OrderItem(1L, 3L));
		items.add(new OrderItem(2L, 2L));
		items.add(new OrderItem(8L, 1L));
		List<OrderItem> items2 = new ArrayList();
		items2.add(new OrderItem(1L, 3L));
		items2.add(new OrderItem(2L, 2L));
		Assert.assertEquals(Double.valueOf(1860.0), this.orderService.calculateMultipleOrders(Arrays.asList(items, items2)));
	}

	@Test
	public void testGroupProducts() {
		Map<Boolean, List<Product>> groupedProducts = this.orderService.groupProductsBySale(Arrays.asList(1l, 2l, 12l));
		assertNotNull(groupedProducts.get(true));
		assertNotNull(groupedProducts.get(false));
	}

}

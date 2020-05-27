package br.com.codenation.service;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

public class OrderServiceImpl implements OrderService {

	private ProductRepository productRepository = new ProductRepositoryImpl();

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		Supplier<Stream<OrderItem>> orderItemStream = items::stream;
		Supplier<Stream<Product>> productStream = () -> orderItemStream.get().map(item -> productRepository.findById(item.getProductId()).get());

		Double productsIsNotSale = productStream.get()
						.filter(p -> p.getIsSale() == Boolean.FALSE)
						.reduce(0D,
										(partial, product) ->
														partial + (product.getValue() * orderItemStream
																		.get()
																		.filter(item -> item.getProductId().equals(product.getId()))
																		.mapToDouble(OrderItem::getQuantity)
																		.findAny()
																		.orElse(0)),
										Double::sum);

		Double productsIsSale = productStream.get()
						.filter(Product::getIsSale)
						.reduce(0D,
										(partial, product) ->
														partial + (product.getValue() * 0.20) * orderItemStream
																		.get()
																		.filter(item -> item.getProductId().equals(product.getId()))
																		.mapToDouble(OrderItem::getQuantity)
																		.findAny()
																		.orElse(0),
										Double::sum);

		return Double.sum(productsIsNotSale, productsIsSale);
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
						.map(id -> productRepository.findById(id).get())
						.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		double calculate = 0D;

		for (List<OrderItem> order : orders) {
			calculate = Double.sum(calculate, calculateOrderValue(order));
		}
		return calculate;
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return productIds.stream()
						.map(id -> productRepository.findById(id).get())
						.collect(
										Collectors.groupingBy(Product::getIsSale, Collectors.toList())
						);
	}

}
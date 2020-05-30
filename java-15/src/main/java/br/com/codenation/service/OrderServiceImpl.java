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

	private final ProductRepository productRepository = new ProductRepositoryImpl();
	private final double descountWhereIsSale = 0.2d;

	/**
	 * Calculate the sum of all OrderItems
	 */
	@Override
	public Double calculateOrderValue(List<OrderItem> items) {
		return items.stream().mapToDouble(item -> {
			Optional<Product> product = productRepository.findById(item.getProductId());

			if (product.isPresent()) {
				if (product.get().getIsSale())
					return (product.get().getValue() - product.get().getValue() * descountWhereIsSale) * item.getQuantity();
				else
					return product.get().getValue() * item.getQuantity();
			} else {
				return (double) 0;
			}

		}).sum();
	}

	/**
	 * Map from idProduct List to Product Set
	 */
	@Override
	public Set<Product> findProductsById(List<Long> ids) {
		return ids.stream()
						.map(productRepository::findById)
						.filter(Optional::isPresent)
						.map(Optional::get)
						.collect(Collectors.toSet());
	}

	/**
	 * Calculate the sum of all Orders(List<OrderIten>)
	 */
	@Override
	public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
		return orders.stream()
						.mapToDouble(this::calculateOrderValue)
						.sum();
	}

	/**
	 * Group products using isSale attribute as the map key
	 */
	@Override
	public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
		return findProductsById(productIds)
						.stream()
						.collect(Collectors.groupingBy(Product::getIsSale, Collectors.toList()));
	}

}
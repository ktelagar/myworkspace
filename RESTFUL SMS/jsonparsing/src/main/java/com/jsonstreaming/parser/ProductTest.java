package com.jsonstreaming.parser;

public class ProductTest {
	public static void main(String[] args) {
		ProductRepository productRepository = new ProductRepository();
//		int nProducts = productRepository.getNoOfProducts();
//		System.out.println("no products : " + nProducts);
		int nProducts = productRepository.getNoOfProducts("kitchen tools");
		System.out.println("no products : " + nProducts);
	}
}

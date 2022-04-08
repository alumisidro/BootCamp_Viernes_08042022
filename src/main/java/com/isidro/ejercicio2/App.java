package com.isidro.ejercicio2;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;


/**
 * @author isidr
 *
 */
public class App {

	// Variable para el total
	private static BigDecimal total = new BigDecimal("0");

	public static void main(String[] args) {
		
		// Lista de la compra
		List<Product> shoppingCart = List.of(
			new Product("Clothes", new BigDecimal("15.90"), Tax.NORMAL),
			new Product("Bread", new BigDecimal("1.5"), Tax.SUPERREDUCED),
			new Product("Meat", new BigDecimal("13.99"), Tax.REDUCED),
			new Product("Cheese", new BigDecimal("3.59"), Tax.SUPERREDUCED),
			new Product("Coke", new BigDecimal("1.89"), Tax.REDUCED),
			new Product("Whiskey", new BigDecimal("19.90"), Tax.NORMAL)
		);

		// Operaciones
		calcularTotal(shoppingCart);
		empiezanPorC(shoppingCart);

	}

	private static void calcularTotal(List<Product> shoppingCart) {
		
		// Sumar precios
		//TODO: Podría hacerse con reduce? Porque al final un forEach
		shoppingCart.stream().forEach(p -> {
			total = total.add(p.getPrice().add(p.getPrice().multiply(p.getTax().getPercent())));
		});
		
		// Redondear hacia arriba (También podría usarse Math)
		total = total.setScale(2, RoundingMode.HALF_UP);

		// Mostrar precio por consola
		System.out.println("Precio total con IVA: " + total);
	
		
		/*
		// Pruebas
		long test1 = shoppingCart.stream()
                .mapToLong(ob ->( ob.getPrice().multiply(ob.getTax().getPercent()).longValue() ) )
                //.reduce(0, (a,b)->a+b);
                .reduce(0, Long::sum);
		System.out.println(test1);
		*/
		
		//int sum = shoppingCart.stream()
                //.reduce(0, (s,ob)->s+ob.getPrice().multiply(ob.getTax().getPercent()),BigInteger::sum);
		
	}

	
	private static void empiezanPorC(List<Product> shoppingCart) {
		
		// Lista con nombres
		List<String> nombresC = List.of();
		
		// Convertir a flujo
		shoppingCart.stream()
		
			// Obtener los que empiezan por C
			.filter(producto -> producto.getName().startsWith("C"))

			// Ordenar alfabéticamente
			.sorted()

			// Recorrer todo para mostrar por coma
			// TODO: Habría que utilizar implode de PHP, que aquí quizá sea join
			// como en JavaScript para poner las comas en vez de esto, pero lo
			// buscaré más adelante porque ahora tengo que mudarme :(
			.forEach(p -> {
				System.out.print(p.getName() + ", ");
			});
	}
}

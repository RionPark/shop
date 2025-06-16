package com.furit.shop.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Lambda1 {
	

	public static void main(String[] args) {
		List<String> strs = Arrays.asList("11","2222","333333","444");
		// K, V, E, T, ?
		
		Predicate<String> predicate = str->str.length()>2;
		Consumer<String> action = str->System.out.println(str);
		
		strs.stream()
		.filter(str->str.length()>2)
		.forEach(str->System.out.println(str));
		
	}
}

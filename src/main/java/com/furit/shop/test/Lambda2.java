package com.furit.shop.test;

import java.awt.dnd.DropTargetAdapter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
class Person{
	private String name;
	private int age;
}
public class Lambda2 {

	public static void main(String[] args) {
		Person[] persons = {new Person("홍길동",32),new Person("임꺽정",24),new Person("신사임당",45)};
		List<Person> people = Arrays.asList(persons);
		people.sort((o1, o2)->o1.getAge()-o2.getAge());
		System.out.println(people);
	}
}

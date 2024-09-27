package com.hramn.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/*
 * Task
 * Дана группа людей из k человек. Некоторые люди из этой группы людей знают 
 * друг друга. Среди этой группы людей может находится знаменитость. 
 * Знаменитость, это человек который не знает никого из группы, но каждый 
 * человек в группе знает его. Мы можем спрашивать людей из этой группы, 
 * знает ли он какого-то конкретного человека. Например, можно спросить у 
 * второго человека, знает ли он четвёртого. Нужно определить есть ли в группе 
 * знаменитость и если есть, то кто этот человек, используя минимальное 
 * количество вопросов.
 */

public class CelebritySearch {
	
	public static void main(String[] args) {
		Person person1 = new Person("1");
		Person person2 = new Person("2");
		Person person3 = new Person("3");
		Person person4 = new Person("4");
		Person person5 = new Person("5");
		
		person1.addKnownPeople(person2, person3, person4);
		person2.addKnownPeople(person3, person4);
		person3.addKnownPeople(person4, person5);
		person5.addKnownPeople(person1, person4);
		
		System.out.println(MySolution.findCelebrity(person1, 
				person2, person3, person4, person5));
		System.out.println(Solution_1.findCelebrity(new Person[] {person1, 
				person2, person3, person4, person5}));
		System.out.println(Solution_2.findCelebrity(new Person[] {person1, 
				person2, person3, person4, person5}));
	}
	
	static class Person {
		private String id;
		private String name;
		private Set<Person> knownPeople = new HashSet<>();
		
		public Person(String name) {
			this.id = UUID.randomUUID().toString();
			this.name = name;
		}
		
		public void addKnownPerson(Person person) {
			knownPeople.add(person);
		}
		
		public void addKnownPeople(Person... people) {
			knownPeople.addAll(Arrays.asList(people));
		}
		
		public boolean knows(Person person) {
			return knownPeople.contains(person);
		}
		
		public String getName() {
			return name;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			return Objects.equals(id, other.id);
		}

		@Override
		public String toString() {
			return "Person [id=" + id + ", name=" + name + "]";
		}
	}
	
	// Решение 1 (time O(n**2), memory O(1))
	static class Solution_1 {
		static Person findCelebrity(Person[] people) {
			for (int i = 0; i < people.length; i++) {
				boolean c = true;
				for (int j = i + 1; j < people.length; j++) {
					if (people[i].knows(people[j]) 
							|| !people[j].knows(people[i])) {
						c = false;
						break;
					}
				}
				if (c) {
					return people[i];
				}
			}
			return null;
		}
	}
	
	// Решение 2 (time O(n), memory O(1))
	static class Solution_2 {
		static Person findCelebrity(Person[] people) {
			int l = 0, r = people.length - 1;
			while(l != r) {
				if (people[l].knows(people[r])) {
					l++;
				} else {
					r--;
				}
			}
			for (int i = 0; i < people.length; i++) {
				if (i != l && (!people[i].knows(people[l]) 
						|| people[l].knows(people[i]))) {
					return null;
				}
			}
			return people[l];
		}
	}
	
	// Моё решение (time O(n), memory O(n**2)
	static class MySolution {
		static Person findCelebrity(Person... persons) {
			List<Person> personsList = 
					new LinkedList<Person>(Arrays.asList(persons));
			List<Person> fans = new ArrayList<>();
			while (personsList.size() > 1) {
				if (personsList.get(0).knows(personsList.get(1))) {
					fans.add(personsList.get(0));
					personsList.remove(0);
				} else {
					fans.add(personsList.get(1));
					personsList.remove(1);
				}
			}
			Person celebrity = personsList.get(0);
			for (Person fan : fans) {
				if (!fan.knows(celebrity) || celebrity.knows(fan)) {
					return null;
				}
			}
			return celebrity;
		}
	}
}

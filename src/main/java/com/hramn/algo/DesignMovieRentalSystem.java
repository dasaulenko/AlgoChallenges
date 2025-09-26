package com.hramn.algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1912. Design Movie Rental System
 * https://leetcode.com/problems/design-movie-rental-system/description
 * 
 * You have a movie renting company consisting of n shops. You want to 
 * implement a renting system that supports searching for, booking, and 
 * returning movies. The system should also support generating a report of 
 * the currently rented movies.
 * 
 * Each movie is given as a 2D integer array entries where entries[i] = 
 * [shopi, moviei, pricei] indicates that there is a copy of movie moviei at 
 * shop shopi with a rental price of pricei. Each shop carries at most one 
 * copy of a movie moviei.
 * 
 * The system should support the following functions:
 * 
 * - Search: Finds the cheapest 5 shops that have an unrented copy of a given 
 *   movie. The shops should be sorted by price in ascending order, and in case 
 *   of a tie, the one with the smaller shopi should appear first. If there are 
 *   less than 5 matching shops, then all of them should be returned. 
 *   If no shop has an unrented copy, then an empty list should be returned.
 * 
 * - Rent: Rents an unrented copy of a given movie from a given shop.
 * 
 * - Drop: Drops off a previously rented copy of a given movie at a given shop.
 * 
 * - Report: Returns the cheapest 5 rented movies (possibly of the same movie 
 *   ID) as a 2D list res where res[j] = [shopj, moviej] describes that the jth 
 *   cheapest rented movie moviej was rented from the shop shopj. The movies in 
 *   res should be sorted by price in ascending order, and in case of a tie, 
 *   the one with the smaller shopj should appear first, and if there is still 
 *   tie, the one with the smaller moviej should appear first. If there are 
 *   fewer than 5 rented movies, then all of them should be returned. 
 *   If no movies are currently being rented, then an empty list should be 
 *   returned.
 * 
 * Implement the MovieRentingSystem class:
 * 
 * - MovieRentingSystem(int n, int[][] entries) Initializes 
 *   the MovieRentingSystem object with n shops and the movies in entries.
 * 
 * - List<Integer> search(int movie) Returns a list of shops that have 
 *   an unrented copy of the given movie as described above.
 * 
 * - void rent(int shop, int movie) Rents the given movie from the given shop.
 * 
 * - void drop(int shop, int movie) Drops off a previously rented movie at 
 *   the given shop.
 * 
 * - List<List<Integer>> report() Returns a list of cheapest rented movies as 
 *   described above.
 * 
 * Note: The test cases will be generated such that rent will only be called if 
 * the shop has an unrented copy of the movie, and drop will only be called if 
 * the shop had previously rented out the movie.
 * 
 * Example 1:
 * Input
 * ["MovieRentingSystem", "search", "rent", "rent", "report", "drop", "search"]
 * [[3, [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]], [1], [0, 1], [1, 2], [], [1, 2], [2]]
 * Output
 * [null, [1, 0, 2], null, null, [[0, 1], [1, 2]], null, [0, 1]]
 * Explanation
 * - MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, 
 *   [[0, 1, 5], [0, 2, 6], [0, 3, 7], [1, 1, 4], [1, 2, 7], [2, 1, 5]]);
 * - movieRentingSystem.search(1);  // return [1, 0, 2], Movies of ID 1 are 
 *   unrented at shops 1, 0, and 2. Shop 1 is cheapest; shop 0 and 2 are 
 *   the same price, so order by shop number.
 * - movieRentingSystem.rent(0, 1); // Rent movie 1 from shop 0. Unrented 
 *   movies at shop 0 are now [2,3].
 * - movieRentingSystem.rent(1, 2); // Rent movie 2 from shop 1. Unrented 
 *   movies at shop 1 are now [1].
 * - movieRentingSystem.report();   // return [[0, 1], [1, 2]]. Movie 1 from 
 *   shop 0 is cheapest, followed by movie 2 from shop 1.
 * - movieRentingSystem.drop(1, 2); // Drop off movie 2 at shop 1. Unrented 
 *   movies at shop 1 are now [1,2].
 * - movieRentingSystem.search(2);  // return [0, 1]. Movies of ID 2 are 
 *   unrented at shops 0 and 1. Shop 0 is cheapest, followed by shop 1.
 * 
 * Constraints:
 * 1 <= n <= 3 * 10^5
 * 1 <= entries.length <= 10^5
 * 0 <= shopi < n
 * 1 <= moviei, pricei <= 10^4
 * Each shop carries at most one copy of a movie moviei.
 * At most 10^5 calls in total will be made to search, rent, drop and report.
 * 
 * TAG: hard
 * TAG: class
 * TAG: heap
 */
public class DesignMovieRentalSystem {
	class MovieRentingSystemPQ {
		class Movie {
			int shop;
			int movie;
			int price;
			String id;
			boolean isRented = false;

			public Movie(int shop, int movie, int price) {
				this.shop = shop;
				this.movie = movie;
				this.price = price;
			}

			public void rent() {
				this.isRented = true;
			}

			public void drop() {
				this.isRented = false;
			}

			public List<Integer> getList() {
				return List.of(shop, movie);
			}
		}

		private Comparator<Movie> searchComparator = new Comparator<>() {
			public int compare(Movie m1, Movie m2) {
				int dif = m1.price - m2.price;
				if (dif != 0) return dif;
				return m1.shop - m2.shop;
			}
		};

		private Comparator<Movie> rentedComparator = new Comparator<>() {
			public int compare(Movie m1, Movie m2) {
				int dif = m1.price - m2.price;
				if (dif != 0) return dif;
				dif = m1.shop - m2.shop;
				if (dif != 0) return dif;
				return m1.movie - m2.movie;
			}
		};

		private Map<String, Movie> idToMovie = new HashMap<>();
		private PriorityQueue<Movie> rentedMovies = 
			new PriorityQueue<>(rentedComparator);
		private Set<String> rentedIds = new HashSet<>();
		private Set<String> unrentedIds = new HashSet<>();
		private Map<Integer, PriorityQueue<Movie>> movieToUnrented = 
			new HashMap<>(); 

		public MovieRentingSystemPQ(int n, int[][] entries) { // O(N * log(N)), O(N) where N = entries.length
			for (int[] e : entries) {
				String id = getId(e[0], e[1]);
				Movie movie = new Movie(e[0], e[1], e[2]);
				movie.id = id;
				idToMovie.put(id, movie);
				PriorityQueue<Movie> queue = movieToUnrented.getOrDefault(
					movie.movie, 
					new PriorityQueue<>(searchComparator));
				queue.add(movie);
				movieToUnrented.put(movie.movie, queue);
				unrentedIds.add(id);
			}
		}

		public List<Integer> search(int movie) { // O(N), O(1) where N = queue.size()
			PriorityQueue<Movie> queue = movieToUnrented.get(movie);
			List<Integer> result = new ArrayList<>();
			if (queue == null) return result;
			List<Movie> movies = new ArrayList<>();
			while (!queue.isEmpty() && movies.size() < 5) {
				Movie m = queue.poll();
				if (m.isRented) {
					unrentedIds.remove(m.id);
					continue;
				}
				movies.add(m);
				result.add(m.shop);
			}
			queue.addAll(movies);
			return result;
		}

		public void rent(int shop, int movie) { // O(log(N)) where N = rentedIds.size()
			String id = getId(shop, movie);
			Movie m = idToMovie.get(id);
			m.rent();
			if (!rentedIds.contains(id)) {
				rentedMovies.add(m);
				rentedIds.add(id);
			}
		}

		public void drop(int shop, int movie) { // 
			String id = getId(shop, movie);
			Movie m = idToMovie.get(id);
			m.drop();
			if (!unrentedIds.contains(id)) {
				PriorityQueue<Movie> queue = movieToUnrented.get(movie);
				queue.add(m);
				unrentedIds.add(id);
			}
		}

		public List<List<Integer>> report() {
			List<Movie> movies = new ArrayList<>();
			List<List<Integer>> result = new ArrayList<>();
			while (!rentedMovies.isEmpty() && movies.size() < 5) {
				Movie movie = rentedMovies.poll();
				if (!movie.isRented) {
					rentedIds.remove(movie.id);
					continue;
				}
				movies.add(movie);
				result.add(movie.getList());
			}
			rentedMovies.addAll(movies);
			return result;
		}

		private String getId(int shop, int movie) {
			return "" + shop + "_" + movie;
		}
	}

	class MovieRentingSystemTS {
		class Movie {
			int shop;
			int movie;
			int price;

			public Movie(int shop, int movie, int price) {
				this.shop = shop;
				this.movie = movie;
				this.price = price;
			}
		}

		private Comparator<Movie> searchComparator = new Comparator<>() {
			public int compare(Movie m1, Movie m2) {
				int dif = m1.price - m2.price;
				if (dif != 0) return dif;
				return m1.shop - m2.shop;
			}
		};

		private Comparator<Movie> rentedComparator = new Comparator<>() {
			public int compare(Movie m1, Movie m2) {
				int dif = m1.price - m2.price;
				if (dif != 0) return dif;
				dif = m1.shop - m2.shop;
				if (dif != 0) return dif;
				return m1.movie - m2.movie;
			}
		};

		private Map<String, Movie> idToMovie = new HashMap<>();
		private Set<Movie> rentedMovies = 
			new TreeSet<>(rentedComparator);
		private Map<Integer, Set<Movie>> movieToUnrented = 
			new HashMap<>(); 

		public MovieRentingSystemTS(int n, int[][] entries) {
			for (int[] e : entries) {
				int shop = e[0], movie = e[1], price = e[2];
				String id = getId(shop, movie);
				Movie mov = new Movie(shop, movie, price);
				idToMovie.put(id, mov);
				Set<Movie> set = movieToUnrented.getOrDefault(
					movie, 
					new TreeSet<>(searchComparator));
				set.add(mov);
				movieToUnrented.put(movie, set);
			}
		}

		public List<Integer> search(int movie) {
			Set<Movie> set = movieToUnrented.get(movie);
			List<Integer> result = new ArrayList<>(5);
			if (set == null || set.isEmpty()) return result;
			Iterator<Movie> iterator = set.iterator();
			while (iterator.hasNext() && result.size() < 5) {
				Movie m = iterator.next();
				result.add(m.shop);
			}
			return result;
		}

		public void rent(int shop, int movie) {
			String id = getId(shop, movie);
			Movie m = idToMovie.get(id);
			rentedMovies.add(m);
			Set<Movie> set = movieToUnrented.get(movie);
			set.remove(m);
		}

		public void drop(int shop, int movie) {
			String id = getId(shop, movie);
			Movie m = idToMovie.get(id);
			rentedMovies.remove(m);
			Set<Movie> set = movieToUnrented.get(movie);
			set.add(m);
		}

		public List<List<Integer>> report() {
			List<List<Integer>> result = new ArrayList<>(5);
			if (rentedMovies.isEmpty()) return result;
			Iterator<Movie> iterator = rentedMovies.iterator();
			while (iterator.hasNext() && result.size() < 5) {
				Movie movie = iterator.next();
				result.add(List.of(movie.shop, movie.movie));
			}
			return result;
		}

		private String getId(int shop, int movie) {
			return "" + shop + "_" + movie;
		}
	}
}

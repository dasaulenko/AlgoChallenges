package com.hramn.interview.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
	void set (String key, String value, int timestamp) {

	}

	String get (String key, int timestamp) {

	}

get() должен возвращать значение с максимальным timestamp, не превышающим запрошенный.

Предположим, что set() вызывается с возрастающими временными метками.

Требования:

* set() — O(1) в среднем.
* get() — O(log n), где n — количество версий значения для ключа.
*
* TAG: Binary Search (floor search)
*/
public class TimeBasedKeyValueStore {

	private static class Entry {
		int timestamp;
		String value;

		public Entry(int timestamp, String value) {
			this.timestamp = timestamp;
			this.value = value;
		}
	}

	private Map<String, List<Entry>> storage = new HashMap<>();

	public void set (String key, String value, int timestamp) {
		storage.computeIfAbsent(key, k -> new ArrayList<>())
				.add(new Entry(timestamp, value));
	}

	public String get (String key, int timestamp) {
		List<Entry> entries = storage.get(key);
		if (entries == null) return null;
		int index = binarySearch(entries, timestamp);
		return index < 0 ? null : entries.get(index).value;
	}

	private int binarySearch(List<Entry> timeline, int timestamp) {
		int l = 0;
		int r = timeline.size() - 1;
		int result = -1;

		while (l <= r) {
			int mid = l + (r-l) / 2;
			if (timeline.get(mid).timestamp <= timestamp) {
				result = mid;
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return result;
	}
}

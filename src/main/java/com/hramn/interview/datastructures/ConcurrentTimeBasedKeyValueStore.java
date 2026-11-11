package com.hramn.interview.datastructures;

import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ConcurrentTimeBasedKeyValueStore {
	private static class Timeline {
		final NavigableMap<Integer, String> values = new TreeMap<>();
		final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	}

	private final ConcurrentHashMap<String, Timeline> storage =
			new ConcurrentHashMap<>();

	public void set(String key, String value, int timestamp) {
		Timeline timeline = storage.computeIfAbsent(key, k -> new Timeline());
		timeline.lock.writeLock().lock();
		try {
			timeline.values.put(timestamp, value);
    } finally {
			timeline.lock.writeLock().unlock();
		}
	}

	public String get(String key, int timestamp) {
		Timeline timeline = storage.get(key);
		if (timeline == null) return null;
		timeline.lock.readLock().lock();
		try {
			Map.Entry<Integer, String> entry = timeline.values.floorEntry(timestamp);
			return entry == null ? null : entry.getValue();
		} finally {
			timeline.lock.readLock().unlock();
		}
	}

	public void deleteOlderThan(String key, int timestamp) {
		Timeline timeline = storage.get(key);
		if (timeline == null) return;
		timeline.lock.writeLock().lock();
		try {
			timeline.values.headMap(timestamp, false).clear();
		} finally {
			timeline.lock.writeLock().unlock();
		}
	}
}

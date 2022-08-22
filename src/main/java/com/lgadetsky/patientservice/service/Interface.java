package com.lgadetsky.patientservice.service;

public interface Interface<T, E> {
	T create(T obj);
	T findById(E id);
	T update(T obj);
	void deleteById(E id);
}

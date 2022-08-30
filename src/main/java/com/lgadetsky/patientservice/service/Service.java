package com.lgadetsky.patientservice.service;

public interface Service<T, E> {
	E create(T obj);
	T findById(E id);
	E update(T obj);
}

package com.lgadetsky.patientservice.service;

public interface Service<T, E> {
	T create(T obj);
	T findByName(E first, E  mid, E last, E birthday);
	T update(T obj);
}

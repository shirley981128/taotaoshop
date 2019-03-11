package com.taotao.manage.service;

public interface Function<T,E> {

	public T callback(E e); 
}

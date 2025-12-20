package com.example.noSqlProject.services;

import java.util.List;

public  interface   GenericService <T>{
    List<T> getAll();
    T findById(String id);
    T save(T element);
    T update(T element,String id);
    void delete(T element);
    void deleteById(String id);
}

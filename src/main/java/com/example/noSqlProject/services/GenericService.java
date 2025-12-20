package com.example.noSqlProject.services;

import java.util.List;

public  interface   GenericService <T,ID>{
    List<T> getAll();
    T findById(ID id);
    T save(T element);
    T update(T element,ID id);
    void deleteById(ID id);
}

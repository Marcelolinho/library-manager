package com.example.library_manager.service.base_service;

import com.example.library_manager.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BaseService<T, ID> {
    List<T> getAll();

    Optional<T> getById(ID id);

    T saveData(T data);

    T updateData(ID id, Map<String, Object> data);

    void deleteData(ID id);
}

package com.example.library_manager.service;

import com.example.library_manager.domain.Book;
import com.example.library_manager.service.base_service.BaseService;
import com.example.library_manager.settings.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class BookService implements BaseService<Book, UUID> {
    private JpaRepository<Book, UUID> repository;

    @Override
    public List<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Book> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Book saveData(Book data) {
        return repository.save(data);
    }

    @Override
    public Book updateData(UUID id, Map<String, Object> data) {
        Optional<Book> book = repository.getById(id);



        return repository.save(book.get());
    }

    @Override
    public void deleteData(UUID id) {
        if(getById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Livro não encontrado para deletar.");
        }
    }
}
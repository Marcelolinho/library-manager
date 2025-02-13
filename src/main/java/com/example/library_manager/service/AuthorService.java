package com.example.library_manager.service;

import com.example.library_manager.domain.Author;
import com.example.library_manager.repository.AuthorRepository;
import com.example.library_manager.service.base_service.BaseService;
import com.example.library_manager.settings.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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
public class AuthorService implements BaseService<Author, UUID> {
    private AuthorRepository repository;

    @Override
    public List<Author> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Author> getById(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Author saveData(Author data) {
        return repository.save(data);
    }

    @Override
    public Author updateData(UUID id, Map<String, Object> data) {
        Optional<Author> author = repository.findById(id);

        if(author.isPresent()) {
            data.forEach((key, value) -> {
               Field field = ReflectionUtils.findField(Author.class, key);
               field.setAccessible(true);
               ReflectionUtils.setField(field, author, value);
            });
        }
        return repository.save(author.get());
    }

    @Override
    public void deleteData(UUID id) {
        if(getById(id).isPresent()) {
            repository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Autor não encontrado para deletar.");
        }

    }
}

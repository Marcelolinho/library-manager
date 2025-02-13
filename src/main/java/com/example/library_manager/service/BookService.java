package com.example.library_manager.service;

import com.example.library_manager.domain.Book;
import com.example.library_manager.service.base_service.BaseService;
import com.example.library_manager.settings.exceptions.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

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
//        TODO implementar a mensagem e os DTOs
        return repository.findAll();
    }

    @Override
    public Optional<Book> getById(UUID id) {
//        TODO implementar a resposta
        return repository.findById(id);
    }

    @Override
    public Book saveData(Book data) {
//        TODO implementar a resposta e o tratamento
        return repository.save(data);
    }

    @Override
    public Book updateData(UUID id, Map<String, Object> data) {
//        TODO implementar a lógica e a resposta
        Optional<Book> book = repository.findById(id);



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
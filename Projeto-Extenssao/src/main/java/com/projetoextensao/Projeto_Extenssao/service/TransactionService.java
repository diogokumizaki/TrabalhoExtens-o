package com.projetoextensao.Projeto_Extenssao.service;

import com.projetoextensao.Projeto_Extenssao.domain.Category;
import com.projetoextensao.Projeto_Extenssao.domain.Client;
import com.projetoextensao.Projeto_Extenssao.domain.Transaction;
import com.projetoextensao.Projeto_Extenssao.dto.TransactionRequestDTO;
import com.projetoextensao.Projeto_Extenssao.repository.CategoryRepository;
import com.projetoextensao.Projeto_Extenssao.repository.ClientRepository;
import com.projetoextensao.Projeto_Extenssao.repository.TransactionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction findById(UUID id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Transação com ID " + id + " não encontrada"));
    }

    public Transaction create(TransactionRequestDTO dto) {

        Client client = clientRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("Cliente com ID " + dto.getUserId() + " não encontrado"));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new EntityNotFoundException("Categoria com ID " + dto.getCategoryId() + " não encontrada"));

        Transaction transaction = new Transaction();
        transaction.setTitle(dto.getTitle());
        transaction.setPrice(dto.getPrice());
        transaction.setClient(client);
        transaction.setCategory(category);

        return transactionRepository.save(transaction);
    }

    public Transaction update(UUID id, TransactionRequestDTO dto) {
        Transaction existingTransaction = findById(id);

        existingTransaction.setTitle(dto.getTitle());
        existingTransaction.setPrice(dto.getPrice());

        if (dto.getCategoryId() != null) {
            Category category = categoryRepository.findById(dto.getCategoryId())
                    .orElseThrow(() -> new EntityNotFoundException("Categoria com ID " + dto.getCategoryId() + " não encontrada"));
            existingTransaction.setCategory(category);
        }

        return transactionRepository.save(existingTransaction);
    }

    public void delete(UUID id) {
        Transaction transaction = findById(id);
        transactionRepository.delete(transaction);
    }
}

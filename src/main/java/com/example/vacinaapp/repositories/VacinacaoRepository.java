package com.example.vacinaapp.repositories;

import com.example.vacinaapp.models.Vacinacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacinacaoRepository extends JpaRepository<Vacinacao, Integer> {
}

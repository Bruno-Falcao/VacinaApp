package com.example.vacinaapp.repositories;

import com.example.vacinaapp.models.Organigacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganigacaoRepository extends JpaRepository<Organigacao, Integer> {

}

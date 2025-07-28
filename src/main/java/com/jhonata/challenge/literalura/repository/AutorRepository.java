package com.jhonata.challenge.literalura.repository;

import com.jhonata.challenge.literalura.model.AutorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<AutorEntity, Long> {
    List<AutorEntity> findByDataNascimento(Integer anoNascimento);
}

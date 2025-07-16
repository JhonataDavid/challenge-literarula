package com.jhonata.challenge.literalura.repository;

import com.jhonata.challenge.literalura.model.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
}

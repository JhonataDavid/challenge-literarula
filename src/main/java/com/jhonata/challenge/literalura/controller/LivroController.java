package com.jhonata.challenge.literalura.controller;

import com.jhonata.challenge.literalura.dto.LivroDTO;
import com.jhonata.challenge.literalura.dto.LivroResponseDTO;
import com.jhonata.challenge.literalura.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livro")
public class LivroController {

    private final LivroService service;

    public LivroController(LivroService livroService) {
        this.service = livroService;
    }

    @PostMapping
    public ResponseEntity<LivroDTO> salvar(@RequestBody LivroDTO livroDto) {
        LivroDTO livroSalvo = service.saveBook(livroDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }

    @GetMapping("/livros")
    public ResponseEntity<List<LivroResponseDTO>> getAllLivros() {
        List<LivroResponseDTO> livroResponseDTOList = service.getAllBooks();
        return ResponseEntity.ok(livroResponseDTOList);
    }
}

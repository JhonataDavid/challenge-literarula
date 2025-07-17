package com.jhonata.challenge.literalura.controller;

import com.jhonata.challenge.literalura.dto.LivroDto;
import com.jhonata.challenge.literalura.dto.LivroResponseDto;
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
    public ResponseEntity<LivroDto> salvar(@RequestBody LivroDto livroDto) {
        LivroDto livroSalvo = service.saveBook(livroDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }


    @GetMapping("/livros")
    public ResponseEntity<List<LivroResponseDto>> getLivros() {
        List<LivroResponseDto> livroResponseDtoList = service.getAllBooks();
        return ResponseEntity.ok(livroResponseDtoList);
    }
}

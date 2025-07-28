package com.jhonata.challenge.literalura.service;

import com.jhonata.challenge.literalura.dto.response.AutorCompletoDTO;
import com.jhonata.challenge.literalura.dto.response.LivroResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ViewService {

    private final Scanner scanner = new Scanner(System.in);
    private final LivroService livroService;
    private final AutorService autorService;

    public ViewService(LivroService livroService, AutorService autorService) {
        this.livroService = livroService;
        this.autorService = autorService;
    }

    public void menu(){
        System.out.println("\n=== MENU ===");
        System.out.println("1 - Inserir dados");
        System.out.println("2 - Consultar livros");
        System.out.println("3 - Consultar autores");
        System.out.println("4 - Consultar autores vivos em um determinado ano");
        System.out.println("5 - Consultar livros pelo idioma");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");    }

    public void mostrarAutoresPeloAno() {
        Integer anoDeNascimento = scanner.nextInt();
        List<AutorCompletoDTO> autores = autorService.buscarAutoresPeloAno(anoDeNascimento);
        autores.forEach(System.out::println);
    }

    public void mostrarAutoresSalvos() {
        List<AutorCompletoDTO>autorCompletoDTOS = autorService.buscarTodosAutores();
        autorCompletoDTOS.forEach(System.out::println);
    }

    public void menuSalvaLivro() {
        System.out.println("Digite o nome de um livro para buscar e salvar");
        String nomeLivro = scanner.nextLine();
        Optional<LivroResponseDTO> livroResponse = livroService.buscarLivros(nomeLivro);
        System.out.println("Livro salvo: \n" + livroResponse);
    }

    public void menuDeLivrosSalvos(){
        System.out.println("Seus livros salvos sao: ");
        System.out.println("-----====LIVROS====-----");
        AtomicInteger index = new AtomicInteger(1);
        livroService.getAllBooks().forEach(livroResponseDTO -> {
            System.out.println("Livro " + index.getAndIncrement());
            System.out.println(livroResponseDTO);
        });
        System.out.println("------------------------");
    }

    public void mostrarPorIdioma(){
        System.out.println("Digite um idioma para buscar");
        String idioma = scanner.nextLine();
        System.out.println("pt - portugues");
        System.out.println("en - inglês");
        System.out.println("es - espanhol ");
        System.out.println("fr - frances");
        List<LivroResponseDTO> livros = livroService.buscarLivrosPorIdioma(idioma);
        livros.forEach(System.out::println);
    }
}

package com.jhonata.challenge.literalura.view;

import com.jhonata.challenge.literalura.client.GutendexClient;
import com.jhonata.challenge.literalura.dto.LivroResponseDTO;
import com.jhonata.challenge.literalura.mapper.LivroMapper;
import com.jhonata.challenge.literalura.service.LivroService;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Scanner;

@Component
public class InterfaceUsuario {

    private final Scanner scanner = new Scanner(System.in);
    private final LivroService service;
    private GutendexClient gutendexClient;
    private LivroMapper mapper;

    public InterfaceUsuario(LivroService livroService) {
        this.service = livroService;
    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            System.out.println("\n=== MENU ===");
            System.out.println("1 - Inserir dados");
            System.out.println("2 - Consultar dados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        menuSalvaLivro();
                        break;
                    case 2:
                        menuDeLivrosSalvos();
                        break;
                    case 0:
                        System.out.println("Encerrando...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite um número.");
            }
        }

        scanner.close();
    }

    private void menuSalvaLivro() {
        System.out.println("Digite o nome de um livro para buscar e salvar");
        String nomeLivro = scanner.nextLine();
        Optional<LivroResponseDTO> livroResponse = service.buscarLivros(nomeLivro);
        System.out.println("Livro salvo: \n" + livroResponse);
    }

    private void menuDeLivrosSalvos(){
        System.out.println("Seus livros salvos sao: ");
        System.out.println(service.getAllBooks());
    }

}

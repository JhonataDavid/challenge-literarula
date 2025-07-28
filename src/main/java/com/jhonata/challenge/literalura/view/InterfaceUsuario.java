package com.jhonata.challenge.literalura.view;

import com.jhonata.challenge.literalura.service.ViewService;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class InterfaceUsuario {

    private final Scanner scanner;
    private final ViewService service;

    public InterfaceUsuario(ViewService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu() {
        int opcao = -1;

        while (opcao != 0) {
            service.menu();
            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        service.menuSalvaLivro();
                        break;
                    case 2:
                        service.menuDeLivrosSalvos();
                        break;
                    case 3:
                        service.mostrarAutoresSalvos();
                        break;
                    case 4:
                        service.mostrarAutoresPeloAno();
                    case 5:
                        service.mostrarPorIdioma();
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
}

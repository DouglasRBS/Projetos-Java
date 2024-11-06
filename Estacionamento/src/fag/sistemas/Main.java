package fag.sistemas;

import fag.objetos.Vaga;
import fag.objetos.Veiculo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Estacionamento estacionamento = new Estacionamento();

        
        estacionamento.adicionarVaga(new Vaga(1, "pequeno"));
        estacionamento.adicionarVaga(new Vaga(2, "médio"));
        estacionamento.adicionarVaga(new Vaga(3, "grande"));

        
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Cadastrar veículo");
            System.out.println("2. Registrar saída de veículo");
            System.out.println("3. Relatório de vagas ocupadas");
            System.out.println("4. Histórico de veículos");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            if (opcao == 1) {
                System.out.print("Digite a placa do veículo: ");
                String placa = scanner.nextLine();
                System.out.print("Digite o modelo do veículo: ");
                String modelo = scanner.nextLine();
                System.out.print("Digite o tamanho do veículo (pequeno, médio, grande): ");
                String tamanho = scanner.nextLine();

                Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
                if (estacionamento.alocarVaga(veiculo)) {
                    System.out.println("Veículo alocado com sucesso!");
                } else {
                    System.out.println("Não há vagas disponíveis para este veículo.");
                }
            } else if (opcao == 2) {
                System.out.print("Digite a placa do veículo para registrar saída: ");
                String placa = scanner.nextLine();
                if (!estacionamento.registrarSaida(placa)) {
                    System.out.println("Veículo não encontrado.");
                }
            } else if (opcao == 3) {
                estacionamento.relatorioVagasOcupadas();
            } else if (opcao == 4) {
                estacionamento.historicoVeiculos();
            } else if (opcao == 5) {
                System.out.println("Saindo...");
                break;
            }
        }
        scanner.close();
    }
}

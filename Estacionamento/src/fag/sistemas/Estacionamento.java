package fag.sistemas;

import fag.objetos.Vaga;
import fag.objetos.Veiculo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Veiculo> veiculos;

    public Estacionamento() {
        vagas = new ArrayList<>();
        veiculos = new ArrayList<>();
    }

    public void adicionarVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public boolean alocarVaga(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equals(veiculo.getTamanho())) {
                vaga.setDisponivel(false);
                veiculo.registrarEntrada(LocalDateTime.now());
                veiculos.add(veiculo);
                return true;
            }
        }
        return false; 
    }

    public boolean registrarSaida(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equals(placa)) {
                veiculo.registrarSaida(LocalDateTime.now());
                double valor = veiculo.calcularValorPermanencia();
                System.out.println("Valor a ser pago: R$ " + valor);
                liberarVaga(veiculo);
                return true;
            }
        }
        return false; 
    }

    private void liberarVaga(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel() && vaga.getTamanho().equals(veiculo.getTamanho())) {
                vaga.setDisponivel(true);
                return;
            }
        }
    }

    public void relatorioVagasOcupadas() {
        System.out.println("Relatório de vagas ocupadas:");
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                System.out.println("Vaga " + vaga.getNumero() + " | Tamanho: " + vaga.getTamanho());
            }
        }
    }

    public void historicoVeiculos() {
        System.out.println("Histórico de veículos:");
        for (Veiculo veiculo : veiculos) {
            System.out.println("Placa: " + veiculo.getPlaca() + 
                               " | Entrada: " + veiculo.getHoraEntrada() + 
                               " | Saída: " + veiculo.getHoraSaida() +
                               " | Valor pago: R$ " + veiculo.calcularValorPermanencia());
        }
    }
}

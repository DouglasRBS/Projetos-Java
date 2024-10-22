package fag;

import java.util.ArrayList;
import java.util.List;
import fag.objetos.Quarto;
import fag.objetos.Reserva;

public class Hotel {
    private List<Quarto> quartos;
    private List<Reserva> reservas;

    public Hotel() {
        quartos = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    public void adicionarQuarto(Quarto quarto) {
        quartos.add(quarto);
    }

    public void fazerReserva(Reserva reserva) {
        reservas.add(reserva);
        int quartosReservados = 0;

        for (Quarto quarto : quartos) {
            if (quarto.getTipo().equals(reserva.getTipoQuarto()) && quarto.isDisponivel()) {
                quarto.setDisponivel(false); 
                reserva.adicionarQuartoReservado(quarto);
                quartosReservados++;
                if (quartosReservados == reserva.getNumeroQuartosReservados()) {
                    break;
                }
            }
        }

        if (quartosReservados < reserva.getNumeroQuartosReservados()) {
            System.out.println("Não há quartos suficientes disponíveis para essa reserva.");
        }
    }

    public void checkIn(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nomeHospede)) {
                System.out.println("Check-in realizado para " + nomeHospede);
                return;
            }
        }
        System.out.println("Reserva não encontrada para o hóspede " + nomeHospede);
    }

    public void checkOut(String nomeHospede) {
        for (Reserva reserva : reservas) {
            if (reserva.getNomeHospede().equals(nomeHospede)) {
                System.out.println("Check-out realizado para " + nomeHospede);

                for (Quarto quarto : reserva.getQuartosReservados()) {
                    quarto.setDisponivel(true);
                }
                reservas.remove(reserva);
                return;
            }
        }
        System.out.println("Reserva não encontrada para o hóspede " + nomeHospede);
    }

    public void relatorioOcupacao() {
        System.out.println("Relatório de Ocupação:");
        for (Quarto quarto : quartos) {
            System.out.println(quarto);
        }
    }

    public void relatorioReservas() {
        System.out.println("Histórico de Reservas:");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }
}

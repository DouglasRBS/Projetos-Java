package fag.objetos;

import java.time.LocalDateTime;

public class Veiculo {
    private String placa;
    private String modelo;
    private String tamanho; 
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;

    public Veiculo(String placa, String modelo, String tamanho) {
        this.placa = placa;
        this.modelo = modelo;
        this.tamanho = tamanho;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void registrarEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void registrarSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public long calcularTempoPermanencia() {
        return java.time.Duration.between(horaEntrada, horaSaida).toHours();
    }

    public double calcularValorPermanencia() {
        long horas = calcularTempoPermanencia();
        if (horas <= 1) {
            return 5.00;
        } else if (horas <= 3) {
            return 10.00;
        } else {
            return 15.00;
        }
    }
}

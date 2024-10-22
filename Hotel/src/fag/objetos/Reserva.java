package fag.objetos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private String nomeHospede;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;
    private int numeroQuartosReservados;
    private String tipoQuarto;
    private List<Quarto> quartosReservados;

    public Reserva(String nomeHospede, LocalDate dataCheckIn, LocalDate dataCheckOut, int numeroQuartosReservados, String tipoQuarto) {
        this.nomeHospede = nomeHospede;
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
        this.numeroQuartosReservados = numeroQuartosReservados;
        this.tipoQuarto = tipoQuarto;
        this.quartosReservados = new ArrayList<>();
    }

    public String getNomeHospede() {
        return nomeHospede;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    public int getNumeroQuartosReservados() {
        return numeroQuartosReservados;
    }

    public String getTipoQuarto() {
        return tipoQuarto;
    }

    public List<Quarto> getQuartosReservados() {
        return quartosReservados;
    }

    public void adicionarQuartoReservado(Quarto quarto) {
        quartosReservados.add(quarto);
    }

    @Override
    public String toString() {
        return "Reserva: " + nomeHospede + " | Check-in: " + dataCheckIn + " | Check-out: " + dataCheckOut + " | Quartos reservados: " + quartosReservados.size() + " | Tipo de quarto: " + tipoQuarto;
    }
}

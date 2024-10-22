package fag;

import java.time.LocalDate;
import fag.objetos.Quarto;
import fag.objetos.Reserva;

public class Main {

    public static void main(String[] args) {
    	
        Hotel hotel = new Hotel();

        hotel.adicionarQuarto(new Quarto(101, "Solteiro", 150));
        hotel.adicionarQuarto(new Quarto(102, "Casal", 200));
        hotel.adicionarQuarto(new Quarto(103, "Suíte", 300));

        Reserva reserva1 = new Reserva("João Silva", LocalDate.of(2024, 10, 1), LocalDate.of(2024, 10, 5), 1, "Solteiro");
        Reserva reserva2 = new Reserva("Maria Souza", LocalDate.of(2024, 10, 2), LocalDate.of(2024, 10, 6), 1, "Casal");

        hotel.fazerReserva(reserva1);
        hotel.fazerReserva(reserva2);

        hotel.relatorioOcupacao();

        
        hotel.checkIn("João Silva");
        hotel.checkOut("João Silva");

        
        hotel.relatorioOcupacao();

        
        hotel.relatorioReservas();
    }
}

package fag.objetos;

public class Quarto {
    private int numero;
    private String tipo;
    private double precoDiario;
    private boolean disponivel;

    public Quarto(int numero, String tipo, double precoDiario) {
        this.numero = numero;
        this.tipo = tipo;
        this.precoDiario = precoDiario;
        this.disponivel = true; 
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public double getPrecoDiario() {
        return precoDiario;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return "Quarto " + numero + " (" + tipo + ") - " + (disponivel ? "Disponível" : "Ocupado");
    }
}

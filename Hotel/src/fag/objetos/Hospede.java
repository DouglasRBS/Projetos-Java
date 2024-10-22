package fag.objetos;

public class Hospede {
    private String nome;
    private String documento;
    private String telefone;

    public Hospede(String nome, String documento, String telefone) {
        this.nome = nome;
        this.documento = documento;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getDocumento() {
        return documento;
    }

    public String getTelefone() {
        return telefone;
    }

    @Override
    public String toString() {
        return "Hóspede: " + nome + " | Documento: " + documento + " | Telefone: " + telefone;
    }
}

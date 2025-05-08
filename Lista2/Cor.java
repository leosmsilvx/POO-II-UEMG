import java.awt.Color;

public class Cor {
    private String nome;
    private Color cor;

    public Cor(String nome, Color cor) {
        this.nome = nome;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Color getCor() {
        return cor;
    }
    public void setCor(Color cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return nome;
    }
    
}

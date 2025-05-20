import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {
    private JPanel painelPrincipal;

    private JPanel painelBotoes;

    private JTextField jtfTextoConta;

    private JButton jbAc, jbNegativo, jbPercentual, jbRaiz, jbDividir, jb7, jb8, jb9, jbElevadoY, jbVezes, jb4, jb5, jb6, jbElevado2, jbMenos;
    private JButton jb1, jb2, jb3, jbElevado3, jbMais, jb0, jbPonto, jbFatorial, jbPotencia10, jbIgual;

    public Tela() {
        painelPrincipal = new JPanel(new BorderLayout());
        painelBotoes = new JPanel(new GridLayout(5,5,5,5));
        jtfTextoConta = new JTextField();
        inicializaBotoes();
    }

    private void inicializaBotoes(){
        jbAc = new JButton("AC/C");
        jbNegativo = new JButton("+/-");
        jbPercentual = new JButton("%");
        jbRaiz = new JButton("RAIZ Q");
        jbDividir = new JButton("/");
        jb7 = new JButton("7");
        jb8 = new JButton("8");
        jb9 = new JButton("9");
        jbElevadoY = new JButton("x^Y");
        jbVezes = new JButton("*");
        jb4 = new JButton("4");
        jb5 = new JButton("5");
        jb6 = new JButton("6");
        jbElevado2 = new JButton("x^2");
        jbMenos = new JButton("-");
        jb1 = new JButton("1");
        jb2 = new JButton("2");
        jb3 = new JButton("3");
        jbElevado3 = new JButton("x^3");
        jbMais = new JButton("+");
        jb0 = new JButton("0");
        jbPonto = new JButton(".");
        jbFatorial = new JButton("X!");
        jbPotencia10 = new JButton("10^X");
        jbIgual = new JButton("=");
    }

    public void configurarJanela() {
        setVisible(true);
        setTitle("Lista 3");
        setSize(450,360);
        setResizable(false);
        setLocation(600, 300);
        configurarPainelPrincipal();
        add(painelPrincipal);
    }

    private void configurarPainelBotoes(){
        configuraFuncoesBotoes();
        
        painelBotoes.add(jbAc);
        painelBotoes.add(jbNegativo);
        painelBotoes.add(jbPercentual);
        painelBotoes.add(jbRaiz);
        painelBotoes.add(jbDividir);
        painelBotoes.add(jb7);
        painelBotoes.add(jb8);
        painelBotoes.add(jb9);
        painelBotoes.add(jbElevadoY);
        painelBotoes.add(jbVezes);
        painelBotoes.add(jb4);
        painelBotoes.add(jb5);
        painelBotoes.add(jb6);
        painelBotoes.add(jbElevado2);
        painelBotoes.add(jbMenos);
        painelBotoes.add(jb1);
        painelBotoes.add(jb2);
        painelBotoes.add(jb3);
        painelBotoes.add(jbElevado3);
        painelBotoes.add(jbMais);
        painelBotoes.add(jb0);
        painelBotoes.add(jbPonto);
        painelBotoes.add(jbFatorial);
        painelBotoes.add(jbPotencia10);
        painelBotoes.add(jbIgual);

        painelBotoes.setPreferredSize(new Dimension(400,250));

        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
    }

    private void configurarPainelPrincipal() {
        configurarPainelBotoes();
        configurarTextField();
        painelPrincipal.setBorder(new EmptyBorder(10,10,10,10)); // Cria uma borda vazia, como uma "margem"
    }
    
    private void configurarTextField(){
        jtfTextoConta.setPreferredSize(new Dimension(400, 30));
        jtfTextoConta.setHorizontalAlignment(JTextField.RIGHT);
        jtfTextoConta.setEditable(false);
        jtfTextoConta.setFont(new Font("Arial", Font.PLAIN, 20));
        jtfTextoConta.setBackground(Color.WHITE);
        painelPrincipal.add(jtfTextoConta, BorderLayout.NORTH);

    }

    private void configuraFuncoesBotoes(){
        configuraBotoesSimples();
        configuraBotaoLimpar();
        configuraBotaoSinal();
        configuraBotaoIgual();
        configuraBotaoZero();
    }

    private void configuraBotoesSimples(){
        adicionarAcaoTexto(jb1, "1");
        adicionarAcaoTexto(jb2, "2");
        adicionarAcaoTexto(jb3, "3");
        adicionarAcaoTexto(jb4, "4");
        adicionarAcaoTexto(jb5, "5");
        adicionarAcaoTexto(jb6, "6");
        adicionarAcaoTexto(jb7, "7");
        adicionarAcaoTexto(jb8, "8");
        adicionarAcaoTexto(jb9, "9");
        adicionarAcaoTexto(jbPonto, ".");
        
        adicionarAcaoTexto(jbDividir, "/");
        adicionarAcaoTexto(jbVezes, "*");
        adicionarAcaoTexto(jbMenos, "-");
        adicionarAcaoTexto(jbMais, "+");
        adicionarAcaoTexto(jbPercentual, "%");

        adicionarAcaoTexto(jbElevado2, "^2");
        adicionarAcaoTexto(jbElevado3, "^3");
        adicionarAcaoTexto(jbElevadoY, "^");
        adicionarAcaoTexto(jbPotencia10, "10^");
        adicionarAcaoTexto(jbRaiz, "√");

        adicionarAcaoTexto(jbFatorial, "!");
    }

    private void configuraBotaoLimpar(){
        jbAc.addActionListener(e -> {
            jtfTextoConta.setText("");
        });
    }

    private void configuraBotaoSinal(){
        jbNegativo.addActionListener(e -> {
            if(jtfTextoConta.getText().startsWith("-")){
                jtfTextoConta.setText(jtfTextoConta.getText().substring(1));
            } else {
                jtfTextoConta.setText("-" + jtfTextoConta.getText());
            }
        });
    }

    private void configuraBotaoZero(){
        jb0.addActionListener(e -> {
            limpaCampoErro();
            String textoCampo = jtfTextoConta.getText();
            if(textoCampo.isEmpty()){
                jtfTextoConta.setText(jtfTextoConta.getText() + "0");
            }
            for(int i = textoCampo.length() - 1; i >= 0; i--){
                Character c = textoCampo.charAt(i);
                if(c == '.' || (Character.isDigit(c) && c != '0')){ // Caso seja um numero decimal ou um numero > 9 -> 0.0001 ou 10000
                    jtfTextoConta.setText(jtfTextoConta.getText() + "0");
                    break;
                }

                if ("+-*/^%".indexOf(c) != -1) { // Parar no operador, pois deixa de ser o mesmo numero se continuar
                    if(textoCampo.length() - 1 == i){ // Se o primeiro digito for um operador, adiciona o zero -> 1.2 + 0
                        jtfTextoConta.setText(jtfTextoConta.getText() + "0");
                    } 
                    break;
                }
            }
        });
    }

    private void adicionarAcaoTexto(JButton botao, String texto){
        botao.addActionListener(e -> {
            limpaCampoErro();
            jtfTextoConta.setText(jtfTextoConta.getText() + texto);
        });
    }   

    private void configuraBotaoIgual() {
        jbIgual.addActionListener(e -> {
            String expressao = jtfTextoConta.getText();
            try {
                Double resultado = Calculadora.calculaExpressao(expressao);
                DecimalFormat df = new DecimalFormat("#.###############"); // Evitando problemas como 0.1 + 0.2 = 0.30000000000000004;
                jtfTextoConta.setText(df.format(resultado).replace(",", ".")); // Transformando o resultado 0,3 em 0.3
            } catch (Exception ex) {
                jtfTextoConta.setText("Erro: " + ex.getMessage());
            }
        });
    }

    private void limpaCampoErro(){
        if(jtfTextoConta.getText().startsWith("Erro:")){
            jtfTextoConta.setText("");
        }
    }

}


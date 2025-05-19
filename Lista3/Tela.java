import java.math.BigDecimal;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame {
    private JPanel painelPrincipal;

    private JPanel painelBotoes;

    private JTextField jtfTextoConta;

    private JButton jbAc, jbNegativo, jbPercentual, jbRaiz, jbDividir, jb7, jb8, jb9, jbElevadoY, jbVezes, jb4, jb5, jb6, jbElevado2, jbMenos;
    private JButton jb1, jb2, jb3, jbElevado3, jbMais, jb0, jbPonto, jbFatorial, jbPotencia10, jbIgual;

    public Tela() {
        painelPrincipal = new JPanel(new BorderLayout(5,5));
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450,360);
        setResizable(false);
        setLocation(600, 300);
        add(painelPrincipal);
        configurarPainelPrincipal();
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
    }

    private void configurarPainelPrincipal() {
        configurarPainelBotoes();
        configurarTextField();
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
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
    }

    private void configuraBotoesSimples(){
        adicionarAcaoTexto(jb0, "0");
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
        adicionarAcaoTexto(jbRaiz, "√");

        adicionarAcaoTexto(jbPotencia10, "10^");
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

    private void adicionarAcaoTexto(JButton botao, String texto){
        botao.addActionListener(e -> {
            jtfTextoConta.setText(jtfTextoConta.getText() + texto);
        });
    }

    private void configuraBotaoIgual() {
        jbIgual.addActionListener(e -> {
            String expressao = jtfTextoConta.getText();
            try {
                double resultado = calculaExpressao(expressao);
                String resultadoStr = new BigDecimal(resultado).toPlainString(); // Mostra o valor sem o notações cientificas 4.8392E8
                jtfTextoConta.setText(resultadoStr);
            } catch (Exception ex) {
                jtfTextoConta.setText("Erro: " + ex.getMessage());
            }
        });
    }
    
    private double calculaExpressao(String expr) throws Exception {
        expr = expr.replaceAll("\\s+", ""); // Remove espaços em branco
        return calculaSomaSubtracao(expr);
    }
    
    private double calculaSomaSubtracao(String expr) throws Exception {
        int index = acharOperador(expr, '+', '-');
        if (index != -1) {
            char op = expr.charAt(index);
            double esquerda = 0; // Caso a parte da esquerda seja vazia, coloca-se o valor de 0, para casos de numeros negativos
            if(!expr.substring(0, index).isEmpty()){
                esquerda = calculaSomaSubtracao(expr.substring(0, index));
            }
            double direita = calculaMultiplicacaoDivisao(expr.substring(index + 1)); 
            if (op == '+') return esquerda + direita;
            else return esquerda - direita;
        }
        return calculaMultiplicacaoDivisao(expr);
    }
    
    private double calculaMultiplicacaoDivisao(String expr) throws Exception {
        int index = acharOperador(expr, '*', '/', '%'); 
        if (index != -1) {
            char op = expr.charAt(index);
            double esquerda = calculaMultiplicacaoDivisao(expr.substring(0, index));
            double direita = calculaPotencia(expr.substring(index + 1));
            if (op == '*') return esquerda * direita;
            else if(op == '%') return esquerda / 100 * direita; // X%Y = (X/100) * Y
            else {
                if (direita == 0) throw new ArithmeticException("Divisão por zero"); // Impossível dividir por 0
                return esquerda / direita;
            }
        }
        return calculaPotencia(expr);
    }
    
    private double calculaPotencia(String expr) throws Exception {
        int index = acharOperador(expr, '^', '√');
        if (index != -1) {
            char op = expr.charAt(index);
            double esquerda = 1; // Caso a parte da esquerda seja vazia, coloca-se o valor de 1, para casos de somente raiz √25 = 1*√25
            if(!expr.substring(0, index).isEmpty()){
                esquerda = calculaSomaSubtracao(expr.substring(0, index));
            }
            double direita = calculaPotencia(expr.substring(index + 1));
            if(op == '^') return Math.pow(esquerda, direita);
            else return esquerda * Math.sqrt(direita);
        }
        return calculaNumero(expr);
    }
    
    private double calculaNumero(String expr) throws Exception {
        if (expr.endsWith("!")) {
            double valor = calculaNumero(expr.substring(0, expr.length() - 1));
            return fatorial(valor);
        }
        return Double.parseDouble(expr);
    }

    private double fatorial(double n) throws Exception {
        if (n < 0 || n != Math.floor(n)) throw new Exception("Fatorial inválido (negativo/decimal)"); // Impossivel calcular fatorial de negativo ou decimal
        double resultado = 1;
        for (int i = 2; i <= (int)n; i++) {
            resultado *= i;
        }
        return resultado;
    }
    
    private int acharOperador(String expr, char... operadores) {
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            for (char op : operadores) { 
                if(op == '-' && (i == 0 || "+-*/^%".indexOf(expr.charAt(i - 1)) != -1)) continue; // Caso o operador de menos não seja uma operação e sim um sinal do numero                
                if (c == op) return i;
            }
        }
        return -1;
    }
}


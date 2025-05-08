import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class Tela extends JFrame {
    private JPanel painel;

    private JComboBox jcbFonte, jcbTamanho, jcbCor;
    private JLabel jlFonte, jlTamanho, jlCor;
    private JButton jbFormatar, jbLimpar, jbApagar;
    private ButtonGroup grEstiloTexto;
    private JRadioButton jrbNegrito, jrbItalico, jrbNormal, jrbNegritoItalico;
    private JTextArea jtaTexto;
    private JScrollPane jspTexto;

    private List<Cor> cores;

    public Tela() {
        inicializaCores();
        painel = new JPanel();
        jcbFonte = new JComboBox<>(new String[]{"- Selecione -","Arial","Calibri","Cambria","Comic Sans MS","Courier New","Georgia","Impact","Times New Roman","Trebuchet","Verdana"});
        jcbTamanho = new JComboBox<>(new String[]{"- Selecione -","8","9","10","11","12","14","16","18","20","22"});
        jcbCor = new JComboBox<>(cores.toArray());

        jlFonte = new JLabel("Fonte: ");
        jlTamanho = new JLabel("Tamanho: ");
        jlCor = new JLabel("Cor: ");

        jbFormatar = new JButton("Alterar formatação");
        jbLimpar = new JButton("Limpar formatação");
        jbApagar = new JButton("Apagar texto");

        grEstiloTexto = new ButtonGroup();
        jrbNegrito = new JRadioButton("Negrito");
        jrbItalico = new JRadioButton("Itálico");
        jrbNormal = new JRadioButton("Normal");
        jrbNegritoItalico = new JRadioButton("Negrito - Itálico");

        jtaTexto = new JTextArea();
        jspTexto = new JScrollPane(jtaTexto);
    }

    public void inicializaCores(){
        cores = new ArrayList<>();
        cores.add(new Cor("- Selecione -", null));
        cores.add(new Cor("Preto", Color.BLACK));
        cores.add(new Cor("Vermelho", Color.RED));
        cores.add(new Cor("Verde", Color.GREEN));
        cores.add(new Cor("Azul", Color.BLUE));
        cores.add(new Cor("Amarelo", Color.YELLOW));
        cores.add(new Cor("Rosa", Color.PINK));
        cores.add(new Cor("Laranja", Color.ORANGE));
        cores.add(new Cor("Cinza", Color.GRAY));
        cores.add(new Cor("Ciano", Color.CYAN));
        cores.add(new Cor("Magenta", Color.MAGENTA));
    }

    public void configurarJanela() {
        setVisible(true);
        setTitle("Lista 2");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 600);
        setResizable(false);
        setLocation(600, 300);
        add(painel);
        configurarPainel();
    }

    public void configurarPainel() {
        painel.setLayout(null);
        painel.setVisible(true);

        configurarFonteCombobox();
        configurarTamanhoCombobox();
        configurarCorCombobox();

        configurarFormatacaoButton();
        configurarLimparButton();
        configurarApagarButton();

        configurarRadioButtons();

        configurarTextArea();
    }

    public void configurarFonteCombobox(){
        jlFonte.setBounds(10, 10, 50, 30);
        jcbFonte.setBounds(60, 10, 130, 30);
        painel.add(jlFonte);
        painel.add(jcbFonte);
    }

    public void configurarTamanhoCombobox(){
        jlTamanho.setBounds(210, 10, 60, 30);
        jcbTamanho.setBounds(280, 10, 130, 30);
        painel.add(jlTamanho);
        painel.add(jcbTamanho);
    }

    public void configurarCorCombobox(){
        jlCor.setBounds(10, 60, 30, 30);
        jcbCor.setBounds(40, 60, 130, 30);
        painel.add(jlCor);
        painel.add(jcbCor);
    }

    public void configurarFormatacaoButton(){
        jbFormatar.setBounds(190, 60, 160, 30);
        jbFormatar.addActionListener(e -> {
            String fonte = (String) jcbFonte.getSelectedItem();
            int tamanho = jcbTamanho.getSelectedItem().equals("- Selecione -") ? 12 : Integer.parseInt((String) jcbTamanho.getSelectedItem());
            Cor cor = (Cor) jcbCor.getSelectedItem();
            jtaTexto.setFont(getFonteSelecionada(fonte, tamanho));
            jtaTexto.setForeground(cor.getCor());            
        });
        painel.add(jbFormatar);
    }

    public Font getFonteSelecionada(String nomeFonte, int tamanho) {
        if (jrbNegrito.isSelected()) {
            return new Font(nomeFonte, Font.BOLD, tamanho);
        } else if (jrbItalico.isSelected()) {
            return new Font(nomeFonte, Font.ITALIC, tamanho);
        } else if (jrbNegritoItalico.isSelected()) {
            return new Font(nomeFonte, Font.BOLD | Font.ITALIC, tamanho);
        } else {
            return new Font(nomeFonte, Font.PLAIN, tamanho);
        }
    }    

    public void configurarLimparButton(){
        jbLimpar.setBounds(360, 60, 160, 30);
        jbLimpar.addActionListener(e -> {
            jtaTexto.setFont(new Font("Arial", Font.PLAIN, 12));
            jtaTexto.setForeground(Color.BLACK);
        });
        painel.add(jbLimpar);
    }

    public void configurarApagarButton(){
        jbApagar.setBounds(380, 100, 140, 30);
        jbApagar.addActionListener(e -> {
            jtaTexto.setText("");
        });        
        painel.add(jbApagar);
    }

    public void configurarRadioButtons(){
        jrbNegrito.setBounds(10, 100, 70, 30);
        jrbItalico.setBounds(80, 100, 70, 30);
        jrbNormal.setBounds(150, 100, 70, 30);
        jrbNegritoItalico.setBounds(220, 100, 130, 30);

        grEstiloTexto.add(jrbNegrito);
        grEstiloTexto.add(jrbItalico);
        grEstiloTexto.add(jrbNormal);
        grEstiloTexto.add(jrbNegritoItalico);

        painel.add(jrbNegrito);
        painel.add(jrbItalico);
        painel.add(jrbNormal);
        painel.add(jrbNegritoItalico);
    }

    public void configurarTextArea(){
        jspTexto.setBounds(10, 140, 510, 400);
        jspTexto.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jspTexto.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        jtaTexto.setLineWrap(true);
        painel.add(jspTexto);
    }


}


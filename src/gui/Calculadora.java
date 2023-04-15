package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculadora {
  private JFrame janela;
  private final int LARGURA_JANELA = 400;
  private final int ALTURA_JANELA = 700;
  private final String[] NOME_BOTAO = {
    "C", "␡", "", "÷",
    "7", "8", "9", "✕",
    "5", "6", "4", "-",
    "3", "2", "1", "+",
    "0", "i", ".", "="
  };
  
  public Calculadora() {
    janela = new JFrame("Calculator");
    janela.setSize(LARGURA_JANELA, ALTURA_JANELA);
    janela.setLocationRelativeTo(null);

    Label visor = new Label("0",Label.RIGHT);
    visor.setFont(new Font("Arial",Font.PLAIN,30));
    visor.setBounds(0, 0, LARGURA_JANELA, 100);
    visor.setBackground(Color.gray);
    janela.add(visor);

    JPanel painel = new JPanel();
    painel.setBounds(0,visor.getHeight(),LARGURA_JANELA, ALTURA_JANELA - visor.getHeight() - 35);
    painel.setLayout(new GridLayout(5,4));
    for(String nome : NOME_BOTAO) {
      JButton botao = new JButton(nome);
      botao.setFont(new Font("Arial",Font.BOLD,30));
      botao.setBackground(Color.white);
      botao.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
          Botao.click(nome, visor);
        }
      });
      painel.add(botao);
    }

    janela.add(painel);
    
    janela.setLayout(null);
    janela.setResizable(false);
    janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    janela.setVisible(true);
  }
}
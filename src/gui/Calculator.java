package gui;
import javax.swing.*;
import javax.swing.event.*;

import operations.OpNumComplexos;
import operations.OpNumReais;

import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.Stack;
import java.util.ArrayList;

public class Calculator {
  private JFrame janela;
  private final int LARGURA_JANELA = 400;
  private final int ALTURA_JANELA = 700;
  private final String[] nomeBotao = {
    "C", "", "", "÷",
    "7", "8", "9", "✕",
    "5", "6", "4", "-",
    "3", "2", "1", "+",
    "0", "i", ".", "="
  };

  Stack<String> numeros = new Stack<String>();
  private String resultado;
  private boolean clear = true;

  private String a, b;

  OpNumReais calcReais = new OpNumReais();
  OpNumComplexos calcComplexos = new OpNumComplexos();
  
  public Calculator() {
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
    for(String nome : nomeBotao) {
      JButton botao = new JButton(nome);
      botao.setFont(new Font("Arial",Font.BOLD,30));
      botao.setBackground(Color.white);
      botao.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
          btnFunc(nome, visor);
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

  private void btnFunc(String btnText, Label visor) {
    try {
      Float.parseFloat(btnText);
      if(clear || !visor.getText().contains("i")) {
        if(!clear) visor.setText(visor.getText() + btnText);
        else {
          visor.setText(btnText);
          clear = false;
        };
      }
    } catch (Exception exception) {
      switch (btnText) {
        case "C":
          visor.setText("0");
          numeros.clear();
          break;
        case "i":
          if(!visor.getText().contains("i")) {
            visor.setText(visor.getText() + "i");
          }
          break;
        case "=":
          numeros.push(visor.getText());
          clear = true;
          System.out.println(numeros);
          break;
        case ".":
          visor.setText(visor.getText() + btnText);
          break;
        case "÷":
          try {
            System.out.println(numeros);
            a = numeros.pop();
            b = numeros.pop();
            if(a.contains("i") || b.contains("i")) resultado = calcComplexos.divisao(a, b);
            else resultado = calcReais.divisao(a, b);
            visor.setText(resultado);
            numeros.push(resultado);
          } catch (Exception e) {
            System.out.println("a lista ta vazia");
          }
          break;
        case "✕":
          try {
            System.out.println(numeros);
            a = numeros.pop();
            b = numeros.pop();
            if(a.contains("i") || b.contains("i")) resultado = calcComplexos.multiplicacao(a, b);
            else resultado = calcReais.multiplicacao(a, b);
            visor.setText(resultado);
            numeros.push(resultado);
          } catch (Exception e) {
            System.out.println("a lista ta vazia");
          }
          break;
        case "-":
          try {
            System.out.println(numeros);
            a = numeros.pop();
            b = numeros.pop();
            if(a.contains("i") || b.contains("i")) resultado = calcComplexos.subtracao(a, b);
            else resultado = calcReais.subtracao(a, b);
            visor.setText(resultado);
            numeros.push(resultado);
          } catch (Exception e) {
            System.out.println("a lista ta vazia");
          }
          break;
        case "+":
          try {
            a = numeros.pop();
            b = numeros.pop();
            if(a.contains("i") || b.contains("i")) {
              resultado = calcComplexos.adicao(a, b);
            }
            else resultado = calcReais.adicao(a, b);
            visor.setText(resultado);
            numeros.push(resultado);
          } catch (Exception e) {
            System.out.println("a lista ta vazia");
          }
          break;
        default:
          break;
      }
    }
  }
}
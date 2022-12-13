package gui;
import operations.OpNumComplexos;
import operations.OpNumReais;
import java.awt.*;
import java.util.Stack;

public class FuncoesBtn {
  private static Stack<String> numeros = new Stack<String>();
  private static String resultado;
  private static boolean clear;
  private static String a, b;
  private static OpNumReais calcReais;
  private static OpNumComplexos calcComplexos;

  public static void click(String btnText, Label visor) {
    calcReais = new OpNumReais();
    calcComplexos = new OpNumComplexos();
    clear = true;

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
          clear = true;
          break;
        case "␡":
          if(visor.getText().length() > 0) visor.setText(visor.getText().substring(0, visor.getText().length() - 1));
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
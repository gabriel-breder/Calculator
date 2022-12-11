package operations;

public class OpNumComplexos extends Operations {
  private String resposta;
  private String[] temp_a, temp_b;
  private float calc_cmp, calc_real;
  
  @Override
  public String adicao(String a, String b) {
    if(a.contains("+")) a = a.replace(" + ", " ");
    if(b.contains("+")) b = b.replace(" + ", " ");
    
    temp_a = a.split("\\s");
    temp_b = b.split("\\s");

    
    if(temp_a[0].contains("i")) temp_a[0] = temp_a[0].replace("i", "");
    if(temp_b[0].contains("i")) temp_b[0] = temp_b[0].replace("i", "");

    

    if(temp_a.length == 1 && temp_b.length == 1) calc_real = Float.parseFloat(temp_a[1]) + Float.parseFloat(temp_b[1]);
    else if (temp_a.length == 1) calc_real = Float.parseFloat(temp_b[0]);
    else calc_real = Float.parseFloat(temp_b[1]) + Float.parseFloat(temp_a[0]); 
  
    if(a.contains("i") && b.contains("i")) {
      calc_cmp = Float.parseFloat(temp_a[0]) + Float.parseFloat(temp_b[0]);
    } else if (a.contains("i")) {
      calc_cmp = Float.parseFloat(temp_a[0]);
    } else {
      System.out.println("entrei aqui");
      calc_cmp = Float.parseFloat(temp_b[0]);
    }
    System.out.println(calc_cmp);
    System.out.println(calc_real);
    resposta = Float.toString(calc_cmp) + " + " + Float.toString(calc_real);
    System.out.println("resposta: " + resposta);
    return resposta;
  }

  @Override
  public String subtracao(String a, String b) {
    if(a.contains("-")) a = a.replace(" - ", " ");
    if(b.contains("-")) b = b.replace(" - ", " ");
    
    temp_a = a.split(" ");
    temp_b = b.split(" ");

    if(temp_a[0].contains("i")) temp_a[0] = temp_a[0].replace("i", "");
    if(temp_b[0].contains("i")) temp_b[0] = temp_b[0].replace("i", "");

    if(temp_a.length == 1 && temp_b.length == 1) calc_real = Float.parseFloat(temp_a[1]) - Float.parseFloat(temp_b[1]);
    else if (temp_a.length == 1) calc_real = Float.parseFloat(temp_b[0]);
    else calc_real = Float.parseFloat(temp_b[1]) - Float.parseFloat(temp_a[0]); 
  
    if(a.contains("i") && b.contains("i")) {
      calc_cmp = Float.parseFloat(temp_a[0]) - Float.parseFloat(temp_b[0]);
    } else if (a.contains("i")) {
      calc_cmp = Float.parseFloat(temp_a[0]);
    } else {
      calc_cmp = Float.parseFloat(temp_b[0]);
    }
    resposta = Float.toString(calc_cmp) + " - " + Float.toString(calc_real);
    return resposta;
  }

  @Override
  public String multiplicacao(String a, String b) {
    System.out.printf(a, b);
    return a + b;
  }

  @Override
  public String divisao(String a, String b) {
    System.out.printf(a, b);
    return a + b;
  }
}
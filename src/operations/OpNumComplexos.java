package operations;

public class OpNumComplexos extends Operacoes {
  private String resposta;
  private String[] temp_a, temp_b;
  private float calc_cmp, calc_real;
  private String calc_real_s, calc_cmp_s;
  
  @Override
  public String adicao(String a, String b) {
    a = a.replace(" ", "");
    b = b.replace(" ", "");
    temp_a = a.split("i");
    temp_b = b.split("i");

    System.out.println(temp_b.length);
    System.out.println(temp_b[0]);    
    if((temp_a.length == 1 && a.contains("i")) && (temp_b.length == 1 && b.contains("i"))) calc_real = 0;
    else if ((temp_a.length == 1 && a.contains("i")) && temp_b.length == 1) calc_real = Float.parseFloat(temp_b[0]);
    else if (temp_a.length == 1 && a.contains("i")) calc_real = Float.parseFloat(temp_b[1]);
    else if ((temp_b.length == 1 && b.contains("i")) && temp_a.length == 1) calc_real = Float.parseFloat(temp_a[0]);
    else if (temp_b.length == 1 && b.contains("i")) calc_real = Float.parseFloat(temp_a[1]);
    else if (temp_a.length == 1) calc_real = Float.parseFloat(temp_a[0]) + Float.parseFloat(temp_b[1]);
    else if (temp_b.length == 1) calc_real = Float.parseFloat(temp_a[1]) + Float.parseFloat(temp_b[0]);
    else calc_real = Float.parseFloat(temp_b[1]) + Float.parseFloat(temp_a[1]); 
    
    if(a.contains("i") && b.contains("i")) {
      calc_cmp = Float.parseFloat(temp_a[0]) + Float.parseFloat(temp_b[0]);
    } else if (a.contains("i")) {
      calc_cmp = Float.parseFloat(temp_a[0]);
    } else {
      calc_cmp = Float.parseFloat(temp_b[0]);
    }

    calc_cmp_s = Float.toString(calc_cmp) + "i";
    calc_real_s = Float.toString(calc_real);
    if(calc_real > 0) calc_real_s = " + " + calc_real_s;
    else if (calc_real < 0) calc_real_s.replace("-", " - ");

    if(calc_real != 0) resposta = calc_cmp_s + calc_real_s;
    else resposta = calc_cmp_s;
    return resposta;
  }

  @Override
  public String subtracao(String a, String b) {
    a = a.replace(" ", "");
    b = b.replace(" ", "");
    temp_a = a.split("i");
    temp_b = b.split("i");

    if((temp_a.length == 1 && a.contains("i")) && (temp_b.length == 1 && b.contains("i"))) calc_real = 0;
    else if ((temp_a.length == 1 && a.contains("i")) && temp_b.length == 1) calc_real = Float.parseFloat(temp_b[0]);
    else if (temp_a.length == 1 && a.contains("i")) calc_real = Float.parseFloat(temp_b[1]);
    else if ((temp_b.length == 1 && b.contains("i")) && temp_a.length == 1) calc_real = Float.parseFloat(temp_a[0]);
    else if (temp_b.length == 1 && b.contains("i")) calc_real = Float.parseFloat(temp_a[1]);
    else if (temp_a.length == 1) calc_real = Float.parseFloat(temp_a[0]) - Float.parseFloat(temp_b[1]);
    else if (temp_b.length == 1) calc_real = Float.parseFloat(temp_a[1]) - Float.parseFloat(temp_b[0]);
    else calc_real =  Float.parseFloat(temp_a[1]) - Float.parseFloat(temp_b[1]); 
  
    if(a.contains("i") && b.contains("i")) {
      calc_cmp = Float.parseFloat(temp_a[0]) - Float.parseFloat(temp_b[0]);
    } else if (a.contains("i")) {
      calc_cmp = Float.parseFloat(temp_a[0]);
    } else {
      calc_cmp = Float.parseFloat(temp_b[0]);
    }

    calc_cmp_s = Float.toString(calc_cmp) + "i";
    calc_real_s = Float.toString(calc_real);
    if(calc_real > 0) calc_real_s = " + " + calc_real_s;
    else calc_real_s.replace("-", " - ");
    System.out.println(calc_real_s);

    if(calc_real != 0) resposta = calc_cmp_s + calc_real_s;
    else resposta = calc_cmp_s;
    return resposta;
  }

  @Override
  public String multiplicacao(String a, String b) {
    a = a.replace(" ", "");
    b = b.replace(" ", "");
    temp_a = a.split("i");
    temp_b = b.split("i");

    if((temp_a.length == 1 && a.contains("i")) && (temp_b.length == 1 && b.contains("i"))) {
      calc_real = Float.parseFloat(temp_a[0]) * Float.parseFloat(temp_b[0]) * (-1);
      calc_cmp = 0;
    }
    else if (temp_a.length == 1 && a.contains("i")){
      calc_real = Float.parseFloat(temp_a[0]) * Float.parseFloat(temp_b[0]) * (-1);
      calc_cmp = Float.parseFloat(temp_a[0]) * Float.parseFloat(temp_b[1]);
    }
    else if (temp_b.length == 1 && b.contains("i")){
      calc_real = Float.parseFloat(temp_a[0]) * Float.parseFloat(temp_b[0]) * (-1);
      calc_cmp = Float.parseFloat(temp_a[1]) * Float.parseFloat(temp_b[0]);
    }
    else calc_real = (Float.parseFloat(temp_a[0]) * Float.parseFloat(temp_b[0]) * (-1)) + (Float.parseFloat(temp_a[1]) * Float.parseFloat(temp_b[1]));

    calc_cmp_s = Float.toString(calc_cmp) + "i";
    calc_real_s = Float.toString(calc_real);
    if(!calc_real_s.contains("-")) calc_real_s = " + " + calc_real_s;
    else {
      calc_real_s = calc_real_s.replace("-", "");
      calc_real_s = " - " + calc_real_s;
    };
    System.out.println(calc_real_s);

    if(calc_real != 0) resposta = calc_cmp_s + calc_real_s;
    else resposta = calc_cmp_s;
    return resposta;
  }

  @Override
  public String divisao(String a, String b) {
    a = a.replace(" ", "");
    b = b.replace(" ", "");
    temp_a = a.split("i");
    temp_b = b.split("i");

    if((temp_a.length == 1 && a.contains("i")) && (temp_b.length == 1 && b.contains("i"))) {
      calc_real = Float.parseFloat(temp_a[0]) / Float.parseFloat(temp_b[0]) * (-1);
      calc_cmp = 0;
    }
    else if (temp_a.length == 1 && a.contains("i")){
      calc_real = Float.parseFloat(temp_a[0]) / Float.parseFloat(temp_b[0]) * (-1);
      calc_cmp = Float.parseFloat(temp_a[0]) / Float.parseFloat(temp_b[1]);
    }
    else if (temp_b.length == 1 && b.contains("i")){
      calc_real = Float.parseFloat(temp_a[0]) / Float.parseFloat(temp_b[0]) * (-1);
      calc_cmp = Float.parseFloat(temp_a[1]) / Float.parseFloat(temp_b[0]);
    }
    else calc_real = (Float.parseFloat(temp_a[0]) / Float.parseFloat(temp_b[0]) * (-1)) + (Float.parseFloat(temp_a[1]) / Float.parseFloat(temp_b[1]));

    calc_cmp_s = Float.toString(calc_cmp) + "i";
    calc_real_s = Float.toString(calc_real);
    if(!calc_real_s.contains("-")) calc_real_s = " + " + calc_real_s;
    else {
      calc_real_s = calc_real_s.replace("-", "");
      calc_real_s = " - " + calc_real_s;
    };
    System.out.println(calc_real_s);

    if(calc_real != 0) resposta = calc_cmp_s + calc_real_s;
    else resposta = calc_cmp_s;
    return resposta;
  }
}
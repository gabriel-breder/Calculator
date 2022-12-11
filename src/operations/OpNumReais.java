package operations;

public class OpNumReais extends Operations {

  @Override
  public String adicao(String a, String b) {
    float n = Float.parseFloat(a);
    float m = Float.parseFloat(b);
    return Float.toString(m + n);
  }

  @Override
  public String subtracao(String a, String b) {
    float n = Float.parseFloat(a);
    float m = Float.parseFloat(b);
    return Float.toString(m - n);
  }

  @Override
  public String multiplicacao(String a, String b) {
    float n = Float.parseFloat(a);
    float m = Float.parseFloat(b);
    return Float.toString(m * n);
  }

  @Override
  public String divisao(String a, String b) {
    float n = Float.parseFloat(a);
    float m = Float.parseFloat(b);
    return Float.toString(m / n);
  }
  
}

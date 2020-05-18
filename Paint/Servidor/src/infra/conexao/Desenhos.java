package src.infra.conexao;

import java.util.ArrayList;

public class Desenhos extends Comunicado {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  private ArrayList<Desenho> desenhos;

  public Desenhos() {
    this.desenhos = new ArrayList<Desenho>();
  }

  public void addDesenho(Desenho novo) {
    this.desenhos.add(novo);
  }

  public double getQtd() {
    return this.desenhos.size();
  }

  public Desenho getDesenho(int i) {
    return this.desenhos.get(i);
  }
}
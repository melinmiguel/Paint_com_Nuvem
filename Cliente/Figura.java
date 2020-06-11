import java.awt.*;

/**
 * Figura desenhada com seus atributos
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
public abstract class Figura {
  protected Color cor;

  protected Figura() {
    this(Color.BLACK);
  }

/**
 * Construtor da cor
 * 
 * @param Color Cor que sera definido para a figura
 * 
 * @author      Leonardo
 * @author      Rodrigo
 * @author      Pedro
 */
  protected Figura(Color cor) {
    this.cor = cor;
  }

  /**
 * Define a Cor selecionada
 * 
 * @param Color   Cor que sera definido para a figura
 * 
 * @author        Leonardo
 * @author        Rodrigo
 * @author        Pedro
 */
  public void setCor(Color cor) {
    this.cor = cor;
  }

/**
 * Retorna a cor definida
 * 
 * @return  Cor da figura
 * @author  Leonardo
 * @author  Rodrigo
 * @author  Pedro
 */
  public Color getCor() {
    return this.cor;
  }

  // public abstract boolean equals (Object obj);
  // public abstract int hashCode ();
  // public abstract Object clone ();
  public abstract String toString();

  public abstract void torneSeVisivel(Graphics g);
}

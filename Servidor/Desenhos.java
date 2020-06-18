import java.util.ArrayList;

/**
 * Pilha de desenhos
 * 
 * @author Leonardo
 * @author Rodrigo
 * @author Pedro
 */
public class Desenhos extends Comunicado {
  private ArrayList<Desenho> desenhos;

  /**
   * Construtor da pilha desenhos
   * 
   * @author Leonardo
   * @author Rodrigo
   * @author Pedro
   */
  public Desenhos() {
    desenhos = new ArrayList<Desenho>();
  }

  /**
   * Adiciona desenho na pilha de desenhos
   * 
   * @param novo Novo objeto Desenho a ser adicionado
   * @author Leonardo
   * @author Rodrigo
   * @author Pedro
   */
  public void addDesenho(Desenho novo) {
    desenhos.add(novo);
  }

  /**
   * Retorna a quantidade de desenhos na pilha
   * 
   * @return Quantidade de itens na pilha
   * @author Leonardo
   * @author Rodrigo
   * @author Pedro
   */
  public double getQtd() {
    return desenhos.size();
  }

  /**
   * Retorna um desenho da pilha
   * 
   * @return Desenho selecionado.
   * @author Leonardo
   * @author Rodrigo
   * @author Pedro
   */
  public Desenho getDesenho(int i) {
    return desenhos.get(i);
  }
}
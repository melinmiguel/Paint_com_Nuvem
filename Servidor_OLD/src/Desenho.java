import java.util.ArrayList;

public class Desenho {
  private String nome;
  private String dataCriacao;
  private String dataUltimaAtualizacao;
  private ArrayList<String> conteudo;

/**
	 * Construtor da classe desenho
	 * 
   * @param nom nome do desenho
   * @param dtCri data de criação do desenho
   * @param dtUltAtu data de atualização do desenho
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public Desenho(String nom, String dtCri, String dtUltAtu) {
    nome = nom;
    dataCriacao = dtCri;
    dataUltimaAtualizacao = dtUltAtu;
    conteudo = new ArrayList<String>();
  }

  // fig vai ter como forma o retorno do metodo toString de alguma das classes
  // herdadas da classe Figura por exemplo, r:11:22:33:44:55:66:77, para uma
  // linha que vai do ponto com coordenada 11,22 ao ponto com coordenada 33,44
  // e com cor 55:66:77 (55 de red, 66 de green e 77 de blue).

/**
	 * Define a string de figuras
	 * 
   * @param fig figura a ser adicionada.
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public void addFigura(String fig) {
    conteudo.add(fig);
  }

  /**
	 * Retorna a quantidade de desenhos na array.
	 * 
   * @return    retorna a quantidade de figuras.
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public int getQtd() {
    return conteudo.size();
  }

  /**
	 * Retorna uma figura do array.
	 * 
   * @param i   nuemro da figura solicitado.
   * @return    retorna a figura solicitada.
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public String getFigura(int i) {
    return conteudo.get(i);
  }

  /**
	 * Retorna o nome da figura
	 * 
   * @return    nome da figura solicitada.
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public String getNome() {
    return this.nome;
  }

  /**
	 * Retorna data de criação da figura
	 * 
   * @return    data de criação
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public String getDataCriacao() {
    return this.dataCriacao;
  }

    /**
	 * Retorna data de atualização da figura
	 * 
   * @return    data de atualização
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public String getDataUltimaAtualizacao() {
    return this.dataUltimaAtualizacao;
  }

/**
	 * Define o nome da figura.
	 * 
   * @param nome da figura
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
	 * Define o data de criação.
	 * 
   * @param dataCriacao da figura
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public void setDataCriacao(String dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  /**
	 * Define o nome da figura.
	 * 
   * @param dataUltimaAtualizacao data de atualização da figura
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
    this.dataUltimaAtualizacao = dataUltimaAtualizacao;
  }
}
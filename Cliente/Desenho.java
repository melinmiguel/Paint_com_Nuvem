import java.util.ArrayList;

	/**
	 * Objeto desenho, objeto que vai armazenar os dados dos desenhos.
	 * 
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
public class Desenho {
  private String nome;
  private String dataCriacao;
  private String dataUltimaAtualizacao;
  private ArrayList<String> conteudo;
  
  /**
	  * Construtor do objeto desenho, objeto que vai armazenar os dados dos desenhos.
	 * 
   * 
   * @param nom       Nome do desenho
   * @param dtCri     Data de criação do desenho
   * @param dtUltAtu  Data de atualização do desenho.
	 * @author          Leonardo
	 * @author          Rodrigo
	 * @author          Pedro
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
	 *Faz adição do desenho na string.
	 * 
   * @param   fig     String da figura
	 * @author          Leonardo
	 * @author          Rodrigo
	 * @author          Pedro
	 */
  public void addFigura(String fig) {
    conteudo.add(fig);
  }

  /**
	 *Retorna a quantidade de desenhos na pilha.
	 * 
   * @return    Quantidade de desenhos.
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public int getQtd() {
    return conteudo.size();
  }

  /**
	 *Retorna uma figura.
	 * 
   * @param i   Numero da figura desejada
   * @return    Quantidade de desenhos.
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public String getFigura(int i) {
    return conteudo.get(i);
  }

  /**
	 *Retorna o nome do objeto Desenho
	 * 
   * @return    nome do objeto.
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public String getNome() {
    return this.nome;
  }

  /**
	 *Retorna a data de criação do objeto.
	 * 
   * @return    Data de criação.
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public String getDataCriacao() {
    return this.dataCriacao;
  }

  /**
	 *Retorna a data de atualização do projeto
	 * 
   * @return    Data de atualização.
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public String getDataUltimaAtualizacao() {
    return this.dataUltimaAtualizacao;
  }

  /**
	 *Define o nome do desenho
	 * 
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
	 *Define a data de criacao do desenho
	 * 
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public void setDataCriacao(String dataCriacao) {
    this.dataCriacao = dataCriacao;
  }

  /**
	 *Define a data de atualizacao do desenho
	 * 
	 * @author    Leonardo
	 * @author    Rodrigo
	 * @author    Pedro
	 */
  public void setDataUltimaAtualizacao(String dataUltimaAtualizacao) {
    this.dataUltimaAtualizacao = dataUltimaAtualizacao;
  }
}
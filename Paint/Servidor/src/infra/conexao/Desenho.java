package src.infra.conexao;

import java.util.ArrayList;

public class Desenho {
  private String nome;
  private String dataCriacao;
  private String dataUltimaAtualizacao;
  private ArrayList<String> conteudo;

  public Desenho(String nom, String dtCri, String dtUltAtu) throws Exception {
    if (nom == null)
      throw new Exception("Nome ausente");

    if (dtCri == null)
      throw new Exception("Data de criacao ausente");

    if (dtUltAtu == null)
      throw new Exception("Data da ultima atualizacao ausente");

    nome = nom;
    dataCriacao = dtCri;
    dataUltimaAtualizacao = dtUltAtu;
    conteudo = new ArrayList<String>();
  }

  // fig vai ter como forma o retorno do metodo toString de alguma das classes
  // herdadas da classe Figura por exemplo, r:11:22:33:44:55:66:77, para uma
  // linha que vai do ponto com coordenada 11,22 ao ponto com coordenada 33,44
  // e com cor 55:66:77 (55 de red, 66 de green e 77 de blue).
  public void addFigura(String fig) throws Exception {
    if (fig == null)
      throw new Exception("Figura ausente");

    conteudo.add(fig);
  }

  public int getQtd() {
    return conteudo.size();
  }

  public String getFigura(int i) {
    return conteudo.get(i);
  }

  public String getNome() {
    return this.nome;
  }

  public String getDataCriacao() {
    return this.dataCriacao;
  }

  public String getDataUltimaAtualizacao() {
    return this.dataUltimaAtualizacao;
  }

  public ArrayList<Desenho> getDesenhos() {
    ArrayList<Desenho> desenhos = new ArrayList<Desenho>();

    return desenhos;
  }

}
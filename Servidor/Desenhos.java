package src.BDSQLServer;

import java.sql.*;

import src.conexao.Desenho;

public class Desenhos {

  public void criar(Desenho desenho) throws Exception {
    if (desenho == null)
      throw new Exception("Desenho nao fornecido");

    try {
      String query = "insert into desenho (nome, dataCriacao, dataUltimaAtualizacao, conteudo) values (?, ?, ?, ?)";

      BDSQLServer.COMANDO.prepareStatement(query);

      BDSQLServer.COMANDO.setString(1, desenho.getNome());
      BDSQLServer.COMANDO.setString(3, desenho.getDataCriacao());
      BDSQLServer.COMANDO.setString(4, desenho.getDataUltimaAtualizacao());
      BDSQLServer.COMANDO.setString(2, desenho.getDesenho());

      BDSQLServer.COMANDO.executeUpdate();
      BDSQLServer.COMANDO.commit();
    } catch (SQLException erro) {
      throw new Exception("Erro ao inserir Desenho");
    }
  }

  public void deletar(String nome) throws Exception {
    try {
      String query = "delete from desenho where nome = ?";

      BDSQLServer.COMANDO.prepareStatement(query);

      BDSQLServer.COMANDO.setString(1, nome);

      BDSQLServer.COMANDO.executeUpdate();
      BDSQLServer.COMANDO.commit();
    } catch (SQLException erro) {
      throw new Exception("Erro ao excluir desenho");
    }
  }

  public void atualizar(Desenho desenho) throws Exception {
    if (desenho == null)
      throw new Exception("Desenho nao fornecido");

    try {
      String query = "update desenho set dataAtualizacao = ? where nome = ?";

      BDSQLServer.COMANDO.prepareStatement(query);

      BDSQLServer.COMANDO.setString(1, desenho.getDataUltimaAtualizacao());
      BDSQLServer.COMANDO.setString(2, desenho.getNome());

      BDSQLServer.COMANDO.executeUpdate();
      BDSQLServer.COMANDO.commit();
    } catch (SQLException erro) {
      throw new Exception("Erro ao atualizar dados de Desenho");
    }
  }

  public Desenho selecionar(String nome) throws Exception {
    Desenho desenho = null;

    try {
      String query = "select * from desenho where nome = ?";

      BDSQLServer.COMANDO.prepareStatement(query);

      BDSQLServer.COMANDO.setString(1, nome);

      MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

      if (!resultado.first())
        throw new Exception("Nao cadastrado");

      desenho = new Desenho(resultado.getString("nome"), resultado.getString("dtCri"),
          resultado.getString("dtUtlAtu"), resultado.getString("desenho"));
    } catch (SQLException erro) {
      throw new Exception("Erro ao procurar Desenho");
    }

    return desenho;
  }

  public src.conexao.Desenhos selecionaDesenhosPorIdCliente(String nome) throws Exception {
    src.conexao.Desenhos desenhos = new src.conexao.Desenhos();
    MeuResultSet resultado = null;

    try {
      String query = "select * from desenhos where nome = ?";

      BDSQLServer.COMANDO.prepareStatement(query);
      BDSQLServer.COMANDO.setString(1, nome);

      resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

      for (int i = 0; i < resultado.getFetchSize(); i++) {
        Desenho desenho = new Desenho(resultado.getString("nome"),
            resultado.getString("dtCri"), resultado.getString("dtUtlAtu"), resultado.getString("desenho"));

        desenhos.addDesenho(desenho);
        resultado.deleteRow();
      }
    } catch (SQLException erro) {
      throw new Exception("Erro ao recuperar Usuarios");
    }

    return desenhos;
  }

  public boolean cadastrado(String nome) throws Exception {
    try {
      String query = "select * from desenho where nome = ?";

      BDSQLServer.COMANDO.prepareStatement(query);

      BDSQLServer.COMANDO.setString(1, nome);

      MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

      if (resultado.first())
        return true;
      else
        return false;

    } catch (SQLException erro) {
      throw new Exception("Erro ao procurar Desenho");
    }
  }
}

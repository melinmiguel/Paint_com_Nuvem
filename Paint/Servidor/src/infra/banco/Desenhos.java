package src.infra.banco;

import java.sql.*;
import java.util.ArrayList;

import src.infra.conexao.Desenho;

public class Desenhos {

  public void criar(Desenho desenho) throws Exception {
    if (desenho == null)
      throw new Exception("Desenho nao fornecido");

    try {
      String query = "insert into desenho (nome, idCliente) values (?,?)";

      BD.COMANDO.prepareStatement(query);

      BD.COMANDO.setString(1, desenho.getNome());
      BD.COMANDO.setString(2, "000.000.000.000");

      BD.COMANDO.executeUpdate();
      BD.COMANDO.commit();
    } catch (SQLException erro) {
      throw new Exception("Erro ao inserir Desenho");
    }
  }

  public void deletar(String nomeDesenho) throws Exception {
    try {
      String query = "delete from desenhos where nome = ?";

      BD.COMANDO.prepareStatement(query);

      BD.COMANDO.setString(1, nomeDesenho);

      BD.COMANDO.executeUpdate();
      BD.COMANDO.commit();
    } catch (SQLException erro) {
      throw new Exception("Erro ao excluir desenho");
    }
  }

  public void atualizar(Desenho desenho) throws Exception {
    if (desenho == null)
      throw new Exception("Desenho nao fornecido");

    try {
      String query = "update desenhos set nome set dataAtualizacao";

      BD.COMANDO.prepareStatement(query);

      BD.COMANDO.setString(1, desenho.getNome());
      BD.COMANDO.setString(2, "12/10/2020");

      BD.COMANDO.executeUpdate();
      BD.COMANDO.commit();
    } catch (SQLException erro) {
      throw new Exception("Erro ao atualizar dados de Desenho");
    }
  }

  public Desenho selecionar(String nomeDesenho) throws Exception {
    Desenho desenho = null;

    try {
      String query = "select * from desenhos where nome = ?";

      BD.COMANDO.prepareStatement(query);

      BD.COMANDO.setString(1, nomeDesenho);

      MeuResultSet resultado = (MeuResultSet) BD.COMANDO.executeQuery();

      if (!resultado.first())
        throw new Exception("Nao cadastrado");

      desenho = new Desenho(resultado.getString("nome"), resultado.getString("dtCri"), resultado.getString("dtUtlAtu"));
    } catch (SQLException erro) {
      throw new Exception("Erro ao procurar Desenho");
    }

    return desenho;
  }

  public src.infra.conexao.Desenhos cionaDesenhosPorIdCliente(String idCliente) throws Exception {
    src.infra.conexao.Desenhos desenhos = new src.infra.conexao.Desenhos();
    MeuResultSet resultado = null;

    try {
      String query = "select * from desenhos where idCliente = ?";

      BD.COMANDO.prepareStatement(query);
      BD.COMANDO.setString(1, idCliente);

      resultado = (MeuResultSet) BD.COMANDO.executeQuery();

      for (int i = 0; i < resultado.getFetchSize(); i++) {
        Desenho desenho = new Desenho(resultado.getString("nome"), resultado.getString("dtCri"),
            resultado.getString("dtUtlAtu"));

        desenhos.addDesenho(desenho);
        resultado.deleteRow();
      }
    } catch (SQLException erro) {
      throw new Exception("Erro ao recuperar Usuarios");
    }

    return desenhos;
  }

  // public MeuResultSet cionaDesenhosPorIdCliente(String idCliente) throws
  // Exception {
  // MeuResultSet resultado = null;

  // try {
  // String query = "select * from desenhos where idCliente = ?";

  // BD.COMANDO.prepareStatement(query);
  // BD.COMANDO.setString(1, idCliente);

  // resultado = (MeuResultSet) BD.COMANDO.executeQuery();
  // } catch (SQLException erro) {
  // throw new Exception("Erro ao recuperar Usuarios");
  // }

  // return resultado;
  // }

}
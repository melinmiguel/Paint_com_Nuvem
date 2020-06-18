package bd.daos;

import java.sql.*;
import bd.*;
import bd.core.*;
import bd.dbos.*;

public class Desenhos {
    public static boolean cadastrado(String nome) throws Exception {
        boolean retorno = false;

        try {
            String sql;

            sql = "SELECT * " + "FROM Desenhos " + "WHERE nome = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, nome);

            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

            retorno = resultado.first(); // pode-se usar resultado.last() ou resultado.next() ou resultado.previous() ou
                                         // resultado.absotule(numeroDaLinha)

            /*
             * // ou, se preferirmos,
             * 
             * String sql;
             * 
             * sql = "SELECT COUNT(*) AS QUANTOS " + "FROM LIVROS " + "WHERE CODIGO = ?";
             * 
             * BDSQLServer.COMANDO.prepareStatement (sql);
             * 
             * BDSQLServer.COMANDO.setInt (1, codigo);
             * 
             * MeuResultSet resultado = (MeuResultSet)BDSQLServer.COMANDO.executeQuery ();
             * 
             * resultado.first();
             * 
             * retorno = resultado.getInt("QUANTOS") != 0;
             * 
             */
        } catch (SQLException erro) {
            throw new Exception("Erro ao procurar livro");
        }

        return retorno;
    }

    public static void incluir(Desenho desenho) throws Exception {
        if (desenho == null)
            throw new Exception("Desenho nao fornecido");

        try {
            String sql;

            sql = "INSERT INTO Desenhos " + "(nome,dataCriacao,dataUltimaAtualizacao,conteudo) " + "VALUES "
                    + "(?,?,?,?)";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, desenho.getNome());
            BDSQLServer.COMANDO.setString(2, desenho.getDataCriacao());
            BDSQLServer.COMANDO.setString(3, desenho.getDataUltimaAtualizacao());
            BDSQLServer.COMANDO.setString(4, desenho.getConteudo());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        } catch (SQLException erro) {
            BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao inserir desenho");
        }
    }

    public static void excluir(String nome) throws Exception {
        if (!cadastrado(nome))
            throw new Exception("Nao cadastrado");

        try {
            String sql;

            sql = "DELETE FROM Desenhos " + "WHERE nome=?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, nome + "");

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        } catch (SQLException erro) {
            BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao excluir desenho");
        }
    }

    public static void alterar(Desenho desenho) throws Exception {
        if (desenho == null)
            throw new Exception("Desenho nao fornecido");

        if (!cadastrado(desenho.getNome()))
            throw new Exception("Nao cadastrado");

        try {
            String sql;

            sql = "UPDATE Desenhos " + "SET dataUltimaAtualizacao=? " + "SET conteudo=? " + "WHERE nome = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, desenho.getDataUltimaAtualizacao());
            BDSQLServer.COMANDO.setString(2, desenho.getConteudo());

            BDSQLServer.COMANDO.executeUpdate();
            BDSQLServer.COMANDO.commit();
        } catch (SQLException erro) {
            BDSQLServer.COMANDO.rollback();
            throw new Exception("Erro ao atualizar dados do desenho");
        }
    }

    public static Desenho getDesenho(String nome) throws Exception {
        Desenho desenho = null;

        try {
            String sql;

            sql = "SELECT * " + "FROM Desenho " + "WHERE nome = ?";

            BDSQLServer.COMANDO.prepareStatement(sql);

            BDSQLServer.COMANDO.setString(1, nome);

            MeuResultSet resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();

            if (!resultado.first())
                throw new Exception("Nao cadastrado");

            desenho = new Desenho(resultado.getString("nome"), resultado.getString("Data"),
                    resultado.getString("conteudo"));
        } catch (SQLException erro) {
            throw new Exception("Erro ao procurar desenho");
        }

        return desenho;
    }

    public static MeuResultSet getDesenho() throws Exception {
        MeuResultSet resultado = null;

        try {
            String sql;

            sql = "SELECT * " + "FROM Desenho";

            BDSQLServer.COMANDO.prepareStatement(sql);

            resultado = (MeuResultSet) BDSQLServer.COMANDO.executeQuery();
        } catch (SQLException erro) {
            throw new Exception("Erro ao recuperar desenho");
        }

        return resultado;
    }
}

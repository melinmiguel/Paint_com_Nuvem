import bd.daos.Livros;
import bd.dbos.Livro;

public class Programa
{
    public static void main (String[] args)
    {
        try
        {
            Livros.incluir (new Livro (3,"Pedro"));
            System.out.println ("Livro incluido com sucesso!");
        }
        catch (Exception erro)
        {
			erro.printStackTrace();
            System.out.println (erro.getMessage());
        }
    }
}

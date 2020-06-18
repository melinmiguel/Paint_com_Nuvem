import bd.daos.Desenhos;
import bd.dbos.Desenho;

public class Programa
{
    public static void main (String[] args)
    {
        try
        {
            Desenhos.incluir (new Desenho ("Desenho 1","21/07/04","21/07/04","\"[elipse:422:89:975:546:0:0:0, quadrado:500:212:598:276:255:51:51, retangulo:731:202:892:286:255:51:51, circulo:585:359:774:385:0:204:153].fga\""));
            System.out.println ("Desenho incluido com sucesso!");
        }
        catch (Exception erro)
        {
			erro.printStackTrace();
            System.out.println (erro.getMessage());
        }
    }
}

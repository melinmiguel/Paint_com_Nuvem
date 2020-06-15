package bd;

import bd.core.*;
import bd.daos.*;

public class BDSQLServer
{
    public static final MeuPreparedStatement COMANDO;

    static
    {
    	MeuPreparedStatement comando = null;

    	try
        {
            comando =
            new MeuPreparedStatement (
            "com.microsoft.sqlserver.jdbc.SQLServerDriver",
            "jdbc:sqlserver://projetoc.database.windows.net:1433;databasename=projetoc",
            "admpedro", "adm123!@#");
        }
        catch (Exception erro)
        {
            System.err.println ("Problemas de conexao com o BD");
            System.exit(0); 
        }
        
        COMANDO = comando;
    }
}

/*jdbc:sqlserver://projetoc.database.windows.net:1433;database=projetoC;user=admpedro@projetoc;password={your_password_here};encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;

*/
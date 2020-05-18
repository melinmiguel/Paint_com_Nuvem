package src.infra.banco;

public class BD {
  public static final MeuPreparedStatement COMANDO;
  public static final Desenhos DESENHOS; // um como esse para cada classe DAO

  static {
    MeuPreparedStatement comando = null;
    Desenhos desenhos = null; // um como esse para cada classe DAO

    try {
      // comando = new
      // MeuPreparedStatement("com.microsoft.sqlserver.jdbc.SQLServerDriver",
      // "jdbc:sqlserver://fs5:1433;databasename=poo201827", "poo201827", "Bwhan7");

      // comando = new
      // MeuPreparedStatement("com.microsoft.sqlserver.jdbc.SQLServerDriver",
      // "jdbc:sqlserver://fs5:1433;databasename=poo201857", "poo201857", "Zscuj7");

      comando = new MeuPreparedStatement("com.microsoft.sqlserver.jdbc.SQLServerDriver",
          "jdbc:sqlserver://fs5:1433;databasename=poo201847", "poo201847", "Dgtvk4");

      desenhos = new Desenhos(); // um como esse para cada classe DAO
    } catch (Exception erro) {
      System.err.println("Problemas de conexao com o BD");
      System.exit(0); // aborta o programa
    }

    COMANDO = comando;
    DESENHOS = desenhos; // um como esse para cada classe DAO
  }
}
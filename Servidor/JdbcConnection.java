// package bd;

// import bd.core.*;
// import bd.daos.*;

// public class BDSQLServer
// {
//     public static final MeuPreparedStatement COMANDO;

//     static
//     {
//     	MeuPreparedStatement comando = null;

public void closeConnection() {
  if (con != null) {
    try {
      con.close();
    } catch (SQLException e) {
    e.printStackTrace();
    }
  }
}
}


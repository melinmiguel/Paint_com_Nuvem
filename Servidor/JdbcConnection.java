// package bd;

// import bd.core.*;
// import bd.daos.*;

// public class BDSQLServer
// {
//     public static final MeuPreparedStatement COMANDO;

//     static
//     {
//     	MeuPreparedStatement comando = null;

//     	try
//         {
//             comando =
//             new MeuPreparedStatement (
//             "com.microsoft.sqlserver.jdbc.SQLServerDriver",
//             "jdbc:sqlserver://SERVIDOR:1433;databasename=BD",
//             "USUARIO", "SENHA");
//         }
//         catch (Exception erro)
//         {
//             System.err.println ("Problemas de conexao com o BD");
//             System.exit(0); // aborta o programa
//         }
        
//         COMANDO = comando;
//     }
// }
// /*{
//     "editor.suggestSelection": "first",
//     "vsintellicode.modify.editor.suggestSelection": "automaticallyOverrodeDefaultValue",
//     "gitlens.advanced.messages": {
//         "suppressLineUncommittedWarning": true
//     },
//     "files.exclude": {
//         "**//*.classpath": true,
//         "**///.project": true,
//        // "**/.settings": true,
//       //  "**/.factorypath": true
//     // },
//   /*  "terminal.integrated.shell.windows": "C:\\Windows\\System32\\cmd.exe",
//     "java.semanticHighlighting.enabled": true,
//     "mssql.enableQueryHistoryCapture": false,
//     "mssql.connections": [
//         {
//             "server": "projetoc.database.windows.net",
//             "database": "projetoc",
//             "user": "admpedro",
//             "password": "",
//             "authenticationType": "SqlLogin",
//             "emptyPasswordInput": false,
//             "savePassword": true,
//             "connectTimeout": 30,
//             "encrypt": true,
//             "applicationName": "vscode-mssql"
//         }
//     ],
//     "sqltools.connections": [

//     ]
// }*/
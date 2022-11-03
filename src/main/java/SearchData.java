import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SearchData {

    static final String db_url = "jdbc:mysql://localhost:3306/cadastro";
    static final String db_user = "root";
    static final String db_password = "";

    public void buscar() {
        final String db_query = "SELECT * FROM pessoas";
        System.out.println("Iniciando conexão ao DB");

        try (Connection c = DriverManager.getConnection(db_url, db_user, db_password);
                Statement statement = c.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                ResultSet resultSet = statement.executeQuery(db_query);) {
            System.out.println("Conectado ao MySQL");

            while (resultSet.next()) {
                // System.out.println(resultSet.getString(2)); // buscando apenas a coluna 2 do
                // select * from pessoas
                System.out
                        .println(resultSet.getString(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

    public void alterar(String celular, String nome, String curso) {
        final String db_query = String.format("INSERT INTO pessoas VALUES ('%s', '%s', '%s')", celular, nome, curso); // mudança
                                                                                                                      // para
                                                                                                                      // inserção
                                                                                                                      // no
                                                                                                                      // db
        System.out.println("Iniciando conexão ao DB");

        try {
            System.out.println(db_query);
            Connection c = DriverManager.getConnection(db_url, db_user, db_password);
            System.out.println("Conectado ao MySQL");
            Statement statement = c.createStatement(); // config de acesso aos cursores
            int linhas = statement.executeUpdate(db_query);
            System.out.println("A query afetou " + linhas);
            statement.close();
            c.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

    }

}
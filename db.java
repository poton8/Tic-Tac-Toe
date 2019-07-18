import java.sql.*;

public class main {

    public static String url = "jdbc:sqlite:C:/sqlite/db/" + "sample.db";


    public static void createNewDatabase(String fileName) {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        }
        catch (Exception ex) {
            System.out.println(ex);
        }

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /*

    public static void createNewTable() {
        String playerTable = "CREATE TABLE IF NOT EXISTS Player (\n player_id integer PRIMARY KEY,\n " +
                "name text NOT NULL\n);";
        String gameTable = "CREATE TABLE IF NOT EXISTS Game (\n game_id integer PRIMARY KEY,\n " +
                "moves_id integer FOREIGN KEY,\n " +
                "win_loss text,\n " +
                ");";
        String moveTable = "CREATE TABLE IF NOT EXISTS Move (\n move_id integer PRIMARY KEY,\n " +
                ""
    }

    public static void insertPlayer(int id, String name) {
        String insertPlayer = "INSERT INTO Player(id, name) VALUES (?,?)";

        try {
            //
        }
        catch (SQLException e) {
            // write msg
        }
    }


     */

    /**
     * Insert information tables
     * table game
     * table move

    public static void insertInformation(int game_id, int move_id, String win_loss) {
        String insertGame = "INSERT INTO Game("
    }

     */


    /*

    public static void createNewTable() {

    }

    public static void


     */
    public static void main(String[] args) {
        createNewDatabase("tictactoe.db");
    }

}

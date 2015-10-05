import java.sql.*;

/**
 * Created by abnormal on 05/10/15.
 */
public class Query {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/Plankton";

    static final String USER = "root";
    static final String PASS = "085215";

    public static void main(String[] args) {
        
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Register Class Success");

            System.out.println("Connecting to a selected database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("Connected database successfully...");

            System.out.println("Creating statement...");
            Statement stmt = conn.createStatement();
            String query = "SELECT student.ID, student.Name, Nilai.Kode, Nilai.Nilai" + " FROM student, Nilai" + " WHERE student.ID = Nilai.ID";
            ResultSet rs = stmt.executeQuery(query);
            System.out.println();
            System.out.println("ID , Name, Kode, Nilai:");
            while (rs.next()) {
                String id = rs.getString("id");
                String Name = rs.getString("Name");
                String Kode = rs.getString("Kode");
                String Nilai = rs.getString("Nilai");
                System.out.println(id + "  " + Name + "   " + Kode + "  " + Nilai);

            }
            System.out.println();
        } catch (ClassNotFoundException e) {
            System.err.println("Join Failed : " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Connection Failed : " + e.getMessage() + " " + e.getSQLState());
        } catch (Exception e) {
            System.err.println("Unknown Exception : " + e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }

    private static class DB_URL {
    }

    private static class USER {
    }

    private static class PASS {
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by abnormal on 05/10/15.
 */
public class Nilai {

    public static void main(String[] args)  {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Register Class Success");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Plankton", "root", "085215");

            System.out.println("Connection is now " + (connection.isClosed() ? "Closed" : "Open"));


            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Nilai SET Nilai = '100' WHERE id = 1300018085");

            int affectedRow1 = preparedStatement.executeUpdate();
            System.out.println("Success Execute Update, " + affectedRow1);



        } catch (ClassNotFoundException e) {
            System.out.println("Register Failed : " +e.getMessage());
        } catch (SQLException e) {
            System.err.println("Unknown Exeption : " + e.getMessage() );
        }

    }

}

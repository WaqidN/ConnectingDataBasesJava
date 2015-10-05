import java.sql.*;

/**
 * Created by abnormal on 29/09/15.
 */
public class Student {
    public static void main(String[] args)  {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Register Class Success");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Plankton", "root", "085215");

            System.out.println("Connection is now " + (connection.isClosed() ? "Closed" : "Open"));


            /*PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO student(id,name,address) VALUES (?,?,?)");
            preparedStatement.setInt(1, 1300018078);
            preparedStatement.setString(2, "Bayu M");
            preparedStatement.setString(3, "Sewon");

            int affectedRow = preparedStatement.executeUpdate();
            System.out.println("Success Execute Update, Row Affected : " + affectedRow);*/



            /*PreparedStatement preparedStatement = connection.prepareStatement("UPDATE student SET Name = 'Waqid Nugroho' WHERE id = 1300018085");

            int affectedRow1 = preparedStatement.executeUpdate();
            System.out.println("Success Execute Update, " + affectedRow1);*/

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM student WHERE id = 1300018078");
            int affectedRow1 = preparedStatement.executeUpdate();
            System.out.println("Success Execute Delete, " + affectedRow1);



        } catch (ClassNotFoundException e) {
            System.out.println("Register Failed : " +e.getMessage());
        } catch (SQLException e) {
            System.err.println("Unknown Exeption : " + e.getMessage() );
        }

    }
}

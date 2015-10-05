import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by abnormal on 05/10/15.
 */
public class Mata_Kuliah {

    public static void main(String[] args)  {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Register Class Success");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Plankton", "root", "085215");

            System.out.println("Connection is now " + (connection.isClosed() ? "Closed" : "Open"));


            /*PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO MataKuliah(Kode,Nama_kuliah,Sks) VALUES (?,?,?)");
            preparedStatement.setInt(1, 6);
            preparedStatement.setString(2, "Algoritma");
            preparedStatement.setInt(3, 3);

            int affectedRow = preparedStatement.executeUpdate();
            System.out.println("Success Execute Update, Row Affected : " + affectedRow);*/



            /*PreparedStatement preparedStatement = connection.prepareStatement("UPDATE MataKuliah SET Nama_kuliah = 'Algoritma Informatic' WHERE Kode = 6");
            int affectedRow1 = preparedStatement.executeUpdate();
            System.out.println("Success Execute Update, " + affectedRow1);*/

            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM MataKuliah WHERE Kode = 6");
            int affectedRow1 = preparedStatement.executeUpdate();
            System.out.println("Success Execute Delete, " + affectedRow1);



        } catch (ClassNotFoundException e) {
            System.out.println("Register Failed : " +e.getMessage());
        } catch (SQLException e) {
            System.err.println("Unknown Exeption : " + e.getMessage() );
        }

    }

}

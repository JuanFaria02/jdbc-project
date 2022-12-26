package application;

import db.DB;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Connection connection = null;
        PreparedStatement st = null;
        try {
            connection = DB.getConnection();
            st = connection.prepareStatement("INSERT INTO seller" +
                    "(Name,Email,BirthDate,BaseSalary,DepartmentId)" +
                    "VALUES (?,?,?,?,?)");
            st.setString(1, "José Junior");
            st.setString(2, "jose@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("25/12/2000").getTime()));
            st.setDouble(4, 3000.00);
            st.setInt(5, 1);

            int result = st.executeUpdate();
            if (result > 0) {
                System.out.println("Done");
            }
            else {
                System.out.println("Error");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ParseException e) {
            e.printStackTrace();
        } finally {

            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
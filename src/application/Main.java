package application;

import db.DB;
import db.DbIntegrityException;

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
            st = connection.prepareStatement("DELETE FROM department " +
                    "WHERE " +
                    "Id = ?");

            st.setInt(1, 2);
            int result = st.executeUpdate();
            if (result > 0) {
                System.out.println("Done. Rows Affect: " + result);
            }
            else {
                System.out.println("Error");
            }
        }
        catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }
        finally {

            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
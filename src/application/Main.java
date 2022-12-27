package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Connection connection = null;
        Statement st = null;
        try {
            connection = DB.getConnection();

            connection.setAutoCommit(false);

            st = connection.createStatement();
            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090.00 " +
                            "WHERE DepartmentId = 1");
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090.00 " +
                    "WHERE DepartmentId = 3");

            connection.commit();
            System.out.println("Rows1: "+rows1);
            System.out.println("Rows2: "+rows2);

        }
        catch (SQLException e) {
            try {
                connection.rollback();
                throw new DbException("Transaction rolled back! Error caused by: " + e.getMessage());
            }
            catch (SQLException e2) {
                throw new DbException("Error trying to rollback! Error caused by: " + e2.getMessage());

            }

        }
        finally {

            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
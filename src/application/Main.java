package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.entities.Department;
import model.entities.Seller;

import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Department department = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", LocalDate.now(), 2000.0, department);
        System.out.println(seller);
    }
}
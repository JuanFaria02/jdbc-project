package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.io.IOException;
import java.sql.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("TEST 1 findById: ");
        Seller seller = sellerDao.findById(3);

        System.out.println(seller);

        System.out.println("===================================");

        System.out.println("TEST 2 findByDepartment: ");

        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller s:
             list) {
            System.out.println(s);
        }

        System.out.println("===================================");
        System.out.println("TEST 3 findAll: ");
        List<Seller> list2 = sellerDao.findAll();
        for (Seller s:
                list2) {
            System.out.println(s);
        }
    }
}
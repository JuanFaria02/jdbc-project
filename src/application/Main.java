package application;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.dao.impl.DepartmentDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.io.IOException;
import java.sql.*;

import java.util.Date;
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

        System.out.println("===================================");
        System.out.println("TEST 4 insertSeller: ");
        Seller seller1 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(seller1);
        System.out.println("Inserted: " + seller1.getId());

        System.out.println("===================================");
        System.out.println("TEST 5 updateSeller: ");
        seller = sellerDao.findById(1);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update Completed");

/*        System.out.println("===================================");
        System.out.println("TEST 6 deleteSeller: ");
        sellerDao.deleteById(3);

 */

        System.out.println("===================================");

        System.out.println("Department Class TEST");

        System.out.println();

        System.out.println("TEST 1 findById:");
        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        Department dep = departmentDao.findById(2);
        System.out.println(dep);

        System.out.println("===================================");
        System.out.println("TEST 2 findAll:");

        List<Department> allDepartment = departmentDao.findAll();
        allDepartment.forEach(System.out::println);

        System.out.println("===================================");
        System.out.println("TEST 3 insert:");
        Department department1 = new Department(null, "Food");
        departmentDao.insert(department1);
        System.out.println("Department inserted id: " + department1.getId());

        System.out.println("===================================");
        System.out.println("TEST 4 update:");
        department = departmentDao.findById(3);
        department.setName("Games");
        departmentDao.update(department);
        System.out.println("Department updated");

        System.out.println("===================================");
        System.out.println("TEST 5 delete:");

        departmentDao.deleteById(9);
        System.out.println("Deleted");
    }
}
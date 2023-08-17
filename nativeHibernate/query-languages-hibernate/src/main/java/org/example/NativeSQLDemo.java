package org.example;

import org.example.entity.Customer;
import org.example.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class NativeSQLDemo {
    public static void main(String[] args) {

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession();) {
            Transaction transaction = session.beginTransaction();

            String sql = "select * from customer";   //customer -> table name
            NativeQuery sqlQuery = session.createNativeQuery(sql);
            sqlQuery.addEntity(Customer.class);

            List<Customer> list = sqlQuery.list();

            for (Customer customer : list) {
                System.out.println(customer);
            }
            transaction.commit();
        }
    }
}

package org.example;

import org.example.entity.Customer;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HQLDemo {
    public static void main(String[] args) {
        /*Hibernate Query Language (HQL) is an object-oriented query language, similar to SQL, but instead of operating on tables and columns, HQL works with persistent objects and their properties.*/

        try (SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
             Session session = sessionFactory.openSession();) {

            Transaction transaction = session.beginTransaction();

            //-------------------------------------------------------------------
            //select * from
            /*
            String hql = "from Customer";   //In here Customer -> entity (Customer.java), not the table name
            Query query = session.createQuery(hql);
            List<Customer> list = query.list();

            for(Customer customer : list) {
                System.out.println(customer);
            }
            */
            //-------------------------------------------------------------------


            //-------------------------------------------------------------------
            //select a specified column
            /*
            String hql = "select name from Customer";   // name -> property | Customer -> entity
            Query query = session.createQuery(hql);
            List<String> list = query.list();

            for (String name : list) {
                System.out.println(name);
            }
            */
            //-------------------------------------------------------------------


            //-------------------------------------------------------------------
            //where clause
            /*
            String hql = "from Customer where salary >= 20000";
            List<Customer> list = session.createQuery(hql).list();

            for (Customer customer : list) {
                System.out.println(customer);
            }
            */
            //-------------------------------------------------------------------


            //-------------------------------------------------------------------
            //LIKE
            /*
            String hql = "from Customer where name like 'S%'";
            List<Customer> list = session.createQuery(hql).list();

            for (Customer customer : list) {
                System.out.println(customer);
            }
            */
            //-------------------------------------------------------------------


            //-------------------------------------------------------------------
            //ORDER BY
            String hql = "from Customer order by salary asc";
            List<Customer> list = session.createQuery(hql).list();

            for (Customer customer : list) {
                System.out.println(customer);
            }
            //-------------------------------------------------------------------

            transaction.commit();
        }
    }
}

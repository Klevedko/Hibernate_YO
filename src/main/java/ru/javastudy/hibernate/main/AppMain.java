package ru.javastudy.hibernate.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.javastudy.hibernate.entity.ContactEntity;
import ru.javastudy.hibernate.model.ContactModel;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AppMain {

    static EntityManager entityManager;

    public static void main(String[] args) {
        System.out.println("Hibernate tutorial start------------");
//        insertExample(session);
        selectEx();
//       updateExample(session);
//        deleteExample(session);
    }

    public static List<ContactModel> selectEx() {
        System.out.println("HQL SELECT:");

        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from ContactEntity where firstName = :paramName");
        query.setParameter("paramName", "2");

        // List<ContactEntity> go = query.list()

        List<ContactModel> lists = new ArrayList<>();
        for(ContactEntity entity : (List<ContactEntity>) query.getResultList() ){
            lists.add(new ContactModel(entity.getId(), entity.getFirstName()));
        }

        tx.commit();

        session.close();
        return lists;

    }


    public static void insertExample(Session session) {
       /* HQL Only the INSERT INTO ... SELECT ... form is supported; not the INSERT INTO ... VALUES ... form.

       "insert into Object (id, name) select oo.id, oo.name from OtherObject oo";
        */
        //IT IS NOT WORKING HERE, Because not ContactEntity2 table;
    /*
        String queryInsert = "insert into ContactEntity(firstName, lastName, birthDate) select firstName2, lastName2, birthDate2 from ContactEntity2";
        int result = session.createQuery(queryInsert).executeUpdate();
    */
    }

    public static void deleteExample(Session session) {
        String sqlDeleteString = "delete ContactEntity where firstName = :param";
        int result = session.createQuery(sqlDeleteString)
                .setString("param", "StringName")
                .executeUpdate();
        /*
        Query query =  session.createQuery("delete ContactEntity where firstName = :param");
        query.setParameter("param", "Leonid");
        int result = query.executeUpdate();
         */
        System.out.println("Result Delete: " + result);
    }

    public static void updateExample(Session session) {
        System.out.println("HQL UPDATE: ");

        String queryString = "update ContactEntity set firstName = :nameParam where firstName = :nameCode";

        int result = session.createQuery(queryString)
                .setString("nameParam", "44")
                // .setString("birthDateParam", "2012-08-03")
                .setString("nameCode", "2")
                .executeUpdate();
        /*

        Query query = session.createQuery("update ContactEntity set firstName = :nameParam, lastName = :lastNameParam" +
                ", birthDate = :birthDateParam"+
                " where firstName = :nameCode");

        query.setParameter("nameCode", "Nick");
        query.setParameter("nameParam", "NickChangedName1");
        query.setParameter("lastNameParam", "LastNameChanged1" );
        query.setParameter("birthDateParam", new Date());
        int result = query.executeUpdate();
         */

        System.out.println("Result: " + result);
    }


    private static void printALL(List<Object> contactEntityList) {
        System.out.println("Print result:");
        for (Object contact : contactEntityList) {
            System.out.println(contact);
        }
    }
}
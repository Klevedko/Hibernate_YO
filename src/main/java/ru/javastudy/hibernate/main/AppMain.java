package ru.javastudy.hibernate.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.javastudy.hibernate.entity.UserEntity;
import ru.javastudy.hibernate.model.ModelUser;
import ru.javastudy.hibernate.model.ModelUser;
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
        //selectEx();
//       updateExample(session);
//        deleteExample(session);
    }

    public static List<ModelUser> selectEx(int idd) {
        System.out.println("HQL SELECT:");
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Query query = session.createQuery("from UserEntity where id = (case when :paramName = 0 then id else :paramName end )");
        query.setParameter("paramName", idd );
        // List<UserEntity> go = query.list()

        List<ModelUser> lists = new ArrayList<>();
        for(UserEntity entity : (List<UserEntity>) query.getResultList() ){
            lists.add(new ModelUser(entity.getId(), entity.getPassword()));
        }
        tx.commit();
        session.close();
        return lists;
    }

    public static void insertExample(Session session) {
       /* HQL Only the INSERT INTO ... SELECT ... form is supported; not the INSERT INTO ... VALUES ... form.

       "insert into Object (id, name) select oo.id, oo.name from OtherObject oo";
        */
        //IT IS NOT WORKING HERE, Because not UserEntity2 table;
    /*
        String queryInsert = "insert into UserEntity(firstName, lastName, birthDate) select firstName2, lastName2, birthDate2 from UserEntity2";
        int result = session.createQuery(queryInsert).executeUpdate();
    */
    }

    public static void deleteExample(Session session) {
        String sqlDeleteString = "delete UserEntity where firstName = :param";
        int result = session.createQuery(sqlDeleteString)
                .setString("param", "StringName")
                .executeUpdate();
        /*
        Query query =  session.createQuery("delete UserEntity where firstName = :param");
        query.setParameter("param", "Leonid");
        int result = query.executeUpdate();
         */
        System.out.println("Result Delete: " + result);
    }

    public static void updateExample(Session session) {
        System.out.println("HQL UPDATE: ");

        String queryString = "update UserEntity set firstName = :nameParam where firstName = :nameCode";

        int result = session.createQuery(queryString)
                .setString("nameParam", "44")
                // .setString("birthDateParam", "2012-08-03")
                .setString("nameCode", "2")
                .executeUpdate();
        /*

        Query query = session.createQuery("update UserEntity set firstName = :nameParam, lastName = :lastNameParam" +
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


    private static void printALL(List<Object> UserEntityList) {
        System.out.println("Print result:");
        for (Object contact : UserEntityList) {
            System.out.println(contact);
        }
    }
}
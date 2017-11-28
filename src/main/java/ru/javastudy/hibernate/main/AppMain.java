package ru.javastudy.hibernate.main;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ru.javastudy.hibernate.dao.ContactEntity;
import ru.javastudy.hibernate.utils.HibernateSessionFactory;

import javax.persistence.EntityManager;
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
        System.exit(1);
    }

    public static List<ContactEntity> selectEx() {
        System.out.println("HQL SELECT:");
// сканер, по какому параметру ищем,
        // Scanner f = new Scanner(System.in);
        // пока вводятся данные

            Session session = HibernateSessionFactory.getSessionFactory().openSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from ContactEntity where firstName = :paramName");
            query.setParameter("paramName", "2");
            List list = query.getResultList();
            List<ContactEntity> gogogo = query.list();
            //Iterator it = list.iterator();
            Iterator<ContactEntity> it = list.iterator();
            // количество строк
            System.out.println(list.size());
            while (it.hasNext()) {
                ContactEntity ccc = (ContactEntity) it.next();
                System.out.println(ccc.getId() + " " + ccc.getFirstName() + " " + ccc.getBirthdate());
            }
            tx.commit();
            session.close();
return gogogo;
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

        String queryString = "update ContactEntity set firstName = :nameParam, lastName = :lastNameParam where firstName = :nameCode";

        int result = session.createQuery(queryString)
                .setString("nameParam", "44")
                .setString("lastNameParam", "LastNameString")
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
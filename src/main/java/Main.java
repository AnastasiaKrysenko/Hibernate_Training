import Hibernate.Entity.User;
import Hibernate.HibernateUtil;
import org.hibernate.Session;

import java.sql.Date;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        //сразу получаем готовый SessionFactory и сразу создаем сессию
        Session session = HibernateUtil.getSessionFactory().openSession();

        //открвть транзакцию
        session.getTransaction().begin();

        User user = new User();
        user.setLastName("Ivanov");
        user.setFirstName("Ivan");
        user.setBirthDate(Date.valueOf("2000-03-01"));

        // id не заполняем, т.к. он сгенерируется автоматически в БД и присвоится в поле
        session.save(user);// фиксирует изменения в объекте
        session.getTransaction().commit();//транзакция завершается
        session.close(); // закрыть сессию
        HibernateUtil.close();// закрыть Session Factory
    }
}
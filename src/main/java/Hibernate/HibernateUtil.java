package Hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.io.File;

    //специальный java класс для инициализации Hibernate
public class HibernateUtil {
    //фабрика для создания сессий
   private static final SessionFactory sessionFactory = buildSessionFactory();
   //этот метод вызывается автоматически, т.к. он вызывается из статичной переменной
   private static SessionFactory buildSessionFactory() {
       try{
           return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
       }
       catch (Throwable ex) {
           System.out.println("Initial SesssionFactory creation failed." + ex);
           throw new ExceptionInInitializerError(ex);
       }
   }
   //этот метод будем вызывать, когда потребуется SessionFactory
   public static SessionFactory getSessionFactory() {
       if (sessionFactory == null){
           buildSessionFactory();
       }
       return sessionFactory;
   }
   //закрыть все соединения с помощью SessionFactory
   public static void close() {
       getSessionFactory().close();
   }
}

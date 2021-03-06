package com.kovacic;

import com.kovacic.configuration.DatabaseConfig;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateWithGenericJPA implements CommandLineRunner {

    private Logger logger = LoggerFactory.logger(this.getClass());

    @Autowired
    private DatabaseConfig databaseConfig;

    public static void main(String[] args) {
        SpringApplication.run(HibernateWithGenericJPA.class, args);

    }

    @Override
    public void run(String... args) {
        System.out.println(databaseConfig);

    }

}


//    @Override
//    public void run(String... args) throws Exception {
//
//        logger.info("Student id 10001 -> {}" +  repository.findById(10001L));
//
//        logger.info("Student id 10001 -> {}" +   repository.findById(10001L));
//
//        logger.info("All users 1 -> {}" +  repository.findAll());
//
//        //Insert
//        logger.info("Inserting -> {}" +   repository.save(new Student("John", "A1234657")));
//
//        //Update
//        logger.info("Update 10001 -> {}" +   repository.save(new Student(10001L, "Name-Updated", "New-Passport")));
//
//        repository.deleteById(10002L);
//
//        logger.info("All users 2 -> {}" +   repository.findAll());
//    }

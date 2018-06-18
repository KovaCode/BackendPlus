package com.kovacic;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HibernateWithJPAWithMySQL {

    private Logger logger = LoggerFactory.logger(this.getClass());

    public static void main(String[] args) {
        SpringApplication.run(HibernateWithJPAWithMySQL.class, args);

    }
}

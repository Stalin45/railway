package com.tschool.railwayapp.server.utils;

import com.tschool.railwayapp.commons.logger.LogUtils;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class JPAUtils {
    
    private static final EntityManagerFactory emf;
    
    private JPAUtils() {}
    
    static {
        try {
            emf = Persistence.createEntityManagerFactory("railwayapp");
        } catch(Throwable ex) {
            Logger logError = LogUtils.getErrorLogger();
            logError.error("Initial EntityManagerFactory creation failed: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}

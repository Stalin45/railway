package com.tschool.railwayapp.commons.logger;

import org.apache.log4j.Logger;

public class LogUtils {
    
   private static final Logger INFO_LOGGER = Logger.getLogger("serverINFO");
   private static final Logger ERR_LOGGER = Logger.getLogger("serverERR");
    
   private LogUtils() {}
    
    public static Logger getInfoLogger() {
        return INFO_LOGGER;
    }
    
    public static Logger getErrorLogger() {
        return ERR_LOGGER;
    }
}
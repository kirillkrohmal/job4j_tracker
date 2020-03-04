package ru.job4j.jdbcconnect;

import org.slf4j.Logger;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Comp on 15.04.2019.
 */
public class JDBCConnect {
    public static void main(String[] args) {
        Logger log = getLogger(JDBCConnect.class.getName());

        log.trace("trace message");
        log.debug("debug message");
        log.info("info message");
        log.warn("warn message");
        log.error("error message");
    }
}

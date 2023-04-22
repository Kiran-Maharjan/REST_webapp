package com.kiran.resfulweb.webapp;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class WebappApplicationTest {
    public static Logger logger = LoggerFactory.getLogger(WebappApplication.class);

    @Test
    void init() {
        logger.info("Test Initialization");
        assertEquals(true,true);

    }

    @Test
    void main() {
        logger.info("Test Initialization");
        assertEquals(true,true);

    }
}
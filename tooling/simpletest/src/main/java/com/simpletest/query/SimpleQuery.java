package com.simpletest.query;

import com.simpletest.coreapi.SimpleEventCreated;
import com.simpletest.coreapi.SimpleEventModified;
import org.axonframework.eventhandling.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SimpleQuery{

    private static final Logger logger = LoggerFactory.getLogger(SimpleQuery.class);

    @EventHandler
    public void on(SimpleEventCreated evt) {
        logger.info("Simple Event has been created", evt.getCommandData());
    }

    @EventHandler
    public void on(SimpleEventModified evt) {
        logger.info("Simple Event has been modified", evt.getCommandData());
    }

}
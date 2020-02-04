package com.simpletest.command;


import com.simpletest.coreapi.SimpleEventCreated;
import com.simpletest.coreapi.SimpleEventModified;
import com.simpletest.coreapi.SimpleCreateCommand;
import com.simpletest.coreapi.SimpleModifyCommand;
import org.axonframework.test.aggregate.AggregateTestFixture;
import org.axonframework.test.aggregate.FixtureConfiguration;
import org.junit.Before;
import org.junit.Test;


public class SimpleCommandTest{
    private static final String COMMAND_ID = "id";
    private FixtureConfiguration<SimpleAggregate> fixture;

    @Before
    public void setup() {
        fixture = new AggregateTestFixture<>(SimpleAggregate.class);
    }

    @Test
    public void shouldCreateSimpleCommand() {
        fixture.givenNoPriorActivity()
                .when(new SimpleCreateCommand(COMMAND_ID, "Create"))
                .expectEvents(new SimpleEventCreated(COMMAND_ID, "Create"));
    }

    @Test
    public void shouldModifySimpleCommand() {
        fixture.given(new SimpleEventCreated(COMMAND_ID, "Create"))
                .when(new SimpleModifyCommand(COMMAND_ID, "Modify"))
                .expectEvents(new SimpleEventModified(COMMAND_ID, "Modify"));
    }
}
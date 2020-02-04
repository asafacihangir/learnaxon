package ${package}.command;


import ${package}.coreapi.*;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateMember;
import org.axonframework.spring.stereotype.Aggregate;

import java.util.ArrayList;
import java.util.List;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Aggregate
public class SimpleAggregate {

    @AggregateIdentifier
    private String id;

    private String data;

    public SimpleAggregate() {
    }

    @CommandHandler
    public SimpleAggregate(SimpleCreateCommand cmd) {
        apply(new SimpleEventCreated(cmd.getCommandId(), cmd.getCommandData()));
    }

    @CommandHandler
    public void handle(SimpleModifyCommand cmd) {
        apply(new SimpleEventModified(cmd.getCommandId(), cmd.getCommandData()));
    }

    @EventSourcingHandler
    public void on(SimpleEventCreated evt) {
        id = evt.getCommandId();
        data = evt.getCommandData();
    }

    @EventSourcingHandler
    public void on(SimpleEventModified evt) {
        data = evt.getCommandData();
    }
}

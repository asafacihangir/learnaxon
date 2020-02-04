package ${package}.coreapi

import org.axonframework.modelling.command.TargetAggregateIdentifier

data class SimpleCreateCommand(@TargetAggregateIdentifier val commandId: String, val commandData: String)
data class SimpleModifyCommand(@TargetAggregateIdentifier val commandId: String, val commandData : String)
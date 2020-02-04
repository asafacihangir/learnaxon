package ${package}.coreapi

data class SimpleEventCreated(val commandId: String, val commandData: String)
data class SimpleEventModified(val commandId: String, val commandData : String)
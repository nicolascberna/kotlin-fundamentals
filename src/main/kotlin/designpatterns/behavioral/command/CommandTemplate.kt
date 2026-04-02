package org.example.designpatterns.behavioral.command

import org.junit.Test

interface Command {
    fun execute()
}

class OrderAddCommand(val id: Int) : Command {
    override fun execute() {
        println("Adding order with id $id")
    }
}

class OrderPayCommand(val id: Int) : Command {
    override fun execute() {
        println("Paying for order with id $id")
    }
}

class CommandProcessor {
    private val queue = arrayListOf<Command>()

    fun addToQueue(command: Command): CommandProcessor = apply {
        queue.add(command)
    }

    fun processCommand(): CommandProcessor = apply {
        queue.forEach { it.execute() }
        queue.clear()
    }
}

class CommandTest {
    @Test
    fun testCommand() {
        CommandProcessor()
            .addToQueue(OrderAddCommand(1))
            .addToQueue(OrderAddCommand(2))
            .addToQueue(OrderPayCommand(1))
            .processCommand()
    }
}

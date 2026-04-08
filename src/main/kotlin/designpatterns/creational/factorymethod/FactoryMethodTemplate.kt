package org.example.designpatterns.creational.factorymethod

interface Vehicle {
    fun printVehicle()
}

class FourWheeler: Vehicle {
    override fun printVehicle() {
        println("I am four wheeler")
    }
}

class TwoWheeler: Vehicle {
    override fun printVehicle() {
        println("I am two wheeler")
    }
}

interface VehicleFactory {
    fun createVehicle(): Vehicle
}

class FourWheelFactory: VehicleFactory {
    override fun createVehicle(): Vehicle {
        return FourWheeler()
    }
}

class TwoWheelFactory: VehicleFactory {
    override fun createVehicle(): Vehicle {
        return TwoWheeler()
    }
}

class Client(factory: VehicleFactory) {
    private var vehicle: Vehicle = factory.createVehicle()
    fun getVehicle(): Vehicle = vehicle
}

fun main() {
    val factory = FourWheelFactory()
    val clientFactory = Client(factory)
    val fourWheeler = clientFactory.getVehicle()
    println(fourWheeler.printVehicle())
}
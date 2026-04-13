package org.example.designpatterns.creational.abstractfactory

interface CarFactory {
    fun createCar(): Car
    fun createSpecification()
}

class NorthAmericaCarFactory : CarFactory {
    override fun createCar(): Car {
        return Sedan()
    }

    override fun createSpecification() {
        TODO("Not yet implemented")
    }
}

interface Car {
    fun assemble()
}

interface CarSpecification {
    fun display()
}

class Sedan: Car {
    override fun assemble() {
        println("Assembling Sedan car")
        }
}

class Hatchback: Car {
    override fun assemble() {
        println("Assembling Hatchback car")
    }
}

class NorthAmericaSpecification: CarSpecification {
    override fun display() {
        println("North America Car Specification: Safety features compliant with local regulations.")
    }
}

class EuropeanSpecification: CarSpecification {
    override fun display() {
        println("European ")
    }
}
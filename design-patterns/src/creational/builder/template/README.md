# Patron de Diseño: Builder

## Índice

1. [Descripción](#descripción)
2. [Motivación](#motivación)
3. [Beneficios](#beneficios)
4. [Diagrama UML](#diagrama-uml)

## Descripción

El patrón **Builder** es un patrón de diseño creacional que permite construir un objeto complejo paso a paso. Separa la construcción de un objeto de su representación, permitiendo que el mismo proceso de construcción cree diferentes representaciones del objeto.

Este patrón es particularmente útil cuando un objeto tiene muchas propiedades opcionales o requiere de una construcción compleja que no puede ser manejada por el constructor tradicional de una clase.

## Motivación

A menudo, en la programación orientada a objetos, crear objetos con muchas propiedades o parámetros puede volverse complejo. En estos casos, el uso de un constructor tradicional con muchos parámetros puede ser ineficaz, difícil de entender y propenso a errores. El patrón **Builder** resuelve este problema proporcionando un mecanismo más limpio para la creación de objetos complejos.

### Caso de uso
Imagina que tienes una clase `Person` que tiene muchos atributos opcionales como un correo electrónico, número de teléfono, etc. El patrón Builder permite crear un objeto de forma flexible y legible.

## Beneficios

- **Flexibilidad**: Permite crear diferentes representaciones de un objeto utilizando el mismo proceso de construcción.
- **Legibilidad**: Los métodos del builder facilitan la creación de objetos complejos sin necesidad de recordar el orden de los parámetros.
- **Evita constructores con demasiados parámetros**: En lugar de utilizar un constructor con muchos parámetros opcionales, el patrón Builder permite construir objetos de manera más estructurada.

## Diagrama UML

```plaintext
       +--------------------+
       |      Director      |
       +--------------------+
       | - builder: Builder |
       +--------------------+
       | + construct()      |
       +--------------------+
                 |
                 v
       +---------------------+
       |       Builder       |
       +---------------------+
       | + buildPart1()      |
       | + buildPart2()      |
       | + getResult()       |
       +---------------------+
                 |
                 v
       +--------------------+
       |      Product       |
       +--------------------+
       | + part1            |
       | + part2            |
       +--------------------+

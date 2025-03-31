package creational.factorymethod.practice

fun main() {
    val room: Room = Room.SmallRoom
    val furniture: FurnitureSize = FurnitureSizeFactory().getFurnitureSizeForRoom(room)
    println(furniture)
}

sealed class Room {
    data object TinyRoom: Room()
    data object SmallRoom: Room()
    data object MediumRoom: Room()
    data object LargeRoom: Room()
}

sealed class FurnitureSize {
    data object TinyFurniture: FurnitureSize()
    data object SmallFurniture: FurnitureSize()
    data object MediumFurniture: FurnitureSize()
    data object LargeFurniture: FurnitureSize()
}

class FurnitureSizeFactory() {
    fun getFurnitureSizeForRoom(room: Room): FurnitureSize {
        return when(room) {
            Room.TinyRoom -> FurnitureSize.TinyFurniture
            Room.SmallRoom -> FurnitureSize.SmallFurniture
            Room.MediumRoom -> FurnitureSize.MediumFurniture
            Room.LargeRoom -> FurnitureSize.LargeFurniture
        }
    }
}
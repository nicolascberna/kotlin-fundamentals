package classes

fun main() {
    val view = TestView() //esta es la vista o lógica que se inyecta en el servicio
    TestServiceImpl(view)

    //tambien se aplica SOLID
    //S:logica y ui separados
    //O: se puede crear otra implementacion sin modificar el codigo actual
    //D: la clase depende de una abstraccion, no de una clase concreta
}

//interface para la abstraccion del comportamiento
interface TestService {
    fun testing(data: List<Int>)
}

internal class TestServiceImpl(
    private val testService: TestService //inversion de dependencia
) {
    private val numbers = listOf<Int>(2,4,6)
    init {
        testService.testing(numbers)
    }
}

//patron Callback: testview recibe los resultados del proceso
internal class TestView: TestService {
    override fun testing(data: List<Int>) {
        println("TestView testing implementation")
        println("list of values: ${data.toList()}")
    }
}
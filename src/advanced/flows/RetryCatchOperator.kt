package advanced.flows

import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.retry
import kotlinx.coroutines.runBlocking


fun main() {
    println("Example 1: retry - catch")
    println("--------------------------------------")
    example1()
    println("======================================")
    println("Example 2: catch - retry")
    //en este ejemplo se emite el valor nulo
    // y por lo tanto no continua con los reintentos con valores esperados
    println("--------------------------------------")
    example2()
}

private const val RETRY_SUCCESS: Long = 2
private const val RETRY_FAILURE: Long = 1

private fun example1() {
    runBlocking {
        var attempt = 0
        val flow = flow {
            attempt++
            println("Intento: $attempt")
            if (attempt < 3) {
                throw Exception("Error en el intento $attempt")
            }
            emit("Éxito en el intento $attempt")
        }.retry(RETRY_SUCCESS) { e ->
            println("Se produjo un error: ${e.message}, reintentando...")
            true
        }.catch { emit(null.toString()) }


        flow.collect { value ->
            println("Recibido: $value")
        }
    }
}

private fun example2() {
    runBlocking {
        var attempt = 0
        val flow = flow {
            attempt++
            println("Intento: $attempt")
            if (attempt < 3) {
                throw Exception("Error en el intento $attempt")
            }
            emit("Éxito en el intento $attempt")
        }.catch { emit(null.toString())
        }.retry(RETRY_SUCCESS) { e ->
            println("Se produjo un error: ${e.message}, reintentando...")
            true
        }

        flow.collect { value ->
            println("Recibido: $value")
        }
    }
}
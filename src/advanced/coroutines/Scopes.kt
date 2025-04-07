package advanced.coroutines

import kotlinx.coroutines.*

fun myCoroutineScopeExample() {
    /**¿Que es un Job?
     * Se define como una unidad de trabajo asincrona y cancelable que se ejecuta dentro de una corrutina.
     * Estos pueden ser ordenados en jerarquias padres-hijas, donde la cancelacion del padre llevara inmediatamente
     * a la cancelacion recursiva de sus hijas. Ademas, CancellationException de un hijo,
     * llevara a la cancelacion de su padre y por consecuencia la de todas sus otras hijas.
     * Este comportamiento puede ser modificado usando SupervisorJob.
     */
    val job = Job()

    /**
     * ¿Que es un CoroutineScope?
     * Son contenedores o ambitos en el que se lanzan y gestionan las corutinas.
     * Define el contexto de ejecucion y controla el ciclo de vida que se inician en el.
     * Si el contexto dado no contiene un Job, entonces se creara uno por defecto.
     * ¿Que es un Dispatcher?
     * Son componentes del contexto de una corutina que determinan en que hilo o grupo de hilos
     * se ejecutara dicha corutina (Default, IO, Main, Unconfined).
     */
    val scope = CoroutineScope(Dispatchers.Default + job)

    //aqui se lanza la corutina dentro de un scope
    scope.launch {
        println("Hola desde la corutina!")
    }
    //esperamos a que la corutinas terminen o, alternativamente usamos runBlocking
    //para mantener el hilo principal activo
    runBlocking {
        job.join()
    }
}

fun main() {
    myCoroutineScopeExample()
}
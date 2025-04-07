package advanced.flows

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*

fun main() {
    runBlocking {
        testCombineFlow()
        println("==")
        testCombineFlow2()
    }
}

suspend fun testCombineFlow() {
    val flow = flowOf(1, 2).onEach { delay(10) }
    val flow2 = flowOf("a", "b", "c").onEach { delay(15) }
    flow.combine(flow2) { int, char -> int.toString() + char }.collect {
        println(it)
    }
}

@OptIn(DelicateCoroutinesApi::class)
suspend fun testCombineFlow2() {
    val flow = flowOf(1, 2).onEach { delay(10) }
    val flow2 = flowOf("a", "b", "c").onEach { delay(15) }
    val flows = combine(flow, flow2) { int, char ->
        int.toString() + char
    }
    val scope: CoroutineScope = GlobalScope
    val myStateFlow: StateFlow<String> = flows.stateIn(
        scope = scope
    )
    myStateFlow.onStart {
        println("loading...")
    }.map {
        "$it.map"
    }.collect {

    }
    TODO("Averiguar como funciona getAndUpdate() para MutableStateFlow")
}

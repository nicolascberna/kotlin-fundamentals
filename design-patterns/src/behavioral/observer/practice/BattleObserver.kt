package behavioral.observer.practice

interface BattleObserver {
    fun onEnemyAttack(enemyName: String, damage: Int) //update function
}

interface BattlePublisher {
    fun addObserver(observer: BattleObserver)
    fun removeObserver(observer: BattleObserver)
    fun attack() //this will implement observer's update function
}

class Enemy(private val name: String): BattlePublisher {

    private val observers = mutableListOf<BattleObserver>()

    override fun addObserver(observer: BattleObserver) {
        observers.add(observer)
    }

    override fun removeObserver(observer: BattleObserver) {
        observers.remove(observer)
    }

    override fun attack() {
        val damage = (5..20).random()
        println("$name ataca causando $damage de daño")
        observers.forEach {
            it.onEnemyAttack(name, damage)
        }
    }

}

class Fighter(
    private val name: String,
    private var hp: Int
): BattleObserver {

    override fun onEnemyAttack(enemyName: String, damage: Int) {
        updateHp(damage)
        println("$name fue atacado por $enemyName y perdió $damage de HP. Vida restante: $hp")
    }

    private fun updateHp(damage: Int) {
        this.hp -= damage
    }
}

fun main() {
    val enemy = Enemy("Orc Warlord")

    val hero1 = Fighter("Arthas", 100)
    val hero2 = Fighter("Jaina", 80)
    val hero3 = Fighter("Thrall", 120)

    enemy.addObserver(hero1)
    enemy.addObserver(hero2)
    enemy.addObserver(hero3)

    repeat(3) {
        println("\nTurno ${it + 1}")
        enemy.attack()
    }
}
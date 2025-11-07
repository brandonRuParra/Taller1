package Model

/**
 * Interfaz para entidades que participan en combate/confrontación.
 */
interface Combatant {
    val attack: Int
    val defense: Int
    fun totalPower(): Int = attack + defense
}

/**
 * Interfaz para entidades con identificación única.
 */
interface Identifiable {
    val id: Int
}

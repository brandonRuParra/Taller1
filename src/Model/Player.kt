package Model

/**
 * Clase base abstracta que representa un jugador con estadísticas de ataque y defensa.
 * No puede ser instanciada directamente. Usa [PlayerDefense], [PlayerMiddle] o [PlayerForward].
 */
abstract class Player : Identifiable, Combatant {

    override val id: Int = idGeneration()
    override val attack: Int = 0
    override val defense: Int = 0

    companion object {
        private var counter = 0
        private fun idGeneration() = counter++
    }
}
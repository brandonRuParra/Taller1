package Model

/**
 * Jugador especializado en defensa. Estadísticas: defensa alta (5-9), ataque bajo.
 * La suma de ataque y defensa siempre es [TOTAL_STAT_POINTS].
 */
class PlayerDefense : Player() {
    override val defense: Int = (MIN_DEFENSE_FOR_DEFENDER..MAX_DEFENSE_FOR_DEFENDER).random()
    override val attack: Int = TOTAL_STAT_POINTS - defense
    
    companion object {
        private const val MIN_DEFENSE_FOR_DEFENDER = 5
        private const val MAX_DEFENSE_FOR_DEFENDER = 9
        private const val TOTAL_STAT_POINTS = 10
    }
}

/**
 * Jugador mediocampista con estadísticas balanceadas (4-6 en defensa).
 * La suma de ataque y defensa siempre es [TOTAL_STAT_POINTS].
 */
class PlayerMiddle : Player() {
    override val defense: Int = (MIN_DEFENSE_FOR_MIDFIELDER..MAX_DEFENSE_FOR_MIDFIELDER).random()
    override val attack: Int = TOTAL_STAT_POINTS - defense
    
    companion object {
        private const val MIN_DEFENSE_FOR_MIDFIELDER = 4
        private const val MAX_DEFENSE_FOR_MIDFIELDER = 6
        private const val TOTAL_STAT_POINTS = 10
    }
}

/**
 * Jugador delantero especializado en ataque. Estadísticas: ataque alto (5-9), defensa baja.
 * La suma de ataque y defensa siempre es [TOTAL_STAT_POINTS].
 */
class PlayerForward : Player() {
    override val attack: Int = (MIN_ATTACK_FOR_FORWARD..MAX_ATTACK_FOR_FORWARD).random()
    override val defense: Int = TOTAL_STAT_POINTS - attack
    
    companion object {
        private const val MIN_ATTACK_FOR_FORWARD = 5
        private const val MAX_ATTACK_FOR_FORWARD = 9
        private const val TOTAL_STAT_POINTS = 10
    }
}

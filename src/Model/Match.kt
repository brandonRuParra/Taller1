package Model

import kotlin.random.Random

/**
 * Representa un evento ocurrido durante un partido.
 *
 * Un evento captura los detalles de una confrontación individual entre dos jugadores,
 * incluyendo quién atacó, quién defendió, si se anotó un gol, y el marcador actualizado.
 *
 * @property attackerId Identificador único del jugador que realizó el ataque
 * @property defenderId Identificador único del jugador que realizó la defensa
 * @property attackingTeam Nombre del equipo que está atacando en este evento
 * @property scored Indica si el ataque resultó en un gol (true) o fue detenido (false)
 * @property score Marcador actual del partido como par (scoreA, scoreB) después de este evento
 */
data class Event(
    val attackerId: Int,
    val defenderId: Int,
    val attackingTeam: String,
    val scored: Boolean,
    val score: Pair<Int, Int>
)

/**
 * Representa un partido entre dos equipos y gestiona su simulación.
 *
 * Esta clase es responsable de simular un partido completo entre dos equipos,
 * gestionando los turnos de ataque, calculando los resultados de cada confrontación,
 * y manteniendo un registro de todos los eventos que ocurren durante el partido.
 *
 * El partido se desarrolla mediante confrontaciones uno a uno entre jugadores de ambos equipos,
 * alternando turnos de ataque. Cada jugador solo puede participar una vez en el partido.
 *
 * @property teamA El primer equipo que participa en el partido
 * @property teamB El segundo equipo que participa en el partido
 */
class Match(
    val teamA: Team,
    val teamB: Team
) {
    /**
     * Simula un partido completo entre los dos equipos.
     *
     * Este método ejecuta la simulación del partido mediante las siguientes etapas:
     * 1. Crea índices de jugadores por identificador para acceso rápido
     * 2. Mantiene conjuntos de jugadores disponibles (que aún no han participado)
     * 3. Determina aleatoriamente qué equipo ataca primero
     * 4. En cada turno:
     *    - Selecciona aleatoriamente un jugador disponible de cada equipo
     *    - Simula una confrontación entre ellos
     *    - Determina si se anota un gol comparando ataque vs defensa
     *    - Registra el evento con todos sus detalles
     *    - Alterna el turno de ataque
     * 5. El partido continúa hasta que un equipo se queda sin jugadores disponibles
     *
     * @return Un par que contiene:
     *         - El resultado final como par (scoreA, scoreB)
     *         - Una lista de todos los [Event] que ocurrieron durante el partido, en orden cronológico
     *
     * @see Event
     * @see attack
     * @see extractRandom
     */
    fun simulate(): Pair<Pair<Int, Int>, List<Event>> {
        val indexA = teamA.group.associateBy { it.identify }
        val indexB = teamB.group.associateBy { it.identify }

        val availableA = teamA.group.map { it.identify }.toMutableSet()
        val availableB = teamB.group.map { it.identify }.toMutableSet()

        var scoreA = 0
        var scoreB = 0
        val events = mutableListOf<Event>()
        var turn = Random.nextInt(0, 2)

        while (availableA.isNotEmpty() && availableB.isNotEmpty()) {
            val idA = extractRandom(availableA)
            val idB = extractRandom(availableB)

            val playerA = indexA.getValue(idA)
            val playerB = indexB.getValue(idB)

            if (turn == 0) {
                val scored = attack(playerA.atk, playerB.defe)
                if (scored) scoreA++
                events += Event(playerA.identify, playerB.identify, teamA.name, scored, scoreA to scoreB)
            } else {
                val scored = attack(playerB.atk, playerA.defe)
                if (scored) scoreB++
                events += Event(playerB.identify, playerA.identify, teamB.name, scored, scoreA to scoreB)
            }

            turn = 1 - turn
        }

        return (scoreA to scoreB) to events
    }

    /**
     * Determina si un ataque resulta exitoso (gol) o es detenido.
     *
     * Un ataque es exitoso si el valor de ataque es estrictamente mayor que el valor de defensa.
     * Esta es la lógica central que determina el resultado de cada confrontación individual.
     *
     * @param atk Valor de ataque del jugador atacante
     * @param def Valor de defensa del jugador defensor
     * @return true si el ataque supera la defensa (se anota gol), false en caso contrario
     */
    private fun attack(atk: Int, def: Int): Boolean = (atk - def) > 0

    /**
     * Extrae y elimina un elemento aleatorio de un conjunto mutable.
     *
     * Este método selecciona aleatoriamente un elemento del conjunto proporcionado,
     * lo elimina del conjunto (para evitar que se vuelva a seleccionar), y lo retorna.
     * Se utiliza para seleccionar jugadores que participarán en cada confrontación,
     * asegurando que cada jugador solo participe una vez.
     *
     * @param T El tipo de elementos contenidos en el conjunto
     * @param set El conjunto mutable del cual extraer el elemento
     * @return El elemento seleccionado aleatoriamente y eliminado del conjunto
     *
     * @throws NoSuchElementException si el conjunto está vacío
     */
    private fun <T> extractRandom(set: MutableSet<T>): T {
        val i = Random.nextInt(set.size)
        val elem = set.elementAt(i)
        set.remove(elem)
        return elem
    }
}

package View

import Model.Event
import Model.Team

/**
 * Vista de consola responsable de renderizar y mostrar la información de los partidos.
 *
 * Este objeto singleton gestiona la presentación visual en consola de toda la información
 * relacionada con un partido: equipos participantes, eventos ocurridos durante el juego,
 * y el resultado final. Utiliza emojis y formato para mejorar la legibilidad de la salida.
 *
 * La vista sigue el patrón de separación de responsabilidades, donde esta clase se encarga
 * únicamente de la presentación, mientras que la lógica del partido se gestiona en otras capas.
 *
 * @see Event
 * @see Team
 * @see Model.Match
 */
object ConsoleView {
    /**
     * Renderiza en consola toda la información de un partido completo.
     *
     * Este método presenta de manera formateada:
     * 1. Un encabezado con los nombres de los equipos enfrentados
     * 2. Cada evento del partido en orden cronológico, mostrando:
     *    - El equipo que ataca
     *    - Los IDs de los jugadores involucrados (atacante vs defensor)
     *    - Si se anotó gol o no (con emojis ✅/❌)
     *    - El marcador actualizado después del evento
     * 3. El resultado final del partido
     *
     * El formato utiliza emojis para mejorar la visualización:
     * - 🔍 para el encabezado de comparación
     * - ✅ para goles anotados
     * - ❌ para ataques sin gol
     * - 🏁 para el resultado final
     *
     * @param teamA El primer equipo participante del partido
     * @param teamB El segundo equipo participante del partido
     * @param result Par que contiene el marcador final (golesA, golesB)
     * @param events Lista de todos los eventos ocurridos durante el partido en orden cronológico
     *
     * @sample
     * ```
     * // Salida de ejemplo:
     * //
     * // 🔍 Comparando equipos 'Tigers' vs 'Lions'
     * // Turno: ataca 'Tigers' -> 1 vs 2 | ✅ GOL | Marcador Tigers 1 - 0 Lions
     * // Turno: ataca 'Lions' -> 3 vs 4 | ❌ Sin gol | Marcador Tigers 1 - 0 Lions
     * // Turno: ataca 'Tigers' -> 5 vs 6 | ✅ GOL | Marcador Tigers 2 - 0 Lions
     * //
     * // 🏁 Final: Tigers 2 - 0 Lions
     * ```
     *
     * @see Event
     * @see Team
     */
    fun render(teamA: Team, teamB: Team, result: Pair<Int, Int>, events: List<Event>) {
        println("\n🔍 Comparando equipos '${teamA.name}' vs '${teamB.name}'")
        events.forEach { e ->
            val (sa, sb) = e.score
            val msg = if (e.scored) "✅ GOL" else "❌ Sin gol"
            println("Turno: ataca '${e.attackingTeam}' -> ${e.attackerId} vs ${e.defenderId} | $msg | Marcador ${teamA.name} $sa - $sb ${teamB.name}")
        }
        println("\n🏁 Final: ${teamA.name} ${result.first} - ${result.second} ${teamB.name}")
    }
}

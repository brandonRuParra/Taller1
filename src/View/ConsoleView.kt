package View

import Model.Team

/**
 * Vista de consola que renderiza la información de los partidos siguiendo patrón MVC.
 * No contiene lógica de negocio, solo presentación.
 */
object ConsoleView {
    
    /** Muestra el encabezado del partido. */
    fun showHeader(team1: String, team2: String) {
        println("\n🔍 Comparando equipos '$team1' vs '$team2'")
    }
    
    /** Muestra el resultado de un enfrentamiento individual. */
    fun showConfrontation(
        confrontationNumber: Int,
        attackingTeam: String,
        attackerId: Int,
        defenderId: Int,
        scored: Boolean
    ) {
        val msg = if (scored) "⚽ GOL" else "❌ No gol"
        println("Enfrentamiento $confrontationNumber: $attackingTeam ataca -> Jugador #$attackerId vs #$defenderId | $msg")
    }
    
    /** Muestra el resultado final del partido. */
    fun render(teamA: Team, teamB: Team, result: Pair<Int, Int>) {
        println("\n🏁 Final: ${teamA.name} ${result.first} - ${result.second} ${teamB.name}")
    }
}

package Controller

import Model.Match
import Model.Team
import View.ConsoleView

/**
 * Controlador responsable de gestionar la comparación y simulación de partidos entre equipos.
 *
 * Este objeto singleton proporciona la funcionalidad para ejecutar un partido entre dos equipos,
 * simular el desarrollo del mismo y presentar los resultados mediante la vista de consola.
 */
object Comparison {
    /**
     * Ejecuta un partido entre dos equipos y muestra los resultados.
     *
     * Este método crea una instancia de [Match] con los equipos proporcionados,
     * simula el desarrollo del partido, y renderiza los resultados y eventos
     * ocurridos durante el partido en la consola.
     *
     * @param teamA El primer equipo que participará en el partido
     * @param teamB El segundo equipo que participará en el partido
     *
     * @see Match.simulate
     * @see ConsoleView.render
     */
    fun play(teamA: Team, teamB: Team) {
        val match = Match(teamA, teamB)
        val (result, events) = match.simulate()
        ConsoleView.render(teamA, teamB, result, events)
    }
}

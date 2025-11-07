package Controller

import Model.Team
import View.ConsoleView
import kotlin.random.Random

/**
 * Controlador que gestiona y simula partidos entre equipos siguiendo patrón MVC.
 */
class MatchController(
    private val view: ConsoleView = ConsoleView
) {
    
    companion object {
        private const val MIN_PLAYERS = 5
        private const val MAX_PLAYERS = 10
        private const val TEAM_A_TURN = 0
        private const val TEAM_B_TURN = 1
    }
    
    /** Ejecuta un partido de demostración entre dos equipos aleatorios (5-10 jugadores). */
    fun playDemo() {
        val numPlayers = (MIN_PLAYERS..MAX_PLAYERS).random()
        val teamA = Team.createRandom("Tigers", numPlayers)
        val teamB = Team.createRandom("Lions", numPlayers)
        play(teamA, teamB)
    }
    
    /** Ejecuta un partido completo entre dos equipos. */
    fun play(teamA: Team, teamB: Team) {
        val result = simulate(teamA, teamB)
        view.render(teamA, teamB, result)
    }
    
    /** Simula un partido. Retorna el marcador final (scoreA, scoreB). */
    private fun simulate(teamA: Team, teamB: Team): Pair<Int, Int> {
        teamA.resetScore()
        teamB.resetScore()
        
        view.showHeader(teamA.name, teamB.name)
        
        val indexA = teamA.players.associateBy { it.id }
        val indexB = teamB.players.associateBy { it.id }

        val availableA = teamA.players.map { it.id }.toMutableSet()
        val availableB = teamB.players.map { it.id }.toMutableSet()

        var turn = Random.nextInt(2)  // 0 o 1
        var confrontationNumber = 1

        while (availableA.isNotEmpty() && availableB.isNotEmpty()) {
            val idA = availableA.random().also { availableA.remove(it) }
            val idB = availableB.random().also { availableB.remove(it) }

            val playerA = indexA.getValue(idA)
            val playerB = indexB.getValue(idB)


            val (attackingTeam, attackingPlayer, defendingPlayer) = when (turn) {
                TEAM_A_TURN -> Triple(teamA, playerA, playerB)
                else -> Triple(teamB, playerB, playerA)
            }
            
            val scored = attackingPlayer.attack > defendingPlayer.defense
            if (scored) attackingTeam.addGoal()
            
            view.showConfrontation(
                confrontationNumber, 
                attackingTeam.name, 
                attackingPlayer.id, 
                defendingPlayer.id, 
                scored
            )

            confrontationNumber++
            turn = 1 - turn  // Alterna entre 0 y 1
        }

        return teamA.score to teamB.score
    }
}

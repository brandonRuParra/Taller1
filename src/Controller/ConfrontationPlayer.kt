package Controller

import Controller.Comparison.play
import Controller.RandomNumber.numRandom
import Model.Team

/**
 * Controlador responsable de gestionar el enfrentamiento entre equipos de jugadores.
 *
 * Este objeto singleton se encarga de crear dos equipos con una cantidad aleatoria de jugadores,
 * distribuidos aleatoriamente en diferentes posiciones (defensas, medios y delanteros),
 * y ejecutar un partido entre ellos.
 */
object ConfrontationPlayer {
    /**
     * Número de jugadores que tendrá cada equipo en el enfrentamiento.
     *
     * Este valor se inicializa aleatoriamente entre 5 y 10 jugadores por equipo.
     */
    var numberPlayers: Int = 0

    init {
        numberPlayers = numRandom(5, 10)
    }

    /**
     * Inicia y ejecuta un partido entre dos equipos predefinidos.
     *
     * Este método crea dos equipos ("Tigers" y "Lions") con el mismo número de jugadores,
     * muestra la composición de ambos equipos en la consola, y ejecuta el partido entre ellos.
     *
     * Los jugadores se distribuyen aleatoriamente entre las posiciones de defensa,
     * medio y delantero para cada equipo.
     *
     * @see createTeam
     * @see Team.showTeam
     * @see Comparison.play
     */
    fun play() {
        val nameFirst = "Tigers"
        val nameLast = "Lions"
        val teamA = createTeam(numberPlayers, nameFirst)
        val teamB = createTeam(numberPlayers, nameLast)
        teamA.showTeam()
        teamB.showTeam()
        play(teamA, teamB)
    }

    /**
     * Crea un equipo con una distribución aleatoria de jugadores en diferentes posiciones.
     *
     * Este método distribuye el número total de jugadores en tres posiciones:
     * - Defensas: Entre 1 y (numPlayers - 2) jugadores
     * - Medios: Entre 1 y (jugadores restantes - 1) jugadores
     * - Delanteros: Los jugadores restantes
     *
     * La distribución garantiza que haya al menos un jugador en cada posición
     * y que la suma total sea igual al número de jugadores especificado.
     *
     * @param numPlayers Número total de jugadores que tendrá el equipo
     * @param name Nombre del equipo a crear
     * @return Una instancia de [Team] con los jugadores distribuidos en las posiciones correspondientes
     *
     * @see Team.createGroup
     * @see RandomNumber.numRandom
     */
    private fun createTeam(numPlayers: Int, name: String): Team {
        var players = numPlayers
        val numberDefenses = numRandom(1, players - 2)
        players -= numberDefenses
        val numberMiddle = numRandom(1, players - 1)
        players -= numberMiddle
        val numberForward = players
        val group = Team(name)
        group.createGroup(numberDefenses, numberMiddle, numberForward)
        return group
    }
}

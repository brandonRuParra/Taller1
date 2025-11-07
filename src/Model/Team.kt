package Model

/**
 * Representa un equipo de jugadores con capacidad de gestionar marcador.
 */
class Team(val name: String) {
    
    private val _players = mutableListOf<Player>()
    val players: List<Player> get() = _players
    
    var score: Int = 0
        private set

    /** Crea y agrega jugadores al equipo. Retorna this para builder pattern. */
    fun createGroup(defenses: Int, midfielders: Int, forwards: Int): Team {
        _players.apply {
            addAll(List(defenses) { PlayerDefense() })
            addAll(List(midfielders) { PlayerMiddle() })
            addAll(List(forwards) { PlayerForward() })
        }
        return this
    }

    fun addGoal() {
        score++
    }
    
    fun resetScore() {
        score = 0
    }
    
    companion object {
        private const val MIN_PLAYERS_TOTAL = 3
        private const val MIN_PLAYERS_PER_POSITION = 1
        
        /**
         * Crea un equipo con distribución aleatoria de jugadores (mínimo 1 por posición).
         * @throws IllegalArgumentException si numPlayers < 3
         */
        fun createRandom(name: String, numPlayers: Int): Team {
            require(numPlayers >= MIN_PLAYERS_TOTAL) { 
                "Un equipo necesita al menos $MIN_PLAYERS_TOTAL jugadores (1 por posición)" 
            }
            
            val defenses = (MIN_PLAYERS_PER_POSITION..(numPlayers - 2)).random()
            val remaining = numPlayers - defenses
            val midfielders = (MIN_PLAYERS_PER_POSITION..(remaining - 1)).random()
            val forwards = remaining - midfielders
            
            return Team(name).createGroup(defenses, midfielders, forwards)
        }
    }
}
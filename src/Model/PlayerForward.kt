package Model

import Controller.RandomNumber.numRandom

/**
 * Representa un jugador especializado en la posición de delantero (atacante).
 *
 * Esta clase hereda de [Player] y define un jugador con características orientadas
 * al ataque. Los jugadores delanteros tienen valores de ataque más altos (5-9)
 * y valores de defensa complementarios más bajos, siguiendo la lógica de que
 * la suma de ataque y defensa siempre es 10.
 *
 * Este balance garantiza que los delanteros sean más efectivos realizando ataques
 * que defendiendo, reflejando su rol especializado en el equipo como anotadores.
 *
 * @constructor Crea un nuevo jugador delantero con estadísticas balanceadas hacia el ataque
 *
 * @see Player
 * @see PlayerDefense
 * @see PlayerMiddle
 */
class PlayerForward : Player() {
    init {
        atk = numRandom(5,9)
        defe = 10-atk
    }
    
    /**
     * Muestra en consola la información del jugador delantero.
     *
     * Sobrescribe el método de la clase base para proporcionar un mensaje
     * específico que identifica claramente al jugador como atacante,
     * mostrando su ID, valor de ataque y valor de defensa.
     *
     * Formato de salida: "Player Atacker created: id:[ID] atk: [ATK] def: [DEF]"
     *
     * @sample
     * ```
     * // Salida de ejemplo:
     * // Player Atacker created: id:5 atk: 8 def: 2
     * ```
     */
    override fun showData(){
        println("Player Atacker created: id:" + this.identify + " atk: " + this.atk + " def: " + this.defe)
    }
}


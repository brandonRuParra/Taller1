package Model

import Controller.RandomNumber.numRandom

/**
 * Representa un jugador especializado en la posición de defensa.
 *
 * Esta clase hereda de [Player] y define un jugador con características orientadas
 * a la defensa. Los jugadores defensivos tienen valores de defensa más altos (5-9)
 * y valores de ataque complementarios más bajos, siguiendo la lógica de que
 * la suma de ataque y defensa siempre es 10.
 *
 * Este balance garantiza que los defensas sean más efectivos deteniendo ataques
 * que realizándolos, reflejando su rol especializado en el equipo.
 *
 * @constructor Crea un nuevo jugador defensa con estadísticas balanceadas hacia la defensa
 *
 * @see Player
 * @see PlayerMiddle
 * @see PlayerForward
 */
class PlayerDefense: Player() {

    init {
        defe = numRandom(5,9)
        atk = 10-defe
    }

    /**
     * Muestra en consola la información del jugador defensa.
     *
     * Sobrescribe el método de la clase base para proporcionar un mensaje
     * específico que identifica claramente al jugador como defensa,
     * mostrando su ID, valor de ataque y valor de defensa.
     *
     * Formato de salida: "Player defense created: id:[ID] atk: [ATK] def: [DEF]"
     *
     * @sample
     * ```
     * // Salida de ejemplo:
     * // Player defense created: id:1 atk: 3 def: 7
     * ```
     */
    override fun showData(){
        println("Player defense created: id:" + this.identify + " atk: " + this.atk + " def: " + this.defe)
    }
}
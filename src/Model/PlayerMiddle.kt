package Model

import Controller.RandomNumber.numRandom

/**
 * Representa un jugador especializado en la posición de mediocampista.
 *
 * Esta clase hereda de [Player] y define un jugador con características balanceadas
 * entre ataque y defensa. Los jugadores de medio campo tienen valores de defensa
 * moderados (4-6) y valores de ataque complementarios, siguiendo la lógica de que
 * la suma de ataque y defensa siempre es 10.
 *
 * Este balance garantiza que los mediocampistas sean versátiles, capaces tanto de
 * defender como de atacar con efectividad similar, reflejando su rol como conectores
 * entre la defensa y el ataque del equipo.
 *
 * @constructor Crea un nuevo jugador mediocampista con estadísticas equilibradas
 *
 * @see Player
 * @see PlayerDefense
 * @see PlayerForward
 */
class PlayerMiddle: Player() {

    init{
        defe = numRandom(4,6)
        atk = 10-defe
    }
    
    /**
     * Muestra en consola la información del jugador mediocampista.
     *
     * Sobrescribe el método de la clase base para proporcionar un mensaje
     * específico que identifica claramente al jugador como mediocampista,
     * mostrando su ID, valor de ataque y valor de defensa.
     *
     * Formato de salida: "Player middle created: id:[ID] atk: [ATK] def: [DEF]"
     *
     * @sample
     * ```
     * // Salida de ejemplo:
     * // Player middle created: id:3 atk: 5 def: 5
     * ```
     */
    override fun showData(){
        println("Player middle created: id:" + this.identify + " atk: " + this.atk + " def: " + this.defe)
    }
}
package Model

import Controller.RandomNumber.numRandom

/**
 * Clase base que representa un jugador genérico en el sistema de simulación de partidos.
 *
 * Esta clase open (heredable) define las propiedades y comportamientos fundamentales
 * de cualquier jugador, incluyendo su identificación única y sus estadísticas de ataque y defensa.
 * Los valores de ataque y defensa se generan aleatoriamente al crear cada instancia.
 *
 * Las clases especializadas de jugadores (defensas, medios, delanteros) pueden heredar
 * de esta clase para agregar características específicas de cada posición.
 *
 * @see PlayerDefense
 * @see PlayerMiddle
 * @see PlayerForward
 */
open class Player {

    /**
     * Identificador único del jugador.
     *
     * Este valor se asigna automáticamente en el bloque init mediante [idGeneration].
     * Cada jugador recibe un ID secuencial único que nunca se repite.
     */
    var identify: Int = 0
    
    /**
     * Valor de ataque del jugador.
     *
     * Representa la capacidad ofensiva del jugador en las confrontaciones.
     * Se inicializa aleatoriamente con un valor entre 1 y 9.
     */
    var atk: Int = 0
    
    /**
     * Valor de defensa del jugador.
     *
     * Representa la capacidad defensiva del jugador en las confrontaciones.
     * Se inicializa aleatoriamente con un valor entre 1 y 9.
     */
    var defe: Int = 0

    companion object {
        /**
         * Contador global utilizado para generar identificadores únicos.
         *
         * Este contador se incrementa con cada nuevo jugador creado,
         * garantizando que cada jugador tenga un ID único durante toda la ejecución del programa.
         */
        private var counter = 0
        
        /**
         * Genera un identificador único para un nuevo jugador.
         *
         * Este método incrementa el contador global y retorna el nuevo valor,
         * asegurando que cada jugador tenga un ID único y secuencial.
         *
         * @return Un identificador único para el jugador
         */
        fun idGeneration(): Int {
            counter += 1
            return counter
        }
    }

    init {
        atk = numRandom(1,9)
        defe = numRandom(1,9)
        identify = idGeneration()
    }

    /**
     * Muestra en consola la información básica del jugador.
     *
     * Este método imprime en formato texto el identificador del jugador
     * junto con sus valores de ataque y defensa.
     *
     * Formato de salida: "Jugador:[ID] [ATK] [DEF]"
     *
     * Este método es open y puede ser sobrescrito por las clases hijas
     * para mostrar información adicional específica de cada posición.
     *
     * @sample
     * ```
     * // Salida de ejemplo:
     * // Jugador:1 7 5
     * ```
     */
    open fun showData(){
        println("Jugador:" + this.identify + " " + this.atk + " " + this.defe)
    }
}
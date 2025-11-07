package Controller

/**
 * Utilidad para generar números aleatorios dentro de un rango especificado.
 *
 * Este objeto singleton proporciona funciones auxiliares para la generación
 * de valores aleatorios utilizados en la simulación de partidos y creación de equipos.
 */
object RandomNumber {
    /**
     * Genera un número entero aleatorio dentro de un rango especificado (inclusivo).
     *
     * Este método utiliza la función `random()` de Kotlin para generar un número
     * aleatorio dentro del rango [start..end], donde ambos límites están incluidos.
     *
     * @param start El valor mínimo del rango (inclusivo)
     * @param end El valor máximo del rango (inclusivo)
     * @return Un número entero aleatorio entre [start] y [end], ambos incluidos
     *
     * @throws IllegalArgumentException si start > end
     *
     * @sample
     * ```
     * val randomScore = numRandom(0, 5)  // Genera un número entre 0 y 5
     * val randomPlayers = numRandom(5, 10)  // Genera un número entre 5 y 10
     * ```
     */
    fun numRandom(start: Int, end: Int): Int {
            return (start..end).random()
        }
}
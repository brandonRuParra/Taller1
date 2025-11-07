package Model

/**
 * Representa un equipo de jugadores en el sistema de simulación de partidos.
 *
 * Esta clase gestiona un conjunto de jugadores organizados en diferentes posiciones
 * (defensas, mediocampistas y delanteros) que conforman un equipo completo.
 * Proporciona funcionalidades para crear el grupo de jugadores con una distribución
 * específica de posiciones y para mostrar la información del equipo.
 *
 * @property name Nombre del equipo
 * @property group Lista mutable que contiene todos los jugadores del equipo
 *
 * @constructor Crea un nuevo equipo con el nombre especificado y una lista de jugadores vacía
 *
 * @see Player
 * @see PlayerDefense
 * @see PlayerMiddle
 * @see PlayerForward
 */
class Team (var name : String){
    /**
     * Lista mutable que contiene todos los jugadores que conforman el equipo.
     *
     * Los jugadores se agregan mediante el método [createGroup] y pueden ser
     * de diferentes tipos: defensas, mediocampistas o delanteros.
     */
    val group = mutableListOf<Player>()

    /**
     * Crea y agrega jugadores al equipo con una distribución específica de posiciones.
     *
     * Este método genera la plantilla completa del equipo creando instancias de
     * jugadores especializados según las cantidades especificadas para cada posición:
     * - Primero se crean los defensas
     * - Luego los mediocampistas
     * - Finalmente los delanteros
     *
     * Cada jugador se inicializa con estadísticas aleatorias apropiadas a su posición
     * y se agrega a la lista [group] del equipo.
     *
     * @param quantityDefense Número de jugadores defensas a crear
     * @param quantityMiddle Número de jugadores mediocampistas a crear
     * @param quantityForward Número de jugadores delanteros a crear
     *
     * @see PlayerDefense
     * @see PlayerMiddle
     * @see PlayerForward
     */
    fun createGroup( quantityDefense: Int, quantityMiddle: Int, quantityForward: Int ) {
        repeat(quantityDefense) {
            group.add(PlayerDefense())
        }
        repeat(quantityMiddle) {
            group.add(PlayerMiddle())
        }
        repeat(quantityForward) {
            group.add(PlayerForward())
        }
    }

    /**
     * Muestra en consola la información completa del equipo.
     *
     * Este método imprime el nombre del equipo seguido de la información detallada
     * de cada jugador que lo conforma, utilizando el método [Player.showData] de
     * cada jugador para mostrar sus estadísticas.
     *
     * Formato de salida:
     * - Primera línea: "se creo un equipo llamado' [NOMBRE] ' conformado por: "
     * - Líneas siguientes: Información de cada jugador según su tipo
     *
     * @sample
     * ```
     * // Salida de ejemplo:
     * // se creo un equipo llamado' Tigers ' conformado por:
     * // Player defense created: id:1 atk: 3 def: 7
     * // Player middle created: id:2 atk: 5 def: 5
     * // Player Atacker created: id:3 atk: 8 def: 2
     * ```
     *
     * @see Player.showData
     */
    fun showTeam (){
        println("se creo un equipo llamado' $name ' conformado por: ")
        group.forEach {it.showData()}
    }

}
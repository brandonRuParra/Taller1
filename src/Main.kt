import Model.PlayerDefense
import Model.PlayerForward
import Model.PlayerMiddle
import Controller.ConfrontationPlayer

/**
 * Punto de entrada principal de la aplicación de simulación de partidos de fútbol.
 *
 * Esta aplicación simula un partido entre dos equipos generados aleatoriamente,
 * donde cada equipo tiene jugadores con diferentes posiciones (defensas, mediocampistas
 * y delanteros) y estadísticas aleatorias.
 *
 * El programa realiza las siguientes acciones:
 * 1. Genera dos equipos con composiciones aleatorias
 * 2. Simula un partido completo entre ellos
 * 3. Muestra todos los eventos del partido y el resultado final
 *
 * @see ConfrontationPlayer
 * @see Model.Team
 * @see Model.Match
 */
fun main() {
    // Mensaje de bienvenida indicando el inicio de la simulación
    println("⚽ Iniciando simulación de partido...")
    
    // Ejecuta la simulación completa del partido entre dos equipos
    ConfrontationPlayer.play()
    
    // Mensaje de cierre indicando que la simulación ha terminado
    println("\n🏁 Simulación finalizada.")
}

import Controller.MatchController

/**
 * Punto de entrada de la simulación de partidos de fútbol.
 * Genera dos equipos aleatorios y simula un partido entre ellos.
 */
fun main() {
    println("⚽ Iniciando simulación de partido...")
    
    val controller = MatchController()
    controller.playDemo()
    
    println("\n🏁 Simulación finalizada.")
}

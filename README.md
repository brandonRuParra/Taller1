# ⚽ Simulador de Partidos de Fútbol

Una aplicación de simulación de partidos de fútbol desarrollada en Kotlin que genera equipos aleatorios y simula enfrentamientos entre ellos.

## 📋 Descripción

Este proyecto simula partidos de fútbol entre dos equipos generados aleatoriamente. Cada equipo está compuesto por jugadores con diferentes posiciones (defensas, mediocampistas y delanteros) que tienen estadísticas únicas de ataque y defensa. El resultado del partido se determina mediante confrontaciones individuales entre jugadores de ambos equipos.

## 🎯 Características

- **Generación aleatoria de equipos**: Cada equipo se crea con 5-10 jugadores distribuidos en diferentes posiciones
- **Tres tipos de jugadores**:
  - **Defensas**: Alta capacidad defensiva (5-9), baja capacidad de ataque (1-5)
  - **Mediocampistas**: Estadísticas balanceadas (4-6 en defensa, 4-6 en ataque)
  - **Delanteros**: Alta capacidad de ataque (5-9), baja capacidad defensiva (1-5)
- **Sistema de balance**: La suma de ataque y defensa de cada jugador siempre es 10
- **Simulación de partido**: Confrontaciones uno a uno entre jugadores de ambos equipos
- **Visualización detallada**: Muestra cada evento del partido con emojis y formato claro
- **Resultados en tiempo real**: Visualización del marcador actualizado después de cada evento

## 🏗️ Arquitectura del Proyecto

El proyecto sigue el patrón MVC (Modelo-Vista-Controlador):

```
src/
├── Main.kt                      # Punto de entrada de la aplicación
├── Controller/
│   ├── Comparison.kt            # Controlador de comparación de equipos
│   └── ConfrontationPlayer.kt   # Controlador de enfrentamiento
├── Model/
│   ├── Match.kt                 # Lógica de simulación del partido
│   ├── Player.kt                # Clase base de jugador
│   ├── Players.kt               # Especializaciones de jugadores
│   └── Team.kt                  # Gestión de equipos
└── View/
    └── ConsoleView.kt           # Vista de consola
```

## 🚀 Cómo Ejecutar

### Requisitos Previos

- Java Development Kit (JDK) 8 o superior
- Kotlin instalado
- IntelliJ IDEA (recomendado) o cualquier IDE compatible con Kotlin

### Pasos para Ejecutar

1. **Clonar o descargar el proyecto**
   ```bash
   git clone <url-del-repositorio>
   cd untitled
   ```

2. **Abrir el proyecto en IntelliJ IDEA**
   - File → Open → Seleccionar la carpeta del proyecto

3. **Ejecutar la aplicación**
   - Abrir `Main.kt`
   - Hacer clic en el ícono de ejecución (▶️) junto a la función `main()`
   - O presionar `Shift + F10` (Windows/Linux) o `Control + R` (macOS)

## 📖 Cómo Funciona

### 1. Generación de Equipos

Al iniciar la simulación, se crean dos equipos ("Tigers" y "Lions") con:
- Número aleatorio de jugadores (5-10 por equipo)
- Distribución aleatoria entre defensas, medios y delanteros
- Cada jugador recibe estadísticas aleatorias según su posición

### 2. Simulación del Partido

El partido se simula mediante:
- Selección aleatoria de un jugador de cada equipo
- Confrontación entre el atacante y el defensor
- Determinación del resultado: gol si `ataque > defensa`
- Alternancia de turnos de ataque entre equipos
- Continúa hasta que un equipo se quede sin jugadores disponibles

### 3. Visualización de Resultados

La consola muestra:
- Composición de cada equipo
- Cada evento del partido con detalles de los jugadores involucrados
- Marcador actualizado tras cada confrontación
- Resultado final del partido

## 💡 Ejemplo de Salida

```
⚽ Iniciando simulación de partido...
se creo un equipo llamado' Tigers ' conformado por: 
Player defense created: id:1 atk: 3 def: 7
Player middle created: id:2 atk: 5 def: 5
Player Atacker created: id:3 atk: 8 def: 2

se creo un equipo llamado' Lions ' conformado por: 
Player defense created: id:4 atk: 2 def: 8
Player middle created: id:5 atk: 6 def: 4
Player Atacker created: id:6 atk: 7 def: 3

🔍 Comparando equipos 'Tigers' vs 'Lions'
Turno: ataca 'Tigers' -> 3 vs 4 | ✅ GOL | Marcador Tigers 1 - 0 Lions
Turno: ataca 'Lions' -> 6 vs 1 | ❌ Sin gol | Marcador Tigers 1 - 0 Lions
Turno: ataca 'Tigers' -> 2 vs 5 | ❌ Sin gol | Marcador Tigers 1 - 0 Lions

🏁 Final: Tigers 2 - 1 Lions

🏁 Simulación finalizada.
```

## 🎲 Mecánicas del Juego

### Sistema de Estadísticas

- **Ataque (atk)**: Capacidad ofensiva del jugador
- **Defensa (defe)**: Capacidad defensiva del jugador
- **Balance**: `atk + defe = 10` (constante para todos los jugadores)

### Tipos de Jugadores

| Posición | Rango Defensa | Rango Ataque | Rol |
|----------|---------------|--------------|-----|
| Defensa | 5-9 | 1-5 | Detener ataques |
| Mediocampista | 4-6 | 4-6 | Equilibrio |
| Delantero | 1-5 | 5-9 | Anotar goles |

### Lógica de Confrontación

```kotlin
gol = (ataque_atacante - defensa_defensor) > 0
```

Un ataque resulta en gol solo si el valor de ataque del atacante es **estrictamente mayor** que la defensa del defensor.

## 🛠️ Tecnologías Utilizadas

- **Lenguaje**: Kotlin
- **Paradigma**: Programación Orientada a Objetos
- **Patrón de diseño**: MVC (Modelo-Vista-Controlador)
- **IDE recomendado**: IntelliJ IDEA

## 📚 Documentación del Código

Todos los archivos del proyecto están completamente documentados con KDoc siguiendo las mejores prácticas de Kotlin. La documentación incluye:

- Descripción de clases y objetos
- Documentación de métodos y funciones
- Parámetros y valores de retorno
- Referencias cruzadas entre componentes
- Ejemplos de uso

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Para contribuir:

1. Fork el proyecto
2. Crea una rama para tu característica (`git checkout -b feature/nueva-caracteristica`)
3. Commit tus cambios (`git commit -m 'Agregar nueva característica'`)
4. Push a la rama (`git push origin feature/nueva-caracteristica`)
5. Abre un Pull Request

## 📝 Posibles Mejoras Futuras

- [ ] Agregar portero como una nueva posición
- [ ] Implementar sistema de tarjetas (amarillas/rojas)
- [ ] Añadir estadísticas de rendimiento de jugadores
- [ ] Crear interfaz gráfica (GUI)
- [ ] Guardar historial de partidos
- [ ] Agregar modo torneo con múltiples equipos
- [ ] Implementar sistema de lesiones
- [ ] Añadir diferentes formaciones tácticas (4-3-3, 4-4-2, etc.)

## 📄 Licencia

Este proyecto es de código abierto y está disponible bajo la licencia MIT.

## ✨ Autor

Proyecto desarrollado como práctica de programación orientada a objetos en Kotlin.

---

⚽ **¡Disfruta simulando partidos!** ⚽

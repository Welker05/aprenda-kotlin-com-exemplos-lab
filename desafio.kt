enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val id: Long, val name: String)

data class ConteudoEducacional(val id: Long, var nome: String, val duracao: Int = 60)

data class Formacao(val id: Long, val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        this.inscritos.add(usuario)
    }
}

fun main() {
    val Usuario1 = Usuario(1L, "Welker")
	val Usuario2 = Usuario(2L, "Wesley")

    val Java = ConteudoEducacional(1L, "Java Fundamentals", 160)
    val Kotlin = ConteudoEducacional(12, "Kotlin Fundamentals", 180)
    val conteudos = listOf(Java, Kotlin)

    val formacao = Formacao(1L, "Back-End Fundamentals", Nivel.BASICO, conteudos)
    formacao.matricular(Usuario1)
    formacao.matricular(Usuario2)

    println("Formação: $formacao")
	println("Inscritos: ${formacao.inscritos}")
}
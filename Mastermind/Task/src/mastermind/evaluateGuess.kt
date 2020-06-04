package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val rightPosition = secret.zip(guess).count { p -> p.first == p.second}
    val commonLetters = "ABCDEF".sumBy { ch -> Math.min(secret.count{it == ch},guess.count {it ==ch})}
    return Evaluation(rightPosition,commonLetters - rightPosition)
}

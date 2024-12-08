import kotlin.math.abs

fun main() {
    fun parseInput(input: List<String>): Pair<MutableList<Int>, MutableList<Int>> {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        for (line in input) {
            val (l, r) = line.trim().split(Regex("\\s+")).map { it.toInt() }
            left.add(l)
            right.add(r)
        }
        return Pair(left, right)
    }

    fun part1(input: List<String>): Int {
        val (left, right) = parseInput(input)
        left.sort()
        right.sort()
        return left.zip(right).sumOf { (a,b) -> abs(a-b) }
    }

    fun part2(input: List<String>): Int {
        val (left, right) = parseInput(input)

        return left.sumOf { num ->
            val frequency = right.count { it == num }
            num * frequency
        }
    }
    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

fun main() {
    val input = readInput("Day03").joinToString()
    part1(input).println()
    part2(input).println()
}

fun part1(input: String): Int {
    return doMuls(input)
}

fun part2(input: String): Int =
    """(^|do\(\)).*?($|don't\(\))"""
        .toRegex()
        .findAll(input)
        .sumOf { doMuls(it.value) }

private fun doMuls(instructions: String): Int =
    """mul\((\d{1,3}),(\d{1,3})\)"""
        .toRegex()
        .findAll(instructions)
        .sumOf { match ->
            match.groupValues
                .drop(1)
                .map { it.toInt() }
                .reduce(Int::times)
        }

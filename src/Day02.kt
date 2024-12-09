import kotlin.math.abs

fun main() {
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}

fun part1(input: List<String>): Int {
    return getReports(input).count(::isValid)
}

fun part2(input: List<String>): Int {
    return getReports(input).count { report ->
        isValid(report) || report.withEachElementRemoved().any(::isValid)
    }
}

fun isValid(report: List<Long>): Boolean {
    val increase = report[1] >= report[0]
    for (idx in report.indices) {
      if (idx == 0) continue
      if (increase && report[idx] <= report[idx - 1]) return false
      if (!increase && report[idx] >= report[idx - 1]) return false
      if (abs(report[idx] - report[idx - 1]) < 1) return false
      if (abs(report[idx] - report[idx - 1]) > 3) return false
    }
    return true
}

fun getReports(input: List<String>) : List<List<Long>> {
    return input.map { line -> line.split(" ").map { it.toLong() } }
}

private fun <R> List<R>.withEachElementRemoved(): Sequence<List<R>> = sequence {
    for (removedIdx in indices) {
        yield(filterIndexed { idx, _ -> idx != removedIdx })
    }
}
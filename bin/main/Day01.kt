import java.io.File
import kotlin.math.*
import kotlin.collections.*

fun main() {
    fun part1(input: List<String>): Int {
        var mx = 0
        var sum = 0
        for (line in input) { 
            if (line.length > 0) {
                sum += line.toInt()
            } else {
                mx = max(mx, sum) 
                sum = 0
            }
        }
        return mx
    }

    fun part2(input: List<String>): Int {
        var mx1 = 0; var mx2 = 0; var mx3 = 0;
        var sum = 0
        for (line in input) { 
            if (line.length > 0) {
                sum += line.toInt()
            } else {
                if (sum >= mx1) {
                    mx3 = mx2
                    mx2 = mx1
                    mx1 = sum
                } else if (sum >= mx2) {
                    mx3 = mx2
                    mx2 = sum
                } else if (sum >= mx3) {
                    mx3 = sum
                }
                sum = 0
            }
        }
        val ans = mx1 + mx2 + mx3
        return ans
    }

    // test if implementation meets criteria from the description, like:
    val input = File("Day01_01.txt").readLines()
    
    println(part1(input))
    println(part2(input))
}

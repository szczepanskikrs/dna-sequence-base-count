package io.github.krs.dna

import io.github.krs.dna.bases.DNABases.*
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    val initialSequence = try {
        args[0]
    } catch (ex: Exception) {
        println("You need to run program with argument representing DNA sequence")
        exitProcess(1)
    }
    println("DNA Base sequence")
    val chunkSize = 50
    val maxLength = initialSequence.length / chunkSize
    initialSequence.chunked(chunkSize).mapIndexed { index, sequence ->
        val padding = (index * chunkSize).toString().padEnd(maxLength, ' ')
        println("$padding: $sequence")
    }

    val basesCount = initialSequence.toCharArray()
        .asSequence()
        .map { char -> valueOf("$char") }
        .groupBy { it }
        .mapValues { entry -> entry.value.count() }

    println(
        """
+------------+---------+-------+
| Nucleotide | Acronym | Count |
+------------+---------+-------+
| ${A.molecule}    |   [A]   |  ${basesCount[A]}  |
+------------+---------+-------+
| ${C.molecule}   |   [C]   |  ${basesCount[C]}   |
+------------+---------+-------+
| ${G.molecule}    |   [G]   |  ${basesCount[G]}  |
+------------+---------+-------+
| ${T.molecule}    |   [T]   |  ${basesCount[T]}  |
+------------+---------+-------+

Σ:${basesCount.values.sum()}
        """.trimIndent()
    )
}
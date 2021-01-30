#!/usr/bin/env kscript

import kotlin.system.exitProcess

/**
 * This problem was asked by Facebook.
 * Given a array of numbers representing the stock prices of a company in chronological order,
 * write a function that calculates the maximum profit you could have made from buying and selling that stock once.
 * You must buy before you can sell it.
 * For example, given [9, 11, 8, 5, 7, 10], you should return 5,
 * since you could buy the stock at 5 dollars and sell it at 10 dollars.
 */

val data = listOf<Int>(9, 11, 8, 5, 7, 10, 4)

fun nextStockPrices(actualPriceIndex: Int, data: List<Int>): List<Int> {
    return data.subList(actualPriceIndex + 1, data.size)
}

fun findHighestValue(data: List<Int>): Int {
    return data.maxOf { n: Int -> n }
}

fun start() {
    var diff = 0
    data.forEachIndexed { index: Int, currentStock: Int ->
        if (index + 1 < data.size) {
            val nextPrices = nextStockPrices(index, data)
            val highestStock = findHighestValue(nextPrices)
            val tempDiff = highestStock - currentStock
            if (tempDiff > diff) {
                diff = tempDiff
            }
        }
    }
    println("Highest diff found: $diff")
    exitProcess(0)
}

start()
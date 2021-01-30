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

val data = mutableListOf<Int>(9, 11, 8, 5, 7, 10, 4)

fun findLowestPrice(data: List<Int>): Int {
    return data.minOf { n: Int -> n }
}

fun lowerPriceIndex(actualPrice: Int, data: List<Int>): Int {
    return data.indexOfFirst { n -> n == actualPrice }
}

fun nextPricesData(actualPriceIndex: Int, data: List<Int>): List<Int> {
    if (actualPriceIndex + 1 == data.size) {
        return emptyList()
    }
    return data.subList(actualPriceIndex + 1, data.size)
}

fun findHighestValue(data: List<Int>): Int {
    return data.maxOf { n: Int -> n }
}

fun start() {
    if (data.isEmpty()) {
        exitProcess(0)
    }
    val lowestPrice = findLowestPrice(data)
    val lowerPriceIndex = lowerPriceIndex(actualPrice = lowestPrice, data = data)
    val nextPrices: List<Int> = nextPricesData(lowerPriceIndex, data)
    println("Prices left: $nextPrices")
    if (nextPrices.isEmpty()) {
        data.removeAt(lowerPriceIndex)
        start()
    } else {
        val highestValueToSell = findHighestValue(nextPrices)
        println(highestValueToSell)
    }
}

start()





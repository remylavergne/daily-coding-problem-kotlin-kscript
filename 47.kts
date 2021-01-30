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
var previousPrice = 0

fun findLowestPrice(data: List<Int>): Int {
    val tempData = data.filter { n: Int -> n > previousPrice }
    println(tempData)
    return tempData.minOf { n: Int -> n }
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
    println("Lowest price found: $lowestPrice")
    val lowerPriceIndex = lowerPriceIndex(actualPrice = lowestPrice, data = data)
    val nextPrices: List<Int> = nextPricesData(lowerPriceIndex, data)
    if (nextPrices.isEmpty()) {
        previousPrice = lowestPrice
        println("Not enough data. Retry.")
        println()
        start()
    } else {
        val highestValueToSell = findHighestValue(nextPrices)
        println("Min price: $lowestPrice, max price: $highestValueToSell, gain: ${highestValueToSell - lowestPrice}")
    }
}

start()
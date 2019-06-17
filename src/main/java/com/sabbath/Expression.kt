package com.sabbath

interface Expression {
    fun reduce(toCurrency: String): Money
}

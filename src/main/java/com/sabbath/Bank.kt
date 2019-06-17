package com.sabbath

class Bank {

    fun reduce(source: Expression, toCurrency: String): Money {
        return source.reduce(toCurrency)
    }

}

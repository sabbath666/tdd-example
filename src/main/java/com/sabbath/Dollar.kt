package com.sabbath

class Dollar(
        amount: Int
) : Money(amount = amount) {

    fun times(multiplier: Int) = Dollar(amount * multiplier)

}

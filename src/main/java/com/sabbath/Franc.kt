package com.sabbath

class Franc(
        amount: Int
) : Money(amount = amount) {

    fun times(multiplier: Int) = Franc(amount * multiplier)

}

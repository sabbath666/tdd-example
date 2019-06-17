package com.sabbath

class Sum(
        val augment: Money,
        val addend: Money
) : Expression {
    override fun reduce(toCurrency: String) = Money(augment.amount + addend.amount,toCurrency)
}

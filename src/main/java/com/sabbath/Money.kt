package com.sabbath

open class Money(
        val amount: Int,
        val currency: String?
) : Expression {

    fun times(multiplier: Int): Money {
        return Money(amount * multiplier, currency)
    }

    fun plus(addend: Money): Expression = Sum(this, addend)

    override fun equals(other: Any?): Boolean {
        val money = other as Money
        return amount == money.amount && currency == other.currency
    }

    override fun toString(): String {
        return "Money(amount=$amount, currency=$currency)"
    }

    companion object {
        fun dollar(amount: Int): Money = Money(amount, "USD")
        fun franc(amount: Int): Money = Money(amount, "CHF")
    }

    override fun reduce(toCurrency: String): Money {
        return this
    }


}
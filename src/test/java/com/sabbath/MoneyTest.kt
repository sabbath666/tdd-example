package com.sabbath

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.test.assertNotEquals

class MoneyTest {

    @Test
    fun testMultiplication() {
        val five = Money.dollar(5)
        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    fun testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5))
        assertNotEquals(Money.dollar(5), Money.dollar(8))
        assertNotEquals(Money.dollar(5), Money.franc(8))
    }

    @Test
    fun testCurrency() {
        assertEquals("USD", Money.dollar(1).currency)
        assertEquals("CHF", Money.franc(1).currency)
    }

    @Test
    fun testSimpleAddition() {
        val five = Money.dollar(5)
        val sum: Expression = five.plus(five)
        val bank = Bank()
        val reduced=bank.reduce(sum, "USD")
        assertEquals(Money.dollar(10), reduced)
    }

    @Test
    fun testPlusReturnsSum() {
        val five = Money.dollar(5)
        val result = five.plus(five)
        val sum: Sum = result as Sum
        assertEquals(five, sum.augment)
        assertEquals(five, sum.addend)
    }

    @Test
    fun testReduceSum() {
        val sum: Expression = Sum(Money.dollar(5), Money.dollar(4))
        val bank = Bank()
        val result = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(9), result)
    }

    @Test
    fun testReduceMoney() {
        val bank = Bank()
        val result = bank.reduce(Money.dollar(1), "USD")
        assertEquals(Money.dollar(1), result)
    }


}
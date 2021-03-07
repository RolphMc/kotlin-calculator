package com.example.kotlincalculator

import org.junit.Assert.assertEquals
import org.junit.Test


class CalculatorTest {

    @Test
    fun `when sum is called then calculate sum`() {
        val calculator = Calculator()
        val result = calculator.sum(1f, 1f)
        assertEquals(2f, result)
    }

    @Test
    fun `when subtraction is called then calculate subtraction`() {
        val calculator = Calculator()
        val result = calculator.subtraction(1f, 1f)
        assertEquals(0f, result)
    }

    @Test
    fun `when multiplication is called then calculate multiplication`() {
        val calculator = Calculator()
        val result = calculator.multiplication(2f, 3f)
        assertEquals(6f, result)
    }

    @Test
    fun `when division is called then calculate division`() {
        val calculator = Calculator()
        val result = calculator.division(10f, 2f)
        assertEquals(5f, result)
    }
}
package org.hyperskill.calculator.enum

enum class Operator(val string : String) {
    CLEAR("AC"),
    EQUAL("="),
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    FLIP_NEGATIVITY("+/-"),
    PERCENT("%")
}
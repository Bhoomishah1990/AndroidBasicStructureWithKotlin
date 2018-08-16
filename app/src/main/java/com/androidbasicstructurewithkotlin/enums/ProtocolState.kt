package com.androidbasicstructurewithkotlin.enums

/**
 * Created by Darshna Desai on 6/7/18.
 */
enum class ProtocolState(s: String) {
    WAITING("ddd") {
        override fun signal() = TALKING
    },

    TALKING("ddd") {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}
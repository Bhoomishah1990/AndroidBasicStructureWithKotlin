package com.androidbasicstructurewithkotlin

import com.androidbasicstructurewithkotlin.enums.ProtocolState

/**
 * Created by Darshna Desai on 2/7/18.
 */
class D {
    fun bar() {}
}

sealed class ASealed {
    val ab = ProtocolState.TALKING.signal()
    //val ab = ProtocolState.TALKING.name
    val dd = ProtocolState.valueOf("sd")
    val dde = ProtocolState.values()
}

data class X(val a: String = "") : ASealed()

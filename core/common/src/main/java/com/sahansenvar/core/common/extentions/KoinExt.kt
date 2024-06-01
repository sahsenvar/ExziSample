package com.sahansenvar.core.common.extentions

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

inline fun <reified T> inject(): T {
    return object : KoinComponent {
        val value: T by inject()
    }.value
}
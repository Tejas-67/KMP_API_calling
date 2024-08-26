package com.tejasdev.kmm1

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package org.himanshu.productbrowser

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
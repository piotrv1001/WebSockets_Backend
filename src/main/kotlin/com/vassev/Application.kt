package com.vassev

import com.vassev.di.mainModule
import com.vassev.plugins.*
import io.ktor.application.*
import org.koin.ktor.ext.Koin

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(Koin) {
        modules(mainModule)
    }
    configureSerialization()
    configureSecurity()
    configureMonitoring()
    configureSockets()
    configureRouting()
}

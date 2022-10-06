package com.vassev.plugins

import com.vassev.session.ChatSession
import io.ktor.sessions.*
import io.ktor.application.*
import io.ktor.util.*

fun Application.configureSecurity() {

    install(Sessions) {
        cookie<ChatSession>("SESSION")
    }

    intercept(ApplicationCallPipeline.Features) {
        if(call.sessions.get<ChatSession>() == null) {
            val username = call.request.queryParameters["username"] ?: "Guest"
            call.sessions.set(ChatSession(
                username = username,
                sessionId = generateNonce()
            ))
        }
    }
}

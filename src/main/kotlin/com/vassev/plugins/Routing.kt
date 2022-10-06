package com.vassev.plugins


import com.vassev.room.RoomController
import com.vassev.routes.chatSocket
import com.vassev.routes.getAllMessages
import io.ktor.application.*
import io.ktor.routing.*
import org.koin.ktor.ext.inject

fun Application.configureRouting() {
    val roomController by inject<RoomController>()
    install(Routing) {
        chatSocket(roomController = roomController)
        getAllMessages(roomController = roomController)
    }
}

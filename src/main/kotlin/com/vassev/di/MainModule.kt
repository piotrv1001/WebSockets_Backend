package com.vassev.di

import com.vassev.data.MessageDataSource
import com.vassev.data.MessageDataSourceImpl
import com.vassev.room.RoomController
import org.koin.dsl.module
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

val mainModule = module {
    single {
        KMongo.createClient()
            .coroutine
            .getDatabase("message_db")
    }
    single<MessageDataSource> {
        MessageDataSourceImpl(
            db = get()
        )
    }
    single {
        RoomController(
            messageDataSource = get()
        )
    }
}
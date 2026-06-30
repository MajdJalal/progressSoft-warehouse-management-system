package com.progressoft.internal.warehouse.management.system.starter.exposed

import WHSTransactionalExecutor
import io.arkitik.radix.develop.exposed.table.ensureInTransaction
import org.jetbrains.exposed.v1.jdbc.Database

class ExposedWHSTransactionalExecutor(
    private val database : Database?,
) : WHSTransactionalExecutor {
    override fun <T> runOnTransaction(command: () -> T): T {
        return ensureInTransaction(database) {
            command()
        }
    }
}
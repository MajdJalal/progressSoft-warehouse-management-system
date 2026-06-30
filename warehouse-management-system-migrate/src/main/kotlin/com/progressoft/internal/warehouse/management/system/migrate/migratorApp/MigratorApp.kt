package com.progressoft.internal.warehouse.management.system.migrate.migratorApp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MigratorApp

fun main(args: Array<String>) {
    runApplication<MigratorApp>(*args)
}

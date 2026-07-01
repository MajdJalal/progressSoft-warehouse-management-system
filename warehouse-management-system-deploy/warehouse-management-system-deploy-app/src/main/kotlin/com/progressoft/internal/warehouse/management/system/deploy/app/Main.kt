package com.progressoft.internal.warehouse.management.system.deploy.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity


@SpringBootApplication
@EnableMethodSecurity(securedEnabled = true)
class Main

fun main(args: Array<String>) {
    runApplication<Main>(*args)
}


package com.progressoft.internal.warehouse.management.system.starter.shared.web.filter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.filter.OncePerRequestFilter


@Configuration
class SharedWebConfiguration {

    @Bean
    fun whsAuthFilter(
    ): OncePerRequestFilter =
        WhsAuthFilter()
}
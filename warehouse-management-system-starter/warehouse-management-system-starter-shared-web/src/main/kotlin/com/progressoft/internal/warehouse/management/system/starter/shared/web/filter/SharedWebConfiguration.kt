package com.progressoft.internal.warehouse.management.system.starter.shared.web.filter

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter
import org.springframework.web.filter.OncePerRequestFilter


@Configuration
class SharedWebConfiguration {

    @Bean
    fun whsAuthFilter(
    ): OncePerRequestFilter =
        WhsAuthFilter()

    @Bean
    fun jwtAuthenticationConverter(): JwtAuthenticationConverter {
        val converter = JwtAuthenticationConverter()
        converter.setJwtGrantedAuthoritiesConverter { jwt ->
            val realmAccess = jwt.claims["realm_access"] as? Map<*, *>
            val roles = realmAccess?.get("roles") as? List<*> ?: emptyList<Any>()
            roles.map { SimpleGrantedAuthority("ROLE_${it.toString().uppercase()}") }
        }
        return converter
    }
}
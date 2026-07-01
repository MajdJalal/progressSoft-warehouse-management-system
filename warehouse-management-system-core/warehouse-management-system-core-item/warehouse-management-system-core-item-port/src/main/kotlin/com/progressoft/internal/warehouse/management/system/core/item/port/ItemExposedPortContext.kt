package com.progressoft.internal.warehouse.management.system.core.item.port

import com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.ExposedItemAuditStore
import com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.ExposedItemStore
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemAuditStore
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemStore
import org.jetbrains.exposed.v1.jdbc.Database
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class ItemExposedPortContext {

    @Bean
    fun itemStore(
        @Autowired(required = false) database: Database?
    ): ItemStore =
        ExposedItemStore(database)
}
package com.progressoft.internal.warehouse.management.system.core.warehouse.port

import com.progressoft.internal.warehouse.management.system.core.warehouse.adapter.exposed.ExposedWarehouseStore
import com.progressoft.internal.warehouse.management.system.core.warehouse.store.WarehouseStore
import org.jetbrains.exposed.v1.jdbc.Database
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class WarehouseExposedPortContext {


    @Bean
    fun warehouseStore(
        @Autowired(required = false) database : Database
    ) : WarehouseStore {
        return ExposedWarehouseStore(database)
    }
}
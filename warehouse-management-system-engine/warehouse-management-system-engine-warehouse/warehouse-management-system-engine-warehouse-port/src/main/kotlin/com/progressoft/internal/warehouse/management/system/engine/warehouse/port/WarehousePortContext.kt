package com.progressoft.internal.warehouse.management.system.engine.warehouse.port

import com.progressoft.internal.warehouse.management.system.core.warehouse.store.WarehouseStore
import com.progressoft.internal.warehouse.management.system.engine.warehouse.operation.WarehouseDomainSdkImpl
import com.progressoft.internal.warehouse.management.system.engine.warehouse.operation.WarehouseSdkImpl
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.WarehouseDomainSdk
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.WarehouseSdk
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class WarehousePortContext {

    @Bean
    fun warehouseSdk(
        @Autowired workhouseStore: WarehouseStore,
    ): WarehouseSdk {

        return WarehouseSdkImpl(workhouseStore)
    }

    @Bean
    fun warehouseDomainSdk(
        @Autowired workhouseStore: WarehouseStore
    ): WarehouseDomainSdk {

        return WarehouseDomainSdkImpl(workhouseStore)
    }
}
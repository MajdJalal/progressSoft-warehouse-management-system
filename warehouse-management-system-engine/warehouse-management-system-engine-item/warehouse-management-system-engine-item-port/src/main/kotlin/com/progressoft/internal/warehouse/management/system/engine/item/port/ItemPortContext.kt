package com.com.progressoft.internal.warehouse.management.system.engine.item.port

import com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.ExposedItemAuditStore
import com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.ExposedItemStore
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemStore
import com.progressoft.internal.warehouse.management.system.engine.item.operation.ItemSdkImpl
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.ItemSdk
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.WarehouseDomainSdk
import io.arkitik.radix.audit.operation.RadixAuditSdkImpl
import io.arkitik.radix.audit.sdk.RadixAuditSdk
import io.arkitik.radix.audit.store.AuditRecordStore
import org.jetbrains.exposed.v1.jdbc.Database
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ItemPortContext {


    @Bean
    fun itemAuditRecordStore(
        @Autowired(required = false) database: Database?,
    ): ExposedItemAuditStore =
        ExposedItemAuditStore(database)


    @Bean
    fun itemAuditSdk(
        itemAuditStore: AuditRecordStore<String, ItemDomain, ItemAuditDomain>,
    ): RadixAuditSdk<String, ItemDomain, ItemAuditDomain> =
        RadixAuditSdkImpl(
            auditRecordStore = itemAuditStore
        )

    @Bean
    fun itemSdk(
        itemStore: ItemStore,
        @Autowired warehouseDomainSdk: WarehouseDomainSdk,
        @Autowired itemAuditSdk: RadixAuditSdk<String, ItemDomain, ItemAuditDomain>
    ): ItemSdk = ItemSdkImpl(
        itemStore = itemStore,
        warehouseDomainSdk = warehouseDomainSdk,
        itemAuditSdk = itemAuditSdk,
    )

//    @Bean
//    fun itemDomainSdk(
//        itemStore: ItemStore,
//    ): ItemDomainSdk = ItemDomainSdkImpl(
//        itemStore = itemStore,
//    )
}
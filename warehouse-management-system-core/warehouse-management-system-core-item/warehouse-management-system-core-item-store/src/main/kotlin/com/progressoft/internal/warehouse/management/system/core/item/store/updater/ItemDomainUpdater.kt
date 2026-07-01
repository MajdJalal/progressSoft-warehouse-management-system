package com.progressoft.internal.warehouse.management.system.core.item.store.updater

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemStatus
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemUnit
import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater
import io.arkitik.radix.starter.audit.store.core.updater.AuditStoreIdentityUpdater

interface ItemDomainUpdater : AuditStoreIdentityUpdater<String, ItemDomain, ItemAuditDomain> {
    fun String.name(): ItemDomainUpdater
    fun ItemStatus.status(): ItemDomainUpdater
    fun String.description(): ItemDomainUpdater
    fun Int.quantity(): ItemDomainUpdater
    fun String.category(): ItemDomainUpdater
    fun ItemUnit.unit(): ItemDomainUpdater
    fun String.warehouseId(): ItemDomainUpdater
}
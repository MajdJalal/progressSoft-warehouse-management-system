package com.progressoft.internal.warehouse.management.system.core.warehouse.store.updater

import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseStatus
import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater

interface WarehouseUpdater : StoreIdentityUpdater<String, WarehouseDomain> {

    fun WarehouseStatus.status(): WarehouseUpdater
    fun String.name(): WarehouseUpdater
    fun String.description(): WarehouseUpdater
    fun String.address(): WarehouseUpdater
}
package com.progressoft.internal.warehouse.management.system.core.warehouse.store.creator

import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseStatus
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator

interface WarehouseCreator : StoreIdentityCreator<String, WarehouseDomain> {
    fun String.code(): WarehouseCreator
    fun String.name(): WarehouseCreator
    fun String.description(): WarehouseCreator
    fun String.address(): WarehouseCreator
    fun WarehouseStatus.status(): WarehouseCreator
}
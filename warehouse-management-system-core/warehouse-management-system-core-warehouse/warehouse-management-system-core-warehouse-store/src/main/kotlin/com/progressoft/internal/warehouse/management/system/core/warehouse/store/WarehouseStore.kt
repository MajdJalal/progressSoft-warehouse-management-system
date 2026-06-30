package com.progressoft.internal.warehouse.management.system.core.warehouse.store

import com.progressoft.internal.warehouse.management.system.core.warehouse.store.creator.WarehouseCreator
import com.progressoft.internal.warehouse.management.system.core.warehouse.store.query.WarehouseStoreQuery
import com.progressoft.internal.warehouse.management.system.core.warehouse.store.updater.WarehouseUpdater
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import io.arkitik.radix.develop.store.Store

interface WarehouseStore : Store<String, WarehouseDomain> {

    override val storeQuery: WarehouseStoreQuery
    override fun identityCreator(): WarehouseCreator
    override fun WarehouseDomain.identityUpdater(): WarehouseUpdater
}
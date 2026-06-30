package com.progressoft.internal.warehouse.management.system.core.warehouse.adapter.exposed

import com.progressoft.internal.warehouse.management.system.core.warehouse.adapter.exposed.creator.WarehouseCreatorImpl
import com.progressoft.internal.warehouse.management.system.core.warehouse.adapter.exposed.query.ExposedWarehouseStoreQuery
import com.progressoft.internal.warehouse.management.system.core.warehouse.adapter.exposed.updater.WarehouseUpdaterImpl
import com.progressoft.internal.warehouse.management.system.core.warehouse.entity.exposed.Warehouse
import com.progressoft.internal.warehouse.management.system.core.warehouse.entity.exposed.WarehouseTable
import com.progressoft.internal.warehouse.management.system.core.warehouse.store.WarehouseStore
import com.progressoft.internal.warehouse.management.system.core.warehouse.store.creator.WarehouseCreator
import com.progressoft.internal.warehouse.management.system.core.warehouse.store.query.WarehouseStoreQuery
import com.progressoft.internal.warehouse.management.system.core.warehouse.store.updater.WarehouseUpdater
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import io.arkitik.radix.adapter.exposed.ExposedStore
import org.jetbrains.exposed.v1.core.statements.UpdateBuilder
import org.jetbrains.exposed.v1.jdbc.Database

class ExposedWarehouseStore(
    database: Database?
) : ExposedStore<String, WarehouseDomain, WarehouseTable>(WarehouseTable), WarehouseStore {
    override val storeQuery: WarehouseStoreQuery = ExposedWarehouseStoreQuery(database)

    override fun identityCreator(): WarehouseCreator = WarehouseCreatorImpl()

    private fun WarehouseDomain.map(): Warehouse = this as Warehouse

    override fun WarehouseDomain.identityUpdater(): WarehouseUpdater = WarehouseUpdaterImpl(map())

    override fun <K : Any> UpdateBuilder<K>.createEntity(identity: WarehouseDomain) {
        this[identityTable.code] = identity.code
        this[identityTable.name] = identity.name
        this[identityTable.description] = identity.description
        this[identityTable.address] = identity.address
        this[identityTable.status] = identity.status
    }
}

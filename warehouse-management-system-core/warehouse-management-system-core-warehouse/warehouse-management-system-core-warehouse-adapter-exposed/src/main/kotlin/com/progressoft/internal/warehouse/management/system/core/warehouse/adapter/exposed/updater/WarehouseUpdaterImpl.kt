package com.progressoft.internal.warehouse.management.system.core.warehouse.adapter.exposed.updater

import com.progressoft.internal.warehouse.management.system.core.warehouse.entity.exposed.Warehouse
import com.progressoft.internal.warehouse.management.system.core.warehouse.store.updater.WarehouseUpdater
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseStatus

class WarehouseUpdaterImpl(
    private val warehouse: Warehouse
) : WarehouseUpdater {

    override fun WarehouseStatus.status(): WarehouseUpdater {
        this@WarehouseUpdaterImpl.warehouse.status = this
        return this@WarehouseUpdaterImpl
    }

    override fun String.name(): WarehouseUpdater {
        this@WarehouseUpdaterImpl.warehouse.name = this
        return this@WarehouseUpdaterImpl
    }

    override fun String.description(): WarehouseUpdater {
        this@WarehouseUpdaterImpl.warehouse.description = this
        return this@WarehouseUpdaterImpl
    }

    override fun String.address(): WarehouseUpdater {
        this@WarehouseUpdaterImpl.warehouse.address = this
        return this@WarehouseUpdaterImpl
    }

    override fun update(): WarehouseDomain {
        return warehouse
    }
}
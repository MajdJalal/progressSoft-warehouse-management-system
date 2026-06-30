package com.progressoft.internal.warehouse.management.system.engine.warehouse.operation.domain

import com.progressoft.internal.warehouse.management.system.core.warehouse.store.query.WarehouseStoreQuery
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.error.WarehouseErrors
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.shared.ext.resourceNotFound

class FindWarehouseById(
    private val warehouseQuery: WarehouseStoreQuery
) : Operation<String, WarehouseDomain> {
    override fun String.operate(): WarehouseDomain {
        return warehouseQuery.find(this)
            .resourceNotFound(WarehouseErrors.WAREHOUSE_DOES_NOT_EXIST)
    }
}
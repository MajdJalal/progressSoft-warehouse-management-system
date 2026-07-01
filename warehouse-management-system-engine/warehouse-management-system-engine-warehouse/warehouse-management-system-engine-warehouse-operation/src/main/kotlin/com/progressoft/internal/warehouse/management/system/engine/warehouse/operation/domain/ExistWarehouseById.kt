package com.progressoft.internal.warehouse.management.system.engine.warehouse.operation.domain

import com.progressoft.internal.warehouse.management.system.core.warehouse.store.query.WarehouseStoreQuery
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.error.WarehouseErrors
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.shared.exception.ResourceNotFoundException
import io.arkitik.radix.develop.store.exists

class ExistWarehouseById(
    private val warehouseQuery: WarehouseStoreQuery
) : Operation<String, Unit> {

    override fun String.operate() {
        if (!warehouseQuery.exists(this)) {
            throw ResourceNotFoundException(WarehouseErrors.WAREHOUSE_DOES_NOT_EXIST)
        }
    }
}
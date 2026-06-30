package com.progressoft.internal.warehouse.management.system.engine.warehouse.operation.main

import com.progressoft.internal.warehouse.management.system.core.warehouse.store.WarehouseStore
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.error.WarehouseErrors
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.DeactivateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseStatus
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.shared.ext.resourceNotFound
import io.arkitik.radix.develop.store.storeUpdaterWithUpdate

class DeactivateWarehouseOperation(
    private val warehouseStore: WarehouseStore
) : Operation<DeactivateWarehouseRequest, Unit> {
    override fun DeactivateWarehouseRequest.operate() {
        val warehouse = warehouseStore.storeQuery.findByCode(code)
            .resourceNotFound(WarehouseErrors.WAREHOUSE_DOES_NOT_EXIST)

        with(warehouseStore) {
            storeUpdaterWithUpdate(warehouse.identityUpdater()) {
                WarehouseStatus.INACTIVE.status()
                update()
            }
        }
    }
}
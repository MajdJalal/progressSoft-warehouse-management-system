package com.progressoft.internal.warehouse.management.system.engine.warehouse.operation.main

import com.progressoft.internal.warehouse.management.system.core.warehouse.store.WarehouseStore
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.error.WarehouseErrors
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.UpdateWarehouseRequest
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.shared.ext.resourceNotFound
import io.arkitik.radix.develop.store.storeUpdaterWithUpdate

class UpdateWarehouseOperation(
    private val warehouseStore: WarehouseStore
) : Operation<UpdateWarehouseRequest, Unit> {
    override fun UpdateWarehouseRequest.operate() {

        val warehouse = warehouseStore.storeQuery.findByCode(code)
            .resourceNotFound(WarehouseErrors.WAREHOUSE_DOES_NOT_EXIST)

        with(warehouseStore) {
            storeUpdaterWithUpdate(warehouse.identityUpdater()) {
                name?.name()
                description?.description()
                address?.address()
                update()
            }
        }

    }
}
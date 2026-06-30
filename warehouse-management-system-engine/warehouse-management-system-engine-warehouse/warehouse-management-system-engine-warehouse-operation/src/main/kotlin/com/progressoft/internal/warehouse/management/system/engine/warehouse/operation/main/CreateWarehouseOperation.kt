package com.progressoft.internal.warehouse.management.system.engine.warehouse.operation.main

import com.progressoft.internal.warehouse.management.system.core.warehouse.store.WarehouseStore
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.CreateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseStatus
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.store.storeCreatorWithInsert

class CreateWarehouseOperation(
    private val warehouseStore: WarehouseStore
) : Operation<CreateWarehouseRequest, Unit> {
    override fun CreateWarehouseRequest.operate() {
        with(warehouseStore) {
            storeCreatorWithInsert(identityCreator()) {
                this@operate.id.uuid()
                this@operate.code.code()
                this@operate.name.name()
                this@operate.description.description()
                this@operate.address.address()
                WarehouseStatus.ACTIVE.status()
                create()
            }
        }
    }
}
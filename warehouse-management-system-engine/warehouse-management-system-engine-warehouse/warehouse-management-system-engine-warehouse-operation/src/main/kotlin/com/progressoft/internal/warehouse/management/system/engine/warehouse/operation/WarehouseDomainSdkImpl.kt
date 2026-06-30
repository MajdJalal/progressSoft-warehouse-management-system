package com.progressoft.internal.warehouse.management.system.engine.warehouse.operation

import com.progressoft.internal.warehouse.management.system.core.warehouse.store.WarehouseStore
import com.progressoft.internal.warehouse.management.system.engine.warehouse.operation.domain.FindWarehouseById
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.WarehouseDomainSdk
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.operation.ext.operationBuilder

class WarehouseDomainSdkImpl(
    warehouseStore: WarehouseStore
) : WarehouseDomainSdk {
    override val findWarehouseById: Operation<String, WarehouseDomain> =
        operationBuilder {
            mainOperation(
                FindWarehouseById(
                    warehouseQuery = warehouseStore.storeQuery
                )
            )
        }

}
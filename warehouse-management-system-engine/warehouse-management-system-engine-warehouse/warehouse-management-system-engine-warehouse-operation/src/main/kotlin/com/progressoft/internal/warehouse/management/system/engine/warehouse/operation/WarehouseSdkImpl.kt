package com.progressoft.internal.warehouse.management.system.engine.warehouse.operation

import com.progressoft.internal.warehouse.management.system.core.warehouse.store.WarehouseStore
import com.progressoft.internal.warehouse.management.system.engine.warehouse.operation.main.*
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.WarehouseSdk
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.*
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.ViewWarehouseInventoryResponse
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.ViewWarehousesPaginationResponse
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.WarehouseResponse
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.operation.ext.JakartaValidator
import io.arkitik.radix.develop.operation.ext.operationBuilder

class WarehouseSdkImpl(
    warehouseStore: WarehouseStore,
) : WarehouseSdk {
    override val createWarehouse: Operation<CreateWarehouseRequest, Unit> =
        operationBuilder {
            install(JakartaValidator())

            mainOperation(
                CreateWarehouseOperation(warehouseStore)
            )
        }
    override val updateWarehouse: Operation<UpdateWarehouseRequest, Unit> =
        operationBuilder {
            install(JakartaValidator())

            mainOperation(
                UpdateWarehouseOperation(
                    warehouseStore
                )
            )
        }

    override val deactivateWarehouse: Operation<DeactivateWarehouseRequest, Unit> =
        operationBuilder {
            install(JakartaValidator())

            mainOperation(
                DeactivateWarehouseOperation(warehouseStore)
            )
        }

    override val viewAllWarehouses: Operation<ViewWarehousesRequest, ViewWarehousesPaginationResponse<WarehouseResponse>> =
        operationBuilder {
            install(JakartaValidator())

            mainOperation(
                ViewAllWarehousesOperation(warehouseStore)
            )
        }
//
//    override val viewWarehouseInventory: Operation<ViewWarehouseInventoryRequest, ViewWarehouseInventoryResponse> =
//        operationBuilder {
//            install(JakartaValidator())
//
//            mainOperation(
//                ViewWarehouseInventoryOperation(
//                    itemDomainSdk
//                )
//            )
//        }


}
package com.progressoft.internal.warehouse.management.system.api.warehouse.controller

import com.progressoft.internal.warehouse.management.system.api.warehouse.contract.WarehouseContract
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.WarehouseSdk
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.CreateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.DeactivateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.UpdateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.ViewWarehousesRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.ViewWarehousesPaginationResponse
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.WarehouseResponse
import io.arkitik.radix.develop.operation.ext.runOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class WarehouseController(
    val warehouseSdk: WarehouseSdk
) : WarehouseContract {
    override fun createWarehouse(request: CreateWarehouseRequest): ResponseEntity<Unit> {
        warehouseSdk.createWarehouse.runOperation(request)
        return ResponseEntity.ok().build()
    }

    override fun deactivateWarehouse(request: DeactivateWarehouseRequest): ResponseEntity<Unit> {
        warehouseSdk.deactivateWarehouse.runOperation(request)
        return ResponseEntity.ok().build()
    }

    override fun viewWarehouses(request: ViewWarehousesRequest): ResponseEntity<ViewWarehousesPaginationResponse<WarehouseResponse>> {
        val response: ViewWarehousesPaginationResponse<WarehouseResponse> =
            warehouseSdk.viewAllWarehouses.runOperation(request)
        return ResponseEntity.ok().body(response)
    }

    override fun updateWarehouse(request: UpdateWarehouseRequest): ResponseEntity<Unit> {
        warehouseSdk.updateWarehouse.runOperation(request)
        return ResponseEntity.ok().build()
    }

//    override fun viewInventory(
//        warehouseId: String,
//        page: Int,
//        size: Int
//    ): ResponseEntity<ViewWarehouseInventoryResponse> {
//        val viewWarehouseInventoryRequest = ViewWarehouseInventoryRequest(warehouseId, page, size)
//        val warehouseInventoryResponse: ViewWarehouseInventoryResponse =
//            warehouseSdk.viewWarehouseInventory.runOperation(viewWarehouseInventoryRequest)
//        return ResponseEntity.ok().body(warehouseInventoryResponse)
//    }
}
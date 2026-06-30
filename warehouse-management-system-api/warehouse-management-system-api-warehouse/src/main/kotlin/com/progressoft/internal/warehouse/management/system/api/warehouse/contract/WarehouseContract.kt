package com.progressoft.internal.warehouse.management.system.api.warehouse.contract

import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.CreateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.DeactivateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.UpdateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.ViewWarehousesRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.ViewWarehouseInventoryResponse
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.ViewWarehousesPaginationResponse
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.WarehouseResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


interface WarehouseContract {


    @PostMapping("/v1/warehouses/create")
    fun createWarehouse(
        @RequestBody request: CreateWarehouseRequest
    ): ResponseEntity<Unit>

    @PostMapping("/v1/warehouses/deactivate")
    fun deactivateWarehouse(
        @RequestBody request: DeactivateWarehouseRequest
    ): ResponseEntity<Unit>

    @GetMapping("/v1/warehouses")
    fun viewWarehouses(
        @RequestBody request: ViewWarehousesRequest
    ): ResponseEntity<ViewWarehousesPaginationResponse<WarehouseResponse>>

    @PatchMapping("/v1/warehouses")
    fun updateWarehouse(
        @RequestBody request: UpdateWarehouseRequest
    ): ResponseEntity<Unit>
//
//    @GetMapping("/v1/warehouses/inventory/{warehouseId}")
//    fun viewInventory(
//        @PathVariable("warehouseId") warehouseId: String,
//        @RequestParam("page") page: Int = 0,
//        @RequestParam("size") size: Int = 10
//    ): ResponseEntity<ViewWarehouseInventoryResponse>
}
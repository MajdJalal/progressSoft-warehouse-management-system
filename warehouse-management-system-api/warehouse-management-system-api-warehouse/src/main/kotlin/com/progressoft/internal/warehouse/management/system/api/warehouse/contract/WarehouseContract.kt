package com.progressoft.internal.warehouse.management.system.api.warehouse.contract

import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.CreateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.DeactivateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.UpdateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.ViewWarehousesRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.ViewWarehousesPaginationResponse
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.WarehouseResponse
import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody


interface WarehouseContract {


    @PostMapping("/v1/warehouses/create")
    @PreAuthorize("hasRole('ADMIN')")
    fun createWarehouse(
        @RequestBody request: CreateWarehouseRequest
    ): ResponseEntity<Unit>

    @PostMapping("/v1/warehouses/deactivate")
    @PreAuthorize("hasRole('ADMIN')")
    fun deactivateWarehouse(
        @RequestBody request: DeactivateWarehouseRequest
    ): ResponseEntity<Unit>

    @GetMapping("/v1/warehouses")
    @PreAuthorize("hasRole('ADMIN')")
    fun viewWarehouses(
        @RequestBody request: ViewWarehousesRequest
    ): ResponseEntity<ViewWarehousesPaginationResponse<WarehouseResponse>>

    @PatchMapping("/v1/warehouses")
    @PreAuthorize("hasRole('ADMIN')")
    fun updateWarehouse(
        @RequestBody request: UpdateWarehouseRequest
    ): ResponseEntity<Unit>
}
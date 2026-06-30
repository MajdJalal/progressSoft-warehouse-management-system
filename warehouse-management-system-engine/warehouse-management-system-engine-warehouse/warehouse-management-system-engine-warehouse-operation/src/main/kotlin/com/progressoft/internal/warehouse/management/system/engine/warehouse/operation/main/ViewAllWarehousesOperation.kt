package com.progressoft.internal.warehouse.management.system.engine.warehouse.operation.main

import com.progressoft.internal.warehouse.management.system.core.warehouse.store.WarehouseStore
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.ViewWarehousesRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.ViewWarehousesPaginationResponse
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.WarehouseResponse
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.store.query.PageData

class ViewAllWarehousesOperation(
    private val warehouseStore: WarehouseStore,
) : Operation<ViewWarehousesRequest, ViewWarehousesPaginationResponse<WarehouseResponse>> {
    override fun ViewWarehousesRequest.operate(): ViewWarehousesPaginationResponse<WarehouseResponse> {
        val all: PageData<WarehouseDomain> = warehouseStore.storeQuery.all(page, size)
        val content = all.content
            .map { warehouseResponse ->
                WarehouseResponse(
                    warehouseResponse.name,
                    warehouseResponse.description
                )
            }

        return ViewWarehousesPaginationResponse(
            content = content,
            numberOfElements = all.numberOfElements,
            totalElements = all.totalElements,
            totalPages = all.totalPages,
            currentPage = all.currentPage,
            currentPageSize = all.currentPageSize
        )
    }
}
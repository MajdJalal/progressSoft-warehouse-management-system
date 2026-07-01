package com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk

import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.CreateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.DeactivateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.UpdateWarehouseRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.ViewWarehousesRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.ViewWarehousesPaginationResponse
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.WarehouseResponse
import io.arkitik.radix.develop.operation.Operation

interface WarehouseSdk {
    val createWarehouse: Operation<CreateWarehouseRequest, Unit>
    val updateWarehouse: Operation<UpdateWarehouseRequest, Unit>
    val deactivateWarehouse: Operation<DeactivateWarehouseRequest, Unit>
    val viewAllWarehouses: Operation<ViewWarehousesRequest, ViewWarehousesPaginationResponse<WarehouseResponse>>
}
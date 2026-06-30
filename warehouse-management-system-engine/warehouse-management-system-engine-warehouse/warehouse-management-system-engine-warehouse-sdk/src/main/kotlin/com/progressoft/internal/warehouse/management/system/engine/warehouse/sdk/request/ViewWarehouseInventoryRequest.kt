package com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request

data class ViewWarehouseInventoryRequest(
    val warehouseId: String,
    val page : Int,
    val size : Int
)
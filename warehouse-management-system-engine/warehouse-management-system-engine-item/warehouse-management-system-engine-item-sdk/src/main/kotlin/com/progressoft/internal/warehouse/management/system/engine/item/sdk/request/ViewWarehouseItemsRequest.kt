package com.progressoft.internal.warehouse.management.system.engine.item.sdk.request

data class ViewWarehouseItemsRequest(
    val warehouseId: String,
    val page: Int,
    val size: Int
)

package com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemResponse

class ViewWarehouseInventoryResponse(
    val warehouseId: String,
    val items: List<ItemResponse>
)
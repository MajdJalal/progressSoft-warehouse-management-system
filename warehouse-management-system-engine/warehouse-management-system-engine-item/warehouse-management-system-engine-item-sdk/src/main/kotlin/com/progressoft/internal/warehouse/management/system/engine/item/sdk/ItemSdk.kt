package com.progressoft.internal.warehouse.management.system.engine.item.sdk

import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.*
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemAuditResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemHistoryPaginationResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemsPaginationResponse
import io.arkitik.radix.develop.operation.Operation

interface ItemSdk {
    val createItem: Operation<CreateItemRequest, Unit>
    val updateItem: Operation<UpdateItemRequest, Unit>
    val deactivateItem: Operation<DeactivateItemRequest, Unit>
    val viewAllItems: Operation<ViewItemsRequest, ViewItemsPaginationResponse<ItemResponse>>
    val viewItemHistory: Operation<ViewItemHistoryRequest, ViewItemHistoryPaginationResponse<ItemAuditResponse>>
}
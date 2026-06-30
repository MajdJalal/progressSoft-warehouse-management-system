package com.progressoft.internal.warehouse.management.system.engine.item.sdk

import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.CreateItemRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.DeactivateItemRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.UpdateItemRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.ViewItemsRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemsPaginationResponse
import io.arkitik.radix.develop.operation.Operation

interface ItemSdk {
    val createItem: Operation<CreateItemRequest, Unit>
    val updateItem: Operation<UpdateItemRequest, Unit>
    val deactivateItem: Operation<DeactivateItemRequest, Unit>
    val viewAllItems: Operation<ViewItemsRequest, ViewItemsPaginationResponse<ItemResponse>>
}
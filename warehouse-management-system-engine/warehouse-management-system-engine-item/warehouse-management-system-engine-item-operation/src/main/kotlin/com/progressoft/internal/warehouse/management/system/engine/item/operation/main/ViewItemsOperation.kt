package com.progressoft.internal.warehouse.management.system.engine.item.operation.main

import com.progressoft.internal.warehouse.management.system.core.item.store.ItemStore
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.ViewItemsRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemsPaginationResponse
import io.arkitik.radix.develop.operation.Operation

class ViewItemsOperation(
    private val itemStore: ItemStore,
) : Operation<ViewItemsRequest, ViewItemsPaginationResponse<ItemResponse>> {
    override fun ViewItemsRequest.operate(): ViewItemsPaginationResponse<ItemResponse> {
        val all = itemStore.storeQuery.queryItems(this)
        val content = all.content
            .map { itemDomain ->
                ItemResponse(
                    itemDomain.name,
                    itemDomain.description
                )
            }

        return ViewItemsPaginationResponse(
            content = content,
            numberOfElements = all.numberOfElements,
            totalElements = all.totalElements,
            totalPages = all.totalPages,
            currentPage = all.currentPage,
            currentPageSize = all.currentPageSize
        )
    }
}

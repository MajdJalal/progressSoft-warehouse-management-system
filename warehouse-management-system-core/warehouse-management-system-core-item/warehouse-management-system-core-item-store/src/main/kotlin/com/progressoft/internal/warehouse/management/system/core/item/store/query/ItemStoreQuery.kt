package com.progressoft.internal.warehouse.management.system.core.item.store.query

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.ViewItemsRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemsResponse
import io.arkitik.radix.develop.store.query.PageData
import io.arkitik.radix.develop.store.query.StoreQuery

interface ItemStoreQuery : StoreQuery<String, ItemDomain> {

    fun findByCode(itemCode: String): ItemDomain?
    fun existByCode(itemCode: String): Boolean
    fun findByWarehouseId(warehouseId: String, page: Int, size: Int): PageData<ItemDomain>
    fun queryItems(viewItemsRequest: ViewItemsRequest): PageData<ItemDomain>

}
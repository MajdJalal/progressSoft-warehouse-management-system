//package com.progressoft.internal.warehouse.management.system.engine.warehouse.operation.main
//
//import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
//import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.ViewWarehouseItemsRequest
//import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemResponse
//import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemsPaginationResponse
//import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request.ViewWarehouseInventoryRequest
//import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response.ViewWarehouseInventoryResponse
//import io.arkitik.radix.develop.operation.Operation
//import io.arkitik.radix.develop.operation.ext.runOperation
//
//class ViewWarehouseInventoryOperation(
//    private val itemDomainSdk: ItemDomainSdk
//) : Operation<ViewWarehouseInventoryRequest, ViewWarehouseInventoryResponse> {
//
//    override fun ViewWarehouseInventoryRequest.operate(): ViewWarehouseInventoryResponse {
//        val itemsPaged: ViewItemsPaginationResponse<ItemDomain> =
//            itemDomainSdk.findWarehouseItems.runOperation(ViewWarehouseItemsRequest(warehouseId, page, size))
//
//        val items = itemsPaged.content.map { item -> ItemResponse(item.name, item.description) }
//
//
//        return ViewWarehouseInventoryResponse(warehouseId, items)
//    }
//}
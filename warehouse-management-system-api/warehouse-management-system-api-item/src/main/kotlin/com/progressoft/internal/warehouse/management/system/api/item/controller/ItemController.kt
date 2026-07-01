package com.progressoft.internal.warehouse.management.system.api.item.controller

import com.progressoft.internal.warehouse.management.system.api.item.contract.ItemContract
import com.progressoft.internal.warehouse.management.system.api.item.model.DeactivateItemModel
import com.progressoft.internal.warehouse.management.system.api.item.model.TransferItemModel
import com.progressoft.internal.warehouse.management.system.api.item.model.ViewItemHistoryQueryModel
import com.progressoft.internal.warehouse.management.system.api.item.model.ViewItemsQueryModel
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.ItemSdk
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.*
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemAuditResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemHistoryPaginationResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemsPaginationResponse
import io.arkitik.radix.develop.operation.ext.runOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemController(
    val itemSdk: ItemSdk
) : ItemContract {
    override fun createItem(request: CreateItemRequest): ResponseEntity<Unit> {
        itemSdk.createItem.runOperation(request)
        return ResponseEntity.ok().build()
    }

    override fun deactivateItem(request: DeactivateItemModel): ResponseEntity<Unit> {
        itemSdk.deactivateItem.runOperation(
            DeactivateItemRequest(
                code = request.code,
                actorId = request.actorId,
                actorType = request.actorType,
            )
        )
        return ResponseEntity.ok().build()
    }

    override fun updateItem(request: UpdateItemRequest): ResponseEntity<Unit> {
        itemSdk.updateItem.runOperation(request)
        return ResponseEntity.ok().build()
    }

    override fun viewItems(model: ViewItemsQueryModel): ResponseEntity<ViewItemsPaginationResponse<ItemResponse>> {
        val request =
            ViewItemsRequest(
                warehouseId = model.warehouseId,
                page = model.page,
                size = model.size
            )
        val items = itemSdk.viewAllItems
            .runOperation(
                request
            )
        return ResponseEntity.ok()
            .body(items)
    }

    override fun viewItemHistory(model: ViewItemHistoryQueryModel): ResponseEntity<ViewItemHistoryPaginationResponse<ItemAuditResponse>> {
        val request =
            ViewItemHistoryRequest(
                id = model.itemId,
                model.page,
                model.size
            )
        val result =
            itemSdk.viewItemHistory.runOperation(request)
        return ResponseEntity.ok().body(result)
    }

    override fun updateItem(model: TransferItemModel): ResponseEntity<Unit> {
        val request =
            TransferItemRequest(
                itemId = model.itemId,
                newWarehouseId = model.newWarehouseId,
                actorId = model.actorId,
                actorType = model.actorType,
            )
        itemSdk.transferItem.runOperation(request)
        return ResponseEntity.ok().build()
    }
}
package com.progressoft.internal.warehouse.management.system.api.item.controller

import com.progressoft.internal.warehouse.management.system.api.item.contract.ItemContract
import com.progressoft.internal.warehouse.management.system.api.item.model.DeactivateItemModel
import com.progressoft.internal.warehouse.management.system.api.item.model.ViewItemsQueryModel
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.ItemSdk
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.CreateItemRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.DeactivateItemRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.UpdateItemRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.ViewItemsRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemResponse
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
}
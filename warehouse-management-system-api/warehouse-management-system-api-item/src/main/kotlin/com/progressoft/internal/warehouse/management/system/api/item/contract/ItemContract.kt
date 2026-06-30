package com.progressoft.internal.warehouse.management.system.api.item.contract

import com.progressoft.internal.warehouse.management.system.api.item.model.DeactivateItemModel
import com.progressoft.internal.warehouse.management.system.api.item.model.ViewItemsQueryModel
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.CreateItemRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.UpdateItemRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemsPaginationResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

interface ItemContract {

    @PostMapping("/v1/items")
    fun createItem(
        @RequestBody request: CreateItemRequest
    ): ResponseEntity<Unit>

    @PostMapping("/v1/items/deactivate")
    fun deactivateItem(
        @RequestBody request: DeactivateItemModel
    ): ResponseEntity<Unit>

    @GetMapping("/v1/items")
    fun viewItems(
        model: ViewItemsQueryModel
    ): ResponseEntity<ViewItemsPaginationResponse<ItemResponse>>

    @PatchMapping("/v1/items")
    fun updateItem(
        @RequestBody request: UpdateItemRequest
    ): ResponseEntity<Unit>
}
package com.progressoft.internal.warehouse.management.system.engine.item.sdk.request

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemUnit
import io.arkitik.radix.audit.domain.embedded.ActorType
import jakarta.validation.constraints.NotBlank

data class CreateItemRequest(
    @get:NotBlank("Id is required")
    val id: String?,
    val warehouseId: String,
    val code: String,
    @get:NotBlank("Name is required")
    val name: String,
    val description: String,
    val category: String,
    val unit: ItemUnit,
    val quantity: Int,
    val actorType: String,
    val actorId: String
)
package com.progressoft.internal.warehouse.management.system.engine.item.sdk.request

import jakarta.validation.constraints.NotBlank

data class TransferItemRequest(
    @get:NotBlank(message = "Name cannot be blank")
    val itemId: String,
    @get:NotBlank(message = "new warehouse id cannot be blank")
    val newWarehouseId: String,
    @get:NotBlank(message = "actor id cannot be blank")
    val actorId: String,
    @get:NotBlank(message = "actor type cannot be blank")
    val actorType: String
)

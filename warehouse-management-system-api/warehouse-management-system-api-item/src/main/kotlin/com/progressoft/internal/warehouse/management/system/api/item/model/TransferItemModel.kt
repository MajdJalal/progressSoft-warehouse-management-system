package com.progressoft.internal.warehouse.management.system.api.item.model

import jakarta.validation.constraints.NotBlank

data class TransferItemModel(
    @get:NotBlank(message = "Name cannot be blank")
    val itemId: String,
    @get:NotBlank(message = "new warehouse id cannot be blank")
    val newWarehouseId: String,
    @get:NotBlank(message = "actor id cannot be blank")
    val actorId: String,
    @get:NotBlank(message = "actor type cannot be blank")
    val actorType: String
)
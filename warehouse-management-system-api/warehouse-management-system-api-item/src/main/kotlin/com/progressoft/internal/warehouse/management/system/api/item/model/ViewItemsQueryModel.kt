package com.progressoft.internal.warehouse.management.system.api.item.model

import jakarta.validation.constraints.NotBlank

data class ViewItemsQueryModel(
    @get:NotBlank(message = "warehouse id must not be blank")
    val warehouseId: String,
    val page : Int = 0,
    val size : Int = 10
)
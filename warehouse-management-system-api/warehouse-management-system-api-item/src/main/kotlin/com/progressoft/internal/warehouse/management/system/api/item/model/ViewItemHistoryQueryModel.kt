package com.progressoft.internal.warehouse.management.system.api.item.model

import jakarta.validation.constraints.NotBlank

data class ViewItemHistoryQueryModel(
    @get:NotBlank("item id must not be blank")
    val itemId: String,
    val page : Int = 0,
    val size: Int = 10,

)
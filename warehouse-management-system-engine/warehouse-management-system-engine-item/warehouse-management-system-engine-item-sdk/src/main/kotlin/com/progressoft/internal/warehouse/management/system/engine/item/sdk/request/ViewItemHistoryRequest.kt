package com.progressoft.internal.warehouse.management.system.engine.item.sdk.request

import jakarta.validation.constraints.NotBlank

data class ViewItemHistoryRequest (
    @get:NotBlank("Id is required")
    val id: String,
    val page : Int,
    val size : Int
)
package com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.request

import jakarta.validation.constraints.NotBlank

class CreateWarehouseRequest(
    @get:NotBlank("Id is required")
    val id: String,
    val code: String,
    @get:NotBlank("Name is required")
    val name: String,
    val description: String,
    val address: String,
)
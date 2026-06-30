package com.progressoft.internal.warehouse.management.system.api.item.model

import jakarta.validation.constraints.NotBlank

data class DeactivateItemModel(
    @get:NotBlank(message = "item code must not be blank")
    val code: String,
    @get:NotBlank(message = "actorId must not be blank")
    val actorId: String,
    @get:NotBlank(message = "actorType  must not be blank")
    val actorType: String
)
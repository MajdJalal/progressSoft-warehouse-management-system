package com.progressoft.internal.warehouse.management.system.engine.item.sdk.request

data class DeactivateItemRequest(
    val code: String,
    val actorId: String,
    val actorType: String
)
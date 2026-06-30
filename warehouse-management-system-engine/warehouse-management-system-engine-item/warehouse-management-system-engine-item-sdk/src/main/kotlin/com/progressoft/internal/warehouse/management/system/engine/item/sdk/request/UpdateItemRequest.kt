package com.progressoft.internal.warehouse.management.system.engine.item.sdk.request

data class UpdateItemRequest(
    val code: String,
    val name: String?,
    val description: String?,
    val category: String?,
    val quantity: Int?,
    val actorId: String,
    val actorType: String
)
package com.progressoft.internal.warehouse.management.system.engine.item.sdk.errors

import io.arkitik.radix.develop.shared.error.ErrorResponse

enum class ItemErrors(
    override val code: String?,
    override val message: String?
) : ErrorResponse {

    ITEM_ALREADY_FOUND(
        "WSH-ITEM-1000",
        "Item already exists"
    ),

    ITEM_DOES_NOT_EXIST(
        "WSH-ITEM-1100",
        "Item does not exist"
    )
}
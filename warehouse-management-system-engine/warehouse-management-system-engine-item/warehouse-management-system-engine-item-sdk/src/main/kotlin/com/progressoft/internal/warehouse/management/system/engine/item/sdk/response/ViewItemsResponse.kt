package com.progressoft.internal.warehouse.management.system.engine.item.sdk.response

data class ViewItemsResponse<T>(
    val content: List<T>,
    val numberOfElements: Int,
    val totalElements: Long,
    val pageNumber: Int,
)
package com.progressoft.internal.warehouse.management.system.engine.item.sdk.response

class ViewItemsPaginationResponse<T>(
    val content: List<T>,
    val numberOfElements: Int,
    val totalElements: Long,
    val totalPages: Int,
    val currentPage: Int,
    val currentPageSize: Int,
)
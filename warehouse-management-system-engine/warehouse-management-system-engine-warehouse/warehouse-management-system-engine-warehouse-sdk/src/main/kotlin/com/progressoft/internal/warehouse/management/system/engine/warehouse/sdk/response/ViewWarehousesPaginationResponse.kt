package com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.response

class ViewWarehousesPaginationResponse<T>(
    val content: List<T>,
    val numberOfElements: Int,
    val totalElements: Long,
    val totalPages: Int,
    val currentPage: Int,
    val currentPageSize: Int,
)
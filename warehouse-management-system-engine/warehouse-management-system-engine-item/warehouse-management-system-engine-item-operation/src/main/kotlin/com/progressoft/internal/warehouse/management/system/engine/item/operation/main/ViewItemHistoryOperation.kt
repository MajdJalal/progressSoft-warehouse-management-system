package com.progressoft.internal.warehouse.management.system.engine.item.operation.main

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemAuditStore
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.ViewItemHistoryRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemAuditResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemHistoryPaginationResponse
import io.arkitik.radix.audit.store.query.OrderProperty
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.store.PageableData
import io.arkitik.radix.develop.store.query.PageData

class ViewItemHistoryOperation(
    private val itemAuditStore: ItemAuditStore,
) : Operation<ViewItemHistoryRequest, ViewItemHistoryPaginationResponse<ItemAuditResponse>> {


    override fun ViewItemHistoryRequest.operate(): ViewItemHistoryPaginationResponse<ItemAuditResponse> {
        val all: PageData<ItemAuditDomain> = itemAuditStore.storeQuery
            .findAllOrderedBy(
                sorting = listOf(OrderProperty("actor_id", true)),
                pageableData = PageableData(page, size),
            )

        val content: List<ItemAuditResponse> = all.content
            .map { itemAuditDomain ->
                ItemAuditResponse(
                    itemAuditDomain.actorId,
                    itemAuditDomain.actorType,
                    itemAuditDomain.changeType,
                    itemAuditDomain.keyName,
                    itemAuditDomain.oldValue,
                    itemAuditDomain.newValue,
                    itemAuditDomain.record.uuid

                )
            }

        return ViewItemHistoryPaginationResponse(
            content = content,
            numberOfElements = all.numberOfElements,
            totalElements = all.totalElements,
            totalPages = all.totalPages,
            currentPage = all.currentPage,
            currentPageSize = all.currentPageSize
        )

    }
}
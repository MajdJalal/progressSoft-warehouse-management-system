package com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.query

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.entity.exposed.ItemTable
import com.progressoft.internal.warehouse.management.system.core.item.store.query.ItemStoreQuery
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.ViewItemsRequest
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemsResponse
import io.arkitik.radix.adapter.exposed.query.ExposedStoreQuery
import io.arkitik.radix.develop.exposed.table.ensureInTransaction
import io.arkitik.radix.develop.store.query.PageData
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.Query
import org.jetbrains.exposed.v1.jdbc.select

class ExposedItemStoreQuery(
    database: Database?
) : ExposedStoreQuery<String, ItemDomain, ItemTable>(ItemTable, database),
    ItemStoreQuery {
    override fun findByCode(itemCode: String): ItemDomain? {
        return ensureInTransaction(database) {
            identityTable
                .select(identityTable.columns)
                .where { identityTable.code eq itemCode }
                .singleOrNull()
                ?.let { resultRow -> identityTable.mapToIdentity(resultRow, database) }
        }
    }

    override fun existByCode(itemCode: String): Boolean {
        return ensureInTransaction(database) {
            identityTable
                .select(identityTable.columns)
                .where { identityTable.code eq itemCode }
                .exist()
        }
    }

    override fun findByWarehouseId(
        warehouseId: String,
        page: Int,
        size: Int
    ): PageData<ItemDomain> {
        return ensureInTransaction(database) {
            identityTable
                .select(identityTable.columns)
                .where { identityTable.warehouse eq warehouseId }
                .paged(page, size)
        }
    }

    override fun queryItems(viewItemsRequest: ViewItemsRequest): PageData<ItemDomain> {
        val q: Query = identityTable
            .select(identityTable.columns)

        viewItemsRequest.warehouseId?.let { q.where(identityTable.warehouse eq it) }
        return q.paged(page = viewItemsRequest.page, size = viewItemsRequest.size)

    }
}
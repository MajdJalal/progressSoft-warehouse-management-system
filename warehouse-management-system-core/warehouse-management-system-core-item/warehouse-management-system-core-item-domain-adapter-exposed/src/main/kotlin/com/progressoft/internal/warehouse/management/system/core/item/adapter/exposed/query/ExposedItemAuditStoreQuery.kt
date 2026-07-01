package com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.query

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.entity.exposed.ItemAuditTable
import io.arkitik.radix.adapter.exposed.query.ExposedStoreQuery
import io.arkitik.radix.audit.store.query.AuditRecordStoreQuery
import io.arkitik.radix.audit.store.query.OrderProperty
import io.arkitik.radix.develop.exposed.table.ensureInTransaction
import io.arkitik.radix.develop.store.PageableData
import io.arkitik.radix.develop.store.query.PageData
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.select

class ExposedItemAuditStoreQuery(
    database: Database?
) : ExposedStoreQuery<String, ItemAuditDomain, ItemAuditTable>(
    ItemAuditTable,
    database
), AuditRecordStoreQuery<String, ItemDomain, ItemAuditDomain> {

    override fun findAllOrderedBy(
        sorting: List<OrderProperty>,
        pageableData: PageableData
    ): PageData<ItemAuditDomain> = ensureInTransaction {
        identityTable.select(identityTable.columns)
            .paged(pageableData.page, pageableData.size)
    }

    override fun findAllByRecordUuidInOrderedBy(
        recordUuids: List<String>,
        sorting: List<OrderProperty>,
        pageableData: PageableData
    ): PageData<ItemAuditDomain> {
        TODO("Not yet implemented")
    }

    override fun findAllByKeyNameInOrderedBy(
        keys: List<String>,
        sorting: List<OrderProperty>,
        pageableData: PageableData
    ): PageData<ItemAuditDomain> {
        TODO("Not yet implemented")
    }

    override fun findAllByKeyNameInAndRecordUuidInOrderedBy(
        keys: List<String>,
        recordUuids: List<String>,
        sorting: List<OrderProperty>,
        pageableData: PageableData
    ): PageData<ItemAuditDomain> {
        TODO("Not yet implemented")
    }


}
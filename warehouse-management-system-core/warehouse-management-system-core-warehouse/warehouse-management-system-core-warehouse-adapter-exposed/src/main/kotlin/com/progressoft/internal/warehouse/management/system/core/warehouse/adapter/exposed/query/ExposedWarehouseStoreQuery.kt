package com.progressoft.internal.warehouse.management.system.core.warehouse.adapter.exposed.query

import com.progressoft.internal.warehouse.management.system.core.warehouse.entity.exposed.WarehouseTable
import com.progressoft.internal.warehouse.management.system.core.warehouse.store.query.WarehouseStoreQuery
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import io.arkitik.radix.adapter.exposed.query.ExposedStoreQuery
import io.arkitik.radix.develop.exposed.table.ensureInTransaction
import org.jetbrains.exposed.v1.core.eq
import org.jetbrains.exposed.v1.jdbc.Database
import org.jetbrains.exposed.v1.jdbc.select

class ExposedWarehouseStoreQuery(
    database: Database?
) : ExposedStoreQuery<String, WarehouseDomain, WarehouseTable>(WarehouseTable, database), WarehouseStoreQuery {
    override fun findByCode(code: String): WarehouseDomain? {
        return ensureInTransaction(database) {
            identityTable.select(identityTable.columns)
                .where {
                    identityTable.code eq code
                }.singleOrNull()
                ?.let { resultRow -> identityTable.mapToIdentity(resultRow, database) }
        }
    }
}
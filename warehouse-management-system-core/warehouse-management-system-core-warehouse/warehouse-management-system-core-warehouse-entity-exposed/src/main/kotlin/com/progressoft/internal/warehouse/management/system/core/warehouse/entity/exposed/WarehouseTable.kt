package com.progressoft.internal.warehouse.management.system.core.warehouse.entity.exposed

import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseStatus
import io.arkitik.radix.develop.exposed.table.RadixTable
import org.jetbrains.exposed.v1.core.ResultRow
import org.jetbrains.exposed.v1.jdbc.Database


object WarehouseTable : RadixTable<String, WarehouseDomain>("wms_warehouse") {
    override val uuid = varchar(name = "id", length = 32)
    val code = varchar(name = "code", length = 32).uniqueIndex()
    val name = varchar(name = "name", length = 32)
    val address = varchar(name = "address", length = 32)
    val description = varchar(name = "description", length = 32)
    val status = enumerationByName<WarehouseStatus>("status", 32)

    override val primaryKey = PrimaryKey(uuid)

    override fun mapToIdentity(
        resultRow: ResultRow,
        database: Database?
    ) = Warehouse(
        uuid = resultRow[uuid],
        code = resultRow[code],
        name = resultRow[name],
        description = resultRow[description],
        address = resultRow[address],
        status = resultRow[status],
        creationDate = resultRow[creationDate],
    )
}
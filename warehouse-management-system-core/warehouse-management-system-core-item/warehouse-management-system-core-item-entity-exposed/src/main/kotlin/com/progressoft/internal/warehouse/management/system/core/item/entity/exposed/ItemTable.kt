package com.progressoft.internal.warehouse.management.system.core.item.entity.exposed

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemStatus
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemUnit
import com.progressoft.internal.warehouse.management.system.core.warehouse.entity.exposed.WarehouseTable
import io.arkitik.radix.develop.exposed.table.RadixTable
import org.jetbrains.exposed.v1.core.ResultRow
import org.jetbrains.exposed.v1.jdbc.Database

object ItemTable : RadixTable<String, ItemDomain>("wms_item") {
    override val uuid = varchar(name = "id", length = 32)
    val code = varchar(name = "code", length = 32).uniqueIndex()
    val name = varchar(name = "name", length = 32)
    val description = varchar(name = "description", length = 32)
    val category = varchar(name = "category", length = 32)
    val unit = enumerationByName<ItemUnit>("unit", 32)
    val status = enumerationByName<ItemStatus>("status", 32)
    val quantity = integer("quantity")
    override val primaryKey = PrimaryKey(uuid)


    val warehouse = reference(
        name = "warehouse_id",
        fkName = "item_warehouse_fk",
        refColumn = WarehouseTable.uuid
    )


    override fun mapToIdentity(
        resultRow: ResultRow,
        database: Database?
    ) = Item(
        uuid = resultRow[uuid],
        code = resultRow[code],
        name = resultRow[name],
        description = resultRow[description],
        category = resultRow[category],
        unit = resultRow[unit],
        status = resultRow[status],
        warehouseId = resultRow[warehouse],
        creationDate = resultRow[creationDate],
        quantity = resultRow[quantity],
        database = database
    )
}
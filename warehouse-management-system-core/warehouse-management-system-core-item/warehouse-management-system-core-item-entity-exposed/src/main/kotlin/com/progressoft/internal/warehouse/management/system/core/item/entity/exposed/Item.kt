package com.progressoft.internal.warehouse.management.system.core.item.entity.exposed

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemStatus
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemUnit
import com.progressoft.internal.warehouse.management.system.core.warehouse.entity.exposed.WarehouseTable
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import org.jetbrains.exposed.v1.jdbc.Database
import java.time.LocalDateTime

class Item(
    override var uuid: String,
    override var code: String,
    override var name: String,
    override var description: String,
    override var category: String,
    override var unit: ItemUnit,
    override var status: ItemStatus,
    override var quantity: Int,
    var warehouseId: String,
    override var creationDate: LocalDateTime,
    val database: Database?
) : ItemDomain {
    override val warehouse: WarehouseDomain by lazy {
        WarehouseTable.findIdentityByUuid(warehouseId, database)!!
    }
}
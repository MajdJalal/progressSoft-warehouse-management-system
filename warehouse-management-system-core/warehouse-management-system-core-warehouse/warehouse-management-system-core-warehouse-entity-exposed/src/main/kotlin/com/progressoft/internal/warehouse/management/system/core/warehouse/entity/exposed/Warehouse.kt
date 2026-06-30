package com.progressoft.internal.warehouse.management.system.core.warehouse.entity.exposed

import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseStatus
import java.time.LocalDateTime

class Warehouse(
    override var uuid: String,
    override var code: String,
    override var name: String,
    override var description: String,
    override var address: String,
    override var status: WarehouseStatus,
    override var creationDate: LocalDateTime
) : WarehouseDomain
package com.progressoft.internal.warehouse.management.system.core.warehouse.adapter.exposed.creator

import com.progressoft.internal.warehouse.management.system.core.warehouse.entity.exposed.Warehouse
import com.progressoft.internal.warehouse.management.system.core.warehouse.store.creator.WarehouseCreator
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseStatus
import java.time.LocalDateTime
import java.util.*

class WarehouseCreatorImpl : WarehouseCreator {

    private var uuid: String = UUID.randomUUID().toString()
    private lateinit var code: String
    private lateinit var name: String
    private lateinit var description: String
    private lateinit var address: String
    private lateinit var status: WarehouseStatus


    override fun String.uuid(): WarehouseCreator {
        this@WarehouseCreatorImpl.uuid = this
        return this@WarehouseCreatorImpl
    }

    override fun String.code(): WarehouseCreator {
        this@WarehouseCreatorImpl.code = this
        return this@WarehouseCreatorImpl
    }

    override fun String.name(): WarehouseCreator {
        this@WarehouseCreatorImpl.name = this
        return this@WarehouseCreatorImpl
    }

    override fun String.description(): WarehouseCreator {
        this@WarehouseCreatorImpl.description = this
        return this@WarehouseCreatorImpl
    }

    override fun String.address(): WarehouseCreator {
        this@WarehouseCreatorImpl.address = this
        return this@WarehouseCreatorImpl
    }

    override fun WarehouseStatus.status(): WarehouseCreator {
        this@WarehouseCreatorImpl.status = this
        return this@WarehouseCreatorImpl
    }

    override fun create(): WarehouseDomain {
        return Warehouse(
            uuid,
            code,
            name,
            description,
            address,
            status,
            LocalDateTime.now(),
        )
    }
}
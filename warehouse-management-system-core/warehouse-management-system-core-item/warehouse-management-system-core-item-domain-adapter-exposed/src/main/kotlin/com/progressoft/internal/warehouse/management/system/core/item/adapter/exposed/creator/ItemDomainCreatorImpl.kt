package com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.creator

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemStatus
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemUnit
import com.progressoft.internal.warehouse.management.system.core.item.entity.exposed.Item
import com.progressoft.internal.warehouse.management.system.core.item.entity.exposed.ItemAudit
import com.progressoft.internal.warehouse.management.system.core.item.store.creator.ItemDomainCreator
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import com.progressoft.saturn.pps.bank.core.payment.inward.entity.exposed.embedded.ActorTypeImpl
import io.arkitik.radix.audit.domain.embedded.AuditChangeType
import io.arkitik.radix.starter.audit.store.adapter.exposed.creator.CoreAuditStoreIdentityCreator
import io.arkitik.radix.starter.audit.store.core.log.AuditLogData
import org.jetbrains.exposed.v1.jdbc.Database
import java.time.LocalDateTime
import java.util.*
import kotlin.properties.Delegates

class ItemDomainCreatorImpl(
    actorId: String,
    actorType: String,
    private val database: Database?,
) : ItemDomainCreator, CoreAuditStoreIdentityCreator<String, ItemDomain, ItemAuditDomain>(
    actorId,
    actorType
) {

    private var uuid: String = UUID.randomUUID().toString()
    private lateinit var code: String
    private lateinit var name: String
    private lateinit var description: String
    private lateinit var category: String
    private lateinit var unit: ItemUnit

    private var quantity by Delegates.notNull<Int>()
    private lateinit var warehouse: WarehouseDomain

    override fun String.uuid(): ItemDomainCreator {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::uuid.name,
                oldValue = null,
                newValue = this
            )
        )


        this@ItemDomainCreatorImpl.uuid = this
        return this@ItemDomainCreatorImpl
    }

    override fun String.code(): ItemDomainCreator {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::code.name,
                oldValue = null,
                newValue = this
            )
        )

        this@ItemDomainCreatorImpl.code = this
        return this@ItemDomainCreatorImpl
    }

    override fun String.name(): ItemDomainCreator {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::name.name,
                oldValue = null,
                newValue = this
            )
        )

        this@ItemDomainCreatorImpl.name = this
        return this@ItemDomainCreatorImpl
    }

    override fun String.description(): ItemDomainCreator {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::description.name,
                oldValue = null,
                newValue = this
            )
        )

        this@ItemDomainCreatorImpl.description = this
        return this@ItemDomainCreatorImpl
    }

    override fun String.category(): ItemDomainCreator {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::category.name,
                oldValue = null,
                newValue = this
            )
        )

        this@ItemDomainCreatorImpl.category = this
        return this@ItemDomainCreatorImpl
    }

    override fun ItemUnit.unit(): ItemDomainCreator {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::unit.name,
                oldValue = null,
                newValue = this
            )
        )

        this@ItemDomainCreatorImpl.unit = this
        return this@ItemDomainCreatorImpl
    }

    override fun WarehouseDomain.warehouse(): ItemDomainCreator {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::warehouse.name,
                oldValue = null,
                newValue = this.uuid
            )
        )

        this@ItemDomainCreatorImpl.warehouse = this
        return this@ItemDomainCreatorImpl
    }

    override fun Int.quantity(): ItemDomainCreator {
        this@ItemDomainCreatorImpl.quantity = this
        return this@ItemDomainCreatorImpl
    }

    override fun ItemDomain.createAudit(
        log: AuditLogData<String>,
        actorId: String,
        actorType: String
    ): ItemAuditDomain {
        return ItemAudit(
            uuid = UUID.randomUUID().toString(),
            actorId = actorId,
            actorType = ActorTypeImpl(actorType),
            changeType = AuditChangeType.CREATE,
            keyName = log.keyName,
            newValue = log.newValue,
            oldValue = log.oldValue,
            recordUuid = uuid,
            database = database
        )
    }

    override fun createIdentity(): ItemDomain {
        return Item(
            uuid = uuid,
            code = code,
            name = name,
            quantity = quantity,
            description = description,
            category = category,
            unit = unit,
            status = ItemStatus.ACTIVE,
            warehouseId = warehouse.uuid,
            creationDate = LocalDateTime.now(),
            database = database
        )
    }
}
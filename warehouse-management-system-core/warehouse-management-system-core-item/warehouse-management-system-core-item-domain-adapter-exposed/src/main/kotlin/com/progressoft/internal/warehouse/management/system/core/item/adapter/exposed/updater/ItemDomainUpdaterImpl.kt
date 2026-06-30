package com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.updater

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemStatus
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemUnit
import com.progressoft.internal.warehouse.management.system.core.item.entity.exposed.Item
import com.progressoft.internal.warehouse.management.system.core.item.entity.exposed.ItemAudit
import com.progressoft.internal.warehouse.management.system.core.item.store.updater.ItemDomainUpdater
import com.progressoft.saturn.pps.bank.core.payment.inward.entity.exposed.embedded.ActorTypeImpl
import io.arkitik.radix.audit.domain.embedded.AuditChangeType
import io.arkitik.radix.starter.audit.store.adapter.exposed.updater.CoreAuditStoreIdentityUpdater
import io.arkitik.radix.starter.audit.store.core.log.AuditLogData
import java.util.*

class ItemDomainUpdaterImpl(
    actorId: String,
    actorType: String,
    private val item: Item
) : CoreAuditStoreIdentityUpdater<String, ItemDomain, ItemAuditDomain>(
    actorId,
    actorType
), ItemDomainUpdater {

    override fun String.name(): ItemDomainUpdater {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::name.name,
                oldValue = item.name,
                newValue = this
            )
        )


        item.name = this
        return this@ItemDomainUpdaterImpl
    }

    override fun String.description(): ItemDomainUpdater {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::description.name,
                oldValue = item.description,
                newValue = this
            )
        )


        item.description = this
        return this@ItemDomainUpdaterImpl
    }

    override fun String.category(): ItemDomainUpdater {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::category.name,
                oldValue = item.category,
                newValue = this
            )
        )


        item.category = this
        return this@ItemDomainUpdaterImpl
    }

    override fun ItemUnit.unit(): ItemDomainUpdater {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::unit.name,
                oldValue = item.unit,
                newValue = this
            )
        )


        item.unit = this
        return this@ItemDomainUpdaterImpl
    }

    override fun ItemStatus.status(): ItemDomainUpdater {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::status.name,
                oldValue = item.status,
                newValue = this
            )
        )


        item.status = this
        return this@ItemDomainUpdaterImpl
    }

    override fun Int.quantity(): ItemDomainUpdater {
        addHistoryRecord(
            AuditLogData(
                keyName = ItemDomain::quantity.name,
                oldValue = item.quantity,
                newValue = this
            )
        )


        item.quantity = this
        return this@ItemDomainUpdaterImpl
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
            changeType = AuditChangeType.UPDATE,
            keyName = log.keyName,
            newValue = log.newValue,
            oldValue = log.oldValue,
            recordUuid = this.uuid,
            database = null
        )
    }

    override fun updateIdentity(): ItemDomain = item
}
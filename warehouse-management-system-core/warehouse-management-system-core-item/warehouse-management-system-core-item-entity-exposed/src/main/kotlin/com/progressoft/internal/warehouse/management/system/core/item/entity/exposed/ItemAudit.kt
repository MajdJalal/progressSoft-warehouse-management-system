package com.progressoft.internal.warehouse.management.system.core.item.entity.exposed

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.saturn.pps.bank.core.payment.inward.entity.exposed.embedded.ActorTypeImpl
import io.arkitik.radix.audit.domain.embedded.AuditChangeType
import org.jetbrains.exposed.v1.jdbc.Database
import java.time.LocalDateTime

class ItemAudit(
    override val uuid: String,
    override val actorId: String,
    override val actorType: ActorTypeImpl,
    override val changeType: AuditChangeType,
    override val keyName: String,
    override val newValue: String?,
    override val oldValue: String?,
    val recordUuid: String,
    override val creationDate: LocalDateTime = LocalDateTime.now(),
    database: Database?,
) : ItemAuditDomain {
    override val record: ItemDomain by lazy {
        ItemTable.findIdentityByUuid(recordUuid, database)!!
    }
}
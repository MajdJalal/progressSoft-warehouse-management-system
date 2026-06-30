package com.progressoft.internal.warehouse.management.system.core.item.entity.exposed

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.saturn.pps.bank.core.payment.inward.entity.exposed.embedded.ActorTypeImpl
import io.arkitik.radix.audit.domain.embedded.AuditChangeType
import io.arkitik.radix.develop.exposed.table.RadixTable
import org.jetbrains.exposed.v1.core.Column
import org.jetbrains.exposed.v1.core.ResultRow
import org.jetbrains.exposed.v1.jdbc.Database

object ItemAuditTable :
    RadixTable<String, ItemAuditDomain>("whs_item_audit") {
    override val uuid: Column<String> = varchar(name = "uuid", length = 255)
    val actorId = varchar(name = "actor_id", length = 255)
    val actorType = varchar(name = "actor_type", length = 255)
    val changeType = enumerationByName<AuditChangeType>(name = "change_type", length = 255)
    val keyName = varchar(name = "key_name", length = 255)
    val newValue = text(name = "new_value").nullable()
    val oldValue = text(name = "old_value").nullable()
    val record =
        reference(
            "record_uuid",
            ItemTable.uuid,
            fkName = "whs_item_audit_fk"
        )

    override fun mapToIdentity(
        resultRow: ResultRow,
        database: Database?,
    ) =
        ItemAudit(
            uuid = resultRow[uuid],
            actorId = resultRow[actorId],
            actorType = ActorTypeImpl(resultRow[actorType]),
            changeType = resultRow[changeType],
            keyName = resultRow[keyName],
            newValue = resultRow[newValue],
            oldValue = resultRow[oldValue],
            recordUuid = resultRow[record],
            creationDate = resultRow[creationDate],
            database = database,
        )

}
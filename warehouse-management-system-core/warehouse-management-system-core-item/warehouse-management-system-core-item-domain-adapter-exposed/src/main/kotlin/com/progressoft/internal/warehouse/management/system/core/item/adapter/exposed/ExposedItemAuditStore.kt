package com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed

import com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.query.ExposedItemAuditStoreQuery
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.entity.exposed.ItemAudit
import com.progressoft.internal.warehouse.management.system.core.item.entity.exposed.ItemAuditTable
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemAuditStore
import io.arkitik.radix.adapter.exposed.ExposedStore
import io.arkitik.radix.audit.store.query.AuditRecordStoreQuery
import org.jetbrains.exposed.v1.core.statements.UpdateBuilder
import org.jetbrains.exposed.v1.jdbc.Database

class ExposedItemAuditStore(
    database: Database?,
) : ExposedStore<String, ItemAuditDomain, ItemAuditTable>(ItemAuditTable, database), ItemAuditStore {

    override val storeQuery: AuditRecordStoreQuery<String, ItemDomain, ItemAuditDomain> =
        ExposedItemAuditStoreQuery(database)


    override fun <K : Any> UpdateBuilder<K>.createEntity(identity: ItemAuditDomain) {
        this[identityTable.actorId] = identity.actorId
        this[identityTable.actorType] = identity.actorType.actorType
        this[identityTable.changeType] = identity.changeType
        this[identityTable.keyName] = identity.keyName
        this[identityTable.newValue] = identity.newValue
        this[identityTable.oldValue] = identity.oldValue
        this[identityTable.record] = (identity as ItemAudit).recordUuid
    }

}
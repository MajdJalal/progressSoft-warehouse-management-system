package com.progressoft.internal.warehouse.management.system.core.item.store

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.store.query.ItemStoreQuery
import io.arkitik.radix.audit.store.AuditRecordStore
import io.arkitik.radix.audit.store.query.AuditRecordStoreQuery

interface ItemAuditStore : AuditRecordStore<String, ItemDomain, ItemAuditDomain> {
    override val storeQuery: AuditRecordStoreQuery<String, ItemDomain, ItemAuditDomain>
}
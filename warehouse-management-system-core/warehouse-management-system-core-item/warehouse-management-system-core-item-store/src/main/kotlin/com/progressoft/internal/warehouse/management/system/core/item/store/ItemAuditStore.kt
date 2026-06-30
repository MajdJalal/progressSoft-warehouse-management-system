package com.progressoft.internal.warehouse.management.system.core.item.store

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import io.arkitik.radix.audit.store.AuditRecordStore

interface ItemAuditStore : AuditRecordStore<String, ItemDomain, ItemAuditDomain> {
}
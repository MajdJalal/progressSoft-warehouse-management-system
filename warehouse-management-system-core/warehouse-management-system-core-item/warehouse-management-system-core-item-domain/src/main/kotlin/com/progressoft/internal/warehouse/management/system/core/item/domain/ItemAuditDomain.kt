package com.progressoft.internal.warehouse.management.system.core.item.domain

import io.arkitik.radix.audit.domain.AuditRecordIdentity

interface ItemAuditDomain : AuditRecordIdentity<String, ItemDomain> {
}
package com.progressoft.internal.warehouse.management.system.engine.item.sdk.response

import io.arkitik.radix.audit.domain.embedded.ActorType
import io.arkitik.radix.audit.domain.embedded.AuditChangeType

class ItemAuditResponse(
    val actorId: String,
    val actorType: ActorType,
    val changeType: AuditChangeType,
    val keyName: String,
    val oldValue: String?,
    val newValue: String?,
    val recordId: String
)
package com.progressoft.internal.warehouse.management.system.engine.item.operation.main

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemStatus
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemStore
import com.progressoft.internal.warehouse.management.system.engine.item.operation.dto.DeactivateItemDto
import io.arkitik.radix.audit.sdk.RadixAuditSdk
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.operation.ext.runOperation
import io.arkitik.radix.develop.store.storeUpdater

class DeactivateItemOperation(
    private val itemStore: ItemStore,
    private val itemAuditSdk: RadixAuditSdk<String, ItemDomain, ItemAuditDomain>
) : Operation<DeactivateItemDto, Unit> {

    override fun DeactivateItemDto.operate() {
        with(itemStore) {
            storeUpdater(item.identityUpdater(actorId = actorId, actorType = actorType)) {
                ItemStatus.INACTIVE.status()
                update()
            }.let { auditLogs ->
                auditLogs.identity.update()
                    .also {
                        itemAuditSdk.insertAudits.runOperation(auditLogs.logs)
                    }
            }
        }
    }
}
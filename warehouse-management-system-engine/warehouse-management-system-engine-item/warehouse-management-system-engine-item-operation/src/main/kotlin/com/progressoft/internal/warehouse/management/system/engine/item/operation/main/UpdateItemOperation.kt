package com.progressoft.internal.warehouse.management.system.engine.item.operation.main

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemStore
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.errors.ItemErrors
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.UpdateItemRequest
import io.arkitik.radix.audit.sdk.RadixAuditSdk
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.operation.ext.runOperation
import io.arkitik.radix.develop.shared.ext.resourceNotFound
import io.arkitik.radix.develop.store.storeUpdater

class UpdateItemOperation(
    private val itemStore: ItemStore,
    private val itemAuditSdk: RadixAuditSdk<String, ItemDomain, ItemAuditDomain>
) : Operation<UpdateItemRequest, Unit> {
    override fun UpdateItemRequest.operate() {
        val item = itemStore.storeQuery.findByCode(code)
            .resourceNotFound(ItemErrors.ITEM_DOES_NOT_EXIST)

        with(itemStore) {
            storeUpdater(item.identityUpdater(actorId = actorId, actorType = actorType)) {
                name?.name()
                description?.description()
                category?.category()
                quantity?.quantity()
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
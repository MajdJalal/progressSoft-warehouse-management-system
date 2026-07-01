package com.progressoft.internal.warehouse.management.system.engine.item.operation.main

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemStore
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.errors.ItemErrors
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.TransferItemRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.WarehouseDomainSdk
import io.arkitik.radix.audit.sdk.RadixAuditSdk
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.operation.ext.runOperation
import io.arkitik.radix.develop.shared.ext.resourceNotFound
import io.arkitik.radix.develop.store.storeUpdater

class TransferItemOperation(
    private val itemStore: ItemStore,
    private val warehouseDomainSdk: WarehouseDomainSdk,
    private val itemAuditSdk: RadixAuditSdk<String, ItemDomain, ItemAuditDomain>
) : Operation<TransferItemRequest, Unit> {


    override fun TransferItemRequest.operate() {
        val item = itemStore.storeQuery.find(itemId)
            .resourceNotFound(ItemErrors.ITEM_DOES_NOT_EXIST)

        warehouseDomainSdk.existWarehouseById
            .runOperation(newWarehouseId)


        with(itemStore) {
            storeUpdater(item.identityUpdater(actorId = actorId, actorType = actorType)) {
                newWarehouseId.warehouseId()
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
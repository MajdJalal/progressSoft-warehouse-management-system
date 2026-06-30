package com.progressoft.internal.warehouse.management.system.engine.item.operation.main

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemStore
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.CreateItemRequest
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.WarehouseDomainSdk
import io.arkitik.radix.audit.sdk.RadixAuditSdk
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.operation.ext.runOperation
import io.arkitik.radix.develop.store.storeCreator

internal class CreateItemOperation(
    private val itemStore: ItemStore,
    private val warehouseDomainSdk: WarehouseDomainSdk,
    private val itemAuditSdk: RadixAuditSdk<String, ItemDomain, ItemAuditDomain>
) : Operation<CreateItemRequest, Unit> {

    override fun CreateItemRequest.operate() {

        val warehouse = warehouseDomainSdk.findWarehouseById
            .runOperation(warehouseId)

        with(itemStore) {
            storeCreator(identityCreator(actorId, actorType)) {
                id?.uuid()
                code.code()
                quantity.quantity()
                name.name()
                description.description()
                category.category()
                warehouse.warehouse()
                unit.unit()
                create()
            }.let { auditLogs ->
                auditLogs.identity.insert()
                    .also {
                        itemAuditSdk.insertAudits.runOperation(auditLogs.logs)
                    }
            }
        }
    }
}
package com.progressoft.internal.warehouse.management.system.engine.item.operation.role

import com.progressoft.internal.warehouse.management.system.core.item.store.ItemStore
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.errors.ItemErrors
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.DeactivateItemRequest
import io.arkitik.radix.develop.operation.OperationRole
import io.arkitik.radix.develop.shared.ext.unprocessableEntity

internal class ItemDeactivationValidationRole(val itemStore: ItemStore) : OperationRole<DeactivateItemRequest, Unit> {
    override fun DeactivateItemRequest.operateRole() {
        itemStore.storeQuery.findByCode(code)
            ?: throw ItemErrors.ITEM_DOES_NOT_EXIST.unprocessableEntity()
    }
}
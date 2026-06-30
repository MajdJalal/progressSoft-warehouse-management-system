package com.progressoft.internal.warehouse.management.system.engine.item.operation.role

import com.progressoft.internal.warehouse.management.system.core.item.store.query.ItemStoreQuery
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.errors.ItemErrors
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.CreateItemRequest
import io.arkitik.radix.develop.operation.OperationRole
import io.arkitik.radix.develop.shared.ext.unprocessableEntity

internal class ItemCreationValidationRole(
    private val itemStoreQuery: ItemStoreQuery
) : OperationRole<CreateItemRequest, Unit> {
    override fun CreateItemRequest.operateRole() {
        val item = itemStoreQuery.existByCode(code)
        if (item) throw ItemErrors.ITEM_ALREADY_FOUND.unprocessableEntity()
    }
}
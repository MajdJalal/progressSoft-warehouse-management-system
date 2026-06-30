package com.progressoft.internal.warehouse.management.system.engine.item.operation.dto

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain

class DeactivateItemDto(
    val item: ItemDomain,
    val actorId: String,
    val actorType: String
)
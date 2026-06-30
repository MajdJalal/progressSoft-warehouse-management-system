package com.progressoft.internal.warehouse.management.system.core.item.domain

import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import io.arkitik.radix.develop.identity.Identity

interface   ItemDomain : Identity<String> {
    override val uuid: String
    val code: String
    val name: String
    val description: String
    val category: String
    val unit: ItemUnit
    val quantity: Int
    val status: ItemStatus
    val warehouse: WarehouseDomain
}
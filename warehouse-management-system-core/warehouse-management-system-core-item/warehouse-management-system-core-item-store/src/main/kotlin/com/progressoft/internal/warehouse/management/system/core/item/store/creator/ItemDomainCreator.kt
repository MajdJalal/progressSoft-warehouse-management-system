package com.progressoft.internal.warehouse.management.system.core.item.store.creator

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemUnit
import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.arkitik.radix.starter.audit.store.core.creator.AuditStoreIdentityCreator

interface ItemDomainCreator : AuditStoreIdentityCreator<String, ItemDomain, ItemAuditDomain> {
    fun String.name(): ItemDomainCreator
    fun String.code(): ItemDomainCreator
    fun String.description(): ItemDomainCreator
    fun String.category(): ItemDomainCreator
    fun Int.quantity(): ItemDomainCreator
    fun ItemUnit.unit(): ItemDomainCreator
    fun WarehouseDomain.warehouse(): ItemDomainCreator
}
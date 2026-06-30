package com.progressoft.internal.warehouse.management.system.core.item.store

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.store.creator.ItemDomainCreator
import com.progressoft.internal.warehouse.management.system.core.item.store.query.ItemStoreQuery
import com.progressoft.internal.warehouse.management.system.core.item.store.updater.ItemDomainUpdater
import io.arkitik.radix.starter.audit.store.core.AuditableStore

interface ItemStore : AuditableStore<String, ItemDomain, ItemAuditDomain> {
    override val storeQuery: ItemStoreQuery

    override fun identityCreator(
        actorId: String,
        actorType: String
    ): ItemDomainCreator

    override fun ItemDomain.identityUpdater(
        actorId: String,
        actorType: String
    ): ItemDomainUpdater

}
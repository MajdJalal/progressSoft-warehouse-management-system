package com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed

import com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.creator.ItemDomainCreatorImpl
import com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.query.ExposedItemStoreQuery
import com.progressoft.internal.warehouse.management.system.core.item.adapter.exposed.updater.ItemDomainUpdaterImpl
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.entity.exposed.Item
import com.progressoft.internal.warehouse.management.system.core.item.entity.exposed.ItemTable
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemStore
import com.progressoft.internal.warehouse.management.system.core.item.store.creator.ItemDomainCreator
import com.progressoft.internal.warehouse.management.system.core.item.store.query.ItemStoreQuery
import com.progressoft.internal.warehouse.management.system.core.item.store.updater.ItemDomainUpdater
import io.arkitik.radix.adapter.exposed.ExposedStore
import io.arkitik.radix.develop.store.creator.StoreIdentityCreator
import io.arkitik.radix.develop.store.updater.StoreIdentityUpdater
import org.jetbrains.exposed.v1.core.statements.UpdateBuilder
import org.jetbrains.exposed.v1.jdbc.Database

class ExposedItemStore(
    database: Database?
) : ItemStore, ExposedStore<String, ItemDomain, ItemTable>(ItemTable, database) {
    override val storeQuery: ItemStoreQuery = ExposedItemStoreQuery(database)
    override fun identityCreator(): StoreIdentityCreator<String, ItemDomain> {
        TODO("Not yet implemented")
    }

    override fun ItemDomain.identityUpdater(): StoreIdentityUpdater<String, ItemDomain> {
        TODO("Not yet implemented")
    }

    private fun ItemDomain.map(): Item = this as Item


    override fun <K : Any> UpdateBuilder<K>.createEntity(identity: ItemDomain) {
        identity as Item
        this[identityTable.code] = identity.code
        this[identityTable.name] = identity.name
        this[identityTable.description] = identity.description
        this[identityTable.category] = identity.category
        this[identityTable.unit] = identity.unit
        this[identityTable.status] = identity.status
        this[identityTable.quantity] = identity.quantity
        this[identityTable.warehouse] = identity.warehouseId
    }

    override fun identityCreator(
        actorId: String,
        actorType: String
    ): ItemDomainCreator = ItemDomainCreatorImpl(actorId, actorType, database)

    override fun ItemDomain.identityUpdater(
        actorId: String,
        actorType: String
    ): ItemDomainUpdater = ItemDomainUpdaterImpl(actorId, actorType, map())
}
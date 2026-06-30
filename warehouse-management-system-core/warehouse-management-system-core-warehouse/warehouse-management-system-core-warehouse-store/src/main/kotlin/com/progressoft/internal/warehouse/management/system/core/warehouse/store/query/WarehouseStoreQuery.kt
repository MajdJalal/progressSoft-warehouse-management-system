package com.progressoft.internal.warehouse.management.system.core.warehouse.store.query

import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import io.arkitik.radix.develop.store.query.StoreQuery

interface WarehouseStoreQuery : StoreQuery<String, WarehouseDomain> {

    fun findByCode(code: String): WarehouseDomain?

}
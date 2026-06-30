package com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk

import com.progressoft.internal.warehouse.management.system.warehouse.domain.WarehouseDomain
import io.arkitik.radix.develop.operation.Operation

interface WarehouseDomainSdk {

    val findWarehouseById: Operation<String, WarehouseDomain>
}
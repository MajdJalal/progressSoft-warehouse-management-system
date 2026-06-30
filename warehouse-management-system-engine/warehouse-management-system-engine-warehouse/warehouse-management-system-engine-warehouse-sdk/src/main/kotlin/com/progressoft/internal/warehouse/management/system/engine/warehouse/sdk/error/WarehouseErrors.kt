package com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.error

import io.arkitik.radix.develop.shared.error.ErrorResponse

enum class WarehouseErrors(
    override val code: String?,
    override val message: String?
) : ErrorResponse {


    WAREHOUSE_DOES_NOT_EXIST(
        "WSH-WAREHOUSE-1100",
        "Warehouse does not exist"
    )

}
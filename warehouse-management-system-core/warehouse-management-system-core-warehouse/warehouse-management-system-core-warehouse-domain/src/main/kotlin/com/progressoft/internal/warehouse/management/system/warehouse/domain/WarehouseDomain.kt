package com.progressoft.internal.warehouse.management.system.warehouse.domain

import io.arkitik.radix.develop.identity.Identity
import java.time.LocalDateTime

interface WarehouseDomain : Identity<String> {
    override var uuid: String
    var code: String
    var name: String
    var description: String
    var address: String
    var status: WarehouseStatus
    override var creationDate: LocalDateTime
}
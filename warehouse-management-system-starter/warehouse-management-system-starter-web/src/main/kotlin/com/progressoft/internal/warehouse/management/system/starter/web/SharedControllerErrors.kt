package com.progressoft.internal.warehouse.management.system.starter.web

import io.arkitik.radix.develop.shared.error.ErrorResponse

enum class SharedControllerErrors(
    override val code: String?,
    override val message: String?
) : ErrorResponse {

    UNRECOGNIZED_ERROR(
        "WHS-1000",
        "Error occurred while processing your request"
    ),

    UNAUTHORIZED_ERROR(
        "WHS-1000",
        "user not authorized to perform this request"
    ),
}
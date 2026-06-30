package com.progressoft.internal.warehouse.management.system.starter.shared.web.filter

import io.arkitik.radix.develop.shared.error.ErrorResponse

enum class AuthErrors(
    override val code: String,
    override val message: String,
) : ErrorResponse {
    NO_AUTH_TOKEN("PPS-AUTH-1000", "No authorization token"),
    INVALID_SIGNATURE("PPS-AUTH-2000", "Signature failed verification"),
    UNRECOGNIZED_ERROR("PPS-AUTH-3000", "Unrecognized error, please try again");
}

package com.progressoft.saturn.pps.bank.core.payment.inward.entity.exposed.embedded

import io.arkitik.radix.audit.domain.embedded.ActorType

/**
 * @author Abdulrahman Alshami
 * @since 15:51, Sunday, 9/7/25
 **/
class ActorTypeImpl(
    override val actorType: String,
) : ActorType
package com.progressoft.internal.warehouse.management.system.engine.item.operation

import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemAuditDomain
import com.progressoft.internal.warehouse.management.system.core.item.domain.ItemDomain
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemAuditStore
import com.progressoft.internal.warehouse.management.system.core.item.store.ItemStore
import com.progressoft.internal.warehouse.management.system.engine.item.operation.dto.DeactivateItemDto
import com.progressoft.internal.warehouse.management.system.engine.item.operation.main.*
import com.progressoft.internal.warehouse.management.system.engine.item.operation.role.ItemCreationValidationRole
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.ItemSdk
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.errors.ItemErrors
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.request.*
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemAuditResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ItemResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemHistoryPaginationResponse
import com.progressoft.internal.warehouse.management.system.engine.item.sdk.response.ViewItemsPaginationResponse
import com.progressoft.internal.warehouse.management.system.engine.warehouse.sdk.WarehouseDomainSdk
import io.arkitik.radix.audit.sdk.RadixAuditSdk
import io.arkitik.radix.develop.operation.Operation
import io.arkitik.radix.develop.operation.ext.JakartaValidator
import io.arkitik.radix.develop.operation.ext.operationBuilder
import io.arkitik.radix.develop.operation.ext.runOperation
import io.arkitik.radix.develop.shared.ext.resourceNotFound

class ItemSdkImpl(
    itemStore: ItemStore,
    warehouseDomainSdk: WarehouseDomainSdk,
    itemAuditSdk: RadixAuditSdk<String, ItemDomain, ItemAuditDomain>,
    itemAuditStore: ItemAuditStore
) : ItemSdk {
    override val createItem: Operation<CreateItemRequest, Unit> =
        operationBuilder {
            install(JakartaValidator())

            install(
                ItemCreationValidationRole(
                    itemStoreQuery = itemStore.storeQuery
                )
            )

            mainOperation(
                CreateItemOperation(
                    itemStore = itemStore,
                    warehouseDomainSdk = warehouseDomainSdk,
                    itemAuditSdk = itemAuditSdk,
                )
            )
        }

    override val deactivateItem: Operation<DeactivateItemRequest, Unit> =
        operationBuilder {
            install(JakartaValidator())

            mainOperation {
                val item = itemStore.storeQuery.findByCode(code)
                    .resourceNotFound(ItemErrors.ITEM_DOES_NOT_EXIST)

                deactivateItemOperation
                    .runOperation(
                        DeactivateItemDto(
                            item = item,
                            actorId = actorId,
                            actorType = actorType,
                        )
                    )
            }
        }

    private val deactivateItemOperation: Operation<DeactivateItemDto, Unit> =
        operationBuilder {
            mainOperation(
                DeactivateItemOperation(
                    itemStore = itemStore,
                    itemAuditSdk = itemAuditSdk,
                )
            )
        }

    override val viewAllItems: Operation<ViewItemsRequest, ViewItemsPaginationResponse<ItemResponse>> =
        operationBuilder {
            install(JakartaValidator())

            mainOperation(
                ViewItemsOperation(
                    itemStore = itemStore
                )
            )
        }

    override val updateItem: Operation<UpdateItemRequest, Unit> =
        operationBuilder {
            install(JakartaValidator())

            mainOperation(
                UpdateItemOperation(
                    itemStore = itemStore,
                    itemAuditSdk = itemAuditSdk,
                )
            )
        }

    override val viewItemHistory: Operation<ViewItemHistoryRequest, ViewItemHistoryPaginationResponse<ItemAuditResponse>> =
        operationBuilder {
            install(JakartaValidator())

            mainOperation(
                ViewItemHistoryOperation(
                    itemAuditStore = itemAuditStore
                )
            )
        }
}

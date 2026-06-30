package com.progressoft.internal.warehouse.management.system.starter.web

import io.arkitik.radix.develop.shared.error.ErrorResponse
import io.arkitik.radix.develop.shared.exception.ResourceNotFoundException
import io.arkitik.radix.develop.shared.exception.UnprocessableEntityException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest

@RestControllerAdvice
internal class WarehouseExceptionHandler {


    @ExceptionHandler
    fun handleUnprocessableException(
        ex : UnprocessableEntityException, request: WebRequest
    ) : ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
            .body(ex.error)
    }

    @ExceptionHandler
    fun handleNotFoundException(
        ex : ResourceNotFoundException, request: WebRequest
    ) : ResponseEntity<ErrorResponse> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(ex.error)
    }

    @ExceptionHandler
    fun handleException(ex: Exception, request: WebRequest):
            ResponseEntity<Any> {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
            .body(SharedControllerErrors.UNRECOGNIZED_ERROR)

    }


}
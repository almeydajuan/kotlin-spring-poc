package ar.com.jalmeyda.kotlin.controller

import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.client.HttpClientErrorException

@ControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(HttpClientErrorException::class)
    fun handleClientErrorException(clientErrorException: HttpClientErrorException) =
        ResponseEntity(
            ErrorResponse(
                clientErrorException.statusCode.value(),
                clientErrorException.message
            ),
            clientErrorException.statusCode
        )
}

data class ErrorResponse(val status: Int, val message: String?)


fun clientException(name: String): HttpClientErrorException {
    return HttpClientErrorException.create(
        HttpStatus.NOT_FOUND,
        "Entity not found for $name",
        HttpHeaders.EMPTY,
        ByteArray(0),
        null
    )
}
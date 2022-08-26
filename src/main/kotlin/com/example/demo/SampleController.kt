package com.example.demo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController


@RestController
class SampleController {

    @GetMapping("/hello/{firstName}/{lastName}")
    fun hello(
        @PathVariable firstName: String,
        @PathVariable lastName: String): ResultObject? {
        val result = helloRemoteServiceCall(firstName, lastName)
        return result
    }

    @GetMapping("/internal/{firstName}/{lastName}")
    fun sample(
        @PathVariable firstName: String,
        @PathVariable lastName: String
    ): ResponseEntity<ResultObject> {
        val data = ResponseEntity<ResultObject>(
            ResultObject(result = "hello world"),
            HttpStatus.ACCEPTED)
        return data
    }
}

data class ResultObject(val result: String)
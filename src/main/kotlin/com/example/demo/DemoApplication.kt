package com.example.demo

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate
import org.springframework.web.client.exchange

@EnableEurekaClient
@SpringBootApplication
class DemoApplication: CommandLineRunner {
	override fun run(vararg args: String?) {
	}
}

fun main(args: Array<String>) {
	runApplication<DemoApplication>(*args)
}

fun helloRemoteServiceCall(firstName: String, lastName: String): ResultObject? {
	val restExchange: ResponseEntity<ResultObject> = RestTemplate().exchange(
		"http://localhost:9011/internal/$firstName/$lastName",
		HttpMethod.GET,
		null,
		firstName, lastName
	)
	return restExchange.body
}


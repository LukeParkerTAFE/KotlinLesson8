package com.lukeparker.videodemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VideodemoApplication

fun main(args: Array<String>) {
	runApplication<VideodemoApplication>(*args)
}

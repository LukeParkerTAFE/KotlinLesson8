package com.lukeparker.videodemo.controllers

import com.lukeparker.videodemo.models.Person
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("persons")
class PersonController {

    @GetMapping
    fun getAllPeople() : ResponseEntity<List<Person>> {
        return ResponseEntity.ok(people)
    }

    companion object {
        var people = mutableListOf(
            Person(
                1,
                "Luke",
                "Parker",
                10,
            ),
            Person(
                2,
                "Dana",
                "Waters",
                20
            ),
            Person(
                3,
                "Luke",
                "Parker",
                30,
            )
        )
    }
}
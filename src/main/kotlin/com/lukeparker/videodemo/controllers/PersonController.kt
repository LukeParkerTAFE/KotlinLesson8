package com.lukeparker.videodemo.controllers

import com.lukeparker.videodemo.models.Person
import com.lukeparker.videodemo.models.PersonCreateModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("persons")
class PersonController {

    @GetMapping
    fun getAllPeople(): ResponseEntity<List<Person>> {
        return ResponseEntity.ok(people)
    }

    @GetMapping("{id}")
    fun getPersonById(@PathVariable id: Int): ResponseEntity<Person> {
        val person = people.find { p -> p.id == id }
        if (person == null) {
            // Return 404
            return ResponseEntity.notFound().build()
        } else {
            return ResponseEntity.ok(person)
        }
    }

    @PostMapping
    fun createPerson(createModel: PersonCreateModel): Person {
        val person = Person(
            (1..1_000_000).random(),
            createModel.firstName,
            createModel.lastName,
            createModel.age,
        )
        people.add(person)
        return person
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
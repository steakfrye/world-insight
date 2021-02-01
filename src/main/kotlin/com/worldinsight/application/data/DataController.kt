package com.worldinsight.application.data

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DataController {
    private val service = DataService()

    @GetMapping("/")
    fun getHomepage(): String {
        return service.getHomepage()
    }
}
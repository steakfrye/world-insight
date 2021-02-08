package com.worldinsight.application.data

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DataController {
    private val dataService = DataService()

    @GetMapping("/")
    fun getHomepage(): String {
        return dataService.getHomepage()
    }

    @GetMapping("/homeland")
    fun getHomelandSecurityLevel(): String {
        return dataService.getDepartmentOfStateAlerts()
    }
}

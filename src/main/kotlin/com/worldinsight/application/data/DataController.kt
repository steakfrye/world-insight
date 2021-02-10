package com.worldinsight.application.data

import com.google.gson.Gson
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/world-insight")
class DataController(val dataService: DataService) {

    @GetMapping("/")
    fun getHomepage(): String {
        return dataService.getHomepage()
    }

    @GetMapping("/dos/alerts", produces = ["application/json"])
    fun getHomelandSecurityLevel(): ResponseEntity<String?> {
        val rssAlertFeedData = dataService.getDepartmentOfStateAlerts()

        if (rssAlertFeedData.channel?.items.isNullOrEmpty()) { return ResponseEntity.notFound().build() }

        return ResponseEntity.ok(Gson().toJson(rssAlertFeedData.channel))
    }
}

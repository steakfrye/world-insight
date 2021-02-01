package com.worldinsight.application.data

import org.junit.jupiter.api.Test

internal class DataServiceTest {
    private val dataService = DataService()

    @Test
    fun getHomepage_called_messageReturned() {
        val result = dataService.getHomepage()
        assert(result == "The United States of America is NOT SAFE for travel")
    }
}
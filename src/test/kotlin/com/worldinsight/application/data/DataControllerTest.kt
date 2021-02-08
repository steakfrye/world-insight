package com.worldinsight.application.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test

internal class DataControllerTest {
    private lateinit var dataController: DataController
    private lateinit var dataService: DataService

    @BeforeTest
    fun setup() {
        dataController = DataController()
        dataService = mock()
    }

    @Test
    fun getHomepage_called_messageReturned() {
        whenever(dataService.getHomepage()).thenReturn("The United States of America is NOT SAFE for travel")
        val result = dataController.getHomepage()

        assert(result == "The United States of America is NOT SAFE for travel")
    }

    @Test
    fun testGetHomelandSecurityLevel() {
        whenever(dataService.getDepartmentOfStateAlerts()).thenReturn("Senegal has an alert status of 'Level 3: Reconsider Travel'")
        val result = dataController.getHomelandSecurityLevel()

        assert(result == "Senegal has an alert status of 'Level 3: Reconsider Travel'")
    }
}

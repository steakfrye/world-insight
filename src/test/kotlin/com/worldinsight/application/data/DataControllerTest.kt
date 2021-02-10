package com.worldinsight.application.data

import com.google.gson.Gson
import com.nhaarman.mockitokotlin2.whenever
import com.worldinsight.application.departmentofstate.Channel
import com.worldinsight.application.departmentofstate.Item
import com.worldinsight.application.departmentofstate.RssAlertFeedData
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.ResponseEntity

@ExtendWith(MockitoExtension::class)
internal class DataControllerTest {
    private lateinit var dataController: DataController

    @Mock private lateinit var dataService: DataService

    @BeforeEach
    fun setup() {
        dataController = DataController(dataService)
    }

    @Test
    fun getHomepage_called_messageReturned() {
        whenever(dataService.getHomepage()).thenReturn("Expected Message")
        val result = dataController.getHomepage()

        assertEquals(result, "Expected Message")
    }

    @Test
    fun testGetHomelandSecurityLevel() {
        val stubAlert = RssAlertFeedData(Channel(listOf(Item(title = "Expected Title"))))
        whenever(dataService.getDepartmentOfStateAlerts()).thenReturn(stubAlert)
        val result = dataController.getHomelandSecurityLevel()

        assertEquals(result, ResponseEntity.ok(Gson().toJson(stubAlert.channel)))
    }
}

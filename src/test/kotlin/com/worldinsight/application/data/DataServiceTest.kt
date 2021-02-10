package com.worldinsight.application.data

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
internal class DataServiceTest {
    private lateinit var dataService: DataService

    @BeforeEach
    fun setup() {
        dataService = DataService()
    }

    @Test
    fun getHomepage_called_messageReturned() {
        val result = dataService.getHomepage()
        assertEquals(result, "The United States of America is NOT SAFE for travel")
    }

    @Test
    fun getDepartmentOfStateAlerts_successfulCall_objectReturned() {
        val result = dataService.getDepartmentOfStateAlerts()

        assertNotNull(result)
    }
}

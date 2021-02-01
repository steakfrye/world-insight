package com.worldinsight.application.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Test

internal class DataControllerTest {
    private var dataController = DataController()
    private var dataService = mock<DataService>()


    @Test
    fun getHomepage_called_messageReturned() {
        whenever(dataService.getHomepage()).thenReturn("The United States of America is NOT SAFE for travel")
        val result = dataController.getHomepage()

        assert(result == "The United States of America is NOT SAFE for travel")
    }
}
package com.worldinsight.application.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import com.worldinsight.application.departmentofstate.Channel
import com.worldinsight.application.departmentofstate.RssAlertFeed
import org.testng.Assert.assertEquals
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.net.URL

internal class DataServiceTest {
    private lateinit var dataService: DataService
    private lateinit var xmlReader: XmlReader

    @BeforeTest
    fun setup() {
        dataService = DataService()
        xmlReader = mock()
    }

    @Test
    fun getHomepage_called_messageReturned() {
        val result = dataService.getHomepage()
        assertEquals(result, "The United States of America is NOT SAFE for travel")
    }

    @Test
    fun testGetDepartmentOfStateAlerts() {
        val stubAlert = RssAlertFeed(channels = listOf(Channel(title = "title goes here")))
        whenever(xmlReader.readFromUrl<RssAlertFeed>(URL("https://travel.state.gov/_res/rss/TAsTWs.xml"))).thenReturn(stubAlert)
        val result = dataService.getDepartmentOfStateAlerts()

        assertEquals(result, stubAlert)
    }
}

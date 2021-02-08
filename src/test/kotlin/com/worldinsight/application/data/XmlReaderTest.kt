package com.worldinsight.application.data

import com.worldinsight.application.departmentofstate.RssAlertFeed
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.net.URL

class XmlReaderTest {
    private lateinit var xmlReader: XmlReader

    @BeforeTest
    fun setup() {
        xmlReader = XmlReader()
    }

    @Test
    fun testReadFromUrl() {
        xmlReader.readFromUrl<RssAlertFeed>(URL("https://travel.state.gov/_res/rss/TAsTWs.xml"))
    }
}

package com.worldinsight.application.data

import com.worldinsight.application.departmentofstate.RssAlertFeedData
import jakarta.xml.bind.JAXBContext
import org.springframework.stereotype.Service
import java.io.InputStream
import java.net.URL

@Service
class DataService {

    fun getHomepage(): String {
        return "The United States of America is NOT SAFE for travel"
    }

    fun getDepartmentOfStateAlerts(): RssAlertFeedData {
        val xmlStream = URL(STATE_DEPARTMENT_ALERT_URL).openConnection().getInputStream()
        // could be useful regex for clearing description of html elements. description?.replace(Regex("\\n|<(.*?)>|(#8217)|(#8239)"), "")
        return getObjectFromXmlStream(xmlStream)
    }

    private inline fun <reified T> getObjectFromXmlStream(inputStream: InputStream): T {
        val jaxbContext = JAXBContext.newInstance(T::class.java)
        val jaxbUnmarshaller = jaxbContext.createUnmarshaller()

        return jaxbUnmarshaller.unmarshal(inputStream) as T
    }

    companion object {
        const val STATE_DEPARTMENT_ALERT_URL = "https://travel.state.gov/_res/rss/TAsTWs.xml"
    }
}

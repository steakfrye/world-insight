package com.worldinsight.application.data

import com.worldinsight.application.departmentofstate.RssAlertFeed
import java.net.URL

class DataService {

    fun getHomepage(): String {
        return "The United States of America is NOT SAFE for travel"
    }

    fun getDepartmentOfStateAlerts(): String {
        val rssAlertFeed = XmlReader().readFromUrl<RssAlertFeed>(URL(STATE_DEPARTMENT_ALERT_URL))

        val firstItemTitle = rssAlertFeed.channels?.get(0)?.items?.get(1)?.title
        val titleList = firstItemTitle?.split(" - ")

        return "${titleList?.get(0)} has an alert status of '${titleList?.get(1)}'"
    }

    companion object {
        const val STATE_DEPARTMENT_ALERT_URL = "https://travel.state.gov/_res/rss/TAsTWs.xml"
    }
}

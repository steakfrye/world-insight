package com.worldinsight.application.departmentofstate

import jakarta.xml.bind.annotation.XmlAccessType
import jakarta.xml.bind.annotation.XmlAccessorType
import jakarta.xml.bind.annotation.XmlElement
import jakarta.xml.bind.annotation.XmlRootElement
import java.util.Date
import kotlin.collections.ArrayList
import kotlin.collections.List

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "rss")
data class RssAlertFeedData(
    @field:XmlElement(name = "channel")
    var channel: Channel? = null
)

@XmlRootElement(name = "channel")
data class Channel(
    @set:XmlElement(name = "item")
    var items: List<Item>? = ArrayList()
)

@XmlRootElement(name = "item")
class Item(
    @set:XmlElement
    var title: String? = null,
    @set:XmlElement
    var pubDate: Date? = null,
    @set:XmlElement
    var link: String? = null,
    @set:XmlElement
    var description: String? = null
)


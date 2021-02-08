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
data class RssAlertFeed(
    @field:XmlElement(name = "channel")
    var channels: List<Channel>? = ArrayList()
)

@XmlRootElement(name = "channel")
data class Channel(
    @set:XmlElement(namespace = "title")
    var title: String? = null,
    @set:XmlElement
    var link: String? = null,
    @set:XmlElement
    var description: String? = null,
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
    var guid: String? = null,
    @set:XmlElement(name = "category")
    var category: List<Category>? = null,
    @set:XmlElement
    var identifier: String? = null,
    @set:XmlElement
    var description: String? = null
)

@XmlRootElement(name = "category")
class Category(
    @set:XmlElement
    var domain: String? = null,
    @set:XmlElement
    var text: String? = null
)

package com.worldinsight.application.data

import jakarta.xml.bind.JAXBContext
import java.net.URL

class XmlReader {
    inline fun <reified T> readFromUrl(url: URL): T {
        val xmlStream = url.openConnection().getInputStream()

        val jaxbContext = JAXBContext.newInstance(T::class.java)
        val jaxbUnmarshaller = jaxbContext.createUnmarshaller()

        return jaxbUnmarshaller.unmarshal(xmlStream) as T
    }
}

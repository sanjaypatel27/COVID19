package com.diyainfotech.covid19.rssFeedParser.engine

import com.diyainfotech.covid19.rssFeedParser.Channel
import com.diyainfotech.covid19.rssFeedParser.core.CoreXMLParser
import java.util.concurrent.Callable

class XMLParser(var xml: String) : Callable<Channel> {

    @Throws(Exception::class)
    override fun call(): Channel {
        return CoreXMLParser.parseXML(xml)
    }
}
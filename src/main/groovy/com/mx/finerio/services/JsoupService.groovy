package com.mx.finerio.services

import org.jsoup.nodes.Document

interface JsoupService {
    Document getHtmlPage(String url)
}
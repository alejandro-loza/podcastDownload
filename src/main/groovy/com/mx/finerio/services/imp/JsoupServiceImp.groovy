package com.mx.finerio.services.imp

import com.mx.finerio.services.JsoupService
import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class JsoupServiceImp implements JsoupService {

    @Override
    Document getHtmlPage(String url){
        Jsoup.connect(url).get()
    }
}

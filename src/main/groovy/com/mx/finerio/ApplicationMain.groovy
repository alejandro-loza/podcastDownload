package com.mx.finerio

import com.mx.finerio.services.HtmlHandlerService
import com.mx.finerio.services.imp.HtmlHandlerServiceImp

class ApplicationMain {
    static void main(String[] args) {
        HtmlHandlerService html = new HtmlHandlerServiceImp()
        html.downloadHtmlPage().each {println(it.getFullName())}
    }
}

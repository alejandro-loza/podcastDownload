package com.mx.finerio.serivices

import com.mx.finerio.dtos.Podcast
import com.mx.finerio.services.HtmlHandlerService
import com.mx.finerio.services.JsoupService
import com.mx.finerio.services.imp.HtmlHandlerServiceImp
import com.mx.finerio.utils.TestUtils
import spock.lang.Specification


class HtmlHandlerServiceSpec  extends Specification{

    HtmlHandlerService handlerService = new HtmlHandlerServiceImp()

    def setup(){
        handlerService.jsoupService = Mock(JsoupService)
    }

    def "Should return an podcast list "() {
       when:'download html page'
       def response = handlerService.podcastFromHtml(_ as String)

       then:
       1 * handlerService.jsoupService.getHtmlPage(_ as String) >> new TestUtils().buildHtmlDocument()
       assert response instanceof List<Podcast>
    }

}

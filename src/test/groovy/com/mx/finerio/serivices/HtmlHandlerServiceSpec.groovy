package com.mx.finerio.serivices

import com.mx.finerio.dtos.Podcast
import com.mx.finerio.services.HtmlHandlerService
import com.mx.finerio.services.JsoupService
import com.mx.finerio.services.imp.HtmlHandlerServiceImp
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import spock.lang.Specification


class HtmlHandlerServiceSpec  extends Specification{

    HtmlHandlerService handlerService = new HtmlHandlerServiceImp()

    def setup(){
        handlerService.jsoupService = Mock(JsoupService)
    }

    def "Should return an podcast list "() {
       when:'download html page'
       def response = handlerService.downloadHtmlPage()

       then:
       1 * handlerService.jsoupService.getHtmlPage(_ as String) >> buildHtmlDocument()
       assert !response
       assert response instanceof List<Podcast>
    }

    private static Document buildHtmlDocument() {
        Jsoup.parse( '''
                <html><head><title>First parse</title></head><body>
                <a class="link-complex popup__list__item island--squashed br-subtle-bg-ontext br-subtle-bg-onbg--hover br-subtle-link-ontext--hover"
                 href="//open.live.bbc.co.uk/mediaselector/6/redir/version/2.0/mediaset/audio-nondrm-download-low/proto/https/vpid/p0869qzb.mp3"
                 download="Body Horror, Episode 6 - p0869yv2.mp3\" aria-label=\"Download Lower quality (64kbps) "></a>
                 </body></html>
                '''
        )
    }
}

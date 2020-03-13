package com.mx.finerio.services.imp

import com.mx.finerio.dtos.Podcast
import com.mx.finerio.services.HtmlHandlerService
import com.mx.finerio.services.JsoupService
import org.apache.log4j.Logger
import org.jsoup.HttpStatusException

class HtmlHandlerServiceImp implements HtmlHandlerService {

    public static final String CLASS = 'link-complex popup__list__item island--squashed br-subtle-bg-ontext br-subtle-bg-onbg--hover br-subtle-link-ontext--hover'
    private static Logger log = Logger.getLogger(HtmlHandlerServiceImp.class)

    JsoupService jsoupService = new JsoupServiceImp()

    @Override
    List<Podcast> podcastFromHtml(String url) {
        List<Podcast> podcast = []
        try{
            podcast = jsoupService.getHtmlPage(url)
                    .getElementsByClass(CLASS).collect({ it -> new Podcast(it) })
        }catch(HttpStatusException e){
            log.error( 'Can not download podcast: ' << e.message)
        }
        podcast
    }

}

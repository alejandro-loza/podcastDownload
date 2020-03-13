package com.mx.finerio.services.imp

import com.mx.finerio.dtos.Podcast
import com.mx.finerio.services.HtmlHandlerService
import com.mx.finerio.services.JsoupService
import org.jsoup.HttpStatusException

class HtmlHandlerServiceImp implements HtmlHandlerService {

    public static final String BBC_PODCAST_URL = 'https://www.bbc.co.uk/programmes/p086934c/episodes/downloads'
    public static final String CLASS = 'link-complex popup__list__item island--squashed br-subtle-bg-ontext br-subtle-bg-onbg--hover br-subtle-link-ontext--hover'

    JsoupService jsoupService = new JsoupServiceImp()

    @Override
    List<Podcast> downloadHtmlPage() {
        List<Podcast> podcast = []
        try{
            podcast = jsoupService.getHtmlPage(BBC_PODCAST_URL)
                    .getElementsByClass(CLASS).collect({ it -> new Podcast(it) })
        }catch(HttpStatusException e){
            println 'Can not download podcast: ' << e.message //TODO place it into logger
        }
        podcast
    }

}

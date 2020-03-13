package com.mx.finerio.services.imp

import com.mx.finerio.dtos.Podcast
import com.mx.finerio.services.HtmlHandlerService
import org.jsoup.Jsoup
import org.springframework.stereotype.Service

@Service
class HtmlHandlerServiceImp implements HtmlHandlerService {

    public static final String BBC_PODCAST_URL = 'https://www.bbc.co.uk/programmes/p086934c/episodes/downloads'
    public static final String CLASS = 'link-complex popup__list__item island--squashed br-subtle-bg-ontext br-subtle-bg-onbg--hover br-subtle-link-ontext--hover'

    @Override
    List<Podcast> downloadHtmlPage() {
        Jsoup.connect(BBC_PODCAST_URL).get().getElementsByClass(CLASS).collect({ it -> new Podcast(it) })
    }

}

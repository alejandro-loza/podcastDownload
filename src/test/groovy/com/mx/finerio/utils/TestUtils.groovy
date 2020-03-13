package com.mx.finerio.utils

import org.jsoup.Jsoup
import org.jsoup.nodes.Document

class TestUtils {
    static Document buildHtmlDocument() {
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

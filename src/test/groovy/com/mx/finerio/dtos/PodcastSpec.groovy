package com.mx.finerio.dtos

import com.mx.finerio.utils.TestUtils
import org.jsoup.nodes.Element
import spock.lang.Specification

class PodcastSpec extends Specification {

    def "Should instanciate a Podcast"(){
        given:'a Element instance'
        Element element = new TestUtils().buildHtmlDocument().getElementsByTag('a').first()

        and:'a podcast instance'
        Podcast podcast = new Podcast(element)

        expect:
        podcast.with {
            assert getQuality() == 'Lower'
            assert name == 'Body Horror, Episode 6 - p0869yv2.mp3'
            assert getUrl() == 'https://open.live.bbc.co.uk/mediaselector/6/redir/version/2.0/mediaset/audio-nondrm-download-low/proto/https/vpid/p0869qzb.mp3'
            assert getCategory() == 'Body Horror'
        }

    }
}

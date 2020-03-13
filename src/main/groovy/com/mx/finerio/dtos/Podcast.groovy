package com.mx.finerio.dtos

import org.jsoup.nodes.Element

class Podcast {
    String name
    String url
    String quality

    Podcast(Element element) {
        this.name = element.attr('download')
        this.url = element.attr('href')
        this.quality = element.attr('aria-label')
    }

    String getUrl(){
        "https:${this.url}"
    }

    String getQuality(){
        this.quality.tokenize()[1]
    }

    String getCategory(){
        this.name.tokenize(',').first()
    }

    String getFullName(){
        this.name << ' ' <<  this.getQuality()
    }
}




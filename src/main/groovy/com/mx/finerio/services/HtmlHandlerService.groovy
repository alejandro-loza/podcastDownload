package com.mx.finerio.services

import com.mx.finerio.dtos.Podcast

interface HtmlHandlerService {
    List<Podcast> podcastFromHtml(String url)
}
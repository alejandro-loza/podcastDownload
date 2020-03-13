package com.mx.finerio.controller.imp

import com.mx.finerio.controller.DownloadController
import com.mx.finerio.dtos.Podcast
import com.mx.finerio.services.DownloadService
import com.mx.finerio.services.HtmlHandlerService
import com.mx.finerio.services.imp.DownloadServiceImp
import com.mx.finerio.services.imp.HtmlHandlerServiceImp
import org.apache.log4j.Logger

class DownloadControllerImp implements DownloadController {

    private static Logger log = Logger.getLogger(DownloadControllerImp.class)

    HtmlHandlerService handlerService = new HtmlHandlerServiceImp()
    DownloadService downloadService = new DownloadServiceImp()

    @Override
    void downloadPodcasts(){
        List<Podcast> podcasts = handlerService.podcastFromHtml()
            if(podcasts.isEmpty()){
                log.error("No podcast found on page")
                return
            }
            podcasts.stream().parallel().each {downloadService.tryDownload(it)}
    }
}

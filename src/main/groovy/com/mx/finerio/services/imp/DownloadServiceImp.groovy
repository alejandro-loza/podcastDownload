package com.mx.finerio.services.imp

import com.mx.finerio.dtos.Podcast
import com.mx.finerio.services.DownloadService
import org.apache.commons.io.FileUtils
import org.apache.log4j.Logger

class DownloadServiceImp implements DownloadService {
    private static Logger log = Logger.getLogger(DownloadServiceImp.class)
    @Override
    void tryDownload(Podcast podcast) {
        try {
            log.info("Downloading: ${podcast.getFullName()}")
            FileUtils.copyURLToFile(
                    new URL(podcast.url),
                    new File("files/${podcast.getCategory()}/${podcast.getQuality()}/${podcast.name}")
            )
        }catch(IOException e){
            log.error("Can not download file ${podcast.name} stachktrace: ${e.message}")
        }
    }
}

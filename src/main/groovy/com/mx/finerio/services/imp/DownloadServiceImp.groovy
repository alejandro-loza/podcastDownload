package com.mx.finerio.services.imp

import com.mx.finerio.dtos.Podcast
import com.mx.finerio.services.DownloadService
import org.apache.commons.io.FileUtils
import org.apache.log4j.Logger

class DownloadServiceImp implements DownloadService {
    private static Logger log = Logger.getLogger(DownloadServiceImp.class)
    @Override
    void tryDownload(Podcast it) {
        try {
            log.info("Downloading: ${it.getFullName()}")
            FileUtils.copyURLToFile(
                    new URL(it.url),
                    new File("files/${it.getCategory()}/${it.getQuality()}/${it.name}")
            )
        }catch(IOException e){
            log.error("Can not download file ${it.name} stachktrace: ${e.message}")
        }
    }
}

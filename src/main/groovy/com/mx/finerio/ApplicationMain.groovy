package com.mx.finerio

import com.mx.finerio.controller.DownloadController
import com.mx.finerio.controller.imp.DownloadControllerImp
import com.mx.finerio.dtos.Arguments
import com.mx.finerio.enums.Quality

class ApplicationMain {

    static void main(String[] args) {
        DownloadController downloadService = new DownloadControllerImp()
        downloadService.downloadPodcasts(args)
    }
}
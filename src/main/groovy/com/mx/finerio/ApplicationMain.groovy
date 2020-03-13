package com.mx.finerio

import com.mx.finerio.controller.DownloadController
import com.mx.finerio.controller.imp.DownloadControllerImp

class ApplicationMain {
    static void main(String[] args) {
        DownloadController downloadService = new DownloadControllerImp()
        downloadService.downloadPodcasts()
    }
}

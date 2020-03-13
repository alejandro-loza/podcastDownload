package com.mx.finerio.services

import com.mx.finerio.dtos.Podcast

interface DownloadService {
    void tryDownload(Podcast it)
}
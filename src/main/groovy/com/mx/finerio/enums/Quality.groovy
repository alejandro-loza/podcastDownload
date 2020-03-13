package com.mx.finerio.enums

enum Quality {
    LOWER('Lower'), HIGHER('Higher')
    Quality(String value) {
        this.value = value
    }
    private final String value
    String getValue() {
        value
    }

}
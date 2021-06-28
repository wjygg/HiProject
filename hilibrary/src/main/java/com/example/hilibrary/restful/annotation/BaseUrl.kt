package com.example.hilibrary.restful.annotation

import java.lang.annotation.RetentionPolicy


@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
annotation class BaseUrl(val str:String) {
}
package com.example.core.network

import okhttp3.Interceptor
import okhttp3.Response


class ServiceInterceptor constructor(

) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()

        return chain.proceed(request)
    }

}
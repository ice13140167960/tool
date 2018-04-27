@file:Suppress("unused")

package com.ice.tool

import javax.servlet.*
import javax.servlet.http.HttpServletResponse
import java.io.IOException

/**
 * CORS跨域代理Fileter
 */
class CORSFilter : Filter {

    override fun init(filterConfig: FilterConfig) {

    }

    @Throws(IOException::class, ServletException::class)
    override fun doFilter(servletRequest: ServletRequest, servletResponse: ServletResponse, filterChain: FilterChain) {
        val httpResponse = servletResponse as HttpServletResponse
        httpResponse.addHeader("Access-Control-Allow-Origin", "*")
        filterChain.doFilter(servletRequest, servletResponse)
    }

    override fun destroy() {

    }
}

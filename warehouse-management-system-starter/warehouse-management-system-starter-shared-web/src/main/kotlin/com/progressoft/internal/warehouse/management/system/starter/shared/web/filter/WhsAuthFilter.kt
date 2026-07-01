package com.progressoft.internal.warehouse.management.system.starter.shared.web.filter

import io.arkitik.radix.develop.shared.ext.notAuthorized
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.http.HttpHeaders
import org.springframework.web.filter.OncePerRequestFilter
import java.io.File
import java.io.FileInputStream
import java.io.InputStream
import java.security.Signature
import java.security.cert.Certificate
import java.security.cert.CertificateFactory
import java.util.*

class WhsAuthFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain,
    ) {

        val accessToken: String? = getAccessToken(request)
        if (accessToken.isNullOrBlank())
            throw AuthErrors.NO_AUTH_TOKEN.notAuthorized()

        val parts = accessToken.split(".")


        val signedData = "${parts[0]}.${parts[1]}".toByteArray(Charsets.UTF_8)
        val signatureBytes = Base64.getUrlDecoder().decode(parts[2])

        val certificateFactory: CertificateFactory = CertificateFactory.getInstance("X.509")
        val signature: Signature = Signature.getInstance("SHA256withRSA")

        val initialFile: File =
            File("/home/majdalkhawaja/Development/warehouse-management-system/warehouse-management-system-starter/warehouse-management-system-starter-shared-web/src/main/resources/certificate.crt")
        val targetStream: InputStream = FileInputStream(initialFile);

        val generateCertificate: Certificate = certificateFactory.generateCertificate(targetStream)

        signature.initVerify(generateCertificate)
        signature.update(signedData)

        val isValid = signature.verify(signatureBytes)
        if (!isValid) {
            throw AuthErrors.INVALID_SIGNATURE.notAuthorized()
        }

        filterChain.doFilter(request, response)

    }


    private fun getAccessToken(request: HttpServletRequest): String? =
        request.getHeader(HttpHeaders.AUTHORIZATION)?.replace("Bearer", "")?.trim()

}
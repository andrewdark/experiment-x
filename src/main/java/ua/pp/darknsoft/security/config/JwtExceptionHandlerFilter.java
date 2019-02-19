package ua.pp.darknsoft.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;
import ua.pp.darknsoft.errors.ErrorCode;
import ua.pp.darknsoft.errors.ErrorCodes;
import ua.pp.darknsoft.errors.ErrorResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtExceptionHandlerFilter extends OncePerRequestFilter {

    @Autowired
    private ErrorCodes errorCodes;

	@Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            ErrorCode errorCode = errorCodes.of(e);
            ErrorResponse errorResponse = ErrorResponse.of(errorCode.httpStatus(), new ErrorResponse.ApiError(errorCode.code(), e.getMessage()));
            response.setStatus(errorCode.httpStatus().value());
            response.getOutputStream().println(new ObjectMapper().writeValueAsString(errorResponse));
        } catch (SignatureException | MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            ErrorCode errorCode = errorCodes.of(e);
            ErrorResponse errorResponse = ErrorResponse.of(errorCode.httpStatus(), new ErrorResponse.ApiError(errorCode.code(), ""));
            response.setStatus(errorCode.httpStatus().value());
            response.getOutputStream().println(new ObjectMapper().writeValueAsString(errorResponse));
        }
    }
}
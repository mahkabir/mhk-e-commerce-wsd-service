package com.mhk.wsd.ecommerce.common.handlers;

import com.mhk.wsd.ecommerce.common.exceptions.CustomRootException;
import com.mhk.wsd.ecommerce.domain.response.ApiResponse;
import com.mhk.wsd.ecommerce.service.SalesServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class EcommerceWsdExceptionHandler extends BaseExceptionHandler{
    private static final Logger logger = LogManager.getLogger(SalesServiceImpl.class);
    @ExceptionHandler(CustomRootException.class)
    public final ResponseEntity<ApiResponse<Void>> handleCustomException(CustomRootException ex) {
        errorLogger.error(ex.getLocalizedMessage(), ex);
        ApiResponse<Void> apiResponse = buildApiResponse(ex.getMessageCode(), ex.getMessage());
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}

package com.example.AssessmentMservice.config.Feign;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomErrorDecoder implements ErrorDecoder {

    private final ErrorDecoder defaultErrorDecoder = new Default();

    @Override
    public Exception decode(String invoqueur, Response response) {
        if(response.status() == 400) {
            return new PatientNotFoundException(
                    "Incorrect request."
            );
        }
        return defaultErrorDecoder.decode(invoqueur, response);
    }
}

package com.fiappostech.burgerbox.infraestructure.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public class InternalServerErrorException {
    @Schema(description = "Código de status HTTP", example = "500")
    private int status;

    @Schema(description = "Detalhes do erro", example = "Internal Server Error")
    private String error;

    @Schema(description = "A data e hora do erro", example = "2024-03-10T00:22:23.606+00:00")
    private String timestamp;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

package com.fiappostech.burgerbox.infraestructure.swagger;

import io.swagger.v3.oas.annotations.media.Schema;

public class ConflictException {
    @Schema(description = "Tipo de erro", example = "about:blank")
    private String type;

    @Schema(description = "Título do erro", example = "Conflict")
    private String title;

    @Schema(description = "Código de status HTTP", example = "409")
    private int status;

    @Schema(description = "Detalhes do erro", example = "Detalhes do erro.")
    private String detail;

    @Schema(description = "Instância do erro", example = "caminho do recurso")
    private String instance;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getInstance() {
        return instance;
    }

    public void setInstance(String instance) {
        this.instance = instance;
    }
}

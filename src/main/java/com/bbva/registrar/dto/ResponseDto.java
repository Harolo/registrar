package com.bbva.registrar.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ResponseDto {
    private String tipoDocumento;
    private String tipoIdentificacionC;
    private String tipoDocumentoC;
    private String tipoIdentificacionB;
    private String tipoDocumentoB;
    private String tipoArchivo;

}

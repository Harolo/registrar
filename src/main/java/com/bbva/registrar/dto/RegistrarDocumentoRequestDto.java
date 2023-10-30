package com.bbva.registrar.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegistrarDocumentoRequestDto {

    private String tipoDocumento;
    private String tipoIdentificacionC;
    private String tipoDocumentoC;
    private String tipoIdentificacionB;
    private String tipoDocumentoB;
    private String tipoArchivo;
    private String codigoTransaccion;

}

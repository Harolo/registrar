package com.bbva.registrar.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RegistroRegDocElement {

    private ResponseDto responseDto;

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(String.format("%s", responseDto));
        return str.toString();
    }

    public void mapRegistroDocumentoRequestDto(RegistrarDocumentoRequestDto registrarDocumentoRequestDto) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setTipoDocumento(registrarDocumentoRequestDto.getTipoDocumento());
        responseDto.setTipoIdentificacionC(registrarDocumentoRequestDto.getTipoIdentificacionC());
        responseDto.setTipoDocumentoC(registrarDocumentoRequestDto.getTipoDocumentoC());
        responseDto.setTipoIdentificacionB(registrarDocumentoRequestDto.getTipoIdentificacionB());
        responseDto.setTipoDocumentoB(registrarDocumentoRequestDto.getTipoDocumentoB());
        responseDto.setTipoArchivo(registrarDocumentoRequestDto.getTipoArchivo());
        this.setResponseDto(responseDto);
    }
}

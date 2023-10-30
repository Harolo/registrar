package com.bbva.registrar.controller;

import com.bbva.registrar.dto.RegistrarDocumentoRequestDto;
import com.bbva.registrar.service.FileProcessingService;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class FileProcessingController {

    private final FileProcessingService fileProcessingService;

    @PostMapping("/procesar")
    public ResponseEntity<List<RegistrarDocumentoRequestDto>> procressFile(){

        List<RegistrarDocumentoRequestDto> list = fileProcessingService.processFile();
        return ResponseEntity.ok(list);
    }
}

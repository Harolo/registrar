package com.bbva.registrar.utils;

import com.bbva.registrar.dto.RegistrarDocumentoRequestDto;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UtilFile {

    public void unzipFile(String zipFilePath, String destinationPath) throws IOException {
        byte[] buffer = new byte[1024];

        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(zipFilePath))) {
            ZipEntry zipEntry = zipInputStream.getNextEntry();

            while (zipEntry != null) {
                String entryName = zipEntry.getName();
                String filePath = destinationPath + File.separator + entryName;

                if (!zipEntry.isDirectory()) {
                    new File(filePath).getParentFile().mkdirs();

                    try (FileOutputStream fos = new FileOutputStream(filePath)) {
                        int len;
                        while ((len = zipInputStream.read(buffer)) > 0) {
                            fos.write(buffer, 0, len);
                        }
                    }
                }

                zipEntry = zipInputStream.getNextEntry();
            }
        }
    }

    public static RegistrarDocumentoRequestDto dataConstruction(String[] datos) {
        RegistrarDocumentoRequestDto registrarDocumentoRequestDto = new RegistrarDocumentoRequestDto();
        registrarDocumentoRequestDto.setTipoDocumento(cleanData(datos[0]));
        registrarDocumentoRequestDto.setTipoIdentificacionC(cleanData(datos[1]));
        registrarDocumentoRequestDto.setTipoDocumentoC(cleanData(datos[2]));
        registrarDocumentoRequestDto.setTipoIdentificacionB(cleanData(datos[3]));
        registrarDocumentoRequestDto.setTipoDocumentoB(cleanData(datos[4]));
        registrarDocumentoRequestDto.setTipoArchivo(cleanData(datos[5]));
        return registrarDocumentoRequestDto;
    }

    public static String cleanData(String data) {
        return data != null ? data.replace(" ", "") : data;
    }

    public static String formatDateGeneric() {
        TimeZone tz = TimeZone.getTimeZone("GMT-5");
        Calendar c = Calendar.getInstance(tz);

        return String.format("%02d", c.get(Calendar.DAY_OF_MONTH)) +
                String.format("%02d", (c.get(Calendar.MONTH) + 1)) +
                String.format("%02d", c.get(Calendar.YEAR));
    }

}

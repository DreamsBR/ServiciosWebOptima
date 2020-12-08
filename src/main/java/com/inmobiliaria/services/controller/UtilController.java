package com.inmobiliaria.services.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;
import java.util.Date;

import org.apache.tomcat.jni.Directory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inmobiliaria.services.model.request.DecodeFileRequest;
import com.inmobiliaria.services.model.request.FileRequest;
import com.inmobiliaria.services.model.response.DecodeFileResponse;
import com.inmobiliaria.services.model.response.FileResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/v1/util")
@Api(value = "util", produces = "application/json", tags = { "Controlador util" })
@PreAuthorize("isAuthenticated()") 
public class UtilController {
	@PostMapping("/upload")
	@ApiOperation(value = "servicio upload", tags = { "Controlador util" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = String.class)
	})
	public ResponseEntity<DecodeFileResponse> upload(@RequestBody DecodeFileRequest fileRequest) {
		DecodeFileResponse response = new DecodeFileResponse();
		Date date= new Date();
		String ruta= "/serverfile/" + date.getTime() + "_" +  fileRequest.getFileName();
		File directorio = new File("/serverfile");
        if (!directorio.exists()) {
            directorio.mkdirs();
        }
		
	    File file = new File(ruta);

	    try ( FileOutputStream fos = new FileOutputStream(file); ) {
	      // To be short I use a corrupted PDF string, so make sure to use a valid one if you want to preview the PDF file
	      //String fileString = "JVBERi0xLjUKJYCBgoMKMSAwIG9iago8PC9GaWx0ZXIvRmxhdGVEZWNvZGUvRmlyc3QgMTQxL04gMjAvTGVuZ3==";
	      byte[] decoder = Base64.getDecoder().decode(fileRequest.getBase64());

	      fos.write(decoder);
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    response.setFileName(ruta);
	    return ResponseEntity.ok().body(response);
	}
	@PostMapping("/download")
	@ApiOperation(value = "servicio download", tags = { "Controlador util" })
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "OK", response = String.class)
	})
	public FileResponse download(@RequestBody FileRequest fileRequest) {
		FileResponse response = new FileResponse();
	    File file = new File(fileRequest.getFileName());
	    try {
	        byte[] fileContent = Files.readAllBytes(file.toPath());
	        response.setBase64(Base64.getEncoder().encodeToString(fileContent));
	        response.setFileName(fileRequest.getFileName());
	    } catch (IOException e) {
	        throw new IllegalStateException("could not read file " + file, e);
	    }
	    return response;
	}
}

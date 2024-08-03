package com.cgi.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgi.utils.FileHelper;

@RestController
@RequestMapping(path = "investimento")
public class InvestimentoController {

    @Autowired
    private FileHelper fileHelper;

    @GetMapping("/image")
    public ResponseEntity<byte[]> getImage() throws IOException {
        Path path = Paths.get(new ClassPathResource("image/pix.jpeg").getURI());
        BufferedImage originalImage = ImageIO.read(Files.newInputStream(path));

        BufferedImage resizedImage = this.fileHelper.resizeImage(originalImage, 400, 400);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(resizedImage, "jpg", baos);
        byte[] imageBytes = baos.toByteArray();

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(imageBytes);
    }

}

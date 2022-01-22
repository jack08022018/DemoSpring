package com.demo.controller;


import com.demo.dto.ProductDto;
import com.demo.pdf.PDFGenerator;
import com.demo.service.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.ByteArrayInputStream;

@RestController
@RequestMapping(value = "/api")
public class ApiController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/view")
    public ModelAndView view() {
        ModelAndView view = new ModelAndView();
        view.setViewName("view");
        return view;
    }

    @GetMapping(value = "/index")
    public ModelAndView index() {
        ModelAndView view = new ModelAndView();
        view.setViewName("index");
        return view;
    }

    @PostMapping(value = "/products")
    public Page<ProductDto> products(@RequestBody ProductDto dto) {
        return productService.getProductList(dto);
    }

    @PostMapping("/getProductData")
    JsonNode getProductData() throws JsonMappingException, JsonProcessingException {
        String jsonStr = "{\"ownerArray\":[{\"id\":1,\"value\":\"John Nash\"},{\"id\":2,\"value\":\"Leonhard Euler\"},{\"id\":3,\"value\":\"Alan Turing\"}],\"categoryArray\":[{\"id\":1,\"value\":\"Clothing\"},{\"id\":2,\"value\":\"Jewelery\"},{\"id\":3,\"value\":\"Accessory\"}]}";
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readTree(jsonStr);
        return jsonNode;
    }

    @GetMapping(value = "/exportPdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<InputStreamResource> exportPdf() throws Exception {
        ByteArrayInputStream bis = PDFGenerator.getPdfReport();
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "inline; filename=customers.pdf");
        return ResponseEntity
                .ok()
                .headers(headers)
                .contentType(MediaType.APPLICATION_PDF)
                .body(new InputStreamResource(bis));
    }
}

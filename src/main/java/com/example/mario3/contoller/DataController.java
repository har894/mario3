package com.example.mario3.contoller;

import com.example.mario3.entity.Point;
import com.example.mario3.service.ProcessingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class DataController {

    private final ProcessingService processingService;

    @RequestMapping(value = "/{angle}/{distance}", method = RequestMethod.GET)
    public ResponseEntity<String> processData(@PathVariable Double angle, @PathVariable Double distance){
        Point point = processingService.getPointByDetectedParams(angle,distance);
        return ResponseEntity.ok(point.toString());
    }

}

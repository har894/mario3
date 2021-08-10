package com.example.mario3.contoller;

import com.example.mario3.entity.Point;
import com.example.mario3.payload.TargetData;
import com.example.mario3.service.DataStorageServiceUtil;
import com.example.mario3.service.ProcessingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class DataController {

    private final ProcessingService processingService;
    final DataStorageServiceUtil dataStorageServiceUtil = new DataStorageServiceUtil();

    @RequestMapping(value = "/finder", method = RequestMethod.GET)
    public ResponseEntity<String> processData(@RequestBody TargetData targetData){
        Point point = processingService.getPointByDetectedParams(targetData.getAngle(),targetData.getDistance(),targetData.isDetectorID());
        return ResponseEntity.ok(point.toString());
    }

    @RequestMapping(value = "/getPoint", method = RequestMethod.GET)
    public ResponseEntity<String> doDespersion(){
        Point point = DataStorageServiceUtil.getPointByDispersion();
        return ResponseEntity.ok(point.toString());
    }

}

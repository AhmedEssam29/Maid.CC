package com.yourcompany.mobileprice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService; // Use an interface for loose coupling

    @PostMapping("/")
    public ResponseEntity<List<Device>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        return ResponseEntity.ok(deviceService.getDeviceById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Device> addDevice(@RequestBody Device device) {
        return ResponseEntity.ok(deviceService.addDevice(device));
    }

    @PostMapping("/predict/{deviceId}")
    @Transactional
    public ResponseEntity<Device> predictPrice(@PathVariable Long deviceId) throws Exception {
        Device device = deviceService.getDeviceById(deviceId);
        Double predictedPrice = callPythonModel(device); // Call your Python model
        device.setPredictedPrice(predictedPrice);
        deviceService.saveDevice(device);
        return ResponseEntity.ok(device);
    }

    // Utility method to call your Python model (implementation details omitted)
    private Double callPythonModel(Device device) throws Exception {
        // ... Call your Python model using appropriate libraries and return the prediction
    }
}

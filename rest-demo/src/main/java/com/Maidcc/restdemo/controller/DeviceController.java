package com.example.mobileprice.controller;

import com.example.mobileprice.model.Device;
import com.example.mobileprice.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceRepository repository;

    // Retrieve a list of all devices
    @PostMapping("/list")
    public List<Device> getAllDevices() {
        return repository.findAll();
    }

    // Retrieve details of a specific device by ID
    @GetMapping("/{id}")
    public Device getDeviceById(@PathVariable Long id) {
        Optional<Device> device = repository.findById(id);
        return device.orElseThrow(() -> new RuntimeException("Device not found with id " + id));
    }

    // Add a new device
    @PostMapping
    public Device addDevice(@RequestBody Device device) {
        return repository.save(device);
    }

    // Predict the price for a specific device and save the result in the device entity
    @PostMapping("/predict/{deviceId}")
    @Transactional
    public Device predictPrice(@PathVariable Long deviceId) {
        Device device = repository.findById(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found with id " + deviceId));

        // Prepare data to send to the Flask model
        RestTemplate restTemplate = new RestTemplate();
        String flaskUrl = "http://localhost:5000/predict";
        
        // Construct the JSON payload
        String jsonPayload = constructJsonPayload(device);
        
        // Send request to Flask model and get the response
        String predictedPrice = restTemplate.postForObject(flaskUrl, jsonPayload, String.class);

        // Parse the response and update the device entity
        device.setPredictedPrice(Float.parseFloat(predictedPrice));
        repository.save(device);
        
        return device;
    }

    private String constructJsonPayload(Device device) {
        return String.format(
            "{\"battery_power\":%f,\"blue\":%d,\"clock_speed\":%f,\"dual_sim\":%d,\"fc\":%d,\"four_g\":%d,\"int_memory\":%d,\"m_dep\":%f,\"mobile_wt\":%d,\"n_cores\":%d,\"pc\":%d,\"px_height\":%d,\"px_width\":%d,\"ram\":%d,\"sc_h\":%d,\"sc_w\":%d,\"talk_time\":%d,\"three_g\":%d,\"touch_screen\":%d,\"wifi\":%d}",
            device.getBatteryPower(), device.getBlue(), device.getClockSpeed(), device.getDualSim(),
            device.getFc(), device.getFourG(), device.getIntMemory(), device.getMDep(), device.getMobileWt(),
            device.getNCores(), device.getPc(), device.getPxHeight(), device.getPxWidth(), device.getRam(),
            device.getScH(), device.getScW(), device.getTalkTime(), device.getThreeG(), device.getTouchScreen(),
            device.getWifi()
        );
    }
}

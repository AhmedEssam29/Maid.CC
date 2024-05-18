@PostMapping("/predict/{deviceId}")
@Transactional
public ResponseEntity<Device> predictPrice(@PathVariable Long deviceId) throws Exception {
    Device device = deviceService.getDeviceById(deviceId);
    Double predictedPrice = callPythonModel(device); // Call your Python model
    device.setPredictedPrice(predictedPrice);
    deviceService.saveDevice(device); // Consider using updateDevice if applicable
    return ResponseEntity.ok(device);
}

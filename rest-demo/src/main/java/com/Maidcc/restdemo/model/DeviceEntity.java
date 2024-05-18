package com.example.mobileprice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "device_info")
@ApiModel(description = "This table holds device information.")
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "This is a Device Id. It shall be unique.")
    private Long id;

    @ApiModelProperty(notes = "Battery power of the device.")
    private float batteryPower;

    @ApiModelProperty(notes = "Indicates if the device has Bluetooth (1: Yes, 0: No).")
    private int blue;

    @ApiModelProperty(notes = "Clock speed of the device's CPU.")
    private float clockSpeed;

    @ApiModelProperty(notes = "Indicates if the device supports dual SIM (1: Yes, 0: No).")
    private int dualSim;

    @ApiModelProperty(notes = "Front camera megapixels.")
    private int fc;

    @ApiModelProperty(notes = "Indicates if the device supports 4G (1: Yes, 0: No).")
    private int fourG;

    @ApiModelProperty(notes = "Internal memory of the device.")
    private int intMemory;

    @ApiModelProperty(notes = "Mobile depth in cm.")
    private float mDep;

    @ApiModelProperty(notes = "Weight of the mobile device.")
    private int mobileWt;

    @ApiModelProperty(notes = "Number of cores in the processor.")
    private int nCores;

    @ApiModelProperty(notes = "Primary camera megapixels.")
    private int pc;

    @ApiModelProperty(notes = "Pixel resolution height.")
    private int pxHeight;

    @ApiModelProperty(notes = "Pixel resolution width.")
    private int pxWidth;

    @ApiModelProperty(notes = "RAM of the device.")
    private int ram;

    @ApiModelProperty(notes = "Screen height of the device.")
    private int scH;

    @ApiModelProperty(notes = "Screen width of the device.")
    private int scW;

    @ApiModelProperty(notes = "Talk time of the device.")
    private int talkTime;

    @ApiModelProperty(notes = "Indicates if the device supports 3G (1: Yes, 0: No).")
    private int threeG;

    @ApiModelProperty(notes = "Indicates if the device has a touch screen (1: Yes, 0: No).")
    private int touchScreen;

    @ApiModelProperty(notes = "Indicates if the device supports WiFi (1: Yes, 0: No).")
    private int wifi;

    @ApiModelProperty(notes = "Predicted price of the device.")
    private float predictedPrice;

    public Device() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(float batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public float getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(float clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getDualSim() {
        return dualSim;
    }

    public void setDualSim(int dualSim) {
        this.dualSim = dualSim;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public int getFourG() {
        return fourG;
    }

    public void setFourG(int fourG) {
        this.fourG = fourG;
    }

    public int getIntMemory() {
        return intMemory;
    }

    public void setIntMemory(int intMemory) {
        this.intMemory = intMemory;
    }

    public float getMDep() {
        return mDep;
    }

    public void setMDep(float mDep) {
        this.mDep = mDep;
    }

    public int getMobileWt() {
        return mobileWt;
    }

    public void setMobileWt(int mobileWt) {
        this.mobileWt = mobileWt;
    }

    public int getNCores() {
        return nCores;
    }

    public void setNCores(int nCores) {
        this.nCores = nCores;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getPxHeight() {
        return pxHeight;
    }

    public void setPxHeight(int pxHeight) {
        this.pxHeight = pxHeight;
    }

    public int getPxWidth() {
        return pxWidth;
    }

    public void setPxWidth(int pxWidth) {
        this.pxWidth = pxWidth;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getScH() {
        return scH;
    }

    public void setScH(int scH) {
        this.scH = scH;
    }

    public int getScW() {
        return scW;
    }

    public void setScW(int scW) {
        this.scW = scW;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getThreeG() {
        return threeG;
    }

    public void setThreeG(int threeG) {
        this.threeG = threeG;
    }

    public int getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(int touchScreen) {
        this.touchScreen = touchScreen;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public float getPredictedPrice() {
        return predictedPrice;
    }

    public void setPredictedPrice(float predictedPrice) {
        this.predictedPrice = predictedPrice;
    }
}

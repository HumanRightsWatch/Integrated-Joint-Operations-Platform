package com.fec.report.dao;

public class WifiDetector {
    private Integer centerFrequency;
    private Integer channelFrequency;
    private Integer channelWidth;
    private String encryptionMethod;
    private Double latitude;
    private String locationDescription;
    private Double longitude;
    private String macAddress;
    private String name;
    private String note;
    private Integer signalLevel;

    public WifiDetector(String macAddress) {
        this.macAddress = macAddress;
    }

    public WifiDetector(String macAddress, String name, String encryptionMethod, Integer signalLevel, Integer channelWidth, Integer centerFrequency, Integer channelFrequency, String note, Double latitude, Double longitude, String locationDescription) {
        this.macAddress = macAddress;
        this.name = name;
        this.encryptionMethod = encryptionMethod;
        this.signalLevel = signalLevel;
        this.channelWidth = channelWidth;
        this.centerFrequency = centerFrequency;
        this.channelFrequency = channelFrequency;
        this.note = note;
        this.latitude = latitude;
        this.longitude = longitude;
        this.locationDescription = locationDescription;
    }

    public String getMacAddress() {
        return this.macAddress;
    }

    public void setMacAddress(String macAddress) {
        this.macAddress = macAddress;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEncryptionMethod() {
        return this.encryptionMethod;
    }

    public void setEncryptionMethod(String encryptionMethod) {
        this.encryptionMethod = encryptionMethod;
    }

    public Integer getSignalLevel() {
        return this.signalLevel;
    }

    public void setSignalLevel(Integer signalLevel) {
        this.signalLevel = signalLevel;
    }

    public Integer getChannelWidth() {
        return this.channelWidth;
    }

    public void setChannelWidth(Integer channelWidth) {
        this.channelWidth = channelWidth;
    }

    public Integer getCenterFrequency() {
        return this.centerFrequency;
    }

    public void setCenterFrequency(Integer centerFrequency) {
        this.centerFrequency = centerFrequency;
    }

    public Integer getChannelFrequency() {
        return this.channelFrequency;
    }

    public void setChannelFrequency(Integer channelFrequency) {
        this.channelFrequency = channelFrequency;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getLatitude() {
        return this.latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return this.longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getLocationDescription() {
        return this.locationDescription;
    }

    public void setLocationDescription(String locationDescription) {
        this.locationDescription = locationDescription;
    }
}

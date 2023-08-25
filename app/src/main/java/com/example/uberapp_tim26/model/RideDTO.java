package com.example.uberapp_tim26.model;

import java.util.List;

public class RideDTO {
    private Integer id;
    private String startTime;
    private String endTime;
    private int totalCost;
    private DriverCredentialsDTO driver;
    private List<PassengerCredentialsDTO> passengers;
    private Integer estimatedTimeInMinutes;
    private String vehicleType;
    private boolean babyTransport;
    private boolean petTransport;
    private RejectionDTO rejection;
    private List<RouteDTO> locations;
    private String status;
}

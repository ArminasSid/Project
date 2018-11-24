/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package groupwork;

/**
 *
 * @author Juliu
 */
public class Distance {

    private String Origin;
    private String Destination;
    private double Distance;
    private double Time;

    public Distance() {

    }

    public void Set(String origin, String destination, double distance, double time) {
        if (origin == null ? destination != null : !origin.equals(destination)) { // if Destination is not equal to Origin
            Origin = origin;
            Destination = destination;
            Distance = distance;
            Time = time;
        }
    }
    
    public String getOrigin() {
        return Origin;
    }

    public String getDestination() {
        return Destination;
    }

    public double getDistance() {
        return Distance;
    }

    public double getTime() {
        return Time;
    }
    @Override
    public String toString()
    {
        String temp = Origin + " " + Destination + " " + Distance + " " + Time;
        return temp;        
    }
}

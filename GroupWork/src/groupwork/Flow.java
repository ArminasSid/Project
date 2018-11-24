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
public class Flow {
    private String load;
    private String unload;
    private String type;
    private int tons;
    private double tonKMs; // CO2 emissions per km
    public Flow()
    {
        
    }
    public void Set(String load, String unload, String type, int tons, double tonKMs)
    {
        this.load = load;
        this.unload = unload;
        this.type = type;
        this.tons = tons;
        this.tonKMs = tonKMs;
    }
    
}

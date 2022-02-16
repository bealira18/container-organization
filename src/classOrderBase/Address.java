/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classOrderBase;

import order.base.IAddress;

/*
* Nome: Beatriz Fonseca Lira de Meireles
* Número: 8190124
* Turma: 2
*
* Nome: Fábio dos Santos Sousa
* Número: 8190181
* Turma: 4
*/
/**
 * Class of Address
 * It extends the interface of IAddress
 */
public class Address implements IAddress{
    
    private String city;
    private String country;
    private int number;
    private String state;
    private String street;
    
    /**
     * constructor
     * used to set initial values for object attribute
     * @param city
     * @param country
     * @param number
     * @param state
     * @param street 
     */
    public Address(String city, String country, int number, String state, String street){
        this.city=city;
        this.country=country;
        this.number=number;
        this.state=state;
        this.street=street;
    }
    
    /**
     * getter for city
     * @return city
     */
    @Override
    public String getCity() {
        return city;
    }

    /**
     * getter for country
     * @return country
     */
    @Override
    public String getCountry() {
        return country;
    }

    /**
     * getter for the port number
     * @return number
     */
    @Override
    public int getNumber() {
        return number;
    }

    /**
     * getter for the state
     * @return state
     */
    @Override
    public String getState() {
        return state;
    }

    /**
     * getter for the street
     * @return street
     */
    @Override
    public String getStreet() {
        return street;
    }

    /**
     * setter for the address city
     * @param city 
     */
    @Override
    public void setCity(String city) {
        this.city=city;
    }

    /**
     * setter for the address country
     * @param country 
     */
    @Override
    public void setCountry(String country) {
        this.country=country;
    }

    /**
     * setter for the port number
     * @param number 
     */
    @Override
    public void setNumber(int number) {
        this.number=number;
    }

    /**
     * setter for the port state
     * @param state 
     */
    @Override
    public void setState(String state) {
        this.state=state;
    }

    /**
     * setter for the port street
     * @param street 
     */
    @Override
    public void setStreet(String street) {
        this.street=street;
    }
    
    /**
     * 
     * @return values of the object address
     */
    @Override
    public String toString(){
        return "City: " + getCity()+
                "\nCountry: " + getCountry()+
                "\nNumber: " + getNumber()+
                "\nState: " + getState()+
                "\nStreet: " + getStreet();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clients;

/**
 *
 * @author FZs
 */
public class Client {

    private String name;
    private String motherName;

    Client(String name, String city) {
        this.name = name;
        this.motherName = city;
    }

    public String getName() {
        return name;
    }

    public String getMotherName() {
        return motherName;
    }

    @Override
    public String toString() {
        return "Client{" + "name=" + name + ", motherName=" + motherName + '}';
    }

}

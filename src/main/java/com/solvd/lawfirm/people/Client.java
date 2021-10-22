package com.solvd.lawfirm.people;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Client implements Speakable {

    private static final Logger LOGGER = LogManager.getLogger(Client.class);

    private String firstName;
    private String lastName;
    private String caseCategory;
    private Lawyer lawyer;

    public Client(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        caseCategory = "undefined";
    }

    @Override
    public void sayHB() {
        LOGGER.info(firstName + " " + lastName + ", Happy people.Birthday!");
    }

    @Override
    public String saySmth(String message) {
        return firstName + " says \"" + message + "\"";
    }

    public void haveConsultation() {
        if (caseCategory.equals("undefined")) {
            LOGGER.info("I need a consultation");
        } else {
            LOGGER.info("The Category of the case is " + caseCategory);
        }
    }

    @Override
    public String toString() {
        return "First name: " + firstName + "; Last name: " + lastName + "; Case category: " + caseCategory + "\nLawyer: \n" +
                lawyer.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return Objects.equals(firstName, client.firstName) && Objects.equals(lastName, client.lastName)
                && Objects.equals(caseCategory, client.caseCategory) && Objects.equals(lawyer, client.lawyer);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((caseCategory == null) ? 0 : caseCategory.hashCode());
        result = prime * result + ((lawyer == null) ? 0 : lawyer.hashCode());
        return result;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCaseCategory() {
        return caseCategory;
    }

    public void setCaseCategory(String caseCategory) {
        this.caseCategory = caseCategory;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }
}

package com.solvd.lawfirm.cases;

import com.solvd.lawfirm.people.Client;
import com.solvd.lawfirm.service.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Set;

public class CurrentCase extends Case {

    private Date dateOfConclusion;
    private Client client;
    private Boolean vacant;
    private Set<Service> service;

    public CurrentCase(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Date of conclusion: " + dateOfConclusion + " Is the case vacant? " + vacant + "; " + super.toString() + "\nClient:\n" +
                client.getFirstName() + " " + client.getLastName() + ";";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        CurrentCase cases = (CurrentCase) obj;
        return Objects.equals(dateOfConclusion, cases.dateOfConclusion) && Objects.equals(client, cases.client);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((dateOfConclusion == null) ? 0 : dateOfConclusion.hashCode());
        result = prime * result + ((client == null) ? 0 : client.hashCode());
        result = prime * result + ((dateOfConclusion == null) ? 0 : dateOfConclusion.hashCode());
        result += super.hashCode();
        return result;
    }

    public Date getDateOfConclusion() {
        return dateOfConclusion;
    }

    public void setDateOfConclusion(Date dateOfConclusion) {
        this.dateOfConclusion = dateOfConclusion;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Boolean getVacant() {
        return vacant;
    }

    public void setVacant(Boolean Vacant) {
        this.vacant = Vacant;
    }

    public Set<Service> getService() {
        return service;
    }

    public void setService(Set<Service> service) {
        this.service = service;
    }
}

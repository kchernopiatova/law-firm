package com.solvd.lawfirm.service;

import com.solvd.lawfirm.people.Lawyer;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;

public class DocumentCheck extends Service {

    private Set<String> documents;
    private Lawyer lawyer;

    public DocumentCheck(String serviceTitle, int timeSpent, Set<String> documents, Lawyer lawyer) {
        super(serviceTitle, timeSpent);
        this.documents = documents;
        this.lawyer = lawyer;
    }

    @Override
    public String toString() {
        StringBuilder doc = new StringBuilder();
        for (String document : documents) {
            doc.append(" ");
            doc.append(document);
        }
        return super.toString() + "Document for checking:" + doc + "; Lawyer: " +
                lawyer.getFirstName() + " " + lawyer.getLastName() + ";";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        DocumentCheck doc = (DocumentCheck) obj;
        return Objects.equals(lawyer, doc.lawyer) && Arrays.equals(documents.toArray(), doc.documents.toArray()) && super.equals(obj);
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((lawyer == null) ? 0 : lawyer.hashCode());
        for (String document : documents) {
            result = prime * result + ((document == null) ? 0 : document.hashCode());
        }
        result += super.hashCode();
        return result;
    }

    public Set<String> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<String> documents) {
        this.documents = documents;
    }

    public Lawyer getLawyer() {
        return lawyer;
    }

    public void setLawyer(Lawyer lawyer) {
        this.lawyer = lawyer;
    }
}

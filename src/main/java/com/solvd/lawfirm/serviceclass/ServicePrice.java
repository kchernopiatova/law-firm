package com.solvd.lawfirm.serviceclass;

import com.solvd.lawfirm.people.Client;
import com.solvd.lawfirm.structure.Court;

public class ServicePrice {

    public double calculateLawService(Client client, Court court) {
        double startPrice = 800;
        double coefficient = 1;

        String clients = client.getCaseCategory();
        int caseNumber = court.getActualCaseNumber();

        switch (clients) {
            case "Civil":
                coefficient *= 1.3;
                break;
            case "Criminal":
                coefficient *= 1.6;
                break;
            case "Intellectual":
                coefficient *= 1.2;
                break;
            default:
                coefficient *= 1;
                break;
        }

        if (caseNumber < 5) {
            coefficient *= 1.1;
        } else if (caseNumber < 10) {
            coefficient *= 1.3;
        } else {
            coefficient *= 1.6;
        }
        return startPrice * coefficient;
    }

    public double calculateAllServices(Client... clients) {
        double totalPrice = 0;

        for (Client value : clients) {
            String client = value.getCaseCategory();
            switch (client) {
                case "Civil":
                    totalPrice += 1300;
                    break;
                case "Criminal":
                    totalPrice += 1600;
                    break;
                case "Intellectual":
                    totalPrice += 1200;
                    break;
                default:
                    totalPrice += 1000;
                    break;
            }
        }
        return totalPrice;
    }

}

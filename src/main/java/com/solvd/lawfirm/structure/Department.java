package com.solvd.lawfirm.structure;

public enum Department {

    HR("HR"), QA("QA"), WEB("Web");

    private String title;

    Department(String title) {
        this.title = title;
    }

    public String switchDepartment() {
        String result = null;
        switch (title) {
            case "QA":
                result = "There is QA department";
                break;
            case "HR":
                result = "There is HR department";
                break;
            case "Web":
                result = "There is Web department";
                break;
        }
        return result;
    }

    public String toString() {
        return "Name: " + title + ";";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

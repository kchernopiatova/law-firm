package com.solvd.lawfirm.structure;

public enum Department {

    HR("HR"), QA("QA"), WEB("Web");

    private String title;

    Department(String title) {
        this.title = title;
    }


    @Override
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

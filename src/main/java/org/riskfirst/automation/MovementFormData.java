package org.riskfirst.automation;

public class MovementFormData {
    private String email;
    private String socialLink;

    public MovementFormData() {
    }

    public MovementFormData(String email, String socialLink) {
        this.email = email;
        this.socialLink = socialLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialLink() {
        return socialLink;
    }

    public void setSocialLink(String socialLink) {
        this.socialLink = socialLink;
    }

    @Override
    public String toString() {
        return "MovementFormData{" +
                "email='" + email + '\'' +
                ", socialLink='" + socialLink + '\'' +
                '}';
    }
}

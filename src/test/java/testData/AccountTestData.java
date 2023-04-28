package testData;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public class AccountTestData {

        private Boolean activated;
        private String address;
        private String createdBy;
        private String createdDate;
        private String login;
        private String lastModifiedDate;
        private String lastModifiedBy;

        private String langKey;

        private String imageUrl;

        private Integer id;
        private String[] authorities;
        private String email;
        private String firstName;
        private String lastName;

        private String ssn;

        private String mobilePhoneNumber;

        private String password;

    public AccountTestData(String email, String firstName, String lastName, String ssn, Integer id){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.id = id;

    }

    public AccountTestData(String email, String firstName, String lastName, String ssn, String
        mobilePhoneNumber, String password, String login){
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.password = password;
        this.login = login;

    }

    public AccountTestData(String firstName,Integer id, String lastName, String ssn ){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.id=id;

    }

    public AccountTestData() {

    }

        public String[] getAuthorities () {
        return authorities;
    }

        public void setAuthorities (String[]authorities){
        this.authorities = authorities;
    }

        public String getEmail () {
        return email;
    }

        public void setEmail (String email){
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

        public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName () {
        return firstName;
    }

        public void setFirstName (String firstName){
        this.firstName = firstName;
    }

        public String getLastName () {
        return lastName;
    }

        public void setLastName (String lastName){
        this.lastName = lastName;
    }

        public String getSsn () {
        return ssn;
    }

        public void setSsn (String ssn){
        this.ssn = ssn;
    }

        public String getMobilePhoneNumber () {
        return mobilePhoneNumber;
    }

        public void setMobilePhoneNumber (String mobilePhoneNumber){
        this.mobilePhoneNumber = mobilePhoneNumber;
    }

        public String getPassword () {
        return password;
    }

        public void setPassword (String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return "AccountTestData{" +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ssn='" + ssn + '\'' +
                ", mobilePhoneNumber='" + mobilePhoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                ", id='" + id +'\'' +
                '}';
    }
}

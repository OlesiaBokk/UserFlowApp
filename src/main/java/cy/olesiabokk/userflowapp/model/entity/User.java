package cy.olesiabokk.userflowapp.model.entity;

public class User {
    private Long id;
    private String login;
    private StringBuilder password;
    private int age;

    private User(){

    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public StringBuilder getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "\nUser {" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", age=" + age +
                '}';
    }

    public static Builder newBuilder(){
        return new User().new Builder();
    }

    public class Builder {
        private Builder(){

        }

        public Builder setUserId(Long userId) {
            User.this.id = userId;
            return this;
        }

        public Builder setUserLogin(String login) {
            User.this.login = login;
            return this;
        }

        public Builder setUserPassword(StringBuilder password) {
            User.this.password = password;
            return this;
        }

        public Builder setUserAge(int userAge) {
            User.this.age = userAge;
            return this;
        }

        public User build() {
            return User.this;
        }

        public Long getUserId(){
            return User.this.id;
        }

        public String getLogin(){
            return User.this.login;
        }

        public StringBuilder getPassword(){
            return User.this.password;
        }

        public int getAge(){
            return User.this.age;
        }
    }
}

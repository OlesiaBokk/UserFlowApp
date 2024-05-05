package cy.olesiabokk.userflowapp.controller;

import cy.olesiabokk.userflowapp.model.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public interface Controller {
    Stream<User.Builder> requestUserListStream();
    Stream<User> sortDesc(List<User> sortUserList);
    Stream<User> filterEvenIdUsers(List<User> evenUserList);
    Optional<User> checkSameIdAndAgeUserList(List<User> sameIdAgeUserList);
    void printCollection(List<User> userList);
    void printUsersSameIdAge(Optional<User> optional);
}

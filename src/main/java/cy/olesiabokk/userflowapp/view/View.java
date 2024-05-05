package cy.olesiabokk.userflowapp.view;

import cy.olesiabokk.userflowapp.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface View {
    void printCollection(List<User> userList);
    void printUsersSameIdAge(Optional<User> optional);
}

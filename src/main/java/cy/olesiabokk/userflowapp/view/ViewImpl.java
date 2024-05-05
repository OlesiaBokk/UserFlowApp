package cy.olesiabokk.userflowapp.view;

import cy.olesiabokk.userflowapp.model.entity.User;

import java.util.List;
import java.util.Optional;

public class ViewImpl implements View {
    @Override
    public void printCollection(List<User> userList) {
        System.out.println(userList + "\n");
    }

    @Override
    public void printUsersSameIdAge(Optional<User> optional) {
        try {
            if (optional.isEmpty()) {
                throw new RuntimeException();
            } else {
                optional.ifPresent(System.out::println);
            }
        } catch (RuntimeException e) {
            System.out.println("There is no users having same id and age");
        }
    }
}

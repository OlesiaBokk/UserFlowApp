package cy.olesiabokk.userflowapp.model.service.util;

import cy.olesiabokk.userflowapp.model.entity.User;

import java.util.Optional;
import java.util.stream.Stream;

public interface UserService {
    Stream<User> initializeUserList(Stream<User.Builder> stream);
    Stream<User> sortDescUserList(Stream<User> streamDesc);
    Stream<User> filterEvenIdUserList(Stream<User> streamEven);
    Optional<User> checkSameIdAndAgeUserList(Stream<User> streamSameIdAge);
}

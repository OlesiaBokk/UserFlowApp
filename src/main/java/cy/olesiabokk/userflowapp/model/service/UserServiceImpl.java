package cy.olesiabokk.userflowapp.model.service;

import cy.olesiabokk.userflowapp.model.entity.User;
import cy.olesiabokk.userflowapp.model.service.util.Generator;
import cy.olesiabokk.userflowapp.model.service.util.UserService;

import java.util.Optional;
import java.util.stream.Stream;

public class UserServiceImpl implements UserService {
    private final Generator generator;

    public UserServiceImpl(Generator generator) {
        this.generator = generator;
    }

    @Override
    public Stream<User> initializeUserList(Stream<User.Builder> stream) {
         return stream.map(user -> user.setUserId(generator.generateUserID())
                .setUserAge(generator.generateUserAge())
                .setUserLogin(generator.generateAlphaNumString())
                .setUserPassword(generator.generateUserPassword()).build());
    }

    @Override
    public Stream<User> sortDescUserList(Stream<User> streamDesc) {
        return streamDesc.sorted((user1, user2) -> Long.compare(user1.getId(), user2.getId()) * -1);
    }

    @Override
    public Stream<User> filterEvenIdUserList(Stream<User> streamEven) {
        return streamEven.filter(user -> user.getId() % 2 == 0);
    }

    @Override
    public Optional<User> checkSameIdAndAgeUserList(Stream<User> streamSameIdAge) {
        return streamSameIdAge.filter(user -> Long.valueOf(user.getAge()).equals(user.getId())).findAny();
    }

}

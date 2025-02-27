package exercise.service;

import exercise.model.User;
import exercise.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    // BEGIN
    public Mono<User> create(User user) {
        return userRepository.save(user);
    }

    public Mono<User> findById(int userId) {
        return userRepository.findById(userId);
    }

    public Mono<User> update(int userId, User data) {
        return userRepository.findById(userId)
            .flatMap(user -> {
                user.setFirstName(data.getFirstName());
                user.setLastName(data.getLastName());
                user.setEmail(data.getEmail());
                return userRepository.save(user);
            });
    }

    public Mono<Void> deleteById(int userId) {
        return userRepository.deleteById(userId);
    }
    // END
}

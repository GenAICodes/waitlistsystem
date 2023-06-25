
    package com.waitlistsystem.user;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Service;
    import java.sql.Timestamp;
    import java.util.List;
    @Service
    public class UserServiceImpl implements UserService {
        @Autowired
        private UserRepository userRepository;
        @Override
        public void registerUser(String email) {
            User user = new User(email, new Timestamp(System.currentTimeMillis()));
            userRepository.save(user);
        }
        @Override
        public int getWaitlistRank(String email) {
            List<User> users = userRepository.findAllByOrderByRegistrationTimeAsc();
            for (int i = 0; i < users.size(); i++) {
                if (users.get(i).getEmail().equals(email)) {
                    return i + 1;
                }
            }
            return -1;
        }
        @Override
        public List<User> getAllUsers() {
            return userRepository.findAll();
        }
    }

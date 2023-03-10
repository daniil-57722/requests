package com.example.requestTracking.service;


import com.example.requestTracking.entity.User;
import com.example.requestTracking.repository.RoleRepository;
import com.example.requestTracking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    public boolean addUser(User user){
        User dbUser = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
        if(dbUser!=null){
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(roleRepository.findByRoleName("Пользователь"));

        userRepository.save(user);
        return true;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            return userRepository.findByLogin(username);
        }catch (UsernameNotFoundException e){
            throw new UsernameNotFoundException("Не удалось найти данного пользователя");
        }
    }

}

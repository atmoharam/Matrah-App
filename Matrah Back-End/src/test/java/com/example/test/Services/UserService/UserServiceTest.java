package com.example.test.Services.UserService;

import com.example.demo.Entites.User;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Services.Interfaces.UserServiceI;
import com.example.demo.Services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private BCryptPasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetUserById_Success() {
        User mockUser = new User("ahmed","ahmed123","ahmed@g.com","Ahmed","Tarek",false , User.Role.User);
        when(userRepository.findById(1)).thenReturn(mockUser);

        User user = userService.getUserById(1);

        assertNotNull(user);
        assertEquals("ahmed", user.getUserName());
        verify(userRepository, times(1)).findById(1);
    }

    @Test
    void testGetUserById_NotFound() {
        when(userRepository.findById(1)).thenReturn(null);
    }

    @Test
    void testCreateUser_Success() {

        User userToCreate = new User("ahmed","ahmed123","ahmed@g.com","Ahmed","Tarek",false , User.Role.User);
        User savedUser = new User("ahmed","encodedPassword","ahmed@g.com","Ahmed","Tarek",false , User.Role.User);


        when(passwordEncoder.encode(userToCreate.getPassword())).thenReturn("encodedPassword");
        when(userRepository.save(userToCreate)).thenReturn(savedUser);

        User createdUser = userService.createUser(userToCreate);

        assertNotNull(createdUser);
        assertEquals("encodedPassword", createdUser.getPassword());
        verify(userRepository, times(1)).save(userToCreate);
    }

    @Test
    void testUpdateUser_Success() {
        User existingUser = new User("ahmed","ahmed123","ahmed@g.com","Ahmed","Tarek",false , User.Role.User);
        User userUpdates = new  User("John Doe Updated","encodedNewPassword","ahmed@g.com","Ahmed","Tarek",false , User.Role.User);

        when(userRepository.findById(1)).thenReturn(existingUser);
        when(userRepository.save(existingUser)).thenReturn(existingUser);

        User updatedUser = userService.updateUser(1, userUpdates);

        assertNotNull(updatedUser);
        assertEquals("John Doe Updated", updatedUser.getUserName());
        verify(userRepository, times(1)).findById(1);
        verify(userRepository, times(1)).save(existingUser);
    }

    @Test
    void testDeleteUser_Success() {
        when(userRepository.existsById(1)).thenReturn(true);

        boolean result = userService.deleteUser(1);

        assertTrue(result);
        verify(userRepository, times(1)).deleteById(1);
    }

    @Test
    void testDeleteUser_NotFound() {
        when(userRepository.existsById(1)).thenReturn(false);

        boolean result = userService.deleteUser(1);

        assertFalse(result);
        verify(userRepository, times(0)).deleteById(1);
    }
}

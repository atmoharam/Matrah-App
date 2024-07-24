package com.example.demo.UserTest;

import com.example.demo.Entites.User;
import com.example.demo.Repositories.UserRepository;
import com.example.demo.Services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setUserName("testuser");
        user.setPassword("testPassword");
        user.setEmail("testuser@example.com");
    }

    @Test
    public void testFindByUsername() {
        when(userRepository.findByUserName("testuser")).thenReturn(user);

        User foundUser = userService.getUserByUserName("testuser");
        assertEquals("testuser", foundUser.getUserName());
    }

    @Test
    public void testFindByEmail() {
        when(userRepository.findByEmail("testuser@example.com")).thenReturn(user);

        User foundUser = userService.getUserByEmail("testuser@example.com");
        assertEquals("testuser@example.com", foundUser.getEmail());
    }

    @Test
    public void testSaveUser() {
        when(userRepository.save(user)).thenReturn(user);

        User savedUser = userService.createUser(user);
        assertNotNull(savedUser);
        assertEquals("testuser", savedUser.getUserName());
    }

    @Test void testGetAllUsers(){
        //A
        List<User> allUsers = new ArrayList<>();
        allUsers.add(user);
        //AA
        when(userRepository.findAll()).thenReturn(allUsers);
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
        assertEquals(1, users.size());
    }



    @Test
    public void testDeleteUser() {
        // Given
        int userId = 1;

        // Mock repository behavior
        when(userRepository.existsById(userId)).thenReturn(true);
        doNothing().when(userRepository).deleteById(userId);

        // When
        boolean result = userService.deleteUser(userId);

        // Then
        assertTrue(result); // Assert that deletion was successful
        verify(userRepository, times(1)).existsById(userId);
        verify(userRepository, times(1)).deleteById(userId);
    }

    @Test
    public void testUpdateUser() {
        // Given
        int userId = 1;
        String newUserName = "updatedUser";
        String newPassword = "newPassword";
        User existingUser = new User();
        existingUser.setId(userId);
        existingUser.setUserName("testuser");
        existingUser.setEmail("test@example.com");
        existingUser.setPassword("password123");

        User updatedUser = new User();
        updatedUser.setId(userId);
        updatedUser.setUserName(newUserName);
        updatedUser.setEmail("updated@example.com");
        updatedUser.setPassword(newPassword); // Set a plain password for testing

        // Mock repository behavior
        when(userRepository.findById(userId)).thenReturn(existingUser);
        when(userRepository.save(any(User.class))).thenReturn(updatedUser);

        // When
        User result = userService.updateUser(userId, updatedUser);

        // Then
        assertEquals(userId, result.getId());
        assertEquals(newUserName, result.getUserName());
        assertEquals("updated@example.com", result.getEmail());

        // Verify repository interactions
        verify(userRepository, times(1)).findById(userId);
        verify(userRepository, times(1)).save(any(User.class));
    }
}


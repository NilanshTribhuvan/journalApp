package com.nilanshki.journalApp.service;

import com.nilanshki.journalApp.entity.User;
import com.nilanshki.journalApp.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTests {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServices userServices;

    @Disabled
    @Test
    public void testFindByUserName(){
        User user =userRepository.findByUserName("ram");
        assertTrue(!user.getJournalEntries().isEmpty());
    }

    @Disabled
    @ParameterizedTest
    @ValueSource(strings = {
            "ram",
            "tn",
            "tipu"
    })
    public void testFindByNameStr(String name){
        assertNotNull(userRepository.findByUserName(name),"failed for: " + name);
    }


    @Disabled
    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv")
    public void testFindByNameCsv(String name){
        assertNotNull(userRepository.findByUserName(name),"failed for: " + name);
    }

    @Disabled
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testSaveNewUser(User user){
       assertTrue(userServices.saveNewUser(user));
    }


    @Disabled
    @ParameterizedTest
    @CsvSource({
            "1,1,2",
            "2,10,12",
            "3.5.9"
    })
    public void test(int a,int b,int expected){
        assertEquals(expected,a+b);
    }
}

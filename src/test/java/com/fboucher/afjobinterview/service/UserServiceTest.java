package com.fboucher.afjobinterview.service;

import com.fboucher.afjobinterview.model.Country;
import com.fboucher.afjobinterview.model.User;
import com.fboucher.afjobinterview.service.exceptions.UserNotFoundException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void userResgistration() {
        User user = new User("Franck", "Boucher", 26, Country.FRANCE, "ANTIBES", "1 avenue du grand cavalier", "06600",
                false);
        user = userService.register(user);
        assertThat(user.getUuid(), is(userService.getByUuid(user.getUuid()).getUuid()));
    }

    @Test(expected = UserNotFoundException.class)
    public void userUnResgistred() {
        User user = userService.getByUuid("bad_uuid");
        assertThat(user, nullValue());
    }
}

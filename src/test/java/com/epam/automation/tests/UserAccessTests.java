package com.epam.automation.tests;

import com.epam.automation.model.User;
import org.testng.annotations.Test;
import com.epam.automation.page.LoginPage;
import com.epam.automation.service.UserFactory;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class UserAccessTests extends AbstractTest {

    @Test
    public void oneCanLoginGithub() {
        User testUser = UserFactory.createUser();
        String loggedInUserName = new LoginPage(getDriver())
                .openPage()
                .login(testUser)
                .getLoggedInUserName();
        assertThat(loggedInUserName, is(equalTo(testUser.getUsername())));
    }
}

package com.revature.steps.hooks;

import com.revature.Setup;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void resetDatabase(){
        System.out.println("resetDatabase hook called");
        Setup.resetTestDatabase();
    }
}
package com.github.vlshat.epam.unit02.task06;

import com.github.vlshat.epam.unit02.task07.SubmarineAnnotation;

/**
 * Created by wladislaw on 24.02.17.
 */
@SubmarineAnnotation(
        creator = "wladyslaw",
        projectNumber = 1,
        reactorType = "br82",
        maxSpeed = 80.2)
public class Submarine {

    private SubmarineEngine engine;


    public Submarine(){
        engine = new SubmarineEngine();
    }

    private class SubmarineEngine {

        boolean reactorIsWorking = false;

        private void startReactor(){
            System.out.println("Reactor started working");
            reactorIsWorking = true;
        }

        public void startEngine(){
            if (!reactorIsWorking){
                startReactor();
            }
            System.out.println("Engine started working");
        }
    }

    public void run(){
        engine.startEngine();
        System.out.println("Went to sea");
    }
}

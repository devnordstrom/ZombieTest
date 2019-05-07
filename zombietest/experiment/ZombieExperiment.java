/*
 * Copyright (C) 2019 Orville Nordström
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package zombietest.experiment;

import java.awt.Graphics;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import zombietest.entity.House;
import zombietest.entity.Human;

/**
 *
 * @author Orville Nordström
 */
public class ZombieExperiment implements Experiment
{   
    private int houseCount, rowSize, simulationCount, 
            roundNumber, screenWidth;
    
    private Collection<Human> infectedHumans = new ArrayList<>();
    
    private final Random random;
    
    private House[] houses;
    
    private PrintStream output;
    
    public ZombieExperiment()
    {
        random = new Random();
        
        screenWidth = 400;
        houseCount = 100;
        rowSize = 10;
        
        reset();
    }
    
    @Override
    public final void reset()
    {
        infectedHumans = new ArrayList<>();
    
        houses = new House[houseCount];
        
        roundNumber = 1;
        
        int houseMargin = screenWidth / rowSize;
        int houseWidth = houseMargin - 2;   //So 1 empty pixel.
        int rowPlacement = 0;
        int rowNumber = 0;
        
        for(int i = 0; i < houseCount; i++) {
            int x = rowPlacement * houseWidth + 1;
            int y = rowNumber * houseWidth + 1;
            
            houses[i] = new House(x, y, houseWidth);
            
            rowPlacement++;
            if(rowPlacement == rowSize) {
                rowPlacement = 0;
                rowNumber++;
            }
        }
        
        Human infectedHuman = new Human();
        infectedHuman.infect();
        
        infectedHumans.add(infectedHuman);
    }
    
    @Override
    public void runRound()
    {
        Collection<Human> targetHumans = new ArrayList<>();

        for(Human infectedHuman : infectedHumans) {
            int targetHouseNumber = random.nextInt(houses.length);

            House targetHouse = houses[targetHouseNumber];
            if(targetHouse.isEmpty()) {
                continue;
            }

            //Infect humans in the house and add the infected humans to the next round to infect more humans.
            targetHumans.addAll(targetHouse.infectHumans());
        }

        infectedHumans.addAll(targetHumans);
        
        output.println("["+ roundNumber +"] "+ targetHumans.size() +" human(s) were infected this round, "
                + "there are " + infectedHumans.size() +" infected human(s).");
        

        int uninfectedHouses = countUninfectedHouses();

        if(uninfectedHouses == 0) {
            output.println("All houses were infected by round "+ roundNumber +".");
        } else {
            output.println("["+ roundNumber +"] There are "+ uninfectedHouses +" uninfected house(s).");
            roundNumber++;
        }
    }
    
    @Override
    public boolean isCompleted()
    {
        return countUninfectedHouses() == 0;
    }
    
    private int countInfectedHumans()
    {
        return infectedHumans.size();
    }
    
    private int countUninfectedHouses()
    {
        int uninfectedHouses = 0;
        
        for(House house : houses) {
            if(!house.isInfected()) uninfectedHouses++;        
        }
        
        return uninfectedHouses;
    }
    
    @Override
    public String getInformation() 
    {
        String msg = "";
        msg += "Round #" + roundNumber + ", ";
        msg += countInfectedHumans() + " infected human(s), " ;
        msg += countUninfectedHouses() + " uninfected house(s) remaining";
        msg += ".";
        return msg;
    }

    @Override
    public void paint(Graphics g) 
    {
        for(House house : houses) {
            house.paint(g);
        }
    }

    @Override
    public void setOutput(PrintStream output) 
    {
        this.output = output;
    }
}
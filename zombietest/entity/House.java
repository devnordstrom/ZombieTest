/*
 * Copyright (C) 2019 Orville Nodström
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

package zombietest.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author User
 */
public class House
{   
    public static final Color DEFAULT_COLOR = Color.GREEN;
    public static final Color INFECTED_COLOR = Color.RED;
    public static final Color BORDER_COLOR = Color.BLACK;
    
    
    private int x, y, width;
    
    private boolean infected;

    private Collection<Human> humans = new ArrayList<>();
    
    /**
     * This class is used if someone just 
     * wants to make a non visual representation.
     */
    public House()
    {
        this(0, 0, 0);
    }
    
    public House(int x, int y, int width)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        
        Human houseHolder = new Human();
        humans.add(houseHolder);
    }
    
    public Collection<Human> getHumans()
    {
        return humans;
    }
    
    public Collection<Human> infectHumans()
    {   
        infected = true;
        
        Collection<Human> infectedHumans = new ArrayList<>(humans);
        
        for(Human human : infectedHumans) {
            human.infect();
        }
        
        humans.clear();
        
        return infectedHumans;
    }
    
    public boolean isInfected()
    {
        return infected;
    }
    
    public boolean isEmpty()
    {
        return humans.isEmpty();
    }
    
    public void paint(Graphics g) 
    {    
        if(isInfected()) {
            g.setColor(INFECTED_COLOR);
        } else {
            g.setColor(DEFAULT_COLOR);
        }
        g.fillRect(x, y, width, width);
        
        
        
        g.setColor(BORDER_COLOR);
        g.drawRect(x, y, width, width);   
    }
}
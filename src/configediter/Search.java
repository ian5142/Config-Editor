/*
 * Copyright (C) 2015 Ian Van Schaick
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package configediter;

import java.util.ArrayList;

/**
 *
 * @author Ian Van Schaick
 */
public class Search {
    private final ArrayList<String> list;
    private final ArrayList<Integer> indexes;
    
    public Search (ArrayList<Integer> indexList) {
        indexes = indexList;
        list = new ArrayList<String>(indexes.size());
        fillArray();
    }
    
    /**
     * fills the list ArrayList with names of all variables
     */
    private void fillArray() {
        list.add("competitor speed"); //start of difficulty tab
        list.add("construction cost");
        list.add("difficulty level");
        list.add("disasters");
        list.add("economy");
        list.add("industry density");
        list.add("initial interest");
        list.add("line reverse mode - reverse at stations");
        list.add("maximum loan");
        list.add("maximum number of competitors");
        list.add("number of industries");
        list.add("number of towns");
        list.add("custom town number");
        list.add("quantity of seas and lakes - number of seas and lakes");
        list.add("subsidy multiplier");
        list.add("terrain type");
        list.add("town council tolerance");
        list.add("vehicle breakdowns");
        list.add("vehicle costs"); //end of difficulty tab, start of vehicle tab
        list.add("disable elrails - disable electric rails");
        list.add("dynamic engines");
        list.add("extend vehicle life");
        list.add("freight trains");
        list.add("maximum aircraft");
        list.add("maximum road vehicles");
        list.add("maximum ships");
        list.add("maximum train length");
        list.add("maximum trains");
        list.add("never expire vehicles");
        list.add("plane crashes");
        list.add("plane speed");
        list.add("road side");
        list.add("road vehicle acceleration model");
        list.add("road vehicle slope steepness");
        list.add("service interval aircraft");
        list.add("service interval road vehicle");
        list.add("service interval ships");
        list.add("service interval trains");
        list.add("service interval is percent");
        list.add("train acceleration model"); //end of vehicle tab
    }
}

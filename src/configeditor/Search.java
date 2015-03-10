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
package configeditor;

import java.util.ArrayList;

/**
 *  Searches for a term or terms inside a given arraylist, returns the index using another arrayList
 * @author Ian Van Schaick
 */
public class Search {
    private final ArrayList<String> list;
    private final ArrayList<Integer> indexes;
    /**
     * Creates a Search object
     * @param indexList The list of indexes in the Config file
     */
    public Search (ArrayList<Integer> indexList) {
        indexes = indexList;
        list = new ArrayList<String>(indexes.size());
        fillArray();
    }
    
    /**
     * fills the list ArrayList with names of all variables
     */
    private void fillArray() {
        list.add("competitor speed, D-L"); //start of difficulty tab
        list.add("construction cost, D-L");
        list.add("disasters, D-L");
        list.add("economy, D-L");
        list.add("industry density, D-L");
        list.add("initial interest, D-L");
        list.add("line reverse mode - reverse at stations, D-L");
        list.add("maximum loan, D-L");
        list.add("maximum number of competitors, D-L");
        list.add("number of towns, D-R");
        list.add("custom town number, D-R");
        list.add("quantity of seas and lakes - number of seas and lakes, D-R");
        list.add("subsidy multiplier, D-R");
        list.add("terrain type, D-R");
        list.add("town council tolerance, D-R");
        list.add("vehicle breakdowns, D-R");
        list.add("vehicle costs, D-R"); //end of difficulty tab, start of vehicle tab
        list.add("disable elrails - disable electric rails, V-L");
        list.add("dynamic engines, V-L");
        list.add("extend vehicle life, V-L");
        list.add("freight trains, V-L");
        list.add("maximum aircraft, V-L");
        list.add("maximum road vehicles, V-L");
        list.add("maximum ships, V-L");
        list.add("maximum train length, V-L");
        list.add("maximum trains, V-L");
        list.add("never expire vehicles, V-L");
        list.add("plane crashes, V-R");
        list.add("plane speed, V-R");
        list.add("road side, V-R");
        list.add("road vehicle acceleration model, V-R");
        list.add("road vehicle slope steepness, V-R");
        list.add("service interval aircraft, V-R");
        list.add("service interval road vehicle, V-R");
        list.add("service interval ships, V-R");
        list.add("service interval trains, V-R");
        list.add("service interval is percent, V-R");
        list.add("train acceleration model, V-L"); //end of vehicle tab
    }
    
    /**
     * Finds term in the list ArrayList, then returns all of the results as an ArrayList<Stirng>
     * @param term
     * @return Returns the results of the search, in a new ArrayList<String>
     */
    public ArrayList<String> findTerm (String term) {
        ArrayList<Integer> results = new ArrayList<>();
        for (int index = 0 ; index < indexes.size() ; index++) {
            if (list.get(index).contains(term) ) {
                results.add(index);
            }
        }
        
        ArrayList<String> resultString = new ArrayList<>();
        for (int i : results) {
            String line = list.get(i);
            resultString.add(line);
        }
        return resultString;
    }
}

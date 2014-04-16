/*
 * Copyright (C) 2014 Ian Van Schaick
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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Ian Van Schaick
 */
public class WriteConfig {
    String openTTDfolder;
    String openTTDfolder2;
    public WriteConfig() {
        JFileChooser fr = new JFileChooser();
        FileSystemView fw = fr.getFileSystemView();
        openTTDfolder = fw.getDefaultDirectory() + "\\OpenTTD\\openttd.cfg";
        openTTDfolder2 = fw.getDefaultDirectory() + "\\OpenTTD";
    }
    
    public void writeConfig() throws IOException {
//        ArrayList<ArrayList<String>> data2= new ArrayList<>();
//        ArrayList<String> line2 = new ArrayList<>();
//        line2.add("competitor_speed = " + compSpd);
//        line2.add("construction_cost = " + constCost);
//        line2.add("diff_level = " + diffLevel);
//        line2.add("disasters = " + disasters);
//        line2.add("economy = " + economy);
//        line2.add("industry_density = " + industDens);
//        line2.add("initial_interest = " + initInter);
//        line2.add("line_reverse_mode = " + lineReverse);
//        line2.add("max_loan = " + maxLoan);
//        line2.add("max_no_competitors = " + maxComp);
//        
//        line2.add("number_towns = " + towns);
//        line2.add("quantity_sea_lakes = " + seas);
//        line2.add("subsidy_multiplier = " + subsidy);
//        line2.add("terrain_type = " + terrain);
//        line2.add("town_council_tolerance = " + townCoun);
//        line2.add("vehicle_breakdowns = " + vehicleBr);
//        line2.add("vehicle_costs = " + vehicleCost);
//        if (towns_CUSTOM != 0) {
//            line2.add("custom_town_number = " + towns_CUST);
//        }
        List<List<String>> data = new ArrayList<>();
        FileReader fr = new FileReader(openTTDfolder);
        Scanner in = new Scanner(fr);
        while (in.hasNextLine()) {
            String line = in.nextLine();
            Scanner lineScanner = new Scanner(line).useDelimiter(" ");
            ArrayList<String> array = new ArrayList<>();
            while (lineScanner.hasNext()) {
                array.add(lineScanner.next());
            }
            data.add(array);
        }
        fr.close();
        int lineNumber = 0;
        int size = data.size();
        int i = 0;

        while (size > 0) {
            i++;
            if (data.get(lineNumber).get(0).equals("competitor_speed")) {
                data.get(lineNumber).add(2, compSpd + "");
                System.out.println(data.get(lineNumber).get(0) + "");
            } else if (data.get(lineNumber).get(0).equals("construction_cost")) {
                data.get(lineNumber).add(2, constCost + "");
            } else if (data.get(lineNumber).get(0).equals("diff_level")) {
                data.get(lineNumber).add(2, diffLevel + "");
            } else if (data.get(lineNumber).get(0).equals("disasters")) {
                data.get(lineNumber).add(2, disasters + "");
            } else if (data.get(lineNumber).get(0).equals("economy")) {
                data.get(lineNumber).add(2, economy + "");
            } else if (data.get(lineNumber).get(0).equals("industry_density")) {
                data.get(lineNumber).add(2, industDens + "");
            } else if (data.get(lineNumber).get(0).equals("initial_interest")) {
                data.get(lineNumber).add(2, initInter + "");
            } else if (data.get(lineNumber).get(0).equals("line_reverse_mode")) {
                data.get(lineNumber).add(2, lineReverse + "");
            } else if (data.get(lineNumber).get(0).equals("max_loan")) {
                data.get(lineNumber).add(2, maxLoan + "");
            } else if (data.get(lineNumber).get(0).equals("max_no_competitors")) {
                data.get(lineNumber).add(2, maxComp + "");
            } else if (data.get(lineNumber).get(0).equals("number_towns")) {
                data.get(lineNumber).add(2, towns + "");
            } else if (data.get(lineNumber).get(0).equals("quantity_sea_lakes")) {
                data.get(lineNumber).add(2, seas + "");
            } else if (data.get(lineNumber).get(0).equals("subsidy_multiplier")) {
                data.get(lineNumber).add(2, subsidy + "");
            } else if (data.get(lineNumber).get(0).equals("terrain_type")) {
                data.get(lineNumber).add(2, terrain + "");
            } else if (data.get(lineNumber).get(0).equals("town_council_tolerance")) {
                data.get(lineNumber).add(2, townCoun + "");
            } else if (data.get(lineNumber).get(0).equals("vehicle_breakdowns")) {
                data.get(lineNumber).add(2, vehicleBr + "");
            } else if (data.get(lineNumber).get(0).equals("vehicle_costs")) {
                data.get(lineNumber).add(2, vehicleCost + "");
            } else if (data.get(lineNumber).get(0).equals("custom_town_number")) {
                data.get(lineNumber).add(2, towns_CUST + "");
            }
            lineNumber++;
            size--;
        }

        File temp = new File(openTTDfolder2 + "\\temp.cfg");
        BufferedWriter bf = new BufferedWriter(new FileWriter(temp, false));;

        int length = data.size();
        int index = 1;
        bf.write(data.get(0).get(0));
        bf.newLine();
        int sizeData = data.get(index).size();
        while (length > 0) {
            int indexI = 0;
            if (index < data.size()) {
                sizeData = data.get(index).size();
            }
            while (sizeData > 0) {
                bf.write(data.get(index).get(indexI) + " ");
                sizeData--;
                indexI++;
            }
            bf.newLine();
            index++;
            length--;
        }
        bf.close();
        File config = new File(openTTDfolder);
        boolean delete = config.delete();
        System.out.println("The file was deleted: " + delete);
        Path source = FileSystems.getDefault().getPath("", openTTDfolder2 + "\\temp.cfg");
        Path move = Files.move(source, source.resolveSibling(openTTDfolder));
        System.out.println("finished");
    }
}

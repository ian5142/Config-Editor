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
package configeditor;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Ian Van Schaick
 */
public class ReadConfig {

    String openTTDfolder;
    String openTTDfolder2;

    public ReadConfig() {
        JFileChooser fr = new JFileChooser();
        FileSystemView fw = fr.getFileSystemView();
        openTTDfolder = fw.getDefaultDirectory() + "\\OpenTTD\\openttd.cfg";
        openTTDfolder2 = fw.getDefaultDirectory() + "\\OpenTTD";
    }

    public ArrayList<ArrayList<String>> fillArray(ArrayList<ArrayList<String>> lines) throws FileNotFoundException {
        FileReader fr = null;
        try {
            fr = new FileReader(openTTDfolder);
            Scanner in = new Scanner(fr);
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (line.length() > 0) {
                    Scanner lineScanner = new Scanner(line).useDelimiter(" ");
                    ArrayList<String> array = new ArrayList<>();
                    while (lineScanner.hasNext()) {
                        array.add(lineScanner.next());
                    }
                    lines.add(array);
                } else {
                    line = "\n";
                    Scanner lineScanner = new Scanner(line).useDelimiter(" ");
                    ArrayList<String> array = new ArrayList<>();
                    while (lineScanner.hasNext()) {
                        array.add(lineScanner.next());
                    }
                    lines.add(array);
                }
            }
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(ConfigEditorGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return lines;
    }
}

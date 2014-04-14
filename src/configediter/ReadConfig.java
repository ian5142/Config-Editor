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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
    
    /**
     *
     * @param s
     * @return returns an integer found in a string
     */
    public int readConfigInt(String s) {
        int indexfound;
        int found = 0;
        String[] parts;
        if (s.equals("economy =")) {
            try (BufferedReader bf = new BufferedReader(new FileReader(new File(openTTDfolder)))) {
                String line;
                while (((line = bf.readLine()) != null) && !line.contains("smooth_economy")) {
                    if (line.startsWith(s)) {
                        parts = line.split(" ");
                        found = Integer.parseInt(parts[2]);
                    }
                }
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try (BufferedReader bf = new BufferedReader(new FileReader(new File(openTTDfolder)))) {
                String line;
                while ((line = bf.readLine()) != null) {
                    indexfound = line.indexOf(s);
                    if (indexfound > -1) {
                        parts = line.split(" ");
                        found = Integer.parseInt(parts[2]);
                    }
                }
                bf.close();
            } catch (IOException ex) {
                Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return found;
    }

    /**
     *
     * @param s
     * @return returns a boolean value read from a string
     */
    public boolean readConfigBoo(String s) {
        int indexfound;
        boolean found = true;
        String[] parts;
        try (BufferedReader bf = new BufferedReader(new FileReader(new File(openTTDfolder)))) {
            String line;
            while ((line = bf.readLine()) != null) {
                indexfound = line.indexOf(s);
                if (indexfound > -1) {
                    parts = line.split(" ");
                    found = Boolean.parseBoolean(parts[2]);
                }
            }
            bf.close();
        } catch (IOException ex) {
            Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return found;
    }
}

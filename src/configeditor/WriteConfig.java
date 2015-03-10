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

    public boolean write(ArrayList<ArrayList<String>> lines) throws IOException {
        boolean success = false;
        int length = lines.size();
        int initLength = lines.size() - 1;
        int index = 0;
        int sizeData2 = lines.get(index).size();
        ArrayList<Integer> spaces = new ArrayList<Integer>();
        int removed = 0;
        
        while (length > 0) {
            int indexI = 0;
            if (index < lines.size()) {
                sizeData2 = lines.get(index).size();
            }
            boolean notEmpty = false;
            while (sizeData2 > 0 && indexI < sizeData2) {
                if (lines.get(index).get(indexI).contains("\n")) {
                    lines.get(index).remove(indexI);
                    lines.remove(index);
                    spaces.add(index + removed);
                    removed++;
                    sizeData2--;
                }
                indexI++;
                notEmpty = true;
            }
            length--;
            index++;
        }
        
        File temp = new File(openTTDfolder2 + "\\temp.cfg");
        BufferedWriter bf = new BufferedWriter(new FileWriter(temp, false));
        index = 0;
        length = lines.size();
        
        while (length > 0) {
            boolean titleNext = false;
            int indexI = 0;
            if (index < lines.size()) {
                sizeData2 = lines.get(index).size();
            }
            boolean notEmpty = false;
            if (index + 1 < lines.size()) {
                String next = lines.get(index + 1).get(0);
                if (next.contains("[") && (!(next.contains("0")
                        || next.contains("1") || next.contains("2")))) {
                    titleNext = true;
                }
            }
            while (sizeData2 > 0 && indexI < sizeData2) {
                int diff = sizeData2 - indexI;
                if (diff == 1) {
                    bf.write(lines.get(index).get(indexI) + "");
                } else {
                    bf.write(lines.get(index).get(indexI) + " ");
                }
                indexI++;
                notEmpty = true;
            }
            if (notEmpty) {
                bf.newLine();
                if (titleNext) {
                    bf.newLine();
                }
            }
            length--;
            index++;
        }
        
        bf.close();
        success = true;
        File config = new File(openTTDfolder);
        boolean delete = config.delete();
        Path source = FileSystems.getDefault().getPath("", openTTDfolder2 + "\\temp.cfg");
        Path move = Files.move(source, source.resolveSibling(openTTDfolder));
        return success;
    }
}

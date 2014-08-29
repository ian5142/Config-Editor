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

    public boolean write(ArrayList<ArrayList<String>> lines) throws IOException {
        boolean success = false;
        int length = lines.size();
        int index = 1;
        File temp = new File(openTTDfolder2 + "\\temp.cfg");
        BufferedWriter bf = new BufferedWriter(new FileWriter(temp, false));;

        bf.write(lines.get(0).get(0));
        bf.newLine();
        int sizeData = lines.get(index).size();
        while (length > 0) {
            int indexI = 0;
            if (index < lines.size()) {
                sizeData = lines.get(index).size();
            }
            while (sizeData > 0) {
                bf.write(lines.get(index).get(indexI) + " ");
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
        return success;
    }
}

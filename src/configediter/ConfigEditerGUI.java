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

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Ian Van Schaick
 */
public class ConfigEditerGUI extends javax.swing.JFrame {

    ArrayList<ArrayList<String>> lines;
    //Variables for Difficulty tab, left side
    private final int compSpd;
    private final int constCost;
    private final int diffLevel;
    private final int disasters; //false and true
    private final int economy; //false and true
    private final int industDens;
    private final int initInter;
    private final int lineReverse; //false and true
    private final int maxLoan;
    private final int maxComp;
    private final int industries;
    private int index2;
    private int index3;
    //Variables for Difficulty tab, right side
    private final int towns;
    private int towns_CUSTOM;
    private final int seas;
    private int seas_CUSTOM;
    private final int subsidy;
    private final int terrain;
    private final int townCoun;
    private final int vehicleBr;
    private final int vehicleCost;

    private String openTTDfolder;
    private String openTTDfolder2;
    
    //Variables for Vehicles tab, left side
    private final int elecRail;
    private final int dynaEng;
    private final int vehiLife;
    private final int freightTrains;
    private final int maxAir;
    private final int maxRoad;
    private final int maxShips;
    private final int maxTrainLen;
    private final int maxTrains;

    /**
     * Creates new form ConfigEditerGUI
     */
    public ConfigEditerGUI() {
//        String setProperty = System.setProperty("nb.tabs.suppressCloseButton", "true");
        //start reading the config File
        getMyDocuments();

        lines = new ArrayList<ArrayList<String>>();
        //readconfig obkect
        ReadConfig read = new ReadConfig();
        try {
            lines = read.fillArray(lines);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //All below are between difficulty and game creation
        
        int diff = getLineNum("[difficulty]");
        int game = getLineNum("[game_creation]");
        compSpd = getLineNum("competitor_speed", diff, game);
        constCost = getLineNum("construction_cost", diff, game);
        diffLevel = getLineNum("diff_level", diff, game);
        disasters = getLineNum("disasters", diff, game);
        economy = getLineNum("economy", diff, game);
        industDens = getLineNum("industry_density", diff, game);
        initInter = getLineNum("initial_interest", diff, game);
        lineReverse = getLineNum("line_reverse_mode", diff, game);
        maxLoan = getLineNum("max_loan", diff, game);
        maxComp = getLineNum("max_no_competitors", diff, game);
        industries = getLineNum("number_industries", diff, game);
        towns = getLineNum("number_towns", diff, game);
        if (towns == 4) {
            towns_CUSTOM = getLineNum("custom_town_number", diff, game);
        }
        seas = getLineNum("quantity_sea_lakes", diff, game);
        subsidy = getLineNum("subsidy_multiplier", diff, game);
        terrain = getLineNum("terrain_type", diff, game);
        townCoun = getLineNum("town_council_tolerance", diff, game);
        vehicleBr = getLineNum("vehicle_breakdowns", diff, game);
        vehicleCost = getLineNum("vehicle_costs", diff, game);
        
        //All below are between vehicle and constuction
        int vehicle = getLineNum("[vehicle]");
        int constr = getLineNum("[construction]");
        elecRail = getLineNum("disable_elrails", vehicle, constr);
        dynaEng = getLineNum("dynamic_engines", vehicle, constr);
        vehiLife = getLineNum("extend_vehicle_life", vehicle, constr);
        freightTrains = getLineNum("freight_trains", vehicle, constr);
        maxAir = getLineNum("max_aircraft", vehicle, constr);
        maxRoad = getLineNum("max_roadveh", vehicle, constr);
        maxShips = getLineNum("max_ships", vehicle, constr);
        maxTrainLen = getLineNum("max_train_length", vehicle, constr);
        maxTrains = getLineNum("max_trains", vehicle, constr);
        
//        compSpd = readConfigInt("competitor_speed");
//        constCost = readConfigInt("construction_cost");
//        diffLevel = readConfigInt("diff_level");
//        disasters = readConfigInt("disasters");
//        economy = readConfigInt("economy =");
//        industDens = readConfigInt("industry_density");
//        initInter = readConfigInt("initial_interest");
//        lineReverse = readConfigInt("line_reverse_mode");
//        maxLoan = readConfigInt("max_loan");
//        maxComp = readConfigInt("max_no_competitors");
//        industries = readConfigInt("number_industries");
//
//        towns = readConfigInt("number_towns");
//        if (towns == 4) {
//            towns_CUSTOM = readConfigInt("custom_town_number");
//        }
//        seas = readConfigInt("quantity_sea_lakes");
//        subsidy = readConfigInt("subsidy_multiplier");
//        terrain = readConfigInt("terrain_type");
//        townCoun = readConfigInt("town_council_tolerance");
//        vehicleBr = readConfigInt("vehicle_breakdowns");
//        vehicleCost = readConfigInt("vehicle_costs");
        initComponents();
        // ButtonGroups for Difficulty tab, left side
        compSpdGroup.add(compSpd_VS);
        compSpdGroup.add(compSpd_S);
        compSpdGroup.add(compSpd_M);
        compSpdGroup.add(compSpd_F);
        compSpdGroup.add(compSpd_VF);

        constCostGroup.add(constCost_L);
        constCostGroup.add(constCost_M);
        constCostGroup.add(constCost_H);

        disastersGroup.add(disasters_ON);
        disastersGroup.add(disasters_OFF);

        economyGroup.add(economy_SM);
        economyGroup.add(economy_VAR);

        industDensGroup.add(industDens_NONE);
        industDensGroup.add(industDens_MIN);
        industDensGroup.add(industDens_VL);
        industDensGroup.add(industDens_L);
        industDensGroup.add(industDens_N);
        industDensGroup.add(industDens_H);

        initInterGroup.add(initInter_2);
        initInterGroup.add(initInter_3);
        initInterGroup.add(initInter_4);

        lineReverseGroup.add(lineReverse_TRUE);
        lineReverseGroup.add(lineReverse_FALSE);

        //Buttongroups for difficulty tab, right side
        townsGroup.add(towns_VL);
        townsGroup.add(towns_L);
        townsGroup.add(towns_N);
        townsGroup.add(towns_H);
        townsGroup.add(towns_CUST);

        seasGroup.add(seas_VL);
        seasGroup.add(seas_L);
        seasGroup.add(seas_M);
        seasGroup.add(seas_H);
        seasGroup.add(seas_CUST);

        subsidyGroup.add(subsidy_15);
        subsidyGroup.add(subsidy_20);
        subsidyGroup.add(subsidy_30);
        subsidyGroup.add(subsidy_40);

        terrainGroup.add(terrain_VF);
        terrainGroup.add(terrain_F);
        terrainGroup.add(terrain_H);
        terrainGroup.add(terrain_M);

        townCounGroup.add(townCoun_PER);
        townCounGroup.add(townCoun_TOL);
        townCounGroup.add(townCoun_HOS);

        vehicleBrGroup.add(vehicleBr_NONE);
        vehicleBrGroup.add(vehicleBr_RED);
        vehicleBrGroup.add(vehicleBr_N);

        vehicleCostGroup.add(vehicleCost_L);
        vehicleCostGroup.add(vehicleCost_M);
        vehicleCostGroup.add(vehicleCost_H);
        
        elecRailGroup.add(elecRail_T);
        elecRailGroup.add(elecRail_F);
        
        dynaEngGroup.add(dynaEng_T);
        dynaEngGroup.add(dynaEng_F);
        
        setDisplay();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        compSpdGroup = new javax.swing.ButtonGroup();
        constCostGroup = new javax.swing.ButtonGroup();
        diffLevelGroup = new javax.swing.ButtonGroup();
        disastersGroup = new javax.swing.ButtonGroup();
        economyGroup = new javax.swing.ButtonGroup();
        industDensGroup = new javax.swing.ButtonGroup();
        initInterGroup = new javax.swing.ButtonGroup();
        lineReverseGroup = new javax.swing.ButtonGroup();
        industriesGroup = new javax.swing.ButtonGroup();
        townsGroup = new javax.swing.ButtonGroup();
        seasGroup = new javax.swing.ButtonGroup();
        subsidyGroup = new javax.swing.ButtonGroup();
        terrainGroup = new javax.swing.ButtonGroup();
        townCounGroup = new javax.swing.ButtonGroup();
        vehicleBrGroup = new javax.swing.ButtonGroup();
        vehicleCostGroup = new javax.swing.ButtonGroup();
        elecRailGroup = new javax.swing.ButtonGroup();
        dynaEngGroup = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        if(compSpd == 0) {
            compSpd_VS = new javax.swing.JRadioButton("0",true);
        }
        else{
            compSpd_VS = new javax.swing.JRadioButton();
        }
        if(compSpd == 1) {
            compSpd_S = new javax.swing.JRadioButton("1",true);
        }
        else{
            compSpd_S = new javax.swing.JRadioButton();
        }
        if(compSpd == 2) {
            compSpd_M = new javax.swing.JRadioButton("2", true);
        }
        else{
            compSpd_M = new javax.swing.JRadioButton();
        }
        if(compSpd == 4) {
            compSpd_VF = new javax.swing.JRadioButton("4", true);
        }
        else{
            compSpd_VF = new javax.swing.JRadioButton("4");
        }
        if(compSpd == 3) {
            compSpd_F = new javax.swing.JRadioButton("3", true);
        }
        else{
            compSpd_F = new javax.swing.JRadioButton();
        }
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        if(constCost == 1) {
            constCost_M = new javax.swing.JRadioButton("1", true);
        }
        else{
            constCost_M = new javax.swing.JRadioButton();
        }
        if(constCost == 0) {
            constCost_L = new javax.swing.JRadioButton("0", true);
        }
        else{
            constCost_L = new javax.swing.JRadioButton();
        }
        if(constCost == 2) {
            constCost_H = new javax.swing.JRadioButton("2", true);
        }
        else{
            constCost_H = new javax.swing.JRadioButton();
        }
        if(disasters == 0) {
            disasters_OFF = new javax.swing.JRadioButton("1", true);
        }
        else{
            disasters_OFF = new javax.swing.JRadioButton();
        }
        if(disasters == 0) {
            disasters_ON = new javax.swing.JRadioButton("0", true);
        }
        else{
            disasters_ON = new javax.swing.JRadioButton();
        }
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        if(economy == 1) {
            economy_VAR = new javax.swing.JRadioButton("1", true);
        }
        else{
            economy_VAR = new javax.swing.JRadioButton();
        }
        if(economy == 0) {
            economy_SM = new javax.swing.JRadioButton("0", true);
        }
        else{
            economy_SM = new javax.swing.JRadioButton();
        }
        jLabel14 = new javax.swing.JLabel();
        if(industDens == 3) {
            industDens_L = new javax.swing.JRadioButton("3", true);
        }
        else{
            industDens_L = new javax.swing.JRadioButton();
        }
        if(industDens == 1) {
            industDens_MIN = new javax.swing.JRadioButton("1", true);
        }
        else{
            industDens_MIN = new javax.swing.JRadioButton();
        }
        if(industDens == 0) {
            industDens_NONE = new javax.swing.JRadioButton("0", true);
        }
        else{
            industDens_NONE = new javax.swing.JRadioButton();
        }
        if(industDens == 5) {
            industDens_H = new javax.swing.JRadioButton("5", true);
        }
        else{
            industDens_H = new javax.swing.JRadioButton();
        }
        if(industDens == 2) {
            industDens_VL = new javax.swing.JRadioButton("2", true);
        }
        else{
            industDens_VL = new javax.swing.JRadioButton();
        }
        if(industDens == 4) {
            industDens_N = new javax.swing.JRadioButton("4", true);
        }
        else{
            industDens_N = new javax.swing.JRadioButton();
        }
        if(initInter == 4) {
            initInter_4 = new javax.swing.JRadioButton("4", true);
        }
        else{
            initInter_4 = new javax.swing.JRadioButton();
        }
        if(initInter == 3) {
            initInter_3 = new javax.swing.JRadioButton("3", true);
        }
        else{
            initInter_3 = new javax.swing.JRadioButton();
        }
        if(initInter == 2) {
            initInter_2 = new javax.swing.JRadioButton("2", true);
        }
        else{
            initInter_2 = new javax.swing.JRadioButton();
        }
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        if(lineReverse == 0) {
            lineReverse_FALSE = new javax.swing.JRadioButton("0", true);
        }
        else{
            lineReverse_FALSE = new javax.swing.JRadioButton();
        }
        if(lineReverse == 1) {
            lineReverse_TRUE = new javax.swing.JRadioButton("1", true);
        }
        else{
            lineReverse_TRUE = new javax.swing.JRadioButton();
        }
        jLabel17 = new javax.swing.JLabel();
        maxLoan_TEXT = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        maxComp_TEXT = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        if(towns == 3) {
            towns_H = new javax.swing.JRadioButton("3", true);
        }
        else{
            towns_H = new javax.swing.JRadioButton();
        }
        if(towns == 1) {
            towns_L = new javax.swing.JRadioButton("1", true);
        }
        else{
            towns_L = new javax.swing.JRadioButton();
        }
        if(towns == 0) {
            towns_VL = new javax.swing.JRadioButton("0", true);
        }
        else{
            towns_VL = new javax.swing.JRadioButton();
        }
        if(towns == 4) {
            towns_CUST = new javax.swing.JRadioButton("4", true);
        }
        else{
            towns_CUST = new javax.swing.JRadioButton();
        }
        if(towns == 2) {
            towns_N = new javax.swing.JRadioButton("2", true);
        }
        else{
            towns_N = new javax.swing.JRadioButton();
        }
        jLabel21 = new javax.swing.JLabel();
        if(seas == 3) {
            seas_H = new javax.swing.JRadioButton("3", true);
        }
        else{
            seas_H = new javax.swing.JRadioButton();
        }
        if(seas == 1) {
            seas_L = new javax.swing.JRadioButton("1", true);
        }
        else{
            seas_L = new javax.swing.JRadioButton();
        }
        if(seas == 0) {
            seas_VL = new javax.swing.JRadioButton("0", true);
        }
        else{
            seas_VL = new javax.swing.JRadioButton();
        }
        if(seas == 4) {
            seas_CUST = new javax.swing.JRadioButton("4", true);
        }
        else{
            seas_CUST = new javax.swing.JRadioButton();
        }
        if(seas == 2) {
            seas_M = new javax.swing.JRadioButton("2", true);
        }
        else{
            seas_M = new javax.swing.JRadioButton();
        }
        if(subsidy == 2) {
            subsidy_30 = new javax.swing.JRadioButton("30", true);
        }
        else{
            subsidy_30 = new javax.swing.JRadioButton();
        }
        if(subsidy == 1) {
            subsidy_20 = new javax.swing.JRadioButton("20", true);
        }
        else{
            subsidy_20 = new javax.swing.JRadioButton();
        }
        if(subsidy == 0) {
            subsidy_15 = new javax.swing.JRadioButton("15", true);
        }
        else{
            subsidy_15 = new javax.swing.JRadioButton();
        }
        jLabel22 = new javax.swing.JLabel();
        if(subsidy == 3) {
            subsidy_40 = new javax.swing.JRadioButton("40", true);
        }
        else{
            subsidy_40 = new javax.swing.JRadioButton();
        }
        if(terrain == 2) {
            terrain_H = new javax.swing.JRadioButton("2", true);
        }
        else{
            terrain_H = new javax.swing.JRadioButton();
        }
        if(terrain == 0) {
            terrain_VF = new javax.swing.JRadioButton("0", true);
        }
        else{
            terrain_VF = new javax.swing.JRadioButton();
        }
        jLabel23 = new javax.swing.JLabel();
        if(terrain == 3) {
            terrain_M = new javax.swing.JRadioButton("3", true);
        }
        else{
            terrain_M = new javax.swing.JRadioButton();
        }
        if(terrain == 1) {
            terrain_F = new javax.swing.JRadioButton("1", true);
        }
        else{
            terrain_F = new javax.swing.JRadioButton();
        }
        jLabel24 = new javax.swing.JLabel();
        if(townCoun == 0) {
            townCoun_PER = new javax.swing.JRadioButton("0", true);
        }
        else{
            townCoun_PER = new javax.swing.JRadioButton();
        }
        if(townCoun == 1) {
            townCoun_TOL = new javax.swing.JRadioButton("1", true);
        }
        else{
            townCoun_TOL = new javax.swing.JRadioButton();
        }
        if(townCoun == 2) {
            townCoun_HOS = new javax.swing.JRadioButton("2", true);
        }
        else{
            townCoun_HOS = new javax.swing.JRadioButton();
        }
        jLabel25 = new javax.swing.JLabel();
        if(vehicleBr == 2) {
            vehicleBr_N = new javax.swing.JRadioButton("2", true);
        }
        else{
            vehicleBr_N = new javax.swing.JRadioButton();
        }
        if(vehicleBr == 1) {
            vehicleBr_RED = new javax.swing.JRadioButton("1", true);
        }
        else{
            vehicleBr_RED = new javax.swing.JRadioButton();
        }
        if(vehicleBr == 0) {
            vehicleBr_NONE = new javax.swing.JRadioButton("0", true);
        }
        else{
            vehicleBr_NONE = new javax.swing.JRadioButton();
        }
        if(vehicleCost == 2) {
            vehicleCost_H = new javax.swing.JRadioButton("2", true);
        }
        else{
            vehicleCost_H = new javax.swing.JRadioButton();
        }
        if(vehicleCost == 1) {
            vehicleCost_M = new javax.swing.JRadioButton("1", true);
        }
        else{
            vehicleCost_M = new javax.swing.JRadioButton();
        }
        jLabel26 = new javax.swing.JLabel();
        if(vehicleCost == 0) {
            vehicleCost_L = new javax.swing.JRadioButton("0", true);
        }
        else{
            vehicleCost_L = new javax.swing.JRadioButton();
        }
        towns_TEXT = new javax.swing.JTextField();
        seas_TEXT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        save_Button = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        elecRail_T = new javax.swing.JRadioButton();
        elecRail_F = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        dynaEng_T = new javax.swing.JRadioButton();
        dynaEng_F = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        vehicleLife_TEXT = new javax.swing.JTextField();
        freightTrains_TEXT = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        saveButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        maxAir_TEXT = new javax.swing.JTextField();
        maxRoad_TEXT = new javax.swing.JTextField();
        maxShips_TEXT = new javax.swing.JTextField();
        maxTrainLen_TEXT = new javax.swing.JTextField();
        maxTrains_TEXT = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        compSpd_VS.setText("very slow");
        compSpd_VS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compSpd_VSActionPerformed(evt);
            }
        });

        compSpd_S.setText("slow");
        compSpd_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compSpd_SActionPerformed(evt);
            }
        });

        compSpd_M.setText("medium");
        compSpd_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compSpd_MActionPerformed(evt);
            }
        });

        compSpd_VF.setText("very fast");
        compSpd_VF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compSpd_VFActionPerformed(evt);
            }
        });

        compSpd_F.setText("fast");
        compSpd_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compSpd_FActionPerformed(evt);
            }
        });

        jLabel9.setText("competitor");

        jLabel10.setText("const. cost");

        constCost_M.setText("medium");
        constCost_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constCost_MActionPerformed(evt);
            }
        });

        constCost_L.setText("low");
        constCost_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constCost_LActionPerformed(evt);
            }
        });

        constCost_H.setText("high");
        constCost_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constCost_HActionPerformed(evt);
            }
        });

        disasters_OFF.setText("off");
        disasters_OFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disasters_OFFActionPerformed(evt);
            }
        });

        disasters_ON.setText("on");
        disasters_ON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disasters_ONActionPerformed(evt);
            }
        });

        jLabel12.setText("disasters");

        jLabel13.setText("economy");

        economy_VAR.setText("recessions");
        economy_VAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                economy_VARActionPerformed(evt);
            }
        });

        economy_SM.setText("no recessions");
        economy_SM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                economy_SMActionPerformed(evt);
            }
        });

        jLabel14.setText("indust. density");

        industDens_L.setText("low");
        industDens_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_LActionPerformed(evt);
            }
        });

        industDens_MIN.setText("minimal");
        industDens_MIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_MINActionPerformed(evt);
            }
        });

        industDens_NONE.setText("none");
        industDens_NONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_NONEActionPerformed(evt);
            }
        });

        industDens_H.setText("high");
        industDens_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_HActionPerformed(evt);
            }
        });

        industDens_VL.setText("very low");
        industDens_VL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_VLActionPerformed(evt);
            }
        });

        industDens_N.setText("normal");
        industDens_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_NActionPerformed(evt);
            }
        });

        initInter_4.setText("4 %");
        initInter_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initInter_4ActionPerformed(evt);
            }
        });

        initInter_3.setText("3 %");
        initInter_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initInter_3ActionPerformed(evt);
            }
        });

        initInter_2.setText("2 %");
        initInter_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initInter_2ActionPerformed(evt);
            }
        });

        jLabel15.setText("init. interest");

        jLabel16.setText("line reverse mode");

        lineReverse_FALSE.setText("no reversing at station");
        lineReverse_FALSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineReverse_FALSEActionPerformed(evt);
            }
        });

        lineReverse_TRUE.setText("reversing at station");
        lineReverse_TRUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineReverse_TRUEActionPerformed(evt);
            }
        });

        jLabel17.setText("Max loan (100 000-500 000)");

        maxLoan_TEXT.setText(maxLoan + "");
        maxLoan_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxLoan_TEXTActionPerformed(evt);
            }
        });

        jLabel18.setText("Max # of compet. (0-14)");

        maxComp_TEXT.setText(maxComp + "");
        maxComp_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxComp_TEXTActionPerformed(evt);
            }
        });

        jLabel20.setText("# of towns");

        towns_H.setText("high");
        towns_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_HActionPerformed(evt);
            }
        });

        towns_L.setText("low");
        towns_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_LActionPerformed(evt);
            }
        });

        towns_VL.setText("very low");
        towns_VL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_VLActionPerformed(evt);
            }
        });

        towns_CUST.setText("custom");
        towns_CUST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_CUSTActionPerformed(evt);
            }
        });

        towns_N.setText("normal");
        towns_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_NActionPerformed(evt);
            }
        });

        jLabel21.setText("# of seas / lakes");

        seas_H.setText("high");
        seas_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_HActionPerformed(evt);
            }
        });

        seas_L.setText("low");
        seas_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_LActionPerformed(evt);
            }
        });

        seas_VL.setText("very low");
        seas_VL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_VLActionPerformed(evt);
            }
        });

        seas_CUST.setText("custom");
        seas_CUST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_CUSTActionPerformed(evt);
            }
        });

        seas_M.setText("medium");
        seas_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_MActionPerformed(evt);
            }
        });

        subsidy_30.setText("x 3.0");
        subsidy_30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsidy_30ActionPerformed(evt);
            }
        });

        subsidy_20.setText("x 2.0");
        subsidy_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsidy_20ActionPerformed(evt);
            }
        });

        subsidy_15.setText("x 1.5");
        subsidy_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsidy_15ActionPerformed(evt);
            }
        });

        jLabel22.setText("subsidy multilplier");

        subsidy_40.setText("x 4.0");
        subsidy_40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsidy_40ActionPerformed(evt);
            }
        });

        terrain_H.setText("hilly");
        terrain_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terrain_HActionPerformed(evt);
            }
        });

        terrain_VF.setText("very flat");
        terrain_VF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terrain_VFActionPerformed(evt);
            }
        });

        jLabel23.setText("terrain type");

        terrain_M.setText("mountainous");
        terrain_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terrain_MActionPerformed(evt);
            }
        });

        terrain_F.setText("flat");
        terrain_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terrain_FActionPerformed(evt);
            }
        });

        jLabel24.setText("town council tolerance");

        townCoun_PER.setText("permissive");
        townCoun_PER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                townCoun_PERActionPerformed(evt);
            }
        });

        townCoun_TOL.setText("tolerant");
        townCoun_TOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                townCoun_TOLActionPerformed(evt);
            }
        });

        townCoun_HOS.setText("hostile");
        townCoun_HOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                townCoun_HOSActionPerformed(evt);
            }
        });

        jLabel25.setText("vehicle breakdowns");

        vehicleBr_N.setText("normal");
        vehicleBr_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleBr_NActionPerformed(evt);
            }
        });

        vehicleBr_RED.setText("reduced");
        vehicleBr_RED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleBr_REDActionPerformed(evt);
            }
        });

        vehicleBr_NONE.setText("none");
        vehicleBr_NONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleBr_NONEActionPerformed(evt);
            }
        });

        vehicleCost_H.setText("high");
        vehicleCost_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleCost_HActionPerformed(evt);
            }
        });

        vehicleCost_M.setText("medium");
        vehicleCost_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleCost_MActionPerformed(evt);
            }
        });

        jLabel26.setText("vehicle cost");

        vehicleCost_L.setText("low");
        vehicleCost_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleCost_LActionPerformed(evt);
            }
        });

        if (towns == 4) {
            towns_TEXT.setText(towns_CUSTOM + "");
        }
        else {
            towns_TEXT.setText("custom");
        }
        towns_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_TEXTActionPerformed(evt);
            }
        });

        if (towns == 4) {
            seas_TEXT.setText(seas_CUSTOM + "");
        }
        else {
            seas_TEXT.setText("custom");
        }
        seas_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_TEXTActionPerformed(evt);
            }
        });

        jLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
        jLabel1.setText("<html><B><u>click enter after changing <br> values in text box</B></html>");

        save_Button.setText("Save");
        save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_ButtonActionPerformed(evt);
            }
        });

        jLabel31.setText("speed");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maxComp_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maxLoan_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(compSpd_F)
                                    .addComponent(compSpd_VS))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(compSpd_S)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(compSpd_M))
                                    .addComponent(compSpd_VF)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(disasters_ON))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel13)
                                        .addGap(8, 8, 8)
                                        .addComponent(economy_SM)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(economy_VAR)
                                    .addComponent(disasters_OFF)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initInter_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initInter_3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initInter_4))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(constCost_L)
                                .addGap(31, 31, 31)
                                .addComponent(constCost_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(constCost_H))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lineReverse_FALSE)
                                    .addComponent(lineReverse_TRUE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(industDens_NONE)
                                    .addComponent(industDens_L))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(industDens_N)
                                    .addComponent(industDens_MIN))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(industDens_H)
                                    .addComponent(industDens_VL)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleCost_L)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleCost_M)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleCost_H)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(save_Button))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(seas_VL)
                                    .addComponent(seas_H))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(seas_L)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(seas_M))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(seas_CUST)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(seas_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(towns_H)
                                    .addComponent(towns_VL))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(towns_L)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(towns_N))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(towns_CUST)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(towns_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel23))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(terrain_M)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(terrain_VF)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(terrain_F)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(terrain_H))
                                    .addComponent(subsidy_40)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(subsidy_15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(subsidy_20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(subsidy_30))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel24)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(townCoun_HOS)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(townCoun_PER)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(townCoun_TOL))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(vehicleBr_N)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(vehicleBr_NONE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(vehicleBr_RED)))))
                        .addGap(0, 3, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(towns_VL)
                                .addComponent(towns_L)
                                .addComponent(towns_N))
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(towns_H)
                                    .addComponent(towns_CUST)
                                    .addComponent(towns_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(seas_VL)
                                .addComponent(jLabel21)
                                .addComponent(seas_L)
                                .addComponent(seas_M)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seas_H)
                            .addComponent(seas_CUST)
                            .addComponent(seas_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(subsidy_15)
                            .addComponent(subsidy_20)
                            .addComponent(subsidy_30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subsidy_40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(terrain_VF)
                            .addComponent(jLabel23)
                            .addComponent(terrain_F)
                            .addComponent(terrain_H))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(terrain_M)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(townCoun_PER)
                            .addComponent(townCoun_TOL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(townCoun_HOS)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(vehicleBr_NONE)
                            .addComponent(vehicleBr_RED))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleBr_N)
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(vehicleCost_L)
                            .addComponent(vehicleCost_M)
                            .addComponent(vehicleCost_H)
                            .addComponent(save_Button))
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(compSpd_VS)
                            .addComponent(compSpd_S)
                            .addComponent(compSpd_M)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(compSpd_F)
                            .addComponent(compSpd_VF)
                            .addComponent(jLabel31))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(constCost_L)
                            .addComponent(constCost_M)
                            .addComponent(constCost_H))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(disasters_ON)
                                            .addComponent(disasters_OFF))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(economy_SM)
                                            .addComponent(economy_VAR))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(industDens_NONE)
                                            .addComponent(jLabel14)
                                            .addComponent(industDens_MIN)
                                            .addComponent(industDens_VL))))
                                .addGap(25, 25, 25))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(industDens_L)
                                .addComponent(industDens_N)
                                .addComponent(industDens_H)))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(initInter_2)
                            .addComponent(initInter_3)
                            .addComponent(initInter_4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel16)
                                    .addComponent(lineReverse_TRUE))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(lineReverse_FALSE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(maxLoan_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(maxComp_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Difficulty", jPanel2);

        jLabel2.setText("Disable elec rails");

        elecRail_T.setText("True");
        elecRail_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elecRail_TActionPerformed(evt);
            }
        });

        elecRail_F.setText("False");
        elecRail_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elecRail_FActionPerformed(evt);
            }
        });

        jLabel3.setText("Dynamic engines");

        dynaEng_T.setText("True");
        dynaEng_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynaEng_TActionPerformed(evt);
            }
        });

        dynaEng_F.setText("False");
        dynaEng_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynaEng_FActionPerformed(evt);
            }
        });

        jLabel4.setText("Extend vehicle life");

        jLabel5.setText("default: 0 (0 - 100)");

        vehicleLife_TEXT.setText(vehiLife + "");
        vehicleLife_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleLife_TEXTActionPerformed(evt);
            }
        });

        freightTrains_TEXT.setText(freightTrains + "");
        freightTrains_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                freightTrains_TEXTActionPerformed(evt);
            }
        });

        jLabel6.setText("default: 1 (1 - 255)");

        jLabel7.setText("Freight trains");

        saveButton2.setText("Save");
        saveButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new Font("Arial", Font.PLAIN, 16));
        jLabel8.setText("<html><B><u>click enter after changing <br> values in text box</B></html>");

        jLabel11.setText("Max aircraft");

        jLabel19.setText("Max road vehicles");

        jLabel27.setText("Max ships");

        jLabel28.setText("Max train length");

        jLabel29.setText("Max trains");

        maxAir_TEXT.setText(maxAir + "");
        maxAir_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxAir_TEXTActionPerformed(evt);
            }
        });

        maxRoad_TEXT.setText(maxRoad + "");
        maxRoad_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxRoad_TEXTActionPerformed(evt);
            }
        });

        maxShips_TEXT.setText(maxShips + "");
        maxShips_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxShips_TEXTActionPerformed(evt);
            }
        });

        maxTrainLen_TEXT.setText(maxTrainLen + "");
        maxTrainLen_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxTrainLen_TEXTActionPerformed(evt);
            }
        });

        maxTrains_TEXT.setText(maxTrains + "");
        maxTrains_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxTrains_TEXTActionPerformed(evt);
            }
        });

        jLabel30.setText("False, if you want elec rails");

        jLabel32.setText("Max advisable vehicles per type is 500");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel30)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 274, Short.MAX_VALUE)
                                .addComponent(saveButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(elecRail_T)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(elecRail_F)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dynaEng_T)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dynaEng_F))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(freightTrains_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(13, 13, 13)
                                    .addComponent(vehicleLife_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel29)
                                    .addComponent(jLabel28))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(maxTrainLen_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(maxRoad_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(maxAir_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(maxShips_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                        .addComponent(maxTrains_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel32))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(elecRail_T)
                    .addComponent(elecRail_F))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dynaEng_T)
                    .addComponent(dynaEng_F))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(vehicleLife_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(freightTrains_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(maxAir_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(maxRoad_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(maxShips_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxTrains_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addGap(4, 4, 4)
                .addComponent(jLabel32)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maxTrainLen_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(saveButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Vehicle", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compSpd_VSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compSpd_VSActionPerformed
        // TODO add your handling code here:
        lines.get(compSpd).set(2, "0");
    }//GEN-LAST:event_compSpd_VSActionPerformed

    private void compSpd_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compSpd_SActionPerformed
        // TODO add your handling code here:
        lines.get(compSpd).set(2, "1");
    }//GEN-LAST:event_compSpd_SActionPerformed

    private void compSpd_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compSpd_MActionPerformed
        // TODO add your handling code here:
        lines.get(compSpd).set(2, "2");
    }//GEN-LAST:event_compSpd_MActionPerformed

    private void compSpd_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compSpd_FActionPerformed
        // TODO add your handling code here:
        lines.get(compSpd).set(2, "3");
    }//GEN-LAST:event_compSpd_FActionPerformed

    private void compSpd_VFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compSpd_VFActionPerformed
        // TODO add your handling code here:
        lines.get(compSpd).set(2, "4");
    }//GEN-LAST:event_compSpd_VFActionPerformed

    private void constCost_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constCost_LActionPerformed
        // TODO add your handling code here:
        lines.get(constCost).set(2, "0");
    }//GEN-LAST:event_constCost_LActionPerformed

    private void constCost_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constCost_MActionPerformed
        // TODO add your handling code here:
        lines.get(constCost).set(2, "1");
    }//GEN-LAST:event_constCost_MActionPerformed

    private void constCost_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constCost_HActionPerformed
        // TODO add your handling code here:
        lines.get(constCost).set(2, "2");
    }//GEN-LAST:event_constCost_HActionPerformed

    private void disasters_ONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disasters_ONActionPerformed
        // TODO add your handling code here:
        lines.get(disasters).set(2, "1");
    }//GEN-LAST:event_disasters_ONActionPerformed

    private void disasters_OFFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disasters_OFFActionPerformed
        // TODO add your handling code here:
        lines.get(disasters).set(2, "0");
    }//GEN-LAST:event_disasters_OFFActionPerformed

    private void economy_SMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_economy_SMActionPerformed
        // TODO add your handling code here:
        lines.get(economy).set(2, "0");
    }//GEN-LAST:event_economy_SMActionPerformed

    private void economy_VARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_economy_VARActionPerformed
        // TODO add your handling code here:
        lines.get(economy).set(2, "1");
    }//GEN-LAST:event_economy_VARActionPerformed

    private void industDens_NONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_NONEActionPerformed
        // TODO add your handling code here:
        lines.get(industDens).set(2, "0");
    }//GEN-LAST:event_industDens_NONEActionPerformed

    private void industDens_MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_MINActionPerformed
        // TODO add your handling code here:
        lines.get(industDens).set(2, "1");
    }//GEN-LAST:event_industDens_MINActionPerformed

    private void industDens_VLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_VLActionPerformed
        // TODO add your handling code here:
        lines.get(industDens).set(2, "2");
    }//GEN-LAST:event_industDens_VLActionPerformed

    private void industDens_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_LActionPerformed
        // TODO add your handling code here:
        lines.get(industDens).set(2, "3");
    }//GEN-LAST:event_industDens_LActionPerformed

    private void industDens_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_NActionPerformed
        // TODO add your handling code here:
        lines.get(industDens).set(2, "4");
    }//GEN-LAST:event_industDens_NActionPerformed

    private void industDens_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_HActionPerformed
        // TODO add your handling code here:
        lines.get(industDens).set(2, "0");
    }//GEN-LAST:event_industDens_HActionPerformed

    private void initInter_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initInter_2ActionPerformed
        // TODO add your handling code here:
        lines.get(initInter).set(2, "2");
    }//GEN-LAST:event_initInter_2ActionPerformed

    private void initInter_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initInter_3ActionPerformed
        // TODO add your handling code here:
        lines.get(initInter).set(2, "3");
    }//GEN-LAST:event_initInter_3ActionPerformed

    private void initInter_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initInter_4ActionPerformed
        // TODO add your handling code here:
        lines.get(initInter).set(2, "4");
    }//GEN-LAST:event_initInter_4ActionPerformed

    private void lineReverse_TRUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineReverse_TRUEActionPerformed
        // TODO add your handling code here:
        lines.get(lineReverse).set(2, "1");
    }//GEN-LAST:event_lineReverse_TRUEActionPerformed

    private void lineReverse_FALSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineReverse_FALSEActionPerformed
        // TODO add your handling code here:
        lines.get(lineReverse).set(2, "0");
    }//GEN-LAST:event_lineReverse_FALSEActionPerformed

    private void maxLoan_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxLoan_TEXTActionPerformed
        // TODO add your handling code here:
        String str = maxLoan_TEXT.getText();
        lines.get(maxLoan).set(2, str);
    }//GEN-LAST:event_maxLoan_TEXTActionPerformed

    private void maxComp_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxComp_TEXTActionPerformed
        // TODO add your handling code here:
        String str2 = maxComp_TEXT.getText();
        lines.get(maxComp).set(2, str2);
    }//GEN-LAST:event_maxComp_TEXTActionPerformed

    private void towns_VLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_VLActionPerformed
        // TODO add your handling code here:
        lines.get(towns).set(2, "0");
    }//GEN-LAST:event_towns_VLActionPerformed

    private void towns_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_LActionPerformed
        // TODO add your handling code here:
        lines.get(towns).set(2, "1");
    }//GEN-LAST:event_towns_LActionPerformed

    private void towns_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_NActionPerformed
        // TODO add your handling code here:
        lines.get(towns).set(2, "2");
    }//GEN-LAST:event_towns_NActionPerformed

    private void towns_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_HActionPerformed
        // TODO add your handling code here:
        lines.get(towns).set(2, "3");
    }//GEN-LAST:event_towns_HActionPerformed

    private void towns_CUSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_CUSTActionPerformed
        // TODO add your handling code here:
        lines.get(towns).set(2, "4");
    }//GEN-LAST:event_towns_CUSTActionPerformed

    private void towns_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_TEXTActionPerformed
        // TODO add your handling code here:
        String str3 = towns_TEXT.getText();
        lines.get(towns_CUSTOM).set(2, str3);
    }//GEN-LAST:event_towns_TEXTActionPerformed

    private void seas_VLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_VLActionPerformed
        // TODO add your handling code here:
        lines.get(seas).set(2, "0");
    }//GEN-LAST:event_seas_VLActionPerformed

    private void seas_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_LActionPerformed
        // TODO add your handling code here:
        lines.get(seas).set(2, "1");
    }//GEN-LAST:event_seas_LActionPerformed

    private void seas_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_MActionPerformed
        // TODO add your handling code here:
        lines.get(seas).set(2, "2");
    }//GEN-LAST:event_seas_MActionPerformed

    private void seas_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_HActionPerformed
        // TODO add your handling code here:
        lines.get(seas).set(2, "3");
    }//GEN-LAST:event_seas_HActionPerformed

    private void seas_CUSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_CUSTActionPerformed
        // TODO add your handling code here:
        lines.get(seas).set(2, "4");
    }//GEN-LAST:event_seas_CUSTActionPerformed

    private void seas_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_TEXTActionPerformed
        // TODO add your handling code here:
        String str4 = seas_TEXT.getText();
        lines.get(seas_CUSTOM).set(2, str4);
    }//GEN-LAST:event_seas_TEXTActionPerformed

    private void subsidy_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsidy_15ActionPerformed
        // TODO add your handling code here:
        lines.get(subsidy).set(2, "0");
    }//GEN-LAST:event_subsidy_15ActionPerformed

    private void subsidy_20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsidy_20ActionPerformed
        // TODO add your handling code here:
        lines.get(subsidy).set(2, "1");
    }//GEN-LAST:event_subsidy_20ActionPerformed

    private void subsidy_30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsidy_30ActionPerformed
        // TODO add your handling code here:
        lines.get(subsidy).set(2, "2");
    }//GEN-LAST:event_subsidy_30ActionPerformed

    private void subsidy_40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsidy_40ActionPerformed
        // TODO add your handling code here:
        lines.get(subsidy).set(2, "3");
    }//GEN-LAST:event_subsidy_40ActionPerformed

    private void terrain_VFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terrain_VFActionPerformed
        // TODO add your handling code here:
        lines.get(terrain).set(2, "0");
    }//GEN-LAST:event_terrain_VFActionPerformed

    private void terrain_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terrain_FActionPerformed
        // TODO add your handling code here:
        lines.get(terrain).set(2, "1");
    }//GEN-LAST:event_terrain_FActionPerformed

    private void terrain_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terrain_HActionPerformed
        // TODO add your handling code here:
        lines.get(terrain).set(2, "2");
    }//GEN-LAST:event_terrain_HActionPerformed

    private void terrain_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terrain_MActionPerformed
        // TODO add your handling code here:
        lines.get(terrain).set(2, "3");
    }//GEN-LAST:event_terrain_MActionPerformed

    private void townCoun_PERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_townCoun_PERActionPerformed
        // TODO add your handling code here:
        lines.get(townCoun).set(2, "0");
    }//GEN-LAST:event_townCoun_PERActionPerformed

    private void townCoun_TOLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_townCoun_TOLActionPerformed
        // TODO add your handling code here:
        lines.get(townCoun).set(2, "1");
    }//GEN-LAST:event_townCoun_TOLActionPerformed

    private void townCoun_HOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_townCoun_HOSActionPerformed
        // TODO add your handling code here:
        lines.get(townCoun).set(2, "2");
    }//GEN-LAST:event_townCoun_HOSActionPerformed

    private void vehicleBr_NONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleBr_NONEActionPerformed
        // TODO add your handling code here:
        lines.get(vehicleBr).set(2, "0");
    }//GEN-LAST:event_vehicleBr_NONEActionPerformed

    private void vehicleBr_REDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleBr_REDActionPerformed
        // TODO add your handling code here:
        lines.get(vehicleBr).set(2, "1");
    }//GEN-LAST:event_vehicleBr_REDActionPerformed

    private void vehicleBr_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleBr_NActionPerformed
        // TODO add your handling code here:
        lines.get(vehicleBr).set(2, "2");
    }//GEN-LAST:event_vehicleBr_NActionPerformed

    private void vehicleCost_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleCost_LActionPerformed
        // TODO add your handling code here:
        lines.get(vehicleCost).set(2, "0");
    }//GEN-LAST:event_vehicleCost_LActionPerformed

    private void vehicleCost_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleCost_MActionPerformed
        // TODO add your handling code here:
        lines.get(vehicleCost).set(2, "1");
    }//GEN-LAST:event_vehicleCost_MActionPerformed

    private void vehicleCost_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleCost_HActionPerformed
        // TODO add your handling code here:
        lines.get(vehicleCost).set(2, "2");
    }//GEN-LAST:event_vehicleCost_HActionPerformed

    private void save_ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_ButtonActionPerformed
        // TODO add your handling code here:
        WriteConfig wc = new WriteConfig();
        try {
            boolean success = wc.write(lines);
        } catch (IOException ex) {
            Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_save_ButtonActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formWindowClosed

    private void elecRail_TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elecRail_TActionPerformed
        // TODO add your handling code here:
        lines.get(elecRail).set(2, "true");
    }//GEN-LAST:event_elecRail_TActionPerformed

    private void elecRail_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_elecRail_FActionPerformed
        // TODO add your handling code here:
        lines.get(elecRail).set(2, "false");
    }//GEN-LAST:event_elecRail_FActionPerformed

    private void dynaEng_TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynaEng_TActionPerformed
        // TODO add your handling code here:
        lines.get(dynaEng).set(2, "true");
    }//GEN-LAST:event_dynaEng_TActionPerformed

    private void dynaEng_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dynaEng_FActionPerformed
        // TODO add your handling code here:
        lines.get(dynaEng).set(2, "false");
    }//GEN-LAST:event_dynaEng_FActionPerformed

    private void saveButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButton2ActionPerformed
        // TODO add your handling code here:
        WriteConfig wc = new WriteConfig();
        try {
            boolean success = wc.write(lines);
        } catch (IOException ex) {
            Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveButton2ActionPerformed

    private void vehicleLife_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleLife_TEXTActionPerformed
        // TODO add your handling code here:
        String str4 = vehicleLife_TEXT.getText();
        lines.get(vehiLife).set(2, str4);
    }//GEN-LAST:event_vehicleLife_TEXTActionPerformed

    private void freightTrains_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_freightTrains_TEXTActionPerformed
        // TODO add your handling code here:
        String str4 = freightTrains_TEXT.getText();
        lines.get(freightTrains).set(2, str4);
    }//GEN-LAST:event_freightTrains_TEXTActionPerformed

    private void maxAir_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxAir_TEXTActionPerformed
        // TODO add your handling code here:
        String str4 = maxAir_TEXT.getText();
        lines.get(maxAir).set(2, str4);
    }//GEN-LAST:event_maxAir_TEXTActionPerformed

    private void maxRoad_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxRoad_TEXTActionPerformed
        // TODO add your handling code here:
        String str4 = maxRoad_TEXT.getText();
        lines.get(maxRoad).set(2, str4);
    }//GEN-LAST:event_maxRoad_TEXTActionPerformed

    private void maxShips_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxShips_TEXTActionPerformed
        // TODO add your handling code here:
        String str4 = maxShips_TEXT.getText();
        lines.get(maxShips).set(2, str4);
    }//GEN-LAST:event_maxShips_TEXTActionPerformed

    private void maxTrains_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxTrains_TEXTActionPerformed
        // TODO add your handling code here:
        String str4 = maxTrains_TEXT.getText();
        lines.get(maxTrains).set(2, str4);
    }//GEN-LAST:event_maxTrains_TEXTActionPerformed

    private void maxTrainLen_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxTrainLen_TEXTActionPerformed
        // TODO add your handling code here:
        String str4 = maxTrainLen_TEXT.getText();
        lines.get(maxTrainLen).set(2, str4);
    }//GEN-LAST:event_maxTrainLen_TEXTActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ConfigEditerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConfigEditerGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup compSpdGroup;
    private javax.swing.JRadioButton compSpd_F;
    private javax.swing.JRadioButton compSpd_M;
    private javax.swing.JRadioButton compSpd_S;
    private javax.swing.JRadioButton compSpd_VF;
    private javax.swing.JRadioButton compSpd_VS;
    private javax.swing.ButtonGroup constCostGroup;
    private javax.swing.JRadioButton constCost_H;
    private javax.swing.JRadioButton constCost_L;
    private javax.swing.JRadioButton constCost_M;
    private javax.swing.ButtonGroup diffLevelGroup;
    private javax.swing.ButtonGroup disastersGroup;
    private javax.swing.JRadioButton disasters_OFF;
    private javax.swing.JRadioButton disasters_ON;
    private javax.swing.ButtonGroup dynaEngGroup;
    private javax.swing.JRadioButton dynaEng_F;
    private javax.swing.JRadioButton dynaEng_T;
    private javax.swing.ButtonGroup economyGroup;
    private javax.swing.JRadioButton economy_SM;
    private javax.swing.JRadioButton economy_VAR;
    private javax.swing.ButtonGroup elecRailGroup;
    private javax.swing.JRadioButton elecRail_F;
    private javax.swing.JRadioButton elecRail_T;
    private javax.swing.JTextField freightTrains_TEXT;
    private javax.swing.ButtonGroup industDensGroup;
    private javax.swing.JRadioButton industDens_H;
    private javax.swing.JRadioButton industDens_L;
    private javax.swing.JRadioButton industDens_MIN;
    private javax.swing.JRadioButton industDens_N;
    private javax.swing.JRadioButton industDens_NONE;
    private javax.swing.JRadioButton industDens_VL;
    private javax.swing.ButtonGroup industriesGroup;
    private javax.swing.ButtonGroup initInterGroup;
    private javax.swing.JRadioButton initInter_2;
    private javax.swing.JRadioButton initInter_3;
    private javax.swing.JRadioButton initInter_4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.ButtonGroup lineReverseGroup;
    private javax.swing.JRadioButton lineReverse_FALSE;
    private javax.swing.JRadioButton lineReverse_TRUE;
    private javax.swing.JTextField maxAir_TEXT;
    private javax.swing.JTextField maxComp_TEXT;
    private javax.swing.JTextField maxLoan_TEXT;
    private javax.swing.JTextField maxRoad_TEXT;
    private javax.swing.JTextField maxShips_TEXT;
    private javax.swing.JTextField maxTrainLen_TEXT;
    private javax.swing.JTextField maxTrains_TEXT;
    private javax.swing.JButton saveButton2;
    private javax.swing.JButton save_Button;
    private javax.swing.ButtonGroup seasGroup;
    private javax.swing.JRadioButton seas_CUST;
    private javax.swing.JRadioButton seas_H;
    private javax.swing.JRadioButton seas_L;
    private javax.swing.JRadioButton seas_M;
    private javax.swing.JTextField seas_TEXT;
    private javax.swing.JRadioButton seas_VL;
    private javax.swing.ButtonGroup subsidyGroup;
    private javax.swing.JRadioButton subsidy_15;
    private javax.swing.JRadioButton subsidy_20;
    private javax.swing.JRadioButton subsidy_30;
    private javax.swing.JRadioButton subsidy_40;
    private javax.swing.ButtonGroup terrainGroup;
    private javax.swing.JRadioButton terrain_F;
    private javax.swing.JRadioButton terrain_H;
    private javax.swing.JRadioButton terrain_M;
    private javax.swing.JRadioButton terrain_VF;
    private javax.swing.ButtonGroup townCounGroup;
    private javax.swing.JRadioButton townCoun_HOS;
    private javax.swing.JRadioButton townCoun_PER;
    private javax.swing.JRadioButton townCoun_TOL;
    private javax.swing.ButtonGroup townsGroup;
    private javax.swing.JRadioButton towns_CUST;
    private javax.swing.JRadioButton towns_H;
    private javax.swing.JRadioButton towns_L;
    private javax.swing.JRadioButton towns_N;
    private javax.swing.JTextField towns_TEXT;
    private javax.swing.JRadioButton towns_VL;
    private javax.swing.ButtonGroup vehicleBrGroup;
    private javax.swing.JRadioButton vehicleBr_N;
    private javax.swing.JRadioButton vehicleBr_NONE;
    private javax.swing.JRadioButton vehicleBr_RED;
    private javax.swing.ButtonGroup vehicleCostGroup;
    private javax.swing.JRadioButton vehicleCost_H;
    private javax.swing.JRadioButton vehicleCost_L;
    private javax.swing.JRadioButton vehicleCost_M;
    private javax.swing.JTextField vehicleLife_TEXT;
    // End of variables declaration//GEN-END:variables

    private void getMyDocuments() {
        JFileChooser fr = new JFileChooser();
        FileSystemView fw = fr.getFileSystemView();
        openTTDfolder = fw.getDefaultDirectory() + "\\OpenTTD\\openttd.cfg";
        openTTDfolder2 = fw.getDefaultDirectory() + "\\OpenTTD";
    }

    private void setDisplay() {
        //Conmpetitor's speed
        if (lines.get(compSpd).get(2).equals("0")) {
            compSpd_VS.setSelected(true);
        } else if (lines.get(compSpd).get(2).equals("1")) {
            compSpd_S.setSelected(true);
        } else if (lines.get(compSpd).get(2).equals("2")) {
            compSpd_M.setSelected(true);
        } else if (lines.get(compSpd).get(2).equals("3")) {
            compSpd_F.setSelected(true);
        } else if (lines.get(compSpd).get(2).equals("4")) {
            compSpd_VF.setSelected(true);
        }

        //construction cost
        if (lines.get(constCost).get(2).equals("0")) {
            constCost_L.setSelected(true);
        } else if (lines.get(constCost).get(2).equals("1")) {
            constCost_M.setSelected(true);
        } else if (lines.get(constCost).get(2).equals("2")) {
            constCost_H.setSelected(true);
        }

        //disasters
        if (lines.get(disasters).get(2).equals("0")) {
            disasters_OFF.setSelected(true);
        } else if (lines.get(disasters).get(2).equals("1")) {
            disasters_ON.setSelected(true);
        }

        //economy
        if (lines.get(economy).get(2).equals("false")) { // Check which economy is which
            economy_SM.setSelected(true);
        } else if (lines.get(economy).get(2).equals("true")) {
            economy_VAR.setSelected(true);
        }

        //industtry_density
        if (lines.get(industDens).get(2).equals("0")) {
            industDens_NONE.setSelected(true);
        } else if (lines.get(industDens).get(2).equals("1")) {
            industDens_MIN.setSelected(true);
        } else if (lines.get(industDens).get(2).equals("2")) {
            industDens_VL.setSelected(true);
        } else if (lines.get(industDens).get(2).equals("3")) {
            industDens_L.setSelected(true);
        } else if (lines.get(industDens).get(2).equals("4")) {
            industDens_N.setSelected(true);
        } else if (lines.get(industDens).get(2).equals("5")) {
            industDens_H.setSelected(true);
        }

        //initial_interest
        if (lines.get(initInter).get(2).equals("2")) {
            initInter_2.setSelected(true);
        } else if (lines.get(initInter).get(2).equals("3")) {
            initInter_3.setSelected(true);
        } else if (lines.get(initInter).get(2).equals("4")) {
            initInter_4.setSelected(true);
        }

        //line_reverse_mode
        if (lines.get(lineReverse).get(2).equals("0")) {
            lineReverse_FALSE.setSelected(true);
        } else if (lines.get(lineReverse).get(2).equals("1")) {
            lineReverse_TRUE.setSelected(true);
        }

        //max_loan
        maxLoan_TEXT.setText(lines.get(maxLoan).get(2));

        //max_no_competitors
        maxComp_TEXT.setText(lines.get(maxComp).get(2));

        //number_towns
        if (lines.get(towns).get(2).equals("0")) {
            towns_VL.setSelected(true);
        } else if (lines.get(towns).get(2).equals("1")) {
            towns_L.setSelected(true);
        } else if (lines.get(towns).get(2).equals("2")) {
            towns_N.setSelected(true);
        } else if (lines.get(towns).get(2).equals("3")) {
            towns_H.setSelected(true);
        } else if (lines.get(towns).get(2).equals("4")) {
            towns_CUST.setSelected(true);
        }

        //quantity_sea_lakes
        if (lines.get(seas).get(2).equals("0")) {
            seas_VL.setSelected(true);
        } else if (lines.get(seas).get(2).equals("1")) {
            seas_L.setSelected(true);
        } else if (lines.get(seas).get(2).equals("2")) {
            seas_M.setSelected(true);
        } else if (lines.get(seas).get(2).equals("3")) {
            seas_H.setSelected(true);
        } else if (lines.get(seas).get(2).equals("4")) {
            seas_CUST.setSelected(true);
        }

        //subsidy_multiplier
        if (lines.get(subsidy).get(2).equals("0")) {
            subsidy_15.setSelected(true);
        } else if (lines.get(subsidy).get(2).equals("1")) {
            subsidy_20.setSelected(true);
        } else if (lines.get(subsidy).get(2).equals("2")) {
            subsidy_30.setSelected(true);
        } else if (lines.get(subsidy).get(2).equals("3")) {
            subsidy_40.setSelected(true);
        }

        //terrain_type
        if (lines.get(terrain).get(2).equals("0")) {
            terrain_VF.setSelected(true);
        } else if (lines.get(terrain).get(2).equals("1")) {
            terrain_F.setSelected(true);
        } else if (lines.get(terrain).get(2).equals("2")) {
            terrain_H.setSelected(true);
        } else if (lines.get(terrain).get(2).equals("3")) {
            terrain_M.setSelected(true);
        }

        //town_council_tolerance
        if (lines.get(townCoun).get(2).equals("0")) {
            townCoun_PER.setSelected(true);
        } else if (lines.get(townCoun).get(2).equals("1")) {
            townCoun_TOL.setSelected(true);
        } else if (lines.get(townCoun).get(2).equals("2")) {
            townCoun_HOS.setSelected(true);
        }

        //vehicle_breakdowns
        if (lines.get(vehicleBr).get(2).equals("0")) {
            vehicleBr_NONE.setSelected(true);
        } else if (lines.get(vehicleBr).get(2).equals("1")) {
            vehicleBr_RED.setSelected(true);
        } else if (lines.get(vehicleBr).get(2).equals("2")) {
            vehicleBr_N.setSelected(true);
        }

        //vehicle_breakdowns
        if (lines.get(vehicleCost).get(2).equals("0")) {
            vehicleCost_L.setSelected(true);
        } else if (lines.get(vehicleCost).get(2).equals("1")) {
            vehicleCost_M.setSelected(true);
        } else if (lines.get(vehicleCost).get(2).equals("2")) {
            vehicleCost_H.setSelected(true);
        }
        
        //Start of Vehicles tab
        
        //diable_elrails
        if(lines.get(elecRail).get(2).equals("true")){
            elecRail_T.setSelected(true);
        }
        else {
            elecRail_F.setSelected(true);
        }
        
        //dynamic_engines
        if(lines.get(dynaEng).get(2).equals("true")) {
            dynaEng_T.setSelected(true);
        }
        else {
            dynaEng_F.setSelected(true);
        }
        
        //extend_vehicle_life
        vehicleLife_TEXT.setText(lines.get(vehiLife).get(2));
        
        //freight_trains
        freightTrains_TEXT.setText(lines.get(freightTrains).get(2));
        
        //max_aircraft
        maxAir_TEXT.setText(lines.get(maxAir).get(2));
        
        //max_roadveh
        maxRoad_TEXT.setText(lines.get(maxRoad).get(2));
        
        //max_ships
        maxShips_TEXT.setText(lines.get(maxShips).get(2));
        
        //max_train_length
        maxTrainLen_TEXT.setText(lines.get(maxTrainLen).get(2));
        
        //max_trains
        maxTrains_TEXT.setText(lines.get(maxTrains).get(2));
        
        
    }

    private int getLineNum(String s) {
        int line = 0;
        int length = lines.size();
        while (length > 0 && length > line) {
            String curLine = lines.get(line).get(0);
            if (curLine.equals(s)) {
                return line;
            } else {
                line++;
                length--;
            }
        }
        return line;
    }
    private int getLineNum(String s, int i, int j) {
        int line = i;
        int length = j;
        while (length > 0 && length > line) {
            String curLine = lines.get(line).get(0);
            if (curLine.equals(s)) {
                return line;
            } else {
                line++;
            }
        }
        return line;
    }
}

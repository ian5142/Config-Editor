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

import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileSystemView;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

/**
 *
 * @author Ian Van Schaick
 */
public class ConfigEditerGUI extends javax.swing.JFrame {

    ArrayList<ArrayList<String>> lines;
    //Variables for Difficulty tab, left side
    private int compSpd;
    private int constCost;
    private int diffLevel;
    private int disasters; //false and true
    private int economy; //false and true
    private int industDens;
    private int initInter;
    private int lineReverse; //false and true
    private int maxLoan;
    private int maxComp;
    private int index2;
    private int index3;
    //Variables for Difficulty tab, right side
    private int towns;
    private int towns_CUSTOM;
    private int seas;
    private int seas_CUSTOM;
    private int subsidy;
    private int terrain;
    private int townCoun;
    private int vehicleBr;
    private int vehicleCost;

    private String openTTDfolder;
    private String openTTDfolder2;

    //Variables for Vehicles tab, left side
    private int elecRail;
    private int dynaEng;
    private int vehiLife;
    private int freightTrains;
    private int maxAir;
    private int maxRoad;
    private int maxShips;
    private int maxTrainLen;
    private int maxTrains;
    private int nExpire;

    //Variables for Vehicles tab, right side
    private int planeCrash;
    private int planeSpd;
    private int roadSide;
    private int roadAccel;
    private int roadSlope;
    private boolean roadSlopeSet;
    private int servIntAir;
    private int servIntRoad;
    private int servIntShips;
    private int servIntTrains;
    private int servIntPer;
    private int trainAcc;
    
    private ArrayList<Integer> indexList;

    /**
     * Creates new form ConfigEditerGUI
     */
    public ConfigEditerGUI() {
//        String setProperty = System.setProperty("nb.tabs.suppressCloseButton", "true");
        //start reading the config File
        getMyDocuments();;
        lines = new ArrayList<ArrayList<String>>();
        //readconfig obkect
        ReadConfig read = new ReadConfig();
        try {
            lines = read.fillArray(lines);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        UIManager.put("OptionPane.messageFont", new FontUIResource(new Font("Arial", Font.PLAIN, 18)) );
        
        long start = System.nanoTime();
        indexList = new ArrayList<>(100);
        getIndexes();
        
//All below are between difficulty and game creation
        
//        int diff = getLineNum("[difficulty]");
//        int game = getLineNum("[game_creation]");
//        compSpd = getLineNum("competitor_speed", diff, game);
//        constCost = getLineNum("construction_cost", diff, game);
//        diffLevel = getLineNum("diff_level", diff, game);
//        disasters = getLineNum("disasters", diff, game);
//        economy = getLineNum("economy", diff, game);
//        industDens = getLineNum("industry_density", diff, game);
//        initInter = getLineNum("initial_interest", diff, game);
//        lineReverse = getLineNum("line_reverse_mode", diff, game);
//        maxLoan = getLineNum("max_loan", diff, game);
//        maxComp = getLineNum("max_no_competitors", diff, game);
//        towns = getLineNum("number_towns", diff, game);
//        if (towns == 4) {
//            towns_CUSTOM = getLineNum("custom_town_number", diff, game);
//        }
//        seas = getLineNum("quantity_sea_lakes", diff, game);
//        subsidy = getLineNum("subsidy_multiplier", diff, game);
//        terrain = getLineNum("terrain_type", diff, game);
//        townCoun = getLineNum("town_council_tolerance", diff, game);
//        vehicleBr = getLineNum("vehicle_breakdowns", diff, game);
//        vehicleCost = getLineNum("vehicle_costs", diff, game);
//
////        All below are between vehicle and constuction
//        int vehicle = getLineNum("[vehicle]");
//        int constr = getLineNum("[construction]");
//        elecRail = getLineNum("disable_elrails", vehicle, constr);
//        dynaEng = getLineNum("dynamic_engines", vehicle, constr);
//        vehiLife = getLineNum("extend_vehicle_life", vehicle, constr);
//        freightTrains = getLineNum("freight_trains", vehicle, constr);
//        maxAir = getLineNum("max_aircraft", vehicle, constr);
//        maxRoad = getLineNum("max_roadveh", vehicle, constr);
//        maxShips = getLineNum("max_ships", vehicle, constr);
//        maxTrainLen = getLineNum("max_train_length", vehicle, constr);
//        maxTrains = getLineNum("max_trains", vehicle, constr);
//        nExpire = getLineNum("never_expire_vehicles", vehicle, constr);
//        planeCrash = getLineNum("plane_crashes", vehicle, constr);
//        planeSpd = getLineNum("plane_speed", vehicle, constr);
//        roadSide = getLineNum("road_side", vehicle, constr);
//        roadAccel = getLineNum("roadveh_acceleration_model", vehicle, constr);
//        roadSlope = getLineNum("roadveh_slope_steepness", vehicle, constr);
//        roadSlopeSet = false;
//        servIntAir = getLineNum("servint_aircraft", vehicle, constr);
//        servIntRoad = getLineNum("servint_roadveh", vehicle, constr);
//        servIntShips = getLineNum("servint_ships", vehicle, constr);
//        servIntTrains = getLineNum("servint_trains", vehicle, constr);
//        servIntPer = getLineNum("servint_ispercent", vehicle, constr);
//        trainAcc = getLineNum("train_acceleration_model", vehicle, constr);
                
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

        //Button Groups for Vehicle tab, left side
        elecRailGroup.add(elecRail_T);
        elecRailGroup.add(elecRail_F);

        dynaEngGroup.add(dynaEng_T);
        dynaEngGroup.add(dynaEng_F);

        nExpireGroup.add(nExpire_T);
        nExpireGroup.add(nExpire_F);

        trainAccGroup.add(trainAcc_ORIG);
        trainAccGroup.add(trainAcc_REAL);

        //Button Groups for Vehicle tab, right side
        planeCrashGroup.add(planeCrash_NONE);
        planeCrashGroup.add(planeCrash_RED);
        planeCrashGroup.add(planeCrash_NORM);

        roadSideGroup.add(roadSide_L);
        roadSideGroup.add(roadSide_R);

        roadAccelGroup.add(roadAccel_ORIG);
        roadAccelGroup.add(roadAccel_REAL);

        servIntPerGroup.add(servIntPer_T);
        servIntPerGroup.add(servIntPer_F);

        setDisplay();
        long end = System.nanoTime();
        long duration = (end - start)/1000000;
        System.out.println("The method took: " + duration);
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
        townsGroup = new javax.swing.ButtonGroup();
        seasGroup = new javax.swing.ButtonGroup();
        subsidyGroup = new javax.swing.ButtonGroup();
        terrainGroup = new javax.swing.ButtonGroup();
        townCounGroup = new javax.swing.ButtonGroup();
        vehicleBrGroup = new javax.swing.ButtonGroup();
        vehicleCostGroup = new javax.swing.ButtonGroup();
        elecRailGroup = new javax.swing.ButtonGroup();
        dynaEngGroup = new javax.swing.ButtonGroup();
        nExpireGroup = new javax.swing.ButtonGroup();
        planeCrashGroup = new javax.swing.ButtonGroup();
        roadSideGroup = new javax.swing.ButtonGroup();
        roadAccelGroup = new javax.swing.ButtonGroup();
        servIntPerGroup = new javax.swing.ButtonGroup();
        trainAccGroup = new javax.swing.ButtonGroup();
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
        towns_TEXT = new javax.swing.JTextField();
        seas_TEXT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        save_Button = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator(SwingConstants.VERTICAL);
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
        if(vehicleCost == 0) {
            vehicleCost_L = new javax.swing.JRadioButton("0", true);
        }
        else{
            vehicleCost_L = new javax.swing.JRadioButton();
        }
        jLabel26 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        if(vehicleBr == 0) {
            vehicleBr_NONE = new javax.swing.JRadioButton("0", true);
        }
        else{
            vehicleBr_NONE = new javax.swing.JRadioButton();
        }
        if(vehicleBr == 1) {
            vehicleBr_RED = new javax.swing.JRadioButton("1", true);
        }
        else{
            vehicleBr_RED = new javax.swing.JRadioButton();
        }
        if(vehicleBr == 2) {
            vehicleBr_N = new javax.swing.JRadioButton("2", true);
        }
        else{
            vehicleBr_N = new javax.swing.JRadioButton();
        }
        jSeparator5 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
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
        jLabel33 = new javax.swing.JLabel();
        nExpire_T = new javax.swing.JRadioButton();
        nExpire_F = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator(SwingConstants.VERTICAL);
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        planeCrash_NONE = new javax.swing.JRadioButton();
        planeCrash_RED = new javax.swing.JRadioButton();
        planeCrash_NORM = new javax.swing.JRadioButton();
        planeSpd_TEXT = new javax.swing.JTextField();
        roadSide_L = new javax.swing.JRadioButton();
        roadSide_R = new javax.swing.JRadioButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        roadAccel_ORIG = new javax.swing.JRadioButton();
        roadAccel_REAL = new javax.swing.JRadioButton();
        planeSpdCheck = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        roadSlope_TEXT = new javax.swing.JTextField();
        roadSlopeCheck = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jLabel42 = new javax.swing.JLabel();
        servIntAir_TEXT = new javax.swing.JTextField(4);
        jLabel43 = new javax.swing.JLabel();
        servIntRoad_TEXT = new javax.swing.JTextField(4);
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        servIntShips_TEXT = new javax.swing.JTextField(4);
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        servIntTrains_TEXT = new javax.swing.JTextField(4);
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        servIntAirCheck = new javax.swing.JLabel();
        servIntRoadCheck = new javax.swing.JLabel();
        servIntShipsCheck = new javax.swing.JLabel();
        servIntTrainsCheck = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        servIntPer_T = new javax.swing.JRadioButton();
        servIntPer_F = new javax.swing.JRadioButton();
        jLabel41 = new javax.swing.JLabel();
        trainAcc_ORIG = new javax.swing.JRadioButton();
        trainAcc_REAL = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        searchBox = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        jSeparator13 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        resultArea = new javax.swing.JTextArea();
        searchLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jTabbedPane1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N

        compSpd_VS.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        compSpd_VS.setText("very slow");
        compSpd_VS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compSpd_VSActionPerformed(evt);
            }
        });

        compSpd_S.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        compSpd_S.setText("slow");
        compSpd_S.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compSpd_SActionPerformed(evt);
            }
        });

        compSpd_M.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        compSpd_M.setText("medium");
        compSpd_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compSpd_MActionPerformed(evt);
            }
        });

        compSpd_VF.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        compSpd_VF.setText("very fast");
        compSpd_VF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compSpd_VFActionPerformed(evt);
            }
        });

        compSpd_F.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        compSpd_F.setText("fast");
        compSpd_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compSpd_FActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel9.setText("Competitor");

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Const. cost");

        constCost_M.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        constCost_M.setText("medium");
        constCost_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constCost_MActionPerformed(evt);
            }
        });

        constCost_L.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        constCost_L.setText("low");
        constCost_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constCost_LActionPerformed(evt);
            }
        });

        constCost_H.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        constCost_H.setText("high");
        constCost_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constCost_HActionPerformed(evt);
            }
        });

        disasters_OFF.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        disasters_OFF.setText("off");
        disasters_OFF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disasters_OFFActionPerformed(evt);
            }
        });

        disasters_ON.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        disasters_ON.setText("on");
        disasters_ON.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disasters_ONActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel12.setText("Disasters");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel13.setText("Economy");

        economy_VAR.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        economy_VAR.setText("recessions");
        economy_VAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                economy_VARActionPerformed(evt);
            }
        });

        economy_SM.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        economy_SM.setText("no recessions");
        economy_SM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                economy_SMActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel14.setText("Indust. density");

        industDens_L.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        industDens_L.setText("low");
        industDens_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_LActionPerformed(evt);
            }
        });

        industDens_MIN.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        industDens_MIN.setText("minimal");
        industDens_MIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_MINActionPerformed(evt);
            }
        });

        industDens_NONE.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        industDens_NONE.setText("none");
        industDens_NONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_NONEActionPerformed(evt);
            }
        });

        industDens_H.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        industDens_H.setText("high");
        industDens_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_HActionPerformed(evt);
            }
        });

        industDens_VL.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        industDens_VL.setText("very low");
        industDens_VL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_VLActionPerformed(evt);
            }
        });

        industDens_N.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        industDens_N.setText("normal");
        industDens_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industDens_NActionPerformed(evt);
            }
        });

        initInter_4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        initInter_4.setText("4 %");
        initInter_4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initInter_4ActionPerformed(evt);
            }
        });

        initInter_3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        initInter_3.setText("3 %");
        initInter_3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initInter_3ActionPerformed(evt);
            }
        });

        initInter_2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        initInter_2.setText("2 %");
        initInter_2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initInter_2ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel15.setText("Init. interest");

        jLabel16.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel16.setText("Line reverse mode");

        lineReverse_FALSE.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lineReverse_FALSE.setText("no reversing at station");
        lineReverse_FALSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineReverse_FALSEActionPerformed(evt);
            }
        });

        lineReverse_TRUE.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lineReverse_TRUE.setText("reversing at station");
        lineReverse_TRUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineReverse_TRUEActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel17.setText("Max loan (100 000-500 000)");

        maxLoan_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        maxLoan_TEXT.setText(maxLoan + "");
        maxLoan_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                maxLoan_TEXTCaretUpdate(evt);
            }
        });

        jLabel18.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel18.setText("Max # of compet. (0-14)");

        maxComp_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        maxComp_TEXT.setText(maxComp + "");
        maxComp_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                maxComp_TEXTCaretUpdate(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel20.setText("# of towns");

        towns_H.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        towns_H.setText("high");
        towns_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_HActionPerformed(evt);
            }
        });

        towns_L.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        towns_L.setText("low");
        towns_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_LActionPerformed(evt);
            }
        });

        towns_VL.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        towns_VL.setText("very low");
        towns_VL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_VLActionPerformed(evt);
            }
        });

        towns_CUST.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        towns_CUST.setText("custom");
        towns_CUST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_CUSTActionPerformed(evt);
            }
        });

        towns_N.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        towns_N.setText("normal");
        towns_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_NActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel21.setText("# of seas / lakes");

        seas_H.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        seas_H.setText("high");
        seas_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_HActionPerformed(evt);
            }
        });

        seas_L.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        seas_L.setText("low");
        seas_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_LActionPerformed(evt);
            }
        });

        seas_VL.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        seas_VL.setText("very low");
        seas_VL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_VLActionPerformed(evt);
            }
        });

        seas_CUST.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        seas_CUST.setText("custom");
        seas_CUST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_CUSTActionPerformed(evt);
            }
        });

        seas_M.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        seas_M.setText("medium");
        seas_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_MActionPerformed(evt);
            }
        });

        subsidy_30.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        subsidy_30.setText("x 3.0");
        subsidy_30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsidy_30ActionPerformed(evt);
            }
        });

        subsidy_20.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        subsidy_20.setText("x 2.0");
        subsidy_20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsidy_20ActionPerformed(evt);
            }
        });

        subsidy_15.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        subsidy_15.setText("x 1.5");
        subsidy_15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsidy_15ActionPerformed(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel22.setText("Subsidy multilplier");

        subsidy_40.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        subsidy_40.setText("x 4.0");
        subsidy_40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subsidy_40ActionPerformed(evt);
            }
        });

        terrain_H.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        terrain_H.setText("hilly");
        terrain_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terrain_HActionPerformed(evt);
            }
        });

        terrain_VF.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        terrain_VF.setText("very flat");
        terrain_VF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terrain_VFActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel23.setText("Terrain type");

        terrain_M.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        terrain_M.setText("mountainous");
        terrain_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terrain_MActionPerformed(evt);
            }
        });

        terrain_F.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        terrain_F.setText("flat");
        terrain_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                terrain_FActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel24.setText("Town council tolerance");

        townCoun_PER.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        townCoun_PER.setText("permissive");
        townCoun_PER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                townCoun_PERActionPerformed(evt);
            }
        });

        townCoun_TOL.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        townCoun_TOL.setText("tolerant");
        townCoun_TOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                townCoun_TOLActionPerformed(evt);
            }
        });

        townCoun_HOS.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        townCoun_HOS.setText("hostile");
        townCoun_HOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                townCoun_HOSActionPerformed(evt);
            }
        });

        towns_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        if (towns == 4) {
            towns_TEXT.setText(towns_CUSTOM + "");
        }
        else {
            towns_TEXT.setText("custom");
        }
        towns_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                towns_TEXTCaretUpdate(evt);
            }
        });

        seas_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        if (towns == 4) {
            seas_TEXT.setText(seas_CUSTOM + "");
        }
        else {
            seas_TEXT.setText("custom");
        }
        seas_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                seas_TEXTCaretUpdate(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setFont(new Font("Arial", Font.PLAIN, 16));
        jLabel1.setText("<html><B><u>Clich Save Button before closing</B></html>");

        save_Button.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        save_Button.setText("Save");
        save_Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_ButtonActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel31.setText("speed");

        vehicleCost_H.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        vehicleCost_H.setText("high");
        vehicleCost_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleCost_HActionPerformed(evt);
            }
        });

        vehicleCost_M.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        vehicleCost_M.setText("medium");
        vehicleCost_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleCost_MActionPerformed(evt);
            }
        });

        vehicleCost_L.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        vehicleCost_L.setText("low");
        vehicleCost_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleCost_LActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel26.setText("Vehicle cost");

        jLabel25.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel25.setText("Vehicle breakdowns");

        vehicleBr_NONE.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        vehicleBr_NONE.setText("none");
        vehicleBr_NONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleBr_NONEActionPerformed(evt);
            }
        });

        vehicleBr_RED.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        vehicleBr_RED.setText("reduced");
        vehicleBr_RED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleBr_REDActionPerformed(evt);
            }
        });

        vehicleBr_N.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        vehicleBr_N.setText("normal");
        vehicleBr_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehicleBr_NActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel31, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(compSpd_VS)
                                    .addComponent(compSpd_F))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(compSpd_S)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(compSpd_M))
                                    .addComponent(compSpd_VF)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(constCost_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(constCost_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(constCost_H))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel18))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maxComp_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maxLoan_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(initInter_2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(initInter_3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(initInter_4))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lineReverse_FALSE)
                            .addComponent(lineReverse_TRUE)))
                    .addComponent(jSeparator7)
                    .addComponent(jSeparator5)
                    .addComponent(jSeparator6)
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
                            .addComponent(industDens_VL))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator8)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(save_Button))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(townCoun_PER))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel25)
                                        .addGap(18, 18, 18)
                                        .addComponent(vehicleBr_NONE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(townCoun_TOL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(townCoun_HOS))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(vehicleBr_RED)
                                            .addComponent(vehicleCost_M))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(vehicleCost_H)
                                            .addComponent(vehicleBr_N)))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(64, 64, 64)
                                .addComponent(vehicleCost_L))
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
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(seas_H)
                                        .addGap(24, 24, 24)
                                        .addComponent(seas_CUST)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(seas_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(seas_VL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(seas_L)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(seas_M))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel23)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(terrain_M)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(terrain_VF)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(terrain_F)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(terrain_H))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(subsidy_40)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(subsidy_15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(subsidy_20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(subsidy_30)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jSeparator11)
                    .addComponent(jSeparator9)
                    .addComponent(jSeparator10))
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(towns_H)
                            .addComponent(towns_CUST)
                            .addComponent(towns_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator8, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(seas_VL)
                            .addComponent(seas_L)
                            .addComponent(seas_M))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(seas_H)
                            .addComponent(seas_CUST)
                            .addComponent(seas_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator9, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(subsidy_15)
                            .addComponent(subsidy_20)
                            .addComponent(subsidy_30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(subsidy_40)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator10, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(terrain_VF)
                            .addComponent(jLabel23)
                            .addComponent(terrain_F)
                            .addComponent(terrain_H))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(terrain_M)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator11, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(townCoun_PER)
                            .addComponent(townCoun_TOL)
                            .addComponent(townCoun_HOS))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(vehicleBr_NONE)
                            .addComponent(vehicleBr_RED)
                            .addComponent(vehicleBr_N))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(vehicleCost_L)
                            .addComponent(vehicleCost_M)
                            .addComponent(vehicleCost_H))
                        .addGap(39, 39, 39)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(save_Button)))
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(compSpd_VS)
                            .addComponent(compSpd_S)
                            .addComponent(compSpd_M)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(compSpd_F)
                                .addComponent(jLabel31))
                            .addComponent(compSpd_VF, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(8, 8, 8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(constCost_L)
                                .addComponent(constCost_M)
                                .addComponent(constCost_H)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(economy_SM)
                                    .addComponent(economy_VAR))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(disasters_ON)
                                    .addComponent(disasters_OFF))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13)
                                .addGap(6, 6, 6)))
                        .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(industDens_NONE)
                                .addComponent(industDens_MIN)
                                .addComponent(industDens_VL)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(industDens_L)
                            .addComponent(industDens_N)
                            .addComponent(industDens_H))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                            .addComponent(maxComp_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Difficulty", jPanel2);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Disable elec rails");

        elecRail_T.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        elecRail_T.setText("True");
        elecRail_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elecRail_TActionPerformed(evt);
            }
        });

        elecRail_F.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        elecRail_F.setText("False");
        elecRail_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                elecRail_FActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Dynamic engines");

        dynaEng_T.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dynaEng_T.setText("True");
        dynaEng_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynaEng_TActionPerformed(evt);
            }
        });

        dynaEng_F.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        dynaEng_F.setText("False");
        dynaEng_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dynaEng_FActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Extend vehicle life");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("default: 0 (0 - 100)");

        vehicleLife_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        vehicleLife_TEXT.setText(vehiLife + "");
        vehicleLife_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                vehicleLife_TEXTCaretUpdate(evt);
            }
        });

        freightTrains_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        freightTrains_TEXT.setText(freightTrains + "");
        freightTrains_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                freightTrains_TEXTCaretUpdate(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel6.setText("default: 1 (1 - 255)");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel7.setText("Freight trains");

        saveButton2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        saveButton2.setText("Save");
        saveButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButton2ActionPerformed(evt);
            }
        });

        jLabel8.setFont(new Font("Arial", Font.PLAIN, 16));
        jLabel8.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel8.setText("<html><B><u>Click Save Button before closing</B></html>");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel11.setText("Max aircraft");

        jLabel19.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel19.setText("Max road vehicles");

        jLabel27.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel27.setText("Max ships");

        jLabel28.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel28.setText("Max train length");

        jLabel29.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel29.setText("Max trains");

        maxAir_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        maxAir_TEXT.setText(maxAir + "");
        maxAir_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                maxAir_TEXTCaretUpdate(evt);
            }
        });

        maxRoad_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        maxRoad_TEXT.setText(maxRoad + "");
        maxRoad_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                maxRoad_TEXTCaretUpdate(evt);
            }
        });

        maxShips_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        maxShips_TEXT.setText(maxShips + "");
        maxShips_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                maxShips_TEXTCaretUpdate(evt);
            }
        });

        maxTrainLen_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        maxTrainLen_TEXT.setText(maxTrainLen + "");
        maxTrainLen_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                maxTrainLen_TEXTCaretUpdate(evt);
            }
        });

        maxTrains_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        maxTrains_TEXT.setText(maxTrains + "");
        maxTrains_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                maxTrains_TEXTCaretUpdate(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel30.setText("False, if you want elec rails");

        jLabel32.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel32.setText("Max advisable vehicles per type is 500");

        jLabel33.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel33.setText("Never expire vehiciles");

        nExpire_T.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nExpire_T.setText("True");
        nExpire_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nExpire_TActionPerformed(evt);
            }
        });

        nExpire_F.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        nExpire_F.setText("False");
        nExpire_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nExpire_FActionPerformed(evt);
            }
        });

        jLabel34.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel34.setText("Plane crashes");

        jLabel35.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel35.setText("Plane speed (1-4)");

        jLabel36.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel36.setText("Road side");

        planeCrash_NONE.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        planeCrash_NONE.setText("None");
        planeCrash_NONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planeCrash_NONEActionPerformed(evt);
            }
        });

        planeCrash_RED.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        planeCrash_RED.setText("Reduced");
        planeCrash_RED.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planeCrash_REDActionPerformed(evt);
            }
        });

        planeCrash_NORM.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        planeCrash_NORM.setText("Normal");
        planeCrash_NORM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                planeCrash_NORMActionPerformed(evt);
            }
        });

        planeSpd_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        planeSpd_TEXT.setText(planeSpd + "");
        planeSpd_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                planeSpd_TEXTCaretUpdate(evt);
            }
        });

        roadSide_L.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        roadSide_L.setText("Left");
        roadSide_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roadSide_LActionPerformed(evt);
            }
        });

        roadSide_R.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        roadSide_R.setText("Right");
        roadSide_R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roadSide_RActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel37.setText("default: 4");

        jLabel38.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel38.setText("Road acceleration model");

        roadAccel_ORIG.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        roadAccel_ORIG.setText("Original");
        roadAccel_ORIG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roadAccel_ORIGActionPerformed(evt);
            }
        });

        roadAccel_REAL.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        roadAccel_REAL.setText("Realistic");
        roadAccel_REAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                roadAccel_REALActionPerformed(evt);
            }
        });

        planeSpdCheck.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        planeSpdCheck.setText("");

        jLabel39.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel39.setText("Road slope steepness (1-10)");

        jLabel40.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel40.setText("default: 7");

        roadSlope_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        roadSlope_TEXT.setText(planeSpd + "");
        roadSlope_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                roadSlope_TEXTCaretUpdate(evt);
            }
        });

        roadSlopeCheck.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        roadSlopeCheck.setText("");

        jLabel42.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel42.setText("Service interval aircraft (0, 5-800), days");

        servIntAir_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        servIntAir_TEXT.setText(servIntAir + "");
        servIntAir_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                servIntAir_TEXTCaretUpdate(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel43.setText("default: 150 days");

        servIntRoad_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        servIntRoad_TEXT.setText(servIntRoad + "");
        servIntRoad_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                servIntRoad_TEXTCaretUpdate(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel44.setText("Service interval road (0, 5-800), days");

        jLabel45.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel45.setText("default: 150 days");

        servIntShips_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        servIntShips_TEXT.setText(servIntShips + "");
        servIntShips_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                servIntShips_TEXTCaretUpdate(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel46.setText("Service interval ships (0, 5-800), days");

        jLabel47.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel47.setText("default: 150 days");

        servIntTrains_TEXT.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        servIntTrains_TEXT.setText(servIntTrains + "");
        servIntTrains_TEXT.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                servIntTrains_TEXTCaretUpdate(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel48.setText("Service interval trains (0, 5-800), days");

        jLabel49.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel49.setText("default: 150 days");

        servIntAirCheck.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        servIntAirCheck.setText("");

        servIntRoadCheck.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        servIntRoadCheck.setText("");

        servIntShipsCheck.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        servIntShipsCheck.setText("");

        servIntTrainsCheck.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        servIntTrainsCheck.setText("");

        jLabel50.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel50.setText("Service interval percent");

        servIntPer_T.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        servIntPer_T.setText("True");
        servIntPer_T.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servIntPer_TActionPerformed(evt);
            }
        });

        servIntPer_F.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        servIntPer_F.setText("False");
        servIntPer_F.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servIntPer_FActionPerformed(evt);
            }
        });

        jLabel41.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel41.setText("Train acceleration model");

        trainAcc_ORIG.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        trainAcc_ORIG.setText("Original");
        trainAcc_ORIG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainAcc_ORIGActionPerformed(evt);
            }
        });

        trainAcc_REAL.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        trainAcc_REAL.setText("Realistic");
        trainAcc_REAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainAcc_REALActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(elecRail_T)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(elecRail_F))
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
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jSeparator4)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel29)
                                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(maxRoad_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(maxAir_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(maxShips_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                    .addComponent(maxTrains_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel32)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel30)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel28)
                                .addGap(18, 18, 18)
                                .addComponent(maxTrainLen_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel41)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(trainAcc_REAL)
                                    .addComponent(trainAcc_ORIG)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel33)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nExpire_T)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nExpire_F)))
                        .addGap(35, 35, 35)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel38)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roadAccel_ORIG)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roadAccel_REAL))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel34)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(planeCrash_NONE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(planeCrash_RED)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(planeCrash_NORM))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel37)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(planeSpd_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(planeSpdCheck))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roadSide_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roadSide_R))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(49, 49, 49)
                                        .addComponent(jLabel40)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roadSlope_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(roadSlopeCheck))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel44)
                                    .addComponent(jLabel45))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(servIntRoad_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(servIntRoadCheck)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel43)
                                    .addComponent(jLabel42))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(servIntAir_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(servIntAirCheck)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel47)
                                    .addComponent(jLabel46))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(servIntShipsCheck))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(servIntShips_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel48)
                                .addGap(18, 18, 18)
                                .addComponent(servIntTrains_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(121, 121, 121)
                                        .addComponent(jLabel49))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel50)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(servIntPer_T)))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(servIntPer_F)
                                    .addComponent(servIntTrainsCheck)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel11)
                                .addComponent(maxAir_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(maxTrainLen_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel41)
                            .addComponent(trainAcc_ORIG))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(trainAcc_REAL)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel33)
                            .addComponent(nExpire_T)
                            .addComponent(nExpire_F))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(saveButton2))
                        .addGap(0, 14, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(planeCrash_NONE)
                            .addComponent(planeCrash_RED)
                            .addComponent(planeCrash_NORM))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel35)
                            .addComponent(planeSpd_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(planeSpdCheck))
                        .addGap(5, 5, 5)
                        .addComponent(jLabel37)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(roadSide_L)
                            .addComponent(roadSide_R))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel38)
                            .addComponent(roadAccel_ORIG)
                            .addComponent(roadAccel_REAL))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(roadSlope_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(roadSlopeCheck))
                            .addComponent(jLabel39))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel40)
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(servIntAir_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel43)
                            .addComponent(servIntAirCheck))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel44)
                            .addComponent(servIntRoad_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel45)
                            .addComponent(servIntRoadCheck))
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(servIntShips_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(servIntShipsCheck, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel47))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(servIntTrains_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel48))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel49)
                            .addComponent(servIntTrainsCheck))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel50)
                            .addComponent(servIntPer_T)
                            .addComponent(servIntPer_F))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("Vehicle", jPanel1);

        searchBox.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        searchBox.setText("Type in your search query");
        searchBox.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBoxMouseClicked(evt);
            }
        });
        searchBox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchBoxKeyTyped(evt);
            }
        });

        searchButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        searchButton.setText("Search");

        resultArea.setBackground(new java.awt.Color(240, 240, 240));
        resultArea.setColumns(20);
        resultArea.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        resultArea.setRows(5);
        resultArea.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(resultArea);

        searchLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        searchLabel.setText("The results of your search: (D - Difficulty tab, V - Vehicle tab, L - left side, R - right side)");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jSeparator13)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(searchBox, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(searchLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(searchLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Search", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        lines.get(economy).set(2, "false");
    }//GEN-LAST:event_economy_SMActionPerformed

    private void economy_VARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_economy_VARActionPerformed
        // TODO add your handling code here:
        lines.get(economy).set(2, "true");
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
        lines.get(industDens).set(2, "5");
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
        boolean success = true;
        try {
            success = wc.write(lines);
            
        } catch (IOException ex) {
            Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (success) {
            JOptionPane.showMessageDialog(jTabbedPane1, "Changes saved successfully");
        }
    }//GEN-LAST:event_save_ButtonActionPerformed

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
        boolean success = false;
        try {
            success = wc.write(lines);
        } catch (IOException ex) {
            Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (success) {
            JOptionPane.showMessageDialog(jTabbedPane1, "Changes saved successfully");
        }
    }//GEN-LAST:event_saveButton2ActionPerformed

    private void nExpire_TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nExpire_TActionPerformed
        // TODO add your handling code here:
        lines.get(nExpire).set(2, "true");
    }//GEN-LAST:event_nExpire_TActionPerformed

    private void nExpire_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nExpire_FActionPerformed
        // TODO add your handling code here:
        lines.get(nExpire).set(2, "false");
    }//GEN-LAST:event_nExpire_FActionPerformed

    private void planeCrash_NONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planeCrash_NONEActionPerformed
        // TODO add your handling code here:
        lines.get(planeCrash).set(2, "0");
    }//GEN-LAST:event_planeCrash_NONEActionPerformed

    private void planeCrash_REDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planeCrash_REDActionPerformed
        // TODO add your handling code here:
        lines.get(planeCrash).set(2, "1");
    }//GEN-LAST:event_planeCrash_REDActionPerformed

    private void planeCrash_NORMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_planeCrash_NORMActionPerformed
        // TODO add your handling code here:
        lines.get(planeCrash).set(2, "2");
    }//GEN-LAST:event_planeCrash_NORMActionPerformed

    private void planeSpd_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_planeSpd_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = planeSpd_TEXT.getText();
        if (str4.equals("0") || str4.equals("1") || str4.equals("2")
                || str4.equals("3") || str4.equals("4")) {
            lines.get(planeSpd).set(2, str4);
            planeSpdCheck.setText("");
        } else {
            planeSpdCheck.setText("<html><B><u>Please Check</B></html>");
        }
    }//GEN-LAST:event_planeSpd_TEXTCaretUpdate

    private void roadSide_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roadSide_LActionPerformed
        // TODO add your handling code here:
        lines.get(roadSide).set(2, "left");
    }//GEN-LAST:event_roadSide_LActionPerformed

    private void roadSide_RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roadSide_RActionPerformed
        // TODO add your handling code here:
        lines.get(roadSide).set(2, "right");
    }//GEN-LAST:event_roadSide_RActionPerformed

    private void vehicleLife_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_vehicleLife_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = vehicleLife_TEXT.getText();
        lines.get(vehiLife).set(2, str4);
    }//GEN-LAST:event_vehicleLife_TEXTCaretUpdate

    private void maxAir_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_maxAir_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = maxAir_TEXT.getText();
        lines.get(maxAir).set(2, str4);
    }//GEN-LAST:event_maxAir_TEXTCaretUpdate

    private void maxRoad_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_maxRoad_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = maxRoad_TEXT.getText();
        lines.get(maxRoad).set(2, str4);
    }//GEN-LAST:event_maxRoad_TEXTCaretUpdate

    private void maxShips_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_maxShips_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = maxShips_TEXT.getText();
        lines.get(maxShips).set(2, str4);
    }//GEN-LAST:event_maxShips_TEXTCaretUpdate

    private void maxTrains_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_maxTrains_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = maxTrains_TEXT.getText();
        lines.get(maxTrains).set(2, str4);
    }//GEN-LAST:event_maxTrains_TEXTCaretUpdate

    private void maxTrainLen_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_maxTrainLen_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = maxTrainLen_TEXT.getText();
        lines.get(maxTrainLen).set(2, str4);
    }//GEN-LAST:event_maxTrainLen_TEXTCaretUpdate

    private void freightTrains_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_freightTrains_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = freightTrains_TEXT.getText();
        lines.get(freightTrains).set(2, str4);
    }//GEN-LAST:event_freightTrains_TEXTCaretUpdate

    private void maxLoan_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_maxLoan_TEXTCaretUpdate
        // TODO add your handling code here:
        String str = maxLoan_TEXT.getText();
        lines.get(maxLoan).set(2, str);
    }//GEN-LAST:event_maxLoan_TEXTCaretUpdate

    private void maxComp_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_maxComp_TEXTCaretUpdate
        // TODO add your handling code here:
        String str2 = maxComp_TEXT.getText();
        lines.get(maxComp).set(2, str2);
    }//GEN-LAST:event_maxComp_TEXTCaretUpdate

    private void towns_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_towns_TEXTCaretUpdate
        // TODO add your handling code here:
        String str3 = towns_TEXT.getText();
        lines.get(towns_CUSTOM).set(2, str3);
    }//GEN-LAST:event_towns_TEXTCaretUpdate

    private void seas_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_seas_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = seas_TEXT.getText();
        lines.get(seas_CUSTOM).set(2, str4);
    }//GEN-LAST:event_seas_TEXTCaretUpdate

    private void roadAccel_ORIGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roadAccel_ORIGActionPerformed
        // TODO add your handling code here:
        lines.get(roadAccel).set(2, "0");
    }//GEN-LAST:event_roadAccel_ORIGActionPerformed

    private void roadAccel_REALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_roadAccel_REALActionPerformed
        // TODO add your handling code here:
        lines.get(roadAccel).set(2, "1");
    }//GEN-LAST:event_roadAccel_REALActionPerformed

    private void roadSlope_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_roadSlope_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = roadSlope_TEXT.getText();
        int slope;
        Scanner input = new Scanner(str4);
        if (input.hasNextInt()) {
            slope = input.nextInt();
        } else {
            slope = -1;
        }
        if (slope >= 0 && slope <= 10) {
            lines.get(roadSlope).set(2, str4);
            roadSlopeCheck.setText("");
        } else {
            roadSlopeCheck.setText("<html><B><u>Please Check</B></html>");
        }
    }//GEN-LAST:event_roadSlope_TEXTCaretUpdate

    private void servIntAir_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_servIntAir_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = servIntAir_TEXT.getText();
        int servInt;
        Scanner input = new Scanner(str4);
        if (input.hasNextInt()) {
            servInt = input.nextInt();
        } else {
            servInt = -1;
        }
        if ((servInt == 0) || (servInt >= 5 && servInt <= 800)) {
            lines.get(servIntAir).set(2, str4);
            servIntAirCheck.setText("");
        } else {
            servIntAirCheck.setText("<html><B><u>Please Check</B></html>");
        }
    }//GEN-LAST:event_servIntAir_TEXTCaretUpdate

    private void servIntRoad_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_servIntRoad_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = servIntRoad_TEXT.getText();
        int servInt;
        Scanner input = new Scanner(str4);
        if (input.hasNextInt()) {
            servInt = input.nextInt();
        } else {
            servInt = -1;
        }
        if ((servInt == 0) || (servInt >= 5 && servInt <= 800)) {
            lines.get(servIntRoad).set(2, str4);
            servIntRoadCheck.setText("");
        } else {
            servIntRoadCheck.setText("<html><B><u>Please Check</B></html>");
        }
    }//GEN-LAST:event_servIntRoad_TEXTCaretUpdate

    private void servIntShips_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_servIntShips_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = servIntShips_TEXT.getText();
        int servInt;
        Scanner input = new Scanner(str4);
        if (input.hasNextInt()) {
            servInt = input.nextInt();
        } else {
            servInt = -1;
        }
        if ((servInt == 0) || (servInt >= 5 && servInt <= 800)) {
            lines.get(servIntShips).set(2, str4);
            servIntShipsCheck.setText("");
        } else {
            servIntShipsCheck.setText("<html><B><u>Please Check</B></html>");
        }
    }//GEN-LAST:event_servIntShips_TEXTCaretUpdate

    private void servIntTrains_TEXTCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_servIntTrains_TEXTCaretUpdate
        // TODO add your handling code here:
        String str4 = servIntTrains_TEXT.getText();
        int servInt;
        Scanner input = new Scanner(str4);
        if (input.hasNextInt()) {
            servInt = input.nextInt();
        } else {
            servInt = -1;
        }
        if ((servInt == 0) || (servInt >= 5 && servInt <= 800)) {
            lines.get(servIntTrains).set(2, str4);
            servIntTrainsCheck.setText("");
        } else {
            servIntTrainsCheck.setText("<html><B><u>Please Check</B></html>");
        }
    }//GEN-LAST:event_servIntTrains_TEXTCaretUpdate

    private void servIntPer_TActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servIntPer_TActionPerformed
        // TODO add your handling code here:
        lines.get(servIntPer).set(2, "true");
    }//GEN-LAST:event_servIntPer_TActionPerformed

    private void servIntPer_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servIntPer_FActionPerformed
        // TODO add your handling code here:
        lines.get(servIntPer).set(2, "false");
    }//GEN-LAST:event_servIntPer_FActionPerformed

    private void trainAcc_ORIGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainAcc_ORIGActionPerformed
        // TODO add your handling code here:
        lines.get(trainAcc).set(2, "0");
    }//GEN-LAST:event_trainAcc_ORIGActionPerformed

    private void trainAcc_REALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainAcc_REALActionPerformed
        // TODO add your handling code here:
        lines.get(trainAcc).set(2, "1");
    }//GEN-LAST:event_trainAcc_REALActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int response = JOptionPane.showConfirmDialog(jTabbedPane1, "Do you want to save your changes?", "Save Changes",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            WriteConfig wc = new WriteConfig();
            boolean success = false;
            try {
                success = wc.write(lines);
            } catch (IOException ex) {
                Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (success) {
                JOptionPane.showMessageDialog(jTabbedPane1, "Changes saved successfully");
                System.exit(0);
            }
        }
    }//GEN-LAST:event_formWindowClosing

    private void searchBoxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBoxMouseClicked
        // TODO add your handling code here:
        if (searchBox.getText().equals("Type in your search query")) {
            searchBox.setText("");
        }
    }//GEN-LAST:event_searchBoxMouseClicked

    private void searchBoxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchBoxKeyTyped
        // TODO add your handling code here:
        String term = searchBox.getText();
        resultArea.setEditable(false);
        resultArea.setText("");
        Search find = new Search(indexList);
        ArrayList<String> results = find.findTerm(term);
        for (String line : results) {
            resultArea.append(line + "\n");
        }
    }//GEN-LAST:event_searchBoxKeyTyped
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
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator13;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
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
    private javax.swing.ButtonGroup nExpireGroup;
    private javax.swing.JRadioButton nExpire_F;
    private javax.swing.JRadioButton nExpire_T;
    private javax.swing.ButtonGroup planeCrashGroup;
    private javax.swing.JRadioButton planeCrash_NONE;
    private javax.swing.JRadioButton planeCrash_NORM;
    private javax.swing.JRadioButton planeCrash_RED;
    private javax.swing.JLabel planeSpdCheck;
    private javax.swing.JTextField planeSpd_TEXT;
    private javax.swing.JTextArea resultArea;
    private javax.swing.ButtonGroup roadAccelGroup;
    private javax.swing.JRadioButton roadAccel_ORIG;
    private javax.swing.JRadioButton roadAccel_REAL;
    private javax.swing.ButtonGroup roadSideGroup;
    private javax.swing.JRadioButton roadSide_L;
    private javax.swing.JRadioButton roadSide_R;
    private javax.swing.JLabel roadSlopeCheck;
    private javax.swing.JTextField roadSlope_TEXT;
    private javax.swing.JButton saveButton2;
    private javax.swing.JButton save_Button;
    private javax.swing.JTextField searchBox;
    private javax.swing.JButton searchButton;
    private javax.swing.JLabel searchLabel;
    private javax.swing.ButtonGroup seasGroup;
    private javax.swing.JRadioButton seas_CUST;
    private javax.swing.JRadioButton seas_H;
    private javax.swing.JRadioButton seas_L;
    private javax.swing.JRadioButton seas_M;
    private javax.swing.JTextField seas_TEXT;
    private javax.swing.JRadioButton seas_VL;
    private javax.swing.JLabel servIntAirCheck;
    private javax.swing.JTextField servIntAir_TEXT;
    private javax.swing.ButtonGroup servIntPerGroup;
    private javax.swing.JRadioButton servIntPer_F;
    private javax.swing.JRadioButton servIntPer_T;
    private javax.swing.JLabel servIntRoadCheck;
    private javax.swing.JTextField servIntRoad_TEXT;
    private javax.swing.JLabel servIntShipsCheck;
    private javax.swing.JTextField servIntShips_TEXT;
    private javax.swing.JLabel servIntTrainsCheck;
    private javax.swing.JTextField servIntTrains_TEXT;
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
    private javax.swing.ButtonGroup trainAccGroup;
    private javax.swing.JRadioButton trainAcc_ORIG;
    private javax.swing.JRadioButton trainAcc_REAL;
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
        if (lines.get(elecRail).get(2).equals("true")) {
            elecRail_T.setSelected(true);
        } else {
            elecRail_F.setSelected(true);
        }

        //dynamic_engines
        if (lines.get(dynaEng).get(2).equals("true")) {
            dynaEng_T.setSelected(true);
        } else {
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

        //never_expire_vehicles
        if (lines.get(nExpire).get(2).equals("true")) {
            nExpire_T.setSelected(true);
        } else {
            nExpire_F.setSelected(true);
        }

        //plane_crashes
        if (lines.get(planeCrash).get(2).equals("0")) {
            planeCrash_NONE.setSelected(true);
        } else if (lines.get(planeCrash).get(2).equals("1")) {
            planeCrash_RED.setSelected(true);
        } else {
            planeCrash_NORM.setSelected(true);
        }

        //plane_speed
        planeSpd_TEXT.setText(lines.get(planeSpd).get(2));

        //road_side
        if (lines.get(roadSide).get(2).equals("left")) {
            roadSide_L.setSelected(true);
        } else {
            roadSide_R.setSelected(true);
        }

        //roadveh_acceleration_model
        if (lines.get(roadAccel).get(2).equals("0")) {
            roadAccel_ORIG.setSelected(true);
        } else {
            roadAccel_REAL.setSelected(true);
        }

        //roadveh_slope_steepness
        roadSlope_TEXT.setText(lines.get(roadSlope).get(2));
        roadSlopeSet = true;

        //servint_aircraft
        servIntAir_TEXT.setText(lines.get(servIntAir).get(2));

        //servint_roadveh
        servIntRoad_TEXT.setText(lines.get(servIntRoad).get(2));

        //servint_ships
        servIntShips_TEXT.setText(lines.get(servIntShips).get(2));

        //servint_trains
        servIntTrains_TEXT.setText(lines.get(servIntTrains).get(2));

        //servint_ispercent
        if (lines.get(servIntPer).get(2).equals("true")) {
            servIntPer_T.setSelected(true);
        } else {
            servIntPer_F.setSelected(true);
        }

        //train_acceleration_model
        if (lines.get(trainAcc).get(2).equals("0")) {
            trainAcc_ORIG.setSelected(true);
        } else {
            trainAcc_REAL.setSelected(true);
        }
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
        boolean found = false;
        while (length > 0 && length > line) {
            String curLine = lines.get(line).get(0);
            if (curLine.equals(s)) {
                found = true;
                return line;
            } else {
                line++;
            }
        }
        if (found == false) {
            getLineNum(s);
        }
        return line;
    }
    
    private void getIndexes() {
        int length = lines.size() - 1;
        for(int index = 0; index < length; index++) {
            String line = lines.get(index).get(0);
            if (line.contains("competitor_speed")) {
                compSpd = index;
                indexList.add(index);
            }
            else if(line.contains("construction_cost")) {
                constCost = index;
                indexList.add(index);
            }
            else if(line.contains("disasters")) {
                disasters = index;
                indexList.add(index);
            }
            else if(line.equals("economy")) {
                if (index < 60) {
                    economy = index;
                    indexList.add(index);
                }
            }
            else if(line.contains("industry_density")) {
                industDens = index;
                indexList.add(index);
            }
            else if(line.contains("initial_interest")) {
                initInter = index;
                indexList.add(index);
            }
            else if(line.contains("line_reverse_mode")) {
                lineReverse = index;
                indexList.add(index);
            }
            else if(line.contains("max_loan")) {
                maxLoan = index;
                indexList.add(index);
            }
            else if(line.contains("max_no_competitors")) {
                maxComp = index;
                indexList.add(index);
            }
            else if(line.contains("number_towns")) {
                towns = index;
                indexList.add(index);
            }
            else if(line.contains("custom_town_number")) {
                towns_CUSTOM = index;
                indexList.add(index);
            }
            else if(line.contains("quantity_sea_lakes")) {
                seas = index;
                indexList.add(index);
            }
            else if(line.contains("subsidy_multiplier")) {
                subsidy = index;
                indexList.add(index);
            }
            else if(line.contains("terrain_type")) {
                terrain = index;
                indexList.add(index);
            }
            else if(line.contains("town_council_tolerance")) {
                townCoun = index;
                indexList.add(index);
            }
            else if(line.contains("vehicle_breakdowns")) {
                vehicleBr = index;
                indexList.add(index);
            }
            else if(line.contains("vehicle_costs")) {
                vehicleCost = index;
                indexList.add(index);
            }
            else if(line.contains("disable_elrails")) {
                elecRail = index;
                indexList.add(index);
            }
            else if(line.contains("dynamic_engines")) {
                dynaEng = index;
                indexList.add(index);
            }
            else if(line.contains("extend_vehicle_life")) {
                vehiLife = index;
                indexList.add(index);
            }
            else if(line.contains("freight_trains")) {
                freightTrains = index;
                indexList.add(index);
            }
            else if(line.contains("max_aircraft")) {
                maxAir = index;
                indexList.add(index);
            }
            else if(line.contains("max_roadveh")) {
                maxRoad = index;
                indexList.add(index);
            }
            else if(line.contains("max_ships")) {
                maxShips = index;
                indexList.add(index);
            }
            else if(line.contains("max_train_length")) {
                maxTrainLen = index;
                indexList.add(index);
            }
            else if(line.contains("max_trains")) {
                maxTrains = index;
                indexList.add(index);
            }
            else if(line.contains("never_expire_vehicles")) {
                nExpire = index;
                indexList.add(index);
            }
            else if(line.contains("plane_crashes")) {
                planeCrash = index;
                indexList.add(index);
            }
            else if(line.contains("plane_speed")) {
                planeSpd = index;
                indexList.add(index);
            }
            else if(line.contains("road_side")) {
                roadSide = index;
                indexList.add(index);
            }
            else if(line.contains("roadveh_acceleration_model")) {
                roadAccel = index;
                indexList.add(index);
            }
            else if(line.contains("roadveh_slope_steepness")) {
                roadSlope = index;
                indexList.add(index);
            }
            else if(line.contains("servint_aircraft")) {
                servIntAir = index;
                indexList.add(index);
            }
            else if(line.contains("servint_roadveh")) {
                servIntRoad = index;
                indexList.add(index);
            }
            else if(line.contains("servint_ships")) {
                servIntShips = index;
                indexList.add(index);
            }
            else if(line.contains("servint_trains")) {
                servIntTrains = index;
                indexList.add(index);
            }
            else if(line.contains("servint_ispercent")) {
                servIntPer = index;
                indexList.add(index);
            }
            else if(line.contains("train_acceleration_model")) {
                trainAcc = index;
                indexList.add(index);
            }
//            else if(line.contains("")) {
//                 = index;
//            }
        }
        roadSlopeSet = false;
    }
}

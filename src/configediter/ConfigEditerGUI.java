package configediter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/*
 * Fix button initialization, and economy read
 */

/**
 *
 * @author Ian Van Schaick
 */
public class ConfigEditerGUI extends javax.swing.JFrame {
        //Variables for Difficulty tab, left side
        int compSpd;
        int constCost;
        int diffLevel;
        int disasters; //false and true
//        int economy; //false and true
        int industDens;
        int initInter;
        int lineReverse; //false and true
        int maxLoan;
        int maxComp;
        int industries;
        int index2;
        int index3;
        //Variables for Difficulty tab, right side
        int towns;
        int seas;
        int subsidy;
        int terrain;
        int townCoun;
        int vehicleBr;
        int vehicleCost;

        String openTTDfolder;
    /**
     * Creates new form ConfigEditerGUI
     */
    public ConfigEditerGUI() {
        
        //start reading the config File
        getMyDocuments ();
        
        compSpd = readConfigInt("competitor_speed");
        constCost = readConfigInt("construction_cost");
        diffLevel = readConfigInt("diff_level");
        disasters = readConfigInt("disasters");
//        economy = readConfigInt("economy");
        industDens = readConfigInt("industry_density");
        initInter = readConfigInt("initial_interest");
        lineReverse = readConfigInt("line_reverse_mode");
        maxLoan = readConfigInt("max_loan");
        maxComp = readConfigInt("max_no_competitors");
        industries = readConfigInt("number_industries");
        
        towns = readConfigInt("number_towns");
        seas = readConfigInt("quantity_sea_lakes");
        subsidy = readConfigInt("subsidy_multiplier");
        terrain = readConfigInt("terrain_type");
        townCoun = readConfigInt("town_council_tolerance");
        vehicleBr = readConfigInt("vehicle_breakdowns");
        vehicleCost = readConfigInt("vehicle_costs");
        
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
        
        diffLevelGroup.add(diffLevel_E);
        diffLevelGroup.add(diffLevel_M);
        diffLevelGroup.add(diffLevel_H);
        
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
        initInterGroup.add(initInter_CUST);
        
        lineReverseGroup.add(lineReverse_TRUE);
        lineReverseGroup.add(lineReverse_FALSE);
        
        industriesGroup.add(industries_NONE);
        industriesGroup.add(industries_VL);
        industriesGroup.add(industries_L);
        industriesGroup.add(industries_N);
        industriesGroup.add(industries_H);
        
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
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        System.out.println(compSpd + " D");
        if(compSpd != 0) {
            compSpd_VS = new javax.swing.JRadioButton();
        }
        else{
            compSpd_VS = new javax.swing.JRadioButton("0",true);
        }
        System.out.println(compSpd + " D");
        if(compSpd == 1) {
            compSpd_S = new javax.swing.JRadioButton("1",true);
        }
        else{
            compSpd_S = new javax.swing.JRadioButton();
        }
        System.out.println(compSpd + " D");
        if(compSpd == 2) {
            compSpd_M = new javax.swing.JRadioButton("2", true);
        }
        else{
            compSpd_M = new javax.swing.JRadioButton();
        }
        System.out.println(compSpd + " D");
        if(compSpd == 4) {
            compSpd_VF = new javax.swing.JRadioButton("4", true);
        }
        else{
            compSpd_VF = new javax.swing.JRadioButton("4");
        }
        System.out.println(compSpd + " D");
        if(compSpd == 3) {
            compSpd_F = new javax.swing.JRadioButton("3", true);
        }
        else{
            compSpd_F = new javax.swing.JRadioButton();
        }
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        constCost_M = new javax.swing.JRadioButton();
        constCost_L = new javax.swing.JRadioButton();
        jLabel11 = new javax.swing.JLabel();
        diffLevel_M = new javax.swing.JRadioButton();
        constCost_H = new javax.swing.JRadioButton();
        diffLevel_E = new javax.swing.JRadioButton();
        diffLevel_H = new javax.swing.JRadioButton();
        disasters_OFF = new javax.swing.JRadioButton();
        disasters_ON = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        economy_VAR = new javax.swing.JRadioButton();
        economy_SM = new javax.swing.JRadioButton();
        jLabel14 = new javax.swing.JLabel();
        industDens_L = new javax.swing.JRadioButton();
        industDens_MIN = new javax.swing.JRadioButton();
        industDens_NONE = new javax.swing.JRadioButton();
        industDens_H = new javax.swing.JRadioButton();
        industDens_VL = new javax.swing.JRadioButton();
        industDens_N = new javax.swing.JRadioButton();
        initInter_4 = new javax.swing.JRadioButton();
        initInter_3 = new javax.swing.JRadioButton();
        initInter_2 = new javax.swing.JRadioButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lineReverse_FALSE = new javax.swing.JRadioButton();
        lineReverse_TRUE = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        maxLoan_TEXT = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        maxComp_TEXT = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        industries_N = new javax.swing.JRadioButton();
        industries_VL = new javax.swing.JRadioButton();
        industries_NONE = new javax.swing.JRadioButton();
        industries_H = new javax.swing.JRadioButton();
        industries_L = new javax.swing.JRadioButton();
        jLabel20 = new javax.swing.JLabel();
        towns_H = new javax.swing.JRadioButton();
        towns_L = new javax.swing.JRadioButton();
        towns_VL = new javax.swing.JRadioButton();
        towns_CUST = new javax.swing.JRadioButton();
        towns_N = new javax.swing.JRadioButton();
        jLabel21 = new javax.swing.JLabel();
        seas_H = new javax.swing.JRadioButton();
        seas_L = new javax.swing.JRadioButton();
        seas_VL = new javax.swing.JRadioButton();
        seas_CUST = new javax.swing.JRadioButton();
        seas_M = new javax.swing.JRadioButton();
        subsidy_30 = new javax.swing.JRadioButton();
        subsidy_20 = new javax.swing.JRadioButton();
        subsidy_15 = new javax.swing.JRadioButton();
        jLabel22 = new javax.swing.JLabel();
        subsidy_40 = new javax.swing.JRadioButton();
        terrain_H = new javax.swing.JRadioButton();
        terrain_VF = new javax.swing.JRadioButton();
        jLabel23 = new javax.swing.JLabel();
        terrain_M = new javax.swing.JRadioButton();
        terrain_F = new javax.swing.JRadioButton();
        jLabel24 = new javax.swing.JLabel();
        townCoun_PER = new javax.swing.JRadioButton();
        townCoun_TOL = new javax.swing.JRadioButton();
        townCoun_HOS = new javax.swing.JRadioButton();
        jLabel25 = new javax.swing.JLabel();
        vehicleBr_N = new javax.swing.JRadioButton();
        vehicleBr_RED = new javax.swing.JRadioButton();
        vehicleBr_NONE = new javax.swing.JRadioButton();
        vehicleCost_H = new javax.swing.JRadioButton();
        vehicleCost_M = new javax.swing.JRadioButton();
        jLabel26 = new javax.swing.JLabel();
        vehicleCost_L = new javax.swing.JRadioButton();
        initInter_CUST_Text = new javax.swing.JTextField();
        initInter_CUST = new javax.swing.JRadioButton();
        towns_TEXT = new javax.swing.JTextField();
        seas_TEXT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 653, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 449, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Misc", jPanel1);

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

        jLabel9.setText("Competr. speed");

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

        jLabel11.setText("diff. level");

        diffLevel_M.setText("medium");
        diffLevel_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diffLevel_MActionPerformed(evt);
            }
        });

        constCost_H.setText("high");
        constCost_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                constCost_HActionPerformed(evt);
            }
        });

        diffLevel_E.setText("easy");
        diffLevel_E.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diffLevel_EActionPerformed(evt);
            }
        });

        diffLevel_H.setText("hard");
        diffLevel_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diffLevel_HActionPerformed(evt);
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

        economy_VAR.setText("variable");
        economy_VAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                economy_VARActionPerformed(evt);
            }
        });

        economy_SM.setText("smooth");
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

        lineReverse_FALSE.setText("false");
        lineReverse_FALSE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineReverse_FALSEActionPerformed(evt);
            }
        });

        lineReverse_TRUE.setText("true");
        lineReverse_TRUE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lineReverse_TRUEActionPerformed(evt);
            }
        });

        jLabel17.setText("Max loan (100 000-500 000)");

        maxLoan_TEXT.setText("custom");
        maxLoan_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxLoan_TEXTActionPerformed(evt);
            }
        });

        jLabel18.setText("Max # of compet. (0-14)");

        maxComp_TEXT.setText("custom");
        maxComp_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maxComp_TEXTActionPerformed(evt);
            }
        });

        jLabel19.setText("# of industries");

        industries_N.setText("normal");
        industries_N.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industries_NActionPerformed(evt);
            }
        });

        industries_VL.setText("very low");
        industries_VL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industries_VLActionPerformed(evt);
            }
        });

        industries_NONE.setText("none");
        industries_NONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industries_NONEActionPerformed(evt);
            }
        });

        industries_H.setText("high");
        industries_H.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industries_HActionPerformed(evt);
            }
        });

        industries_L.setText("low");
        industries_L.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                industries_LActionPerformed(evt);
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

        initInter_CUST_Text.setText("custom");
        initInter_CUST_Text.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initInter_CUST_TextActionPerformed(evt);
            }
        });

        initInter_CUST.setText("custom");
        initInter_CUST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                initInter_CUSTActionPerformed(evt);
            }
        });

        towns_TEXT.setText("custom");
        towns_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                towns_TEXTActionPerformed(evt);
            }
        });

        seas_TEXT.setText("custom");
        seas_TEXT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                seas_TEXTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
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
                            .addComponent(industDens_VL)))
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
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(initInter_2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(initInter_3))
                            .addComponent(initInter_CUST))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(initInter_CUST_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(initInter_4)))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17)
                                .addComponent(jLabel18))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(maxComp_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(maxLoan_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(51, 51, 51))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(industries_N)
                                    .addGap(18, 18, 18)
                                    .addComponent(industries_H))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(industries_NONE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(industries_VL)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(industries_L)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineReverse_TRUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lineReverse_FALSE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(diffLevel_E)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(diffLevel_M)
                                .addGap(6, 6, 6))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(constCost_L)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(constCost_M)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(constCost_H)
                            .addComponent(diffLevel_H))))
                .addGap(20, 20, 20)
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
                                .addComponent(vehicleBr_RED))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleCost_L)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleCost_M)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vehicleCost_H)))
                .addContainerGap(18, Short.MAX_VALUE))
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
                            .addComponent(vehicleCost_H)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(compSpd_VS)
                            .addComponent(compSpd_S)
                            .addComponent(compSpd_M)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(compSpd_F)
                            .addComponent(compSpd_VF))
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
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(diffLevel_E)
                                                .addComponent(diffLevel_M)
                                                .addComponent(diffLevel_H))
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(disasters_ON)
                                            .addComponent(disasters_OFF))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
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
                        .addGap(1, 1, 1)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(initInter_CUST_Text, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(initInter_CUST))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(lineReverse_TRUE)
                            .addComponent(lineReverse_FALSE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(maxLoan_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(maxComp_TEXT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(industries_NONE)
                            .addComponent(industries_VL)
                            .addComponent(industries_L))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(industries_N)
                            .addComponent(industries_H))))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Difficulty", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void compSpd_VSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compSpd_VSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compSpd_VSActionPerformed

    private void compSpd_SActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compSpd_SActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compSpd_SActionPerformed

    private void compSpd_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compSpd_MActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compSpd_MActionPerformed

    private void compSpd_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compSpd_FActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compSpd_FActionPerformed

    private void compSpd_VFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compSpd_VFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_compSpd_VFActionPerformed

    private void constCost_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constCost_LActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_constCost_LActionPerformed

    private void constCost_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constCost_MActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_constCost_MActionPerformed

    private void constCost_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_constCost_HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_constCost_HActionPerformed

    private void diffLevel_EActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diffLevel_EActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diffLevel_EActionPerformed

    private void diffLevel_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diffLevel_MActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diffLevel_MActionPerformed

    private void diffLevel_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diffLevel_HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diffLevel_HActionPerformed

    private void disasters_ONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disasters_ONActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disasters_ONActionPerformed

    private void disasters_OFFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disasters_OFFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_disasters_OFFActionPerformed

    private void economy_SMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_economy_SMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_economy_SMActionPerformed

    private void economy_VARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_economy_VARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_economy_VARActionPerformed

    private void industDens_NONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_NONEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industDens_NONEActionPerformed

    private void industDens_MINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_MINActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industDens_MINActionPerformed

    private void industDens_VLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_VLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industDens_VLActionPerformed

    private void industDens_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_LActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industDens_LActionPerformed

    private void industDens_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industDens_NActionPerformed

    private void industDens_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industDens_HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industDens_HActionPerformed

    private void initInter_2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initInter_2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initInter_2ActionPerformed

    private void initInter_3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initInter_3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initInter_3ActionPerformed

    private void initInter_4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initInter_4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initInter_4ActionPerformed

    private void initInter_CUSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initInter_CUSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initInter_CUSTActionPerformed

    private void initInter_CUST_TextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_initInter_CUST_TextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_initInter_CUST_TextActionPerformed

    private void lineReverse_TRUEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineReverse_TRUEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lineReverse_TRUEActionPerformed

    private void lineReverse_FALSEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lineReverse_FALSEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lineReverse_FALSEActionPerformed

    private void maxLoan_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxLoan_TEXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxLoan_TEXTActionPerformed

    private void maxComp_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maxComp_TEXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_maxComp_TEXTActionPerformed

    private void industries_NONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industries_NONEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industries_NONEActionPerformed

    private void industries_VLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industries_VLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industries_VLActionPerformed

    private void industries_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industries_LActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industries_LActionPerformed

    private void industries_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industries_NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industries_NActionPerformed

    private void industries_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_industries_HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_industries_HActionPerformed

    private void towns_VLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_VLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_towns_VLActionPerformed

    private void towns_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_LActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_towns_LActionPerformed

    private void towns_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_towns_NActionPerformed

    private void towns_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_towns_HActionPerformed

    private void towns_CUSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_CUSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_towns_CUSTActionPerformed

    private void towns_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_towns_TEXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_towns_TEXTActionPerformed

    private void seas_VLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_VLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seas_VLActionPerformed

    private void seas_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_LActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seas_LActionPerformed

    private void seas_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_MActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seas_MActionPerformed

    private void seas_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seas_HActionPerformed

    private void seas_CUSTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_CUSTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seas_CUSTActionPerformed

    private void seas_TEXTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_seas_TEXTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_seas_TEXTActionPerformed

    private void subsidy_15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsidy_15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subsidy_15ActionPerformed

    private void subsidy_20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsidy_20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subsidy_20ActionPerformed

    private void subsidy_30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsidy_30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subsidy_30ActionPerformed

    private void subsidy_40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subsidy_40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subsidy_40ActionPerformed

    private void terrain_VFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terrain_VFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_terrain_VFActionPerformed

    private void terrain_FActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terrain_FActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_terrain_FActionPerformed

    private void terrain_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terrain_HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_terrain_HActionPerformed

    private void terrain_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_terrain_MActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_terrain_MActionPerformed

    private void townCoun_PERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_townCoun_PERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_townCoun_PERActionPerformed

    private void townCoun_TOLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_townCoun_TOLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_townCoun_TOLActionPerformed

    private void townCoun_HOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_townCoun_HOSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_townCoun_HOSActionPerformed

    private void vehicleBr_NONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleBr_NONEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicleBr_NONEActionPerformed

    private void vehicleBr_REDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleBr_REDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicleBr_REDActionPerformed

    private void vehicleBr_NActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleBr_NActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicleBr_NActionPerformed

    private void vehicleCost_LActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleCost_LActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicleCost_LActionPerformed

    private void vehicleCost_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleCost_MActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicleCost_MActionPerformed

    private void vehicleCost_HActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehicleCost_HActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehicleCost_HActionPerformed
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
    private javax.swing.JRadioButton diffLevel_E;
    private javax.swing.JRadioButton diffLevel_H;
    private javax.swing.JRadioButton diffLevel_M;
    private javax.swing.ButtonGroup disastersGroup;
    private javax.swing.JRadioButton disasters_OFF;
    private javax.swing.JRadioButton disasters_ON;
    private javax.swing.ButtonGroup economyGroup;
    private javax.swing.JRadioButton economy_SM;
    private javax.swing.JRadioButton economy_VAR;
    private javax.swing.ButtonGroup industDensGroup;
    private javax.swing.JRadioButton industDens_H;
    private javax.swing.JRadioButton industDens_L;
    private javax.swing.JRadioButton industDens_MIN;
    private javax.swing.JRadioButton industDens_N;
    private javax.swing.JRadioButton industDens_NONE;
    private javax.swing.JRadioButton industDens_VL;
    private javax.swing.ButtonGroup industriesGroup;
    private javax.swing.JRadioButton industries_H;
    private javax.swing.JRadioButton industries_L;
    private javax.swing.JRadioButton industries_N;
    private javax.swing.JRadioButton industries_NONE;
    private javax.swing.JRadioButton industries_VL;
    private javax.swing.ButtonGroup initInterGroup;
    private javax.swing.JRadioButton initInter_2;
    private javax.swing.JRadioButton initInter_3;
    private javax.swing.JRadioButton initInter_4;
    private javax.swing.JRadioButton initInter_CUST;
    private javax.swing.JTextField initInter_CUST_Text;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.ButtonGroup lineReverseGroup;
    private javax.swing.JRadioButton lineReverse_FALSE;
    private javax.swing.JRadioButton lineReverse_TRUE;
    private javax.swing.JTextField maxComp_TEXT;
    private javax.swing.JTextField maxLoan_TEXT;
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
    // End of variables declaration//GEN-END:variables


        
    private void getMyDocuments () {
     JFileChooser fr = new JFileChooser();
     FileSystemView fw = fr.getFileSystemView();
     openTTDfolder = fw.getDefaultDirectory() + "\\OpenTTD\\openttd.cfg";
    }
    
    private int readConfigInt (String s) {
        index2++;
        System.out.println(index2 + "");
        int indexfound;
        int found = 0;
        String [] parts;
        try ( BufferedReader bf = new BufferedReader(new FileReader(new File(openTTDfolder) ) ) ) {
            String line;
            while ((line = bf.readLine()) != null) {
                indexfound = line.indexOf(s);
                if (indexfound > -1) {
                    parts = line.split(" ");
                    found = Integer.parseInt(parts [2]);
                    System.out.println(found + " read");
                }
            }
            bf.close();
        } catch (IOException ex) {
            Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        index3++;
        System.out.println(index3 + "");
        System.out.println(compSpd + " compSpd");
        return found;
    }
    
    private boolean readConfigBoo (String s) {
        int indexfound;
        boolean found = true;
        String [] parts;
        System.out.print(openTTDfolder);
        try ( BufferedReader bf = new BufferedReader(new FileReader(new File(openTTDfolder) ) ) ) {
            String line;
            while ((line = bf.readLine()) != null) {
                indexfound = line.indexOf(s);
                if (indexfound > -1) {
                    parts = line.split(" ");
                    found = Boolean.parseBoolean(parts [2]);
                }
            }
            bf.close();
        } catch (IOException ex) {
            Logger.getLogger(ConfigEditerGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return found;
    }
}

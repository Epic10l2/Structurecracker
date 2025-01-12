import javax.swing.*;
import java.awt.*;
import java.awt.desktop.SystemSleepEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class Seedcracker {

    private static final int[] givenorder = {
            19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0
    };
    private JComboBox<String> versionComboBox;

    public static List<Long> structureSeeds = new ArrayList<>();
    public static List<Long> partialSeeds = new ArrayList<>();
    public static AtomicInteger amountofpartialseeds = new AtomicInteger(0);
    public static AtomicInteger partialprogress = new AtomicInteger(0);
    public static AtomicInteger lastprogress = new AtomicInteger(0);
    public static boolean lightmode = true;
    public static boolean lifting = false;
    private JComboBox<String> input1ComboBox, input2ComboBox, input3ComboBox, input4ComboBox, input5ComboBox, input6ComboBox, input7ComboBox, input8ComboBox, input9ComboBox, input10ComboBox, input11ComboBox, input12ComboBox, input13ComboBox, input14ComboBox, input15ComboBox, input16ComboBox, input17ComboBox, input18ComboBox, input19ComboBox, input20ComboBox, gatewayCombobox, gatewayCombobox0, gatewayCombobox1, gatewayCombobox2, gatewayCombobox3, gatewayCombobox4, gatewayCombobox5, gatewayCombobox6, gatewayCombobox7, gatewayCombobox8, gatewayCombobox9, gatewayCombobox10, gatewayCombobox11, gatewayCombobox12, gatewayCombobox13, gatewayCombobox14, gatewayCombobox15, gatewayCombobox16, gatewayCombobox17, gatewayCombobox18, gatewayCombobox19;
    private JTextField input1XInput, input1ZInput, input2XInput, input2ZInput, input3XInput, input3ZInput, input4XInput, input4ZInput, input5XInput, input5ZInput, input6XInput, input6ZInput, input7XInput, input7ZInput, input8XInput, input8ZInput, input9XInput, input9ZInput, input10XInput, input10ZInput, input11XInput, input11ZInput, input12XInput, input12ZInput, input13XInput, input13ZInput, input14XInput, input14ZInput, input15XInput, input15ZInput, input16XInput, input16ZInput, input17XInput, input17ZInput, input18XInput, input18ZInput, input19XInput, input19ZInput, input20XInput, input20ZInput, pillarseedinput;
    private JCheckBox pillarseedbox = new JCheckBox("Pillarseed"), gatewaybox = new JCheckBox("Gatewaylifting"), liftingbox = new JCheckBox("Lifting");
    public static JProgressBar partialbar = new JProgressBar(0,1048576),fullbar = new JProgressBar(0,268435456);
    public static JLabel partiallabel = new JLabel("Partial bruteforce: "+ partialSeeds),fulllabel = new JLabel("Complete bruteforce: "+ structureSeeds);
    public static JLabel gatewayLabel0 = new JLabel("1."),gatewayLabel1 = new JLabel("2."),gatewayLabel2 = new JLabel("3."),gatewayLabel3 = new JLabel("4."),gatewayLabel4 = new JLabel("5."),gatewayLabel5 = new JLabel("6."),gatewayLabel6 = new JLabel("7."),gatewayLabel7 = new JLabel("8."),gatewayLabel8 = new JLabel("9."),gatewayLabel9 = new JLabel("10."),gatewayLabel10 = new JLabel("11."),gatewayLabel11 = new JLabel("12."),gatewayLabel12 = new JLabel("13."),gatewayLabel13 = new JLabel("14."),gatewayLabel14 = new JLabel("15."),gatewayLabel15 = new JLabel("16."),gatewayLabel16 = new JLabel("17."),gatewayLabel17 = new JLabel("18."),gatewayLabel18 = new JLabel("19."),gatewayLabel19 = new JLabel("20.");
    public static boolean printPartialseeds = false;
    public static boolean printStructureseeds = false;
    public static JCheckBox printPartialseedsBox = new JCheckBox("Print partial seeds to file");
    public static JCheckBox printStructureseedsBox = new JCheckBox("Print structure seeds to file");

    public void GUI() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        partiallabel.setBounds(650, 180, 500, 20);
        frame.add(partiallabel);
        fulllabel.setBounds(650, 230, 500, 20);
        frame.add(fulllabel);
        partialbar.setValue(0);
        partialbar.setStringPainted(true);
        partialbar.setBounds(650, 200, 150, 20);
        frame.add(partialbar);
        fullbar.setValue(0);
        fullbar.setStringPainted(true);
        fullbar.setBounds(650, 250, 150, 20);
        frame.add(fullbar);
        versionComboBox = new JComboBox<>(new String[]{"Java", "Bedrock"});
        versionComboBox.setBounds(50, 10, 100, 30);
        panel.add(versionComboBox);
        pillarseedbox.setBounds(650, 50, 100, 30);
        pillarseedinput = createInputField(panel, 300, 80);
        pillarseedinput.setBounds(650, 80, 100, 30);
        pillarseedinput.setVisible(false);
        gatewaybox.setBounds(750, 50, 120, 30);
        gatewayCombobox = new JComboBox<>(new String[] {"96 0","91 29","77 56","56 77","29 91","-91 -1","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","ß -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox.setBounds(750, 80, 100, 30);
        gatewayCombobox.setVisible(false);
        panel.add(gatewayCombobox);
        liftingbox.setBounds(870,50,100,30);
        liftingbox.setSelected(true);
        panel.add(liftingbox);
        printPartialseedsBox.setBounds(650,335,200,30);
        panel.add(printPartialseedsBox);
        printStructureseedsBox.setBounds(650,360,200,30);
        panel.add(printStructureseedsBox);
        pillarseedbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pillarseedinput.setVisible(pillarseedbox.isSelected());
                frame.revalidate();
                frame.repaint();
            }
        });
        gatewaybox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gatewayCombobox.setVisible(gatewaybox.isSelected());
                frame.revalidate();
                frame.repaint();
            }
        });
        printPartialseedsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(printPartialseedsBox.isSelected()){
                    printPartialseeds = true;
                }
                else{
                    printPartialseeds = false;
                }
            }
        });
        printStructureseedsBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(printStructureseedsBox.isSelected()){
                    printStructureseeds = true;
                }
                else{
                    printStructureseeds = false;
                }
            }
        });

        frame.add(pillarseedbox);
        frame.add(gatewaybox);

        input1ComboBox = createRow(panel, 50, 50, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Desertemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input1ComboBox.setBounds(50, 50, 150, 30);
        input1XInput = createInputField(panel, 210, 50);
        input1ZInput = createInputField(panel, 270, 50);

        input2ComboBox = createRow(panel, 50, 90, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input2ComboBox.setBounds(50, 90, 150, 30);
        input2XInput = createInputField(panel, 210, 90);
        input2ZInput = createInputField(panel, 270, 90);

        input3ComboBox = createRow(panel, 50, 130, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input3ComboBox.setBounds(50, 130, 150, 30);
        input3XInput = createInputField(panel, 210, 130);
        input3ZInput = createInputField(panel, 270, 130);

        input4ComboBox = createRow(panel, 50, 170, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input4ComboBox.setBounds(50, 170, 150, 30);
        input4XInput = createInputField(panel, 210, 170);
        input4ZInput = createInputField(panel, 270, 170);

        input5ComboBox = createRow(panel, 50, 210, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input5ComboBox.setBounds(50, 210, 150, 30);
        input5XInput = createInputField(panel, 210, 210);
        input5ZInput = createInputField(panel, 270, 210);

        input6ComboBox = createRow(panel, 50, 250, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input6ComboBox.setBounds(50, 250, 150, 30);
        input6XInput = createInputField(panel, 210, 250);
        input6ZInput = createInputField(panel, 270, 250);

        input7ComboBox = createRow(panel, 50, 290, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input7ComboBox.setBounds(50, 290, 150, 30);
        input7XInput = createInputField(panel, 210, 290);
        input7ZInput = createInputField(panel, 270, 290);

        input8ComboBox = createRow(panel, 50, 330, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input8ComboBox.setBounds(50, 330, 150, 30);
        input8XInput = createInputField(panel, 210, 330);
        input8ZInput = createInputField(panel, 270, 330);

        input9ComboBox = createRow(panel, 50, 370, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input9ComboBox.setBounds(50, 370, 150, 30);
        input9XInput = createInputField(panel, 210, 370);
        input9ZInput = createInputField(panel, 270, 370);

        input10ComboBox = createRow(panel, 50, 410, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input10ComboBox.setBounds(50, 410, 150, 30);
        input10XInput = createInputField(panel, 210, 410);
        input10ZInput = createInputField(panel, 270, 410);

        input11ComboBox = createRow(panel, 350, 50, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Desertemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input11ComboBox.setBounds(350, 50, 150, 30);
        input11XInput = createInputField(panel, 510, 50);
        input11ZInput = createInputField(panel, 570, 50);

        input12ComboBox = createRow(panel, 350, 90, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input12ComboBox.setBounds(350, 90, 150, 30);
        input12XInput = createInputField(panel, 510, 90);
        input12ZInput = createInputField(panel, 570, 90);

        input13ComboBox = createRow(panel, 350, 130, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input13ComboBox.setBounds(350, 130, 150, 30);
        input13XInput = createInputField(panel, 510, 130);
        input13ZInput = createInputField(panel, 570, 130);

        input14ComboBox = createRow(panel, 350, 170, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input14ComboBox.setBounds(350, 170, 150, 30);
        input14XInput = createInputField(panel, 510, 170);
        input14ZInput = createInputField(panel, 570, 170);

        input15ComboBox = createRow(panel, 350, 210, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input15ComboBox.setBounds(350, 210, 150, 30);
        input15XInput = createInputField(panel, 510, 210);
        input15ZInput = createInputField(panel, 570, 210);

        input16ComboBox = createRow(panel, 350, 250, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input16ComboBox.setBounds(350, 250, 150, 30);
        input16XInput = createInputField(panel, 510, 250);
        input16ZInput = createInputField(panel, 570, 250);

        input17ComboBox = createRow(panel, 350, 290, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input17ComboBox.setBounds(350, 290, 150, 30);
        input17XInput = createInputField(panel, 510, 290);
        input17ZInput = createInputField(panel, 570, 290);

        input18ComboBox = createRow(panel, 350, 330, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input18ComboBox.setBounds(350, 330, 150, 30);
        input18XInput = createInputField(panel, 510, 330);
        input18ZInput = createInputField(panel, 570, 330);

        input19ComboBox = createRow(panel, 350, 370, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input19ComboBox.setBounds(350, 370, 150, 30);
        input19XInput = createInputField(panel, 510, 370);
        input19ZInput = createInputField(panel, 570, 370);

        input20ComboBox = createRow(panel, 350, 410, "None", "Deserttemple", "Jungletemple", "Igloo", "Swamphut", "Outpost", "Ship", "Portal", "Ancientcity", "Mansion", "Trialchamber", "Village", "Oceanruin", "Treasure", "Monument", "Trailruin", "Bastion", "Fortress", "Deserttemple 1.12-", "Jungletemple 1.12-", "Igloo 1.12-", "Swamphut 1.12-", "Village 1.17-", "Mineshaft", "Slimechunk");
        input20ComboBox.setBounds(350, 410, 150, 30);
        input20XInput = createInputField(panel, 510, 410);
        input20ZInput = createInputField(panel, 570, 410);


        gatewayCombobox0 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox1 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox2 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox3 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox4 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox5 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox6 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox7 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox8 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox9 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox10 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox11 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox12 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox13 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox14 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox15 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox16 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox17 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox18 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox19 = new JComboBox<>(new String[] {"Unknown","96 0","91 29","77 56","56 77","29 91","-1 96","-30 91","-57 77","-78 56","-92 29","-96 -1","-92 -30","-78 -57","-57 -78","-30 -92","0 -96","29 -92","56 -78","77 -57","91 -30"});
        gatewayCombobox0.setBounds(1030, 50, 100, 30);
        gatewayLabel0.setBounds(1015,50,10,30);
        gatewayCombobox1.setBounds(1030, 90, 100, 30);
        gatewayLabel1.setBounds(1015,90,10,30);
        gatewayCombobox2.setBounds(1030, 130, 100, 30);
        gatewayLabel2.setBounds(1015,130,10,30);
        gatewayCombobox3.setBounds(1030, 170, 100, 30);
        gatewayLabel3.setBounds(1015,170,10,30);
        gatewayCombobox4.setBounds(1030, 210, 100, 30);
        gatewayLabel4.setBounds(1015,210,10,30);
        gatewayCombobox5.setBounds(1030, 250, 100, 30);
        gatewayLabel5.setBounds(1015,250,10,30);
        gatewayCombobox6.setBounds(1030, 290, 100, 30);
        gatewayLabel6.setBounds(1015,290,10,30);
        gatewayCombobox7.setBounds(1030, 330, 100, 30);
        gatewayLabel7.setBounds(1015,330,10,30);
        gatewayCombobox8.setBounds(1030, 370, 100, 30);
        gatewayLabel8.setBounds(1015,370,10,30);
        gatewayCombobox9.setBounds(1030, 410, 100, 30);
        gatewayLabel9.setBounds(1010,410,50,30);
        gatewayLabel10.setBounds(1255,50,50,30);
        gatewayCombobox10.setBounds(1150, 50, 100, 30);
        gatewayLabel11.setBounds(1255,90,50,30);
        gatewayCombobox11.setBounds(1150, 90, 100, 30);
        gatewayLabel12.setBounds(1255,130,50,30);
        gatewayCombobox12.setBounds(1150, 130, 100, 30);
        gatewayLabel13.setBounds(1255,170,50,30);
        gatewayCombobox13.setBounds(1150, 170, 100, 30);
        gatewayLabel14.setBounds(1255,210,50,30);
        gatewayCombobox14.setBounds(1150, 210, 100, 30);
        gatewayLabel15.setBounds(1255,250,50,30);
        gatewayCombobox15.setBounds(1150, 250, 100, 30);
        gatewayLabel16.setBounds(1255,290,50,30);
        gatewayCombobox16.setBounds(1150, 290, 100, 30);
        gatewayLabel17.setBounds(1255,330,50,30);
        gatewayCombobox17.setBounds(1150, 330, 100, 30);
        gatewayLabel18.setBounds(1255,370,50,30);
        gatewayCombobox18.setBounds(1150, 370, 100, 30);
        gatewayLabel19.setBounds(1255,410,50,30);
        gatewayCombobox19.setBounds(1150, 410, 100, 30);
        panel.add(gatewayLabel0);
        panel.add(gatewayLabel1);
        panel.add(gatewayLabel2);
        panel.add(gatewayLabel3);
        panel.add(gatewayLabel4);
        panel.add(gatewayLabel5);
        panel.add(gatewayLabel6);
        panel.add(gatewayLabel7);
        panel.add(gatewayLabel8);
        panel.add(gatewayLabel9);
        panel.add(gatewayLabel10);
        panel.add(gatewayLabel11);
        panel.add(gatewayLabel12);
        panel.add(gatewayLabel13);
        panel.add(gatewayLabel14);
        panel.add(gatewayLabel15);
        panel.add(gatewayLabel16);
        panel.add(gatewayLabel17);
        panel.add(gatewayLabel18);
        panel.add(gatewayLabel19);
        panel.add(gatewayCombobox0);
        panel.add(gatewayCombobox1);
        panel.add(gatewayCombobox2);
        panel.add(gatewayCombobox3);
        panel.add(gatewayCombobox4);
        panel.add(gatewayCombobox5);
        panel.add(gatewayCombobox6);
        panel.add(gatewayCombobox7);
        panel.add(gatewayCombobox8);
        panel.add(gatewayCombobox9);
        panel.add(gatewayCombobox10);
        panel.add(gatewayCombobox11);
        panel.add(gatewayCombobox12);
        panel.add(gatewayCombobox13);
        panel.add(gatewayCombobox14);
        panel.add(gatewayCombobox15);
        panel.add(gatewayCombobox16);
        panel.add(gatewayCombobox17);
        panel.add(gatewayCombobox18);
        panel.add(gatewayCombobox19);

        JButton crackButton = new JButton("Crack");
        crackButton.setBounds(650, 300, 100, 30);
        panel.add(crackButton);
        crackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String edition = (String) versionComboBox.getSelectedItem();
                int editionwarning = 0;
                if (edition == "Bedrock") {
                    editionwarning = JOptionPane.showConfirmDialog(panel, "Bedrock Edition support is not yet fully implemented.", "Bedrock Edition not Supported", JOptionPane.CLOSED_OPTION);

                } else {
                    long liftablebits = 0;
                    StructureChecker desertTempleChecker = new StructureChecker(14357617L);
                    StructureChecker jungleTempleChecker = new StructureChecker(14357619L);
                    StructureChecker iglooChecker = new StructureChecker(14357618L);
                    StructureChecker swampHutChecker = new StructureChecker(14357620L);
                    StructureChecker outpostChecker = new StructureChecker(165745296);
                    StructureChecker shipwreckChecker = new StructureChecker(165745295);
                    StructureChecker ruinedPortalChecker = new StructureChecker(34222645);
                    StructureChecker ancientCityChecker = new StructureChecker(20083232);
                    StructureChecker mansionChecker = new StructureChecker(10387319);
                    StructureChecker chamberChecker = new StructureChecker(94251327);
                    StructureChecker villageChecker = new StructureChecker(10387312);
                    StructureChecker oceanruinChecker = new StructureChecker(14357621);
                    StructureChecker buriedChecker = new StructureChecker(10387320);
                    StructureChecker monumentChecker = new StructureChecker(10387313);
                    StructureChecker trailruinChecker = new StructureChecker(83469867);
                    StructureChecker structurefeatures1_12Checker = new StructureChecker(14357617);
                    StructureChecker village1_17Checker = new StructureChecker(10387312);
                    StructureChecker Netherstructurechecker = new StructureChecker(30084232);
                    StructureChecker bedrock_genericchecker = new StructureChecker(14357617);
                    StructureChecker bedrock_outpostChecker = new StructureChecker(165745296);
                    StructureChecker bedrock_shipwreckChecker = new StructureChecker(165745295);
                    StructureChecker bedrock_shipwreck1_17checker = new StructureChecker(165745295);
                    StructureChecker bedrock_villageChecker = new StructureChecker(10387312);
                    StructureChecker bedrock_village1_17Checker = new StructureChecker(10387312);
                    StructureChecker bedrock_portalChecker = new StructureChecker(40552231);
                    StructureChecker bedrock_treasureChecker = new StructureChecker(16842397);
                    StructureChecker bedrock_mansionChecker = new StructureChecker(10387319);
                    StructureChecker bedrock_monumentChecker = new StructureChecker(10387319);
                    StructureChecker mineshaftChecker = new StructureChecker(0);
                    StructureChecker slimechunkChecker = new StructureChecker(0);

                    String input1Selection = (String) input1ComboBox.getSelectedItem();
                    if (input1Selection != "None") {
                        if (input1Selection == "Deserttemple" || input1Selection == "Jungletemple" || input1Selection == "Igloo" || input1Selection == "Swamphut" || input1Selection == "Outpost" || input1Selection == "Deserttemple 1.12-" || input1Selection == "Jungletemple 1.12-" || input1Selection == "Igloo 1.12-" || input1Selection == "Swamphut 1.12-" || input1Selection == "Village 1.17-") {
                            int input1X = Integer.parseInt(input1XInput.getText());
                            int input1Z = Integer.parseInt(input1ZInput.getText());
                            MainSeedcracker.structureadder(input1Selection, input1X, input1Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input1Selection == "Ship" || input1Selection == "Oceanruin") {
                            int input1X = Integer.parseInt(input1XInput.getText());
                            int input1Z = Integer.parseInt(input1ZInput.getText());
                            MainSeedcracker.structureadder(input1Selection, input1X, input1Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input1Selection == "Slimechunk") {
                            int input1X = Integer.parseInt(input1XInput.getText());
                            int input1Z = Integer.parseInt(input1ZInput.getText());
                            MainSeedcracker.structureadder(input1Selection, input1X, input1Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input1Selection == "Mansion" || input1Selection == "Village" || input1Selection == "Trialchamber" || input1Selection == "Trailruin") {
                            int input1X = Integer.parseInt(input1XInput.getText());
                            int input1Z = Integer.parseInt(input1ZInput.getText());
                            MainSeedcracker.structureadder(input1Selection, input1X, input1Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input1X = Integer.parseInt(input1XInput.getText());
                            int input1Z = Integer.parseInt(input1ZInput.getText());
                            MainSeedcracker.structureadder(input1Selection, input1X, input1Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }

                    String input2Selection = (String) input2ComboBox.getSelectedItem();
                    if (input2Selection != "None") {
                        if (input2Selection == "Deserttemple" || input2Selection == "Jungletemple" || input2Selection == "Igloo" || input2Selection == "Swamphut" || input2Selection == "Outpost" || input2Selection == "Deserttemple 1.12-" || input2Selection == "Jungletemple 1.12-" || input2Selection == "Igloo 1.12-" || input2Selection == "Swamphut 1.12-" || input2Selection == "Village 1.17-") {
                            int input2X = Integer.parseInt(input2XInput.getText());
                            int input2Z = Integer.parseInt(input2ZInput.getText());
                            MainSeedcracker.structureadder(input2Selection, input2X, input2Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input2Selection == "Ship" || input2Selection == "Oceanruin") {
                            int input2X = Integer.parseInt(input2XInput.getText());
                            int input2Z = Integer.parseInt(input2ZInput.getText());
                            MainSeedcracker.structureadder(input2Selection, input2X, input2Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input2Selection == "Slimechunk") {
                            int input2X = Integer.parseInt(input2XInput.getText());
                            int input2Z = Integer.parseInt(input2ZInput.getText());
                            MainSeedcracker.structureadder(input2Selection, input2X, input2Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input2Selection == "Mansion" || input2Selection == "Village" || input2Selection == "Trialchamber" || input2Selection == "Trailruin") {
                            int input2X = Integer.parseInt(input2XInput.getText());
                            int input2Z = Integer.parseInt(input2ZInput.getText());
                            MainSeedcracker.structureadder(input2Selection, input2X, input2Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input2X = Integer.parseInt(input2XInput.getText());
                            int input2Z = Integer.parseInt(input2ZInput.getText());
                            MainSeedcracker.structureadder(input2Selection, input2X, input2Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input3Selection = (String) input3ComboBox.getSelectedItem();
                    if (input3Selection != "None") {
                        if (input3Selection == "Deserttemple" || input3Selection == "Jungletemple" || input3Selection == "Igloo" || input3Selection == "Swamphut" || input3Selection == "Outpost" || input3Selection == "Deserttemple 1.12-" || input3Selection == "Jungletemple 1.12-" || input3Selection == "Igloo 1.12-" || input3Selection == "Swamphut 1.12-" || input3Selection == "Village 1.17-") {
                            int input3X = Integer.parseInt(input3XInput.getText());
                            int input3Z = Integer.parseInt(input3ZInput.getText());
                            MainSeedcracker.structureadder(input3Selection, input3X, input3Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input3Selection == "Ship" || input3Selection == "Oceanruin") {
                            int input3X = Integer.parseInt(input3XInput.getText());
                            int input3Z = Integer.parseInt(input3ZInput.getText());
                            MainSeedcracker.structureadder(input3Selection, input3X, input3Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input3Selection == "Slimechunk") {
                            int input3X = Integer.parseInt(input3XInput.getText());
                            int input3Z = Integer.parseInt(input3ZInput.getText());
                            MainSeedcracker.structureadder(input3Selection, input3X, input3Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input3Selection == "Mansion" || input3Selection == "Village" || input3Selection == "Trialchamber" || input3Selection == "Trailruin" ) {
                            int input3X = Integer.parseInt(input3XInput.getText());
                            int input3Z = Integer.parseInt(input3ZInput.getText());
                            MainSeedcracker.structureadder(input3Selection, input3X, input3Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input3X = Integer.parseInt(input3XInput.getText());
                            int input3Z = Integer.parseInt(input3ZInput.getText());
                            MainSeedcracker.structureadder(input3Selection, input3X, input3Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input4Selection = (String) input4ComboBox.getSelectedItem();
                    if (input4Selection != "None") {
                        if (input4Selection == "Deserttemple" || input4Selection == "Jungletemple" || input4Selection == "Igloo" || input4Selection == "Swamphut" || input4Selection == "Outpost" || input4Selection == "Deserttemple 1.12-" || input4Selection == "Jungletemple 1.12-" || input4Selection == "Igloo 1.12-" || input4Selection == "Swamphut 1.12-" || input4Selection == "Village 1.17-") {
                            int input4X = Integer.parseInt(input4XInput.getText());
                            int input4Z = Integer.parseInt(input4ZInput.getText());
                            MainSeedcracker.structureadder(input4Selection, input4X, input4Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input4Selection == "Ship" || input4Selection == "Oceanruin") {
                            int input4X = Integer.parseInt(input4XInput.getText());
                            int input4Z = Integer.parseInt(input4ZInput.getText());
                            MainSeedcracker.structureadder(input4Selection, input4X, input4Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input4Selection == "Slimechunk") {
                            int input4X = Integer.parseInt(input4XInput.getText());
                            int input4Z = Integer.parseInt(input4ZInput.getText());
                            MainSeedcracker.structureadder(input4Selection, input4X, input4Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input4Selection == "Mansion" || input4Selection == "Village" || input4Selection == "Trialchamber" || input4Selection == "Trailruin") {
                            int input4X = Integer.parseInt(input4XInput.getText());
                            int input4Z = Integer.parseInt(input4ZInput.getText());
                            MainSeedcracker.structureadder(input4Selection, input4X, input4Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input4X = Integer.parseInt(input4XInput.getText());
                            int input4Z = Integer.parseInt(input4ZInput.getText());
                            MainSeedcracker.structureadder(input4Selection, input4X, input4Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }


                    String input5Selection = (String) input5ComboBox.getSelectedItem();
                    if (input5Selection != "None") {
                        if (input5Selection == "Deserttemple" || input5Selection == "Jungletemple" || input5Selection == "Igloo" || input5Selection == "Swamphut" || input5Selection == "Outpost" || input5Selection == "Deserttemple 1.12-" || input5Selection == "Jungletemple 1.12-" || input5Selection == "Igloo 1.12-" || input5Selection == "Swamphut 1.12-" || input5Selection == "Village 1.17-") {
                            int input5X = Integer.parseInt(input5XInput.getText());
                            int input5Z = Integer.parseInt(input5ZInput.getText());
                            MainSeedcracker.structureadder(input5Selection, input5X, input5Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input5Selection == "Ship" || input5Selection == "Oceanruin") {
                            int input5X = Integer.parseInt(input5XInput.getText());
                            int input5Z = Integer.parseInt(input5ZInput.getText());
                            MainSeedcracker.structureadder(input5Selection, input5X, input5Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input5Selection == "Slimechunk") {
                            int input5X = Integer.parseInt(input5XInput.getText());
                            int input5Z = Integer.parseInt(input5ZInput.getText());
                            MainSeedcracker.structureadder(input5Selection, input5X, input5Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input5Selection == "Mansion" || input5Selection == "Village" || input5Selection == "Trialchamber" || input5Selection == "Trailruin") {
                            int input5X = Integer.parseInt(input5XInput.getText());
                            int input5Z = Integer.parseInt(input5ZInput.getText());
                            MainSeedcracker.structureadder(input5Selection, input5X, input5Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input5X = Integer.parseInt(input5XInput.getText());
                            int input5Z = Integer.parseInt(input5ZInput.getText());
                            MainSeedcracker.structureadder(input5Selection, input5X, input5Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }

                    String input6Selection = (String) input6ComboBox.getSelectedItem();
                    if (input6Selection != "None") {
                        if (input6Selection == "Deserttemple" || input6Selection == "Jungletemple" || input6Selection == "Igloo" || input6Selection == "Swamphut" || input6Selection == "Outpost" || input6Selection == "Deserttemple 1.12-" || input6Selection == "Jungletemple 1.12-" || input6Selection == "Igloo 1.12-" || input6Selection == "Swamphut 1.12-" || input6Selection == "Village 1.17-") {
                            int input6X = Integer.parseInt(input6XInput.getText());
                            int input6Z = Integer.parseInt(input6ZInput.getText());
                            MainSeedcracker.structureadder(input6Selection, input6X, input6Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input6Selection == "Ship" || input6Selection == "Oceanruin") {
                            int input6X = Integer.parseInt(input6XInput.getText());
                            int input6Z = Integer.parseInt(input6ZInput.getText());
                            MainSeedcracker.structureadder(input6Selection, input6X, input6Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input6Selection == "Slimechunk") {
                            int input6X = Integer.parseInt(input6XInput.getText());
                            int input6Z = Integer.parseInt(input6ZInput.getText());
                            MainSeedcracker.structureadder(input6Selection, input6X, input6Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input6Selection == "Mansion" || input6Selection == "Village" || input6Selection == "Trialchamber" || input6Selection == "Trailruin") {
                            int input6X = Integer.parseInt(input6XInput.getText());
                            int input6Z = Integer.parseInt(input6ZInput.getText());
                            MainSeedcracker.structureadder(input6Selection, input6X, input6Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input6X = Integer.parseInt(input6XInput.getText());
                            int input6Z = Integer.parseInt(input6ZInput.getText());
                            MainSeedcracker.structureadder(input6Selection, input6X, input6Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input7Selection = (String) input7ComboBox.getSelectedItem();
                    if (input7Selection != "None") {
                        if (input7Selection == "Deserttemple" || input7Selection == "Jungletemple" || input7Selection == "Igloo" || input7Selection == "Swamphut" || input7Selection == "Outpost" || input7Selection == "Deserttemple 1.12-" || input7Selection == "Jungletemple 1.12-" || input7Selection == "Igloo 1.12-" || input7Selection == "Swamphut 1.12-" || input7Selection == "Village 1.17-") {
                            int input7X = Integer.parseInt(input7XInput.getText());
                            int input7Z = Integer.parseInt(input7ZInput.getText());
                            MainSeedcracker.structureadder(input7Selection, input7X, input7Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input7Selection == "Ship" || input7Selection == "Oceanruin") {
                            int input7X = Integer.parseInt(input7XInput.getText());
                            int input7Z = Integer.parseInt(input7ZInput.getText());
                            MainSeedcracker.structureadder(input7Selection, input7X, input7Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input7Selection == "Slimechunk") {
                            int input7X = Integer.parseInt(input7XInput.getText());
                            int input7Z = Integer.parseInt(input7ZInput.getText());
                            MainSeedcracker.structureadder(input7Selection, input7X, input7Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input7Selection == "Mansion" || input7Selection == "Village" || input7Selection == "Trialchamber" || input7Selection == "Trailruin") {
                            int input7X = Integer.parseInt(input7XInput.getText());
                            int input7Z = Integer.parseInt(input7ZInput.getText());
                            MainSeedcracker.structureadder(input7Selection, input7X, input7Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input7X = Integer.parseInt(input7XInput.getText());
                            int input7Z = Integer.parseInt(input7ZInput.getText());
                            MainSeedcracker.structureadder(input7Selection, input7X, input7Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }

                    String input8Selection = (String) input8ComboBox.getSelectedItem();
                    if (input8Selection != "None") {
                        if (input8Selection == "Deserttemple" || input8Selection == "Jungletemple" || input8Selection == "Igloo" || input8Selection == "Swamphut" || input8Selection == "Outpost" || input8Selection == "Deserttemple 1.12-" || input8Selection == "Jungletemple 1.12-" || input8Selection == "Igloo 1.12-" || input8Selection == "Swamphut 1.12-" || input8Selection == "Village 1.17-") {
                            int input8X = Integer.parseInt(input8XInput.getText());
                            int input8Z = Integer.parseInt(input8ZInput.getText());
                            MainSeedcracker.structureadder(input8Selection, input8X, input8Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input8Selection == "Ship" || input8Selection == "Oceanruin") {
                            int input8X = Integer.parseInt(input8XInput.getText());
                            int input8Z = Integer.parseInt(input8ZInput.getText());
                            MainSeedcracker.structureadder(input8Selection, input8X, input8Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input8Selection == "Slimechunk") {
                            int input8X = Integer.parseInt(input8XInput.getText());
                            int input8Z = Integer.parseInt(input8ZInput.getText());
                            MainSeedcracker.structureadder(input8Selection, input8X, input8Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input8Selection == "Mansion" || input8Selection == "Village" || input8Selection == "Trialchamber" || input8Selection == "Trailruin") {
                            int input8X = Integer.parseInt(input8XInput.getText());
                            int input8Z = Integer.parseInt(input8ZInput.getText());
                            MainSeedcracker.structureadder(input8Selection, input8X, input8Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input8X = Integer.parseInt(input8XInput.getText());
                            int input8Z = Integer.parseInt(input8ZInput.getText());
                            MainSeedcracker.structureadder(input8Selection, input8X, input8Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }

                    String input9Selection = (String) input9ComboBox.getSelectedItem();
                    if (input9Selection != "None") {
                        if (input9Selection == "Deserttemple" || input9Selection == "Jungletemple" || input9Selection == "Igloo" || input9Selection == "Swamphut" || input9Selection == "Outpost" || input9Selection == "Deserttemple 1.12-" || input9Selection == "Jungletemple 1.12-" || input9Selection == "Igloo 1.12-" || input9Selection == "Swamphut 1.12-" || input9Selection == "Village 1.17-") {
                            int input9X = Integer.parseInt(input9XInput.getText());
                            int input9Z = Integer.parseInt(input9ZInput.getText());
                            MainSeedcracker.structureadder(input9Selection, input9X, input9Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input9Selection == "Ship" || input9Selection == "Oceanruin") {
                            int input9X = Integer.parseInt(input9XInput.getText());
                            int input9Z = Integer.parseInt(input9ZInput.getText());
                            MainSeedcracker.structureadder(input9Selection, input9X, input9Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input9Selection == "Slimechunk") {
                            int input9X = Integer.parseInt(input9XInput.getText());
                            int input9Z = Integer.parseInt(input9ZInput.getText());
                            MainSeedcracker.structureadder(input9Selection, input9X, input9Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input9Selection == "Mansion" || input9Selection == "Village" || input9Selection == "Trialchamber" || input9Selection == "Trailruin") {
                            int input9X = Integer.parseInt(input9XInput.getText());
                            int input9Z = Integer.parseInt(input9ZInput.getText());
                            MainSeedcracker.structureadder(input9Selection, input9X, input9Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input9X = Integer.parseInt(input9XInput.getText());
                            int input9Z = Integer.parseInt(input9ZInput.getText());
                            MainSeedcracker.structureadder(input9Selection, input9X, input9Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }

                    String input10Selection = (String) input10ComboBox.getSelectedItem();
                    if (input10Selection != "None") {
                        if (input10Selection == "Deserttemple" || input10Selection == "Jungletemple" || input10Selection == "Igloo" || input10Selection == "Swamphut" || input10Selection == "Outpost" || input1Selection == "Deserttemple 1.12-" || input10Selection == "Jungletemple 1.12-" || input10Selection == "Igloo 1.12-" || input10Selection == "Swamphut 1.12-" || input10Selection == "Village 1.17-") {
                            int input10X = Integer.parseInt(input10XInput.getText());
                            int input10Z = Integer.parseInt(input10ZInput.getText());
                            MainSeedcracker.structureadder(input10Selection, input10X, input10Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input10Selection == "Ship" || input10Selection == "Oceanruin") {
                            int input10X = Integer.parseInt(input10XInput.getText());
                            int input10Z = Integer.parseInt(input10ZInput.getText());
                            MainSeedcracker.structureadder(input10Selection, input10X, input10Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input10Selection == "Slimechunk") {
                            int input10X = Integer.parseInt(input10XInput.getText());
                            int input10Z = Integer.parseInt(input10ZInput.getText());
                            MainSeedcracker.structureadder(input10Selection, input10X, input10Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input10Selection == "Mansion" || input10Selection == "Village" || input10Selection == "Trialchamber" || input10Selection == "Trailruin") {
                            int input10X = Integer.parseInt(input10XInput.getText());
                            int input10Z = Integer.parseInt(input10ZInput.getText());
                            MainSeedcracker.structureadder(input10Selection, input10X, input10Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input10X = Integer.parseInt(input10XInput.getText());
                            int input10Z = Integer.parseInt(input10ZInput.getText());
                            MainSeedcracker.structureadder(input10Selection, input10X, input10Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input11Selection = (String) input11ComboBox.getSelectedItem();
                    if (input11Selection != "None") {
                        if (input11Selection == "Deserttemple" || input11Selection == "Jungletemple" || input11Selection == "Igloo" || input11Selection == "Swamphut" || input11Selection == "Outpost" || input11Selection == "Deserttemple 1.12-" || input11Selection == "Jungletemple 1.12-" || input11Selection == "Igloo 1.12-" || input11Selection == "Swamphut 1.12-" || input11Selection == "Village 1.17-") {
                            int input11X = Integer.parseInt(input11XInput.getText());
                            int input11Z = Integer.parseInt(input11ZInput.getText());
                            MainSeedcracker.structureadder(input11Selection, input11X, input11Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input11Selection == "Ship" || input11Selection == "Oceanruin") {
                            int input11X = Integer.parseInt(input11XInput.getText());
                            int input11Z = Integer.parseInt(input11ZInput.getText());
                            MainSeedcracker.structureadder(input11Selection, input11X, input11Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input11Selection == "Slimechunk") {
                            int input11X = Integer.parseInt(input11XInput.getText());
                            int input11Z = Integer.parseInt(input11ZInput.getText());
                            MainSeedcracker.structureadder(input11Selection, input11X, input11Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input11Selection == "Mansion" || input11Selection == "Village" || input11Selection == "Trialchamber" || input11Selection == "Trailruin") {
                            int input11X = Integer.parseInt(input11XInput.getText());
                            int input11Z = Integer.parseInt(input11ZInput.getText());
                            MainSeedcracker.structureadder(input11Selection, input11X, input11Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input11X = Integer.parseInt(input11XInput.getText());
                            int input11Z = Integer.parseInt(input11ZInput.getText());
                            MainSeedcracker.structureadder(input11Selection, input11X, input11Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input12Selection = (String) input12ComboBox.getSelectedItem();
                    if (input12Selection != "None") {
                        if (input12Selection == "Deserttemple" || input12Selection == "Jungletemple" || input12Selection == "Igloo" || input12Selection == "Swamphut" || input12Selection == "Outpost" || input12Selection == "Deserttemple 1.12-" || input12Selection == "Jungletemple 1.12-" || input12Selection == "Igloo 1.12-" || input12Selection == "Swamphut 1.12-" || input12Selection == "Village 1.17-") {
                            int input12X = Integer.parseInt(input12XInput.getText());
                            int input12Z = Integer.parseInt(input12ZInput.getText());
                            MainSeedcracker.structureadder(input12Selection, input12X, input12Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input12Selection == "Ship" || input12Selection == "Oceanruin") {
                            int input12X = Integer.parseInt(input12XInput.getText());
                            int input12Z = Integer.parseInt(input12ZInput.getText());
                            MainSeedcracker.structureadder(input12Selection, input12X, input12Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input12Selection == "Slimechunk") {
                            int input12X = Integer.parseInt(input12XInput.getText());
                            int input12Z = Integer.parseInt(input12ZInput.getText());
                            MainSeedcracker.structureadder(input12Selection, input12X, input12Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input12Selection == "Mansion" || input12Selection == "Village" || input12Selection == "Trialchamber" || input12Selection == "Trailruin") {
                            int input12X = Integer.parseInt(input12XInput.getText());
                            int input12Z = Integer.parseInt(input12ZInput.getText());
                            MainSeedcracker.structureadder(input12Selection, input12X, input12Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input12X = Integer.parseInt(input12XInput.getText());
                            int input12Z = Integer.parseInt(input12ZInput.getText());
                            MainSeedcracker.structureadder(input12Selection, input12X, input12Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input13Selection = (String) input13ComboBox.getSelectedItem();
                    if (input13Selection != "None") {
                        if (input13Selection == "Deserttemple" || input13Selection == "Jungletemple" || input13Selection == "Igloo" || input13Selection == "Swamphut" || input13Selection == "Outpost" || input13Selection == "Deserttemple 1.12-" || input13Selection == "Jungletemple 1.12-" || input13Selection == "Igloo 1.12-" || input13Selection == "Swamphut 1.12-" || input13Selection == "Village 1.17-") {
                            int input13X = Integer.parseInt(input13XInput.getText());
                            int input13Z = Integer.parseInt(input13ZInput.getText());
                            MainSeedcracker.structureadder(input13Selection, input13X, input13Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input13Selection == "Ship" || input13Selection == "Oceanruin") {
                            int input13X = Integer.parseInt(input13XInput.getText());
                            int input13Z = Integer.parseInt(input13ZInput.getText());
                            MainSeedcracker.structureadder(input13Selection, input13X, input13Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input13Selection == "Slimechunk") {
                            int input13X = Integer.parseInt(input13XInput.getText());
                            int input13Z = Integer.parseInt(input13ZInput.getText());
                            MainSeedcracker.structureadder(input13Selection, input13X, input13Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input13Selection == "Mansion" || input13Selection == "Village" || input13Selection == "Trialchamber" || input13Selection == "Trailruin") {
                            int input13X = Integer.parseInt(input13XInput.getText());
                            int input13Z = Integer.parseInt(input13ZInput.getText());
                            MainSeedcracker.structureadder(input13Selection, input13X, input13Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input13X = Integer.parseInt(input13XInput.getText());
                            int input13Z = Integer.parseInt(input13ZInput.getText());
                            MainSeedcracker.structureadder(input13Selection, input13X, input13Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input14Selection = (String) input14ComboBox.getSelectedItem();
                    if (input14Selection != "None") {
                        if (input14Selection == "Deserttemple" || input14Selection == "Jungletemple" || input14Selection == "Igloo" || input14Selection == "Swamphut" || input14Selection == "Outpost" || input14Selection == "Deserttemple 1.12-" || input14Selection == "Jungletemple 1.12-" || input14Selection == "Igloo 1.12-" || input14Selection == "Swamphut 1.12-" || input14Selection == "Village 1.17-") {
                            int input14X = Integer.parseInt(input14XInput.getText());
                            int input14Z = Integer.parseInt(input14ZInput.getText());
                            MainSeedcracker.structureadder(input14Selection, input14X, input14Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input14Selection == "Ship" || input14Selection == "Oceanruin") {
                            int input14X = Integer.parseInt(input14XInput.getText());
                            int input14Z = Integer.parseInt(input14ZInput.getText());
                            MainSeedcracker.structureadder(input14Selection, input14X, input14Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input14Selection == "Slimechunk") {
                            int input14X = Integer.parseInt(input14XInput.getText());
                            int input14Z = Integer.parseInt(input14ZInput.getText());
                            MainSeedcracker.structureadder(input14Selection, input14X, input14Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input14Selection == "Mansion" || input14Selection == "Village" || input14Selection == "Trialchamber" || input14Selection == "Trailruin") {
                            int input14X = Integer.parseInt(input14XInput.getText());
                            int input14Z = Integer.parseInt(input14ZInput.getText());
                            MainSeedcracker.structureadder(input14Selection, input14X, input14Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input14X = Integer.parseInt(input14XInput.getText());
                            int input14Z = Integer.parseInt(input14ZInput.getText());
                            MainSeedcracker.structureadder(input14Selection, input14X, input14Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input15Selection = (String) input15ComboBox.getSelectedItem();
                    if (input15Selection != "None") {
                        if (input15Selection == "Deserttemple" || input15Selection == "Jungletemple" || input15Selection == "Igloo" || input15Selection == "Swamphut" || input15Selection == "Outpost" || input15Selection == "Deserttemple 1.12-" || input15Selection == "Jungletemple 1.12-" || input15Selection == "Igloo 1.12-" || input15Selection == "Swamphut 1.12-" || input15Selection == "Village 1.17-") {
                            int input15X = Integer.parseInt(input15XInput.getText());
                            int input15Z = Integer.parseInt(input15ZInput.getText());
                            MainSeedcracker.structureadder(input15Selection, input15X, input15Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input15Selection == "Ship" || input15Selection == "Oceanruin") {
                            int input15X = Integer.parseInt(input15XInput.getText());
                            int input15Z = Integer.parseInt(input15ZInput.getText());
                            MainSeedcracker.structureadder(input15Selection, input15X, input15Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input15Selection == "Slimechunk") {
                            int input15X = Integer.parseInt(input15XInput.getText());
                            int input15Z = Integer.parseInt(input15ZInput.getText());
                            MainSeedcracker.structureadder(input15Selection, input15X, input15Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input15Selection == "Mansion" || input15Selection == "Village" || input15Selection == "Trialchamber" || input15Selection == "Trailruin") {
                            int input15X = Integer.parseInt(input15XInput.getText());
                            int input15Z = Integer.parseInt(input15ZInput.getText());
                            MainSeedcracker.structureadder(input15Selection, input15X, input15Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input15X = Integer.parseInt(input15XInput.getText());
                            int input15Z = Integer.parseInt(input15ZInput.getText());
                            MainSeedcracker.structureadder(input15Selection, input15X, input15Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input16Selection = (String) input16ComboBox.getSelectedItem();
                    if (input16Selection != "None") {
                        if (input16Selection == "Deserttemple" || input16Selection == "Jungletemple" || input16Selection == "Igloo" || input16Selection == "Swamphut" || input16Selection == "Outpost" || input16Selection == "Deserttemple 1.12-" || input16Selection == "Jungletemple 1.12-" || input16Selection == "Igloo 1.12-" || input16Selection == "Swamphut 1.12-" || input16Selection == "Village 1.17-") {
                            int input16X = Integer.parseInt(input16XInput.getText());
                            int input16Z = Integer.parseInt(input16ZInput.getText());
                            MainSeedcracker.structureadder(input16Selection, input16X, input16Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input16Selection == "Ship" || input16Selection == "Oceanruin") {
                            int input16X = Integer.parseInt(input16XInput.getText());
                            int input16Z = Integer.parseInt(input16ZInput.getText());
                            MainSeedcracker.structureadder(input16Selection, input16X, input16Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input16Selection == "Slimechunk") {
                            int input16X = Integer.parseInt(input16XInput.getText());
                            int input16Z = Integer.parseInt(input16ZInput.getText());
                            MainSeedcracker.structureadder(input16Selection, input16X, input16Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input16Selection == "Mansion" || input16Selection == "Village" || input16Selection == "Trialchamber" || input16Selection == "Trailruin") {
                            int input16X = Integer.parseInt(input16XInput.getText());
                            int input16Z = Integer.parseInt(input16ZInput.getText());
                            MainSeedcracker.structureadder(input16Selection, input16X, input16Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input16X = Integer.parseInt(input16XInput.getText());
                            int input16Z = Integer.parseInt(input16ZInput.getText());
                            MainSeedcracker.structureadder(input16Selection, input16X, input16Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input17Selection = (String) input17ComboBox.getSelectedItem();
                    if (input17Selection != "None") {
                        if (input17Selection == "Deserttemple" || input17Selection == "Jungletemple" || input17Selection == "Igloo" || input17Selection == "Swamphut" || input17Selection == "Outpost" || input17Selection == "Deserttemple 1.12-" || input17Selection == "Jungletemple 1.12-" || input17Selection == "Igloo 1.12-" || input17Selection == "Swamphut 1.12-" || input17Selection == "Village 1.17-") {
                            int input17X = Integer.parseInt(input17XInput.getText());
                            int input17Z = Integer.parseInt(input17ZInput.getText());
                            MainSeedcracker.structureadder(input17Selection, input17X, input17Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input17Selection == "Ship" || input17Selection == "Oceanruin") {
                            int input17X = Integer.parseInt(input17XInput.getText());
                            int input17Z = Integer.parseInt(input17ZInput.getText());
                            MainSeedcracker.structureadder(input17Selection, input17X, input17Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input17Selection == "Slimechunk") {
                            int input17X = Integer.parseInt(input17XInput.getText());
                            int input17Z = Integer.parseInt(input17ZInput.getText());
                            MainSeedcracker.structureadder(input17Selection, input17X, input17Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input17Selection == "Mansion" || input17Selection == "Village" || input17Selection == "Trialchamber" || input17Selection == "Trailruin") {
                            int input17X = Integer.parseInt(input17XInput.getText());
                            int input17Z = Integer.parseInt(input17ZInput.getText());
                            MainSeedcracker.structureadder(input17Selection, input17X, input17Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input17X = Integer.parseInt(input17XInput.getText());
                            int input17Z = Integer.parseInt(input17ZInput.getText());
                            MainSeedcracker.structureadder(input17Selection, input17X, input17Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input18Selection = (String) input18ComboBox.getSelectedItem();
                    if (input18Selection != "None") {
                        if (input18Selection == "Deserttemple" || input18Selection == "Jungletemple" || input18Selection == "Igloo" || input18Selection == "Swamphut" || input18Selection == "Outpost" || input18Selection == "Deserttemple 1.12-" || input18Selection == "Jungletemple 1.12-" || input18Selection == "Igloo 1.12-" || input18Selection == "Swamphut 1.12-" || input18Selection == "Village 1.17-") {
                            int input18X = Integer.parseInt(input18XInput.getText());
                            int input18Z = Integer.parseInt(input18ZInput.getText());
                            MainSeedcracker.structureadder(input18Selection, input18X, input18Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input18Selection == "Ship" || input18Selection == "Oceanruin") {
                            int input18X = Integer.parseInt(input18XInput.getText());
                            int input18Z = Integer.parseInt(input18ZInput.getText());
                            MainSeedcracker.structureadder(input18Selection, input18X, input18Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input18Selection == "Slimechunk") {
                            int input18X = Integer.parseInt(input18XInput.getText());
                            int input18Z = Integer.parseInt(input18ZInput.getText());
                            MainSeedcracker.structureadder(input18Selection, input18X, input18Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input18Selection == "Mansion" || input18Selection == "Village" || input18Selection == "Trialchamber" || input18Selection == "Trailruin") {
                            int input18X = Integer.parseInt(input18XInput.getText());
                            int input18Z = Integer.parseInt(input18ZInput.getText());
                            MainSeedcracker.structureadder(input18Selection, input18X, input18Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input18X = Integer.parseInt(input18XInput.getText());
                            int input18Z = Integer.parseInt(input18ZInput.getText());
                            MainSeedcracker.structureadder(input18Selection, input18X, input18Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input19Selection = (String) input19ComboBox.getSelectedItem();
                    if (input19Selection != "None") {
                        if (input19Selection == "Deserttemple" || input19Selection == "Jungletemple" || input19Selection == "Igloo" || input19Selection == "Swamphut" || input19Selection == "Outpost" || input19Selection == "Deserttemple 1.12-" || input19Selection == "Jungletemple 1.12-" || input19Selection == "Igloo 1.12-" || input19Selection == "Swamphut 1.12-" || input19Selection == "Village 1.17-") {
                            int input19X = Integer.parseInt(input19XInput.getText());
                            int input19Z = Integer.parseInt(input19ZInput.getText());
                            MainSeedcracker.structureadder(input19Selection, input19X, input19Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input19Selection == "Ship" || input19Selection == "Oceanruin") {
                            int input19X = Integer.parseInt(input19XInput.getText());
                            int input19Z = Integer.parseInt(input19ZInput.getText());
                            MainSeedcracker.structureadder(input19Selection, input19X, input19Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input19Selection == "Slimechunk") {
                            int input19X = Integer.parseInt(input19XInput.getText());
                            int input19Z = Integer.parseInt(input19ZInput.getText());
                            MainSeedcracker.structureadder(input19Selection, input19X, input19Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input19Selection == "Mansion" || input19Selection == "Village" || input19Selection == "Trialchamber" || input19Selection == "Trailruin") {
                            int input19X = Integer.parseInt(input19XInput.getText());
                            int input19Z = Integer.parseInt(input19ZInput.getText());
                            MainSeedcracker.structureadder(input19Selection, input19X, input19Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input19X = Integer.parseInt(input19XInput.getText());
                            int input19Z = Integer.parseInt(input19ZInput.getText());
                            MainSeedcracker.structureadder(input19Selection, input19X, input19Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    String input20Selection = (String) input20ComboBox.getSelectedItem();
                    if (input20Selection != "None") {
                        if (input20Selection == "Deserttemple" || input20Selection == "Jungletemple" || input20Selection == "Igloo" || input20Selection == "Swamphut" || input20Selection == "Outpost" || input20Selection == "Deserttemple 1.12-" || input20Selection == "Jungletemple 1.12-" || input20Selection == "Igloo 1.12-" || input20Selection == "Swamphut 1.12-" || input20Selection == "Village 1.17-") {
                            int input20X = Integer.parseInt(input20XInput.getText());
                            int input20Z = Integer.parseInt(input20ZInput.getText());
                            MainSeedcracker.structureadder(input20Selection, input20X, input20Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 6;
                        } else if (input20Selection == "Ship" || input20Selection == "Oceanruin") {
                            int input20X = Integer.parseInt(input20XInput.getText());
                            int input20Z = Integer.parseInt(input20ZInput.getText());
                            MainSeedcracker.structureadder(input20Selection, input20X, input20Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 4;
                        } else if (input20Selection == "Slimechunk") {
                            int input20X = Integer.parseInt(input20XInput.getText());
                            int input20Z = Integer.parseInt(input20ZInput.getText());
                            MainSeedcracker.structureadder(input20Selection, input20X, input20Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 1;
                        } else if (input20Selection == "Mansion" || input20Selection == "Village" || input20Selection == "Trialchamber" || input20Selection == "Trailruin") {
                            int input20X = Integer.parseInt(input20XInput.getText());
                            int input20Z = Integer.parseInt(input20ZInput.getText());
                            MainSeedcracker.structureadder(input20Selection, input20X, input20Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                            liftablebits += 2;
                        } else {
                            int input20X = Integer.parseInt(input20XInput.getText());
                            int input20Z = Integer.parseInt(input20ZInput.getText());
                            MainSeedcracker.structureadder(input20Selection, input20X, input20Z, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker);
                        }
                    }
                    int gateWay = -1;
                    if (gatewaybox.isSelected()) {
                        String gatewaytext = (String) gatewayCombobox.getSelectedItem();
                        if(gatewaytext==("96 0")){
                            gateWay = 0;
                        }
                        if(gatewaytext ==("91 29")){
                            gateWay = 1;
                        }
                        if(gatewaytext ==("77 56")){
                            gateWay = 2;
                        }
                        if(gatewaytext ==("56 77")){
                            gateWay = 3;
                        }
                        if(gatewaytext ==("29 991")){
                            gateWay = 4;
                        }
                        if(gatewaytext ==("-1 96")){
                            gateWay = 5;
                        }
                        if(gatewaytext ==("-30 91")){
                            gateWay = 6;
                        }
                        if(gatewaytext ==("-57 77")){
                            gateWay = 7;
                        }
                        if(gatewaytext ==("-78 56")){
                            gateWay = 8;
                        }
                        if(gatewaytext ==("-92 29")){
                            gateWay = 9;
                        }
                        if(gatewaytext ==("-96 -1")){
                            gateWay = 10;
                        }
                        if(gatewaytext ==("-92 -30")){
                            gateWay = 11;
                        }
                        if(gatewaytext ==("-78 -57")){
                            gateWay = 12;
                        }
                        if(gatewaytext ==("-57 -78")){
                            gateWay = 13;
                        }
                        if(gatewaytext ==("-30 -92")){
                            gateWay = 14;
                        }
                        if(gatewaytext ==("0 -96")){
                            gateWay = 15;
                        }
                        if(gatewaytext ==("29 -92")){
                            gateWay = 16;
                        }
                        if(gatewaytext ==("56 -78")){
                            gateWay = 17;
                        }
                        if(gatewaytext ==("77 -57")){
                            gateWay = 18;
                        }
                        if(gatewaytext ==("91 -30")){
                            gateWay = 19;
                        }
                    }
                    String gatewaytext = (String) gatewayCombobox0.getSelectedItem();
                    givenorderupdater(0,gatewaytext);
                    gatewaytext = (String) gatewayCombobox1.getSelectedItem();
                    givenorderupdater(1,gatewaytext);
                    gatewaytext = (String) gatewayCombobox2.getSelectedItem();
                    givenorderupdater(2,gatewaytext);
                    gatewaytext = (String) gatewayCombobox3.getSelectedItem();
                    givenorderupdater(3,gatewaytext);
                    gatewaytext = (String) gatewayCombobox4.getSelectedItem();
                    givenorderupdater(4,gatewaytext);
                    gatewaytext = (String) gatewayCombobox5.getSelectedItem();
                    givenorderupdater(5,gatewaytext);
                    gatewaytext = (String) gatewayCombobox6.getSelectedItem();
                    givenorderupdater(6,gatewaytext);
                    gatewaytext = (String) gatewayCombobox7.getSelectedItem();
                    givenorderupdater(7,gatewaytext);
                    gatewaytext = (String) gatewayCombobox8.getSelectedItem();
                    givenorderupdater(8,gatewaytext);
                    gatewaytext = (String) gatewayCombobox9.getSelectedItem();
                    givenorderupdater(9,gatewaytext);
                    gatewaytext = (String) gatewayCombobox10.getSelectedItem();
                    givenorderupdater(10,gatewaytext);
                    gatewaytext = (String) gatewayCombobox11.getSelectedItem();
                    givenorderupdater(11,gatewaytext);
                    gatewaytext = (String) gatewayCombobox12.getSelectedItem();
                    givenorderupdater(12,gatewaytext);
                    gatewaytext = (String) gatewayCombobox13.getSelectedItem();
                    givenorderupdater(13,gatewaytext);
                    gatewaytext = (String) gatewayCombobox14.getSelectedItem();
                    givenorderupdater(14,gatewaytext);
                    gatewaytext = (String) gatewayCombobox15.getSelectedItem();
                    givenorderupdater(15,gatewaytext);
                    gatewaytext = (String) gatewayCombobox16.getSelectedItem();
                    givenorderupdater(16,gatewaytext);
                    gatewaytext = (String) gatewayCombobox17.getSelectedItem();
                    givenorderupdater(17,gatewaytext);
                    gatewaytext = (String) gatewayCombobox18.getSelectedItem();
                    givenorderupdater(18,gatewaytext);
                    gatewaytext = (String) gatewayCombobox19.getSelectedItem();
                    givenorderupdater(19,gatewaytext);

                    if(liftingbox.isSelected()){
                        lifting = true;
                        partialbar.setVisible(true);
                        partiallabel.setVisible(true);
                    }
                    else{
                        lifting = false;
                        if(pillarseedbox.isSelected()) {
                            partialbar.setVisible(false);
                            partiallabel.setVisible(false);
                        }
                    }
                    if (gatewaybox.isSelected()) {
                        liftablebits += 2;
                    }
                    if (liftablebits >= 20 || pillarseedbox.isSelected() && liftablebits >= 16) {
                        long pillarSeed = -1;
                        if (pillarseedbox.isSelected()) {
                            pillarSeed = Integer.parseInt(pillarseedinput.getText());
                        }
                        boolean findStructureSeed = true;
                        amountofpartialseeds.set(0);
                        partialprogress.set(0);
                        lastprogress.set(0);
                        partialbar.setValue(0);
                        fullbar.setValue(0);
                        partialSeeds.clear();
                        partiallabel.setText("Partial bruteforce: " + partialSeeds);
                        structureSeeds.clear();
                        fulllabel.setText("Complete bruteforce: " + structureSeeds);
                        if (pillarSeed == -1) {
                            partialbar.setMaximum(1048576);
                            fullbar.setMaximum(268435456);
                            crackSeedsWithoutPillars(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker, gateWay, findStructureSeed, structureSeeds);
                        } else {
                            partialbar.setMaximum(65536);
                            fullbar.setMaximum(65536);
                            crackSeeds(pillarSeed, gateWay, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, Netherstructurechecker, slimechunkChecker, findStructureSeed, structureSeeds);
                        }
                    } else {
                        int result = 0;
                        if (pillarseedbox.isSelected()) {
                            result = JOptionPane.showConfirmDialog(panel, "You only have " + liftablebits + "/16 liftable bits, do you want to continue anyways?", "Not enough Bits.", JOptionPane.YES_NO_OPTION);
                        } else {
                            result = JOptionPane.showConfirmDialog(panel, "You only have " + liftablebits + "/20 liftable bits, do you want to continue anyways?", "Not enough Bits.", JOptionPane.YES_NO_OPTION);
                        }
                        if (result == JOptionPane.YES_OPTION) {
                            List<Long> structureSeeds = new ArrayList<>();
                            long pillarSeed = -1;
                            if (pillarseedbox.isSelected()) {
                                pillarSeed = Integer.parseInt(pillarseedinput.getText());
                            }
                            boolean findStructureSeed = true;
                            amountofpartialseeds.set(0);
                            partialprogress.set(0);
                            lastprogress.set(0);
                            partialbar.setValue(0);
                            fullbar.setValue(0);
                            partialSeeds.clear();
                            partiallabel.setText("Partial bruteforce: " + partialSeeds);
                            structureSeeds.clear();
                            fulllabel.setText("Complete bruteforce: " + structureSeeds);

                            if (pillarSeed == -1) {

                                partialbar.setMaximum(1048576);
                                fullbar.setMaximum(268435456);
                                crackSeedsWithoutPillars(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericchecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker, gateWay, findStructureSeed, structureSeeds);
                            } else {
                                partialbar.setMaximum(65536);
                                fullbar.setMaximum(65536);
                                crackSeeds(pillarSeed, gateWay, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, Netherstructurechecker, slimechunkChecker, findStructureSeed, structureSeeds);
                            }
                        }
                    }
                }


            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Structurecracker");
        frame.setSize(700, 600);
        frame.setVisible(true);
    }
    private void givenorderupdater(int index, String gatewaytext){
        if(gatewaytext ==("Unknown")){
            givenorder[index]=-1;
        }
        if(gatewaytext ==("96 0")){
            givenorder[index]=0;
        }
        if(gatewaytext ==("91 29")){
            givenorder[index]=1;
        }
        if(gatewaytext ==("77 56")){
            givenorder[index]=2;
        }
        if(gatewaytext ==("56 77")){
            givenorder[index]=3;
        }
        if(gatewaytext ==("29 91")){
            givenorder[index]=4;
        }
        if(gatewaytext ==("-1 96")){
            givenorder[index]=5;
        }
        if(gatewaytext ==("-30 91")){
            givenorder[index]=6;
        }
        if(gatewaytext ==("-57 77")){
            givenorder[index]=7;
        }
        if(gatewaytext ==("-78 56")){
            givenorder[index]=8;
        }
        if(gatewaytext ==("-92 29")){
            givenorder[index]=9;
        }
        if(gatewaytext ==("-96 -1")){
            givenorder[index]=10;
        }
        if(gatewaytext ==("-92 -30")){
            givenorder[index]=11;
        }
        if(gatewaytext ==("-78 -57")){
            givenorder[index]=12;
        }
        if(gatewaytext ==("-57 -78")){
            givenorder[index]=13;
        }
        if(gatewaytext ==("-30 -92")){
            givenorder[index]=14;
        }
        if(gatewaytext ==("0 -96")){
            givenorder[index]=15;
        }
        if(gatewaytext ==("29 -92")){
            givenorder[index]=16;
        }
        if(gatewaytext ==("56 -78")){
            givenorder[index]=17;
        }
        if(gatewaytext ==("77 -57")){
            givenorder[index]=18;
        }
        if(gatewaytext ==("91 -30")){
            givenorder[index]=19;
        }
    }


    private JComboBox<String> createRow(JPanel panel, int x, int y, String... options) {
        JComboBox<String> comboBox = new JComboBox<>(options);
        comboBox.setBounds(x, y, 100, 30);
        panel.add(comboBox);
        return comboBox;
    }


    private JTextField createInputField(JPanel panel, int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 50, 30);
        panel.add(textField);
        return textField;
    }

    public static void main(String[] args) {
        Seedcracker main = new Seedcracker();
        main.GUI();
    }

    private static void crackSeeds(long pillarSeed, long gateWay, StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, StructureChecker ruinedPortalChecker, StructureChecker ancientCityChecker, StructureChecker mansionChecker, StructureChecker chamberChecker, StructureChecker villageChecker, StructureChecker oceanruinChecker, StructureChecker buriedChecker, StructureChecker monumentChecker, StructureChecker trailruinChecker, StructureChecker structurefeatures1_12Checker, StructureChecker village1_17Checker, StructureChecker mineshaftChecker, StructureChecker Netherstructurechecker, StructureChecker slimechunkChecker, boolean findStructureSeed, List<Long> structureSeeds) {
        int availableCores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availableCores);
        executorService.submit(() -> {
            new MainSeedcracker.SeedCrackerTask(pillarSeed, gateWay, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, Netherstructurechecker, slimechunkChecker, findStructureSeed, structureSeeds, 0, 65536).invoke();
        });

        executorService.shutdown();
    }

    private static void crackSeedsWithoutPillars(StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, StructureChecker ruinedPortalChecker, StructureChecker ancientCityChecker, StructureChecker mansionChecker, StructureChecker chamberChecker, StructureChecker villageChecker, StructureChecker oceanruinChecker, StructureChecker buriedChecker , StructureChecker monumentChecker, StructureChecker trailruinChecker, StructureChecker structurefeatures1_12Checker, StructureChecker village1_17Checker, StructureChecker mineshaftChecker, StructureChecker bedrock_genericChecker,StructureChecker bedrock_mansionChecker, StructureChecker bedrock_monumentChecker, StructureChecker bedrock_outpostChecker, StructureChecker bedrock_portalChecker, StructureChecker bedrock_shipwreck1_17Checker, StructureChecker bedrock_shipwreckChecker,StructureChecker bedrock_treasureChecker, StructureChecker bedrock_village1_17Checker, StructureChecker bedrock_villageChecker,StructureChecker Netherstructurechecker, StructureChecker slimechunkChecker, long gateWay, boolean findStructureSeed, List<Long> structureSeeds) {
        int availablecores = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(availablecores);
        if (MainSeedcracker.edition) {
            executorService.submit(() -> {
                new MainSeedcracker.SeedCrackerTaskNoPillars(
                        desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker,
                        outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker,
                        mansionChecker, chamberChecker, villageChecker, oceanruinChecker,
                        buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker,
                        village1_17Checker, mineshaftChecker, bedrock_genericChecker, bedrock_mansionChecker,
                        bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker,
                        bedrock_shipwreck1_17Checker, bedrock_shipwreckChecker, bedrock_treasureChecker,
                        bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker,
                        slimechunkChecker, gateWay, findStructureSeed, structureSeeds, 0, 4294967295L
                ).invoke();
            });
        } else {
            executorService.submit(() -> {
                new MainSeedcracker.SeedCrackerTaskNoPillars(
                        desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker,
                        outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker,
                        mansionChecker, chamberChecker, villageChecker, oceanruinChecker,
                        buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker,
                        village1_17Checker, mineshaftChecker, bedrock_genericChecker, bedrock_mansionChecker,
                        bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker,
                        bedrock_shipwreck1_17Checker, bedrock_shipwreckChecker, bedrock_treasureChecker,
                        bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker,
                        slimechunkChecker, gateWay, findStructureSeed, structureSeeds, 0, 1048575
                ).invoke();
            });
        }
        executorService.shutdown();
    }



public class GatewayChecker{
    public static boolean gatewayChecker(long fullseed){
        final int[] order ={
                19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1,0
        };
        long newSeed = fullseed^25214903917l;
        long output = 0;
        for(int i = 0; i<20; i++){
            newSeed = (newSeed * 25214903917l+11)&((1l<<48)-1);
            long modulo = 20-i;
            if(modulo==16||modulo==8||modulo==4||modulo==2){
                output = (newSeed*modulo)>>48;
            }
            else{
                output = (((newSeed>>17)%modulo)+modulo)%modulo;
            }
            int j = (int)(19- output);
            int temp = order[i];
            order[i] = order[j];
            order[j] = temp;
        }
        for(int i = 0; i<20;i++){
            if(!(order[i]==givenorder[i])&&(givenorder[i]!=-1)){
                return false;
            }
        }
        return true;

    }
}
public static void writeSeedToFile(int seedType, long seedValue) {
    String fileName;
    switch (seedType) {
        case 0:
            fileName = "structureseeds.txt";
            break;
        case 1:
            fileName = "liftseeds.txt";
            break;
        case 2:
            fileName = "halfseeds.txt";
            break;
        default:
            System.err.println("Invalid seed type: " + seedType);
            return;
    }
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
        writer.write(Long.toString(seedValue));
        writer.newLine();
    } catch (IOException e) {
        System.err.println("An error occurred while writing to the file: " + e.getMessage());
    }
}
class StructureChecker {
    private List<int[]> coordinates;
    private long salt;

    public StructureChecker(long salt) {
        this.coordinates = new ArrayList<>();
        this.salt = salt;
    }

    public void addCoordinates(int chunkX, int chunkZ) {
        coordinates.add(new int[]{chunkX, chunkZ});
    }

    public boolean canGenerateBuriedTreasure(long fullSeed) {
        for (int[] coord : coordinates) {
            if (!buriedTreasureChecker(fullSeed, coord[0], coord[1])) {
                return false;
            }
        }
        return true;
    }



    public boolean buriedTreasureChecker(long fullseed, long chunkX, long chunkZ) {
        long newFullSeed = ((fullseed + chunkX * 341873128712L + chunkZ * 132897987541L + salt) ^ 25214903917L) & ((1L << 48) - 1);
        newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
        long next24 = newFullSeed >> 24;
        if (next24 < 167772.16) {
            return true;
        }
        return false;
    }
    public boolean canGenerateMineshaft(long fullSeed){
        for (int[] coord : coordinates) {
            if (!mineshaftChecker(fullSeed, coord[0], coord[1])) {
                return false;
            }
        }
        return true;

    }
    public boolean mineshaftChecker(long fullseed, int chunkX, int chunkZ){
        long newSeed = fullseed ^25214903917l;
        long randomInternalState = (newSeed * 25214903917l + 11) & ((1l<<48)-1);
        long firstThingie = randomInternalState >>16;
        randomInternalState = (randomInternalState * 25214903917l + 11) & ((1l<<48)-1);
        long secondThingie = randomInternalState >>16;
        long firstoutputthingie = ((firstThingie<<32) + (int)secondThingie);
        randomInternalState = (randomInternalState * 25214903917l + 11) & ((1l<<48)-1);
        firstThingie = randomInternalState >>16;
        randomInternalState = (randomInternalState * 25214903917l + 11) & ((1l<<48)-1);
        secondThingie = randomInternalState >>16;
        long secondoutputthingie = ((firstThingie<<32) + (int)secondThingie);
        long finaloutputthingie = (long) chunkX * firstoutputthingie ^ (long) chunkZ * secondoutputthingie ^ fullseed;
        newSeed = finaloutputthingie ^ 25214903917l;
        long newSeed1 = (newSeed * 25214903917l +11) & ((1l<<48)-1);
        long firstval = newSeed1 >> 22;
        long newSeed2 = (newSeed1 * 25214903917l +11) & ((1l<<48)-1);
        long secondval = newSeed2 >> 21;
        double finallyimdonewiththisbruh = (((long)firstval << 27) + secondval) /  (double)(1l << 53);
        if(finallyimdonewiththisbruh < 0.004d){
            return true;
        }
        return false;
    }
    public boolean canGenerateSlimechunk(long fullSeed, boolean lifting){

        for (int[] coord : coordinates) {
            if (!slimechunkChecker(fullSeed, coord[0], coord[1],lifting)) {
                return false;
            }
        }
        return true;
    }
    public boolean slimechunkChecker(long fullseed, int chunkX, int chunkZ, boolean lifting){
        if(fullseed==187547){
            System.out.println(chunkX + " "  + chunkZ);
        }
        long newSeed =
                (fullseed+
                        (long)( chunkX * chunkX * 4987142) +
                        (long)(chunkX * 5947611) +
                        (long)(chunkZ * chunkZ) * 4392871 +
                        (long)(chunkZ * 389711) ^ 987234911l)^25214903917L;;
        newSeed = (newSeed * 25214903917l + 11) & ((1l<<48)-1);
        if(lifting){
            return(((newSeed>>17)&1)==0);
        }
        else{
            return(((((newSeed>>17)%10)+10)%10)==0);
        }
    }

    public boolean canGenerateAtAll(long halfSeed, boolean isShip, boolean isMansion, boolean isChamber, boolean isOceanruin) {
        for (int[] coord : coordinates) {
            if (!canGenerateInTheFirstPlace(halfSeed, coord[0], coord[1], isShip, isMansion, isChamber, isOceanruin)) {
                return false;
            }
        }
        return true;
    }

    public boolean canActuallyGenerate(long fullSeed, boolean isShip, boolean isRuinedPortal, boolean isAncient, boolean isMansion, boolean isChamber, boolean isVillage, boolean isOceanruin, boolean isMonument, boolean isNetherstructure) {
        for (int[] coord : coordinates) {
            if (!canActuallyGenerate(fullSeed, coord[0], coord[1], isShip, isRuinedPortal, isAncient, isMansion, isChamber, isVillage, isOceanruin, isMonument, isNetherstructure)) {
                return false;
            }
        }
        return true;
    }

    private boolean canGenerateInTheFirstPlace(long halfSeed, int chunkX, int chunkZ, boolean isShip, boolean isMansion, boolean isChamber, boolean isOceanruin) {
        int regX = isShip ? Math.floorDiv(chunkX, 24) : isMansion ? Math.floorDiv(chunkX, 80) : isChamber ? Math.floorDiv(chunkX, 34) : isOceanruin ? Math.floorDiv(chunkX, 20) : chunkX >> 5;
        int regZ = isShip ? Math.floorDiv(chunkZ, 24) : isMansion ? Math.floorDiv(chunkZ, 80) : isChamber ? Math.floorDiv(chunkZ, 34) : isOceanruin ? Math.floorDiv(chunkZ, 20) : chunkZ >> 5;
        long mask = isShip ? 3 : isMansion ? 3 : isChamber ? 1 : isOceanruin ? 3 : 7;

        long newHalfSeed = ((halfSeed + regX * 341873128712L + regZ * 132897987541L + salt) ^ 25214903917L) & ((1L << 32) - 1);
        newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);
        if (isMansion) {
            long x1 = (newHalfSeed >> 17) & mask;
            newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);
            long x2 = (newHalfSeed >> 17) & mask;
            long x3 = 0;
            while (x3 < 59) {
                long x4 = 0;
                while (x4 < 59) {
                    if (((int)(x3 + x4) / 2) == (((chunkX%80)+80)%80)) {
                        if (x1 == (x3 & mask) && x2 == (x4 & mask)) {
                            newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);
                            long z1 = (newHalfSeed >> 17) & mask;
                            newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);
                            long z2 = (newHalfSeed >> 17) & mask;
                            long z3 = 0;
                            while (z3 < 59) {
                                long z4 = 0;
                                while (z4 < 59) {
                                    if (((int)(z3 + z4) / 2) == (((chunkZ)%80)+80)%80) {
                                        if (z1 == (z3 & mask) && z2 == (z4 & mask)) {
                                            return true;
                                        }
                                    }
                                    z4++;
                                }
                                z3++;
                            }
                            break;
                        }
                    }
                    x4++;
                }
                x3++;
            }
        }

        if (((newHalfSeed >> 17) & mask) == (chunkX & mask)) {
            newHalfSeed = (newHalfSeed * 25214903917L + 11) & ((1L << 32) - 1);
            return ((newHalfSeed >> 17) & mask) == (chunkZ & mask);
        }
        return false;
    }

    private boolean canActuallyGenerate(long fullSeed, int chunkX, int chunkZ, boolean isShip, boolean isRuinedPortal, boolean isAncient, boolean isMansion, boolean isChamber, boolean isVillage, boolean isOceanruin, boolean isMonument, boolean isNetherstructure) {
        int regX = (isRuinedPortal ? Math.floorDiv(chunkX, 40) : isShip ? Math.floorDiv(chunkX, 24) : isAncient ? Math.floorDiv(chunkX, 24) : isMansion ? Math.floorDiv(chunkX, 80) : isChamber ? Math.floorDiv(chunkX, 34) : isVillage ? Math.floorDiv(chunkX, 34) : isOceanruin ? Math.floorDiv(chunkX, 20) : isMonument ? Math.floorDiv(chunkX, 32) : isNetherstructure ? Math.floorDiv(chunkX, 23) : chunkX >> 5);
        int regZ = (isRuinedPortal ? Math.floorDiv(chunkZ, 40) : isShip ? Math.floorDiv(chunkZ, 24) : isAncient ? Math.floorDiv(chunkZ, 24) : isMansion ? Math.floorDiv(chunkZ, 80) : isChamber ? Math.floorDiv(chunkZ, 34) : isVillage ? Math.floorDiv(chunkZ, 34) : isOceanruin ? Math.floorDiv(chunkZ, 20) : isMonument ? Math.floorDiv(chunkZ, 32) : isNetherstructure ? Math.floorDiv(chunkZ, 23) : chunkZ >> 5);
        long mask = isRuinedPortal ? 25 : isShip ? 20 : isChamber ? 22 : isVillage ? 26 : isOceanruin ? 12 : isNetherstructure ? 23 : 24;
        long coordMask = isRuinedPortal ? 40 : isShip ? 24 : isChamber ? 34 : isVillage ? 34 : isOceanruin ? 20 : isNetherstructure ? 27 : 32;
        long newFullSeed = ((fullSeed + regX * 341873128712L + regZ * 132897987541L + salt) ^ 25214903917L) & ((1L << 48) - 1);
        if (isMansion) {
            newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
            long x1 = (newFullSeed >> 17) % 60;
            newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
            long x2 = (newFullSeed >> 17) % 60;
            long x = (x1 + x2) / 2;
            if (x == (((chunkX % 80) + 80) % 80)) {
                newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
                long z1 = (newFullSeed >> 17) % 60;
                newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
                long z2 = (newFullSeed >> 17) % 60;
                long z = (z1 + z2) / 2;
                return (z == (((chunkZ % 80) + 80) % 80));
            }
        }
        if (isMonument) {
            newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
            long x1 = (newFullSeed >> 17) % 27;
            newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
            long x2 = (newFullSeed >> 17) % 27;
            long x = (x1 + x2) / 2;
            if (x == (((chunkX % 32) + 32) % 32)) {
                newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
                long z1 = (newFullSeed >> 17) % 27;
                newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
                long z2 = (newFullSeed >> 17) % 27;
                long z = (z1 + z2) / 2;
                return (z == (((chunkZ % 32) + 32) % 32));
            }
        }
        if (isAncient) {
            newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
            if ((newFullSeed >> 44) == (((chunkX % 24) + 24) % 24)) {
                newFullSeed = ((newFullSeed * 25214903917L + 11) & ((1L << 48) - 1));
                if ((newFullSeed >> 44) == (((chunkZ % 24) + 24) % 24)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        newFullSeed = (newFullSeed * 25214903917L + 11) & ((1L << 48) - 1);
        if (((newFullSeed >> 17) % mask) == (((chunkX % coordMask) + coordMask) % coordMask)) {
            newFullSeed = (newFullSeed * 25214903917L + 11) & ((1L << 48) - 1);
            return ((((newFullSeed >> 17) % mask) + mask) % mask) == (((chunkZ % coordMask) + coordMask) % coordMask);
        }
        return false;
    }
    public boolean bedrock_canGenerate(long seed , boolean isTriangular,boolean isMansions, boolean isMonument, boolean isOutpost,boolean isPortal, boolean isShipwreck, boolean isShipwreck1_17, boolean isTreasure,boolean isVillage, boolean isVillage1_17){
        if(!isTriangular){
            for (int[] coord : coordinates) {
                if(!bedrock_isValidSeed(seed,coord[0],coord[1],false,false)){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }


    }
    private boolean bedrock_isValidSeed(long seed, int chunkX, int chunkZ,boolean isPortal,boolean isShipwreck){
        long regX = isPortal ? Math.floorDiv(chunkX,40) : isShipwreck ? Math.floorDiv(chunkX,24) : chunkX >> 5;
        long regZ = isPortal ? Math.floorDiv(chunkZ,40) : isShipwreck ? Math.floorDiv(chunkZ,24) : chunkZ >> 5;
        long mask = isPortal ? 40 : isShipwreck ? 24 : 32;
        long bound = isPortal ? 25 : isShipwreck ? 20 : 24;
        long regionSeed = regX * 341873128712L + regZ * 132897987541L + seed + salt;
        int[] mt = new int[629];
        int mti = 0;
        mt[0] = (int) regionSeed;
        for (mti = 1; mti < 622; mti += 8) {
            mt[mti] = 1812433253 * (mt[mti - 1] ^ (mt[mti - 1] >>> 30)) + mti;
            mt[mti + 1] = 1812433253 * (mt[mti] ^ (mt[mti] >>> 30)) + (mti + 1);
            mt[mti + 2] = 1812433253 * (mt[mti + 1] ^ (mt[mti + 1] >>> 30)) + (mti + 2);
            mt[mti + 3] = 1812433253 * (mt[mti + 2] ^ (mt[mti + 2] >>> 30)) + (mti + 3);
            mt[mti + 4] = 1812433253 * (mt[mti + 3] ^ (mt[mti + 3] >>> 30)) + (mti + 4);
            mt[mti + 5] = 1812433253 * (mt[mti + 4] ^ (mt[mti + 4] >>> 30)) + (mti + 5);
            mt[mti + 6] = 1812433253 * (mt[mti + 5] ^ (mt[mti + 5] >>> 30)) + (mti + 6);
            mt[mti + 7] = 1812433253 * (mt[mti + 6] ^ (mt[mti + 6] >>> 30)) + (mti + 7);
        }





        if (mti >= 624) {
            for (int k = 0; k < 227; k++) {
                int y = (mt[k] & 0x80000000) | (mt[k + 1] & 0x7fffffff);
                mt[k] = mt[k + 397] ^ (y >>> 1) ^ ((y & 1) * 0x9908b0df);
            }

            for (int k = 624-397; k < 624 - 1; k++) {
                int y = (mt[k] & 0x80000000) | (mt[k + 1] & 0x7fffffff);
                mt[k] = mt[k + (397 - 624)] ^ (y >>> 1) ^ ((y & 1) * 0x9908b0df);
            }
            int y = (mt[624 - 1] & 0x80000000) | (mt[0] & 0x7fffffff);
            mt[624 - 1] = mt[397 - 1] ^ (y >>> 1) ^ ((y & 1) * 0x9908b0df);
            mti = 0;
        }

        int y = mt[mti++];
        y ^= (y >>> 11);
        y ^= (y << 7) & 0x9d2c5680;
        y ^= (y << 15) & 0xefc60000;
        y ^= (y >>> 18);

        long randomValue = y & 0xFFFFFFFFL;
        int x = (int) (randomValue % bound);
        return(x == (((chunkX%mask)+mask)%mask));



    }
    private boolean bedrock_isValidSeedTriangular(){
        return false;
    }

}


class MainSeedfinder{
    public static boolean edition = false;


    public static void structureadder(String structureType, int chunkX, int chunkZ, StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, StructureChecker ruinedPortalChecker, StructureChecker ancientCityChecker, StructureChecker mansionChecker, StructureChecker chamberChecker, StructureChecker villageChecker, StructureChecker oceanruinChecker, StructureChecker buriedChecker, StructureChecker monumentChecker, StructureChecker trailruinChecker, StructureChecker structurefeatures1_12Checker, StructureChecker village1_17Checker, StructureChecker mineshaftChecker, StructureChecker bedrock_genericchecker, StructureChecker bedrock_mansionChecker, StructureChecker bedrock_monumentChecker, StructureChecker bedrock_outpostChecker, StructureChecker bedrock_portalChecker, StructureChecker bedrock_shipwreck1_17checker, StructureChecker bedrock_shipwreckChecker, StructureChecker bedrock_treasureChecker, StructureChecker bedrock_village1_17Checker, StructureChecker bedrock_villageChecker, StructureChecker Netherstructurechecker, StructureChecker slimechunkChecker) {

        List<Long> structureSeeds = new ArrayList<>();



        switch (structureType) {
            case "Deserttemple":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    desertTempleChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Jungletemple":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    jungleTempleChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Igloo":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    iglooChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Swamphut":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    swampHutChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Outpost":
                if (edition) {
                    bedrock_outpostChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    outpostChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Ship":
                if (edition) {
                    bedrock_shipwreckChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    shipwreckChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Portal":
                if (edition) {
                    bedrock_portalChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    ruinedPortalChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Ancientcity":
                if (edition) {
                    ancientCityChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    ancientCityChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Mansion":
                if (edition) {
                    bedrock_mansionChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    mansionChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Trialchamber":
                if (edition) {
                    chamberChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    chamberChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Village":
                if (edition) {
                    bedrock_village1_17Checker.addCoordinates(chunkX, chunkZ);
                } else {
                    villageChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Oceanruin":
                if (edition) {
                    oceanruinChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    oceanruinChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Treasure":
                if (edition) {
                    bedrock_treasureChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    buriedChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Monument":
                if (edition) {
                    bedrock_monumentChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    monumentChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Trailruin":
                if (edition) {
                    trailruinChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    trailruinChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Deserttemple 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX, chunkZ);
                break;
            case "Jungletemple 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX, chunkZ);
                break;
            case  "Igloo 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX, chunkZ);
                break;
            case "Swamphut 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX,chunkZ);
            case "Village 1.17-":
                if (edition) {
                    bedrock_village1_17Checker.addCoordinates(chunkX, chunkZ);
                } else {
                    village1_17Checker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Bastion":
                Netherstructurechecker.addCoordinates(chunkX, chunkZ);
                break;
            case "Fortress":
                Netherstructurechecker.addCoordinates(chunkX, chunkZ);
                break;
            case "Mineshaft":
                mineshaftChecker.addCoordinates(chunkX,chunkZ);
                break;
            case "Slimechunk":
                slimechunkChecker.addCoordinates(chunkX, chunkZ);
                break;
            default:
                System.out.println("Unknown structure type: " + structureType);
        }


    }
}



class MainSeedcracker {
    public static boolean printToFile = false;
    public static boolean edition = false;


    public static void structureadder(String structureType, int chunkX, int chunkZ, StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, StructureChecker ruinedPortalChecker, StructureChecker ancientCityChecker, StructureChecker mansionChecker, StructureChecker chamberChecker, StructureChecker villageChecker, StructureChecker oceanruinChecker, StructureChecker buriedChecker, StructureChecker monumentChecker, StructureChecker trailruinChecker, StructureChecker structurefeatures1_12Checker, StructureChecker village1_17Checker, StructureChecker mineshaftChecker, StructureChecker bedrock_genericchecker, StructureChecker bedrock_mansionChecker, StructureChecker bedrock_monumentChecker, StructureChecker bedrock_outpostChecker, StructureChecker bedrock_portalChecker, StructureChecker bedrock_shipwreck1_17checker, StructureChecker bedrock_shipwreckChecker, StructureChecker bedrock_treasureChecker, StructureChecker bedrock_village1_17Checker, StructureChecker bedrock_villageChecker, StructureChecker Netherstructurechecker, StructureChecker slimechunkChecker) {

        List<Long> structureSeeds = new ArrayList<>();



        switch (structureType) {
            case "Deserttemple":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    desertTempleChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Jungletemple":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    jungleTempleChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Igloo":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    iglooChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Swamphut":
                if (edition) {
                    bedrock_genericchecker.addCoordinates(chunkX, chunkZ);
                } else {
                    swampHutChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Outpost":
                if (edition) {
                    bedrock_outpostChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    outpostChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Ship":
                if (edition) {
                    bedrock_shipwreckChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    shipwreckChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Portal":
                if (edition) {
                    bedrock_portalChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    ruinedPortalChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Ancientcity":
                if (edition) {
                    ancientCityChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    ancientCityChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Mansion":
                if (edition) {
                    bedrock_mansionChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    mansionChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Trialchamber":
                if (edition) {
                    chamberChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    chamberChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Village":
                if (edition) {
                    bedrock_village1_17Checker.addCoordinates(chunkX, chunkZ);
                } else {
                    villageChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Oceanruin":
                if (edition) {
                    oceanruinChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    oceanruinChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Treasure":
                if (edition) {
                    bedrock_treasureChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    buriedChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Monument":
                if (edition) {
                    bedrock_monumentChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    monumentChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Trailruin":
                if (edition) {
                    trailruinChecker.addCoordinates(chunkX, chunkZ);
                } else {
                    trailruinChecker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Deserttemple 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX, chunkZ);
                break;
            case "Jungletemple 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX, chunkZ);
                break;
            case  "Igloo 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX, chunkZ);
                break;
            case "Swamphut 1.12-":
                structurefeatures1_12Checker.addCoordinates(chunkX,chunkZ);
            case "Village 1.17-":
                if (edition) {
                    bedrock_village1_17Checker.addCoordinates(chunkX, chunkZ);
                } else {
                    village1_17Checker.addCoordinates(chunkX, chunkZ);
                }
                break;
            case "Bastion":
                Netherstructurechecker.addCoordinates(chunkX, chunkZ);
                break;
            case "Fortress":
                Netherstructurechecker.addCoordinates(chunkX, chunkZ);
                break;
            case "Mineshaft":
                mineshaftChecker.addCoordinates(chunkX,chunkZ);
                break;
            case "Slimechunk":
                slimechunkChecker.addCoordinates(chunkX, chunkZ);
                break;
            default:
                System.out.println("Unknown structure type: " + structureType);
        }


    }


    public static class SeedCrackerTask extends RecursiveTask<Void> {
        private static final int THRESHOLD = 1024;
        private long pillarSeed;
        private long gateWay;
        private StructureChecker desertTempleChecker;
        private StructureChecker jungleTempleChecker;
        private StructureChecker iglooChecker;
        private StructureChecker swampHutChecker;
        private StructureChecker outpostChecker;
        private StructureChecker shipwreckChecker;
        private StructureChecker ruinedPortalChecker;
        private StructureChecker ancientCityChecker;

        private StructureChecker mansionChecker;

        private StructureChecker chamberChecker;

        private StructureChecker villageChecker;

        private StructureChecker oceanruinChecker;

        private StructureChecker buriedChecker;

        private StructureChecker monumentChecker;

        private StructureChecker trailruinChecker;

        private StructureChecker structurefeatures1_12checker;

        private StructureChecker village1_17Checker;
        private StructureChecker mineshaftChecker;

        private StructureChecker Netherstructurechecker;
        private StructureChecker slimechunkChecker;

        private boolean findStructureSeed;
        private List<Long> structureSeeds;
        private long start;
        private long end;

        public SeedCrackerTask(long pillarSeed, long gateWay, StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, StructureChecker ruinedPortalChecker, StructureChecker ancientCityChecker, StructureChecker mansionChecker, StructureChecker chamberChecker, StructureChecker villageChecker, StructureChecker oceanruinChecker, StructureChecker buriedChecker, StructureChecker monumentChecker, StructureChecker trailruinChecker, StructureChecker structurefeatures1_12checker, StructureChecker village1_17Checker,StructureChecker mineshaftChecker, StructureChecker Netherstructurechecker, StructureChecker slimechunkChecker, boolean findStructureSeed, List<Long> structureSeeds, long start, long end) {
            this.pillarSeed = pillarSeed;
            this.gateWay = gateWay;
            this.desertTempleChecker = desertTempleChecker;
            this.jungleTempleChecker = jungleTempleChecker;
            this.iglooChecker = iglooChecker;
            this.swampHutChecker = swampHutChecker;
            this.outpostChecker = outpostChecker;
            this.shipwreckChecker = shipwreckChecker;
            this.ruinedPortalChecker = ruinedPortalChecker;
            this.ancientCityChecker = ancientCityChecker;
            this.mansionChecker = mansionChecker;
            this.chamberChecker = chamberChecker;
            this.villageChecker = villageChecker;
            this.oceanruinChecker = oceanruinChecker;
            this.buriedChecker = buriedChecker;
            this.monumentChecker = monumentChecker;
            this.trailruinChecker = trailruinChecker;
            this.structurefeatures1_12checker = structurefeatures1_12checker;
            this.village1_17Checker = village1_17Checker;
            this.mineshaftChecker = mineshaftChecker;
            this.Netherstructurechecker = Netherstructurechecker;
            this.slimechunkChecker = slimechunkChecker;
            this.findStructureSeed = findStructureSeed;
            this.structureSeeds = structureSeeds;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Void compute() {
            if (end - start <= THRESHOLD) {
                for (long lowerBits = start; lowerBits < end; lowerBits++) {
                    long partialRandomInternalState = (pillarSeed << 16) + lowerBits;
                    long halfSeed = ((1540035429L * (1540035429L * partialRandomInternalState + 239479465L) + 239479465L) ^ 25214903917L) & 4294967295L;
                    if(lifting){
                        if (canGenerateAtAll(halfSeed)) {
                            if (gateWay != -1) {
                                long nextSeed = halfSeed ^ 25214903917L;
                                nextSeed = (nextSeed * 25214903917L + 11) & ((1L << 32) - 1);
                                if (((nextSeed >> 17) & 3) == (gateWay & 3)) {
                                    int amountofpartialseed = amountofpartialseeds.incrementAndGet();
                                    if(printPartialseeds){
                                        writeSeedToFile(2,halfSeed);
                                    }
                                    partialSeeds.add(halfSeed);
                                    SwingUtilities.invokeLater(() -> Seedcracker.partiallabel.setText("Partial bruteforce: Halfseed/s: " + partialSeeds));
                                    processHalfSeed(halfSeed);
                                }
                            } else {
                                if(printPartialseeds){
                                    writeSeedToFile(2,halfSeed);
                                }
                                int amountofpartialseed = amountofpartialseeds.incrementAndGet();
                                partialSeeds.add(halfSeed);
                                SwingUtilities.invokeLater(() -> Seedcracker.partiallabel.setText("Partial bruteforce: Halfseed/s: " + partialSeeds));
                                processHalfSeed(halfSeed);
                            }
                        }
                    }
                    else{
                        processHalfSeed(halfSeed);
                    }
                    int currentprogress = partialprogress.incrementAndGet();
                    if((currentprogress % 65536)==0){
                        SwingUtilities.invokeLater(() -> Seedcracker.partialbar.setValue(currentprogress));
                    }
                }
                return null;
            } else {
                long mid = (start + end) >>> 1;
                SeedCrackerTask left = new SeedCrackerTask(pillarSeed, gateWay, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12checker, village1_17Checker, mineshaftChecker, Netherstructurechecker, slimechunkChecker ,findStructureSeed, structureSeeds, start, mid);
                SeedCrackerTask right = new SeedCrackerTask(pillarSeed, gateWay, desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12checker, village1_17Checker, mineshaftChecker, Netherstructurechecker, slimechunkChecker ,findStructureSeed, structureSeeds, mid, end);
                invokeAll(left, right);
                return null;
            }
        }

        private void processHalfSeed(long halfSeed) {
            if (findStructureSeed) {
                crackStructureSeed(halfSeed);
            }
        }

        private boolean canGenerateAtAll(long halfSeed) {
            return desertTempleChecker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    jungleTempleChecker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    iglooChecker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    swampHutChecker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    outpostChecker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    village1_17Checker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    structurefeatures1_12checker.canGenerateAtAll(halfSeed, false, false, false, false) &&
                    oceanruinChecker.canGenerateAtAll(halfSeed, false, false, false, true) &&
                    shipwreckChecker.canGenerateAtAll(halfSeed, true, false, false, false) &&
                    trailruinChecker.canGenerateAtAll(halfSeed, false, false, true, false) &&//method to bitlift chambers can be applied to trailruins without any changes
                    chamberChecker.canGenerateAtAll(halfSeed, false, false, true, false) &&
                    villageChecker.canGenerateAtAll(halfSeed, false, false, true, false) &&//method to bitlift chambers can be applied to villages without any changes
                    slimechunkChecker.canGenerateSlimechunk(halfSeed, true)&&
                    mansionChecker.canGenerateAtAll(halfSeed, false, true, false, false);
        }

        private void crackStructureSeed(long halfSeed) {
            int othercurrentprogress = lastprogress.incrementAndGet();

            if ((othercurrentprogress % 655) == 0) {
                SwingUtilities.invokeLater(() -> Seedcracker.fullbar.setValue(othercurrentprogress));
            }

            for (long structureSeed = halfSeed; structureSeed < (1L << 48); structureSeed += (1L << 32)) {
                if (canActuallyGenerate(structureSeed)) {
                    long nextSeed = structureSeed ^ 25214903917L;
                    nextSeed = (nextSeed * 25214903917L + 11) & ((1L << 48) - 1);
                    if (((nextSeed >> 17) % 20) == gateWay || gateWay == -1) {
                        structureSeeds.add(structureSeed);
                        if(printStructureseeds){
                            writeSeedToFile(0,structureSeed);
                        }
                        SwingUtilities.invokeLater(()-> Seedcracker.fulllabel.setText("Complete bruteforce: Structureseed/s: " + structureSeeds));
                    }
                }
                int amountofpartialseed = amountofpartialseeds.get();
                if(lifting) {
                    long currentprogress = lastprogress.incrementAndGet();
                    if ((currentprogress % 6553) == 0) {
                        int newCurrentprogress = (int)(currentprogress / amountofpartialseed);
                        SwingUtilities.invokeLater(() -> Seedcracker.fullbar.setValue(newCurrentprogress));
                    }
                }

            }

        }

        private boolean canActuallyGenerate(long structureSeed) {
            return mansionChecker.canActuallyGenerate(structureSeed, false, false, false, true, false, false, false, false, false) &&
                    buriedChecker.canGenerateBuriedTreasure(structureSeed) &&
                    monumentChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, true, false) &&
                    villageChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, true, false, false, false) &&
                    trailruinChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, true, false, false, false) &&
                    ruinedPortalChecker.canActuallyGenerate(structureSeed, false, true, false, false, false, false, false, false, false) &&
                    desertTempleChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    jungleTempleChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    iglooChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    swampHutChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    outpostChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    village1_17Checker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    Netherstructurechecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, true) &&
                    chamberChecker.canActuallyGenerate(structureSeed, false, false, false, false, true, false, false, false, false) &&
                    shipwreckChecker.canActuallyGenerate(structureSeed, true, false, false, false, false, false, false, false, false) &&
                    structurefeatures1_12checker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    ancientCityChecker.canActuallyGenerate(structureSeed, false, false, true, false, false, false, false, false, false) &&
                    oceanruinChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, true, false, false)&&
                    mineshaftChecker.canGenerateMineshaft(structureSeed)&&
                    slimechunkChecker.canGenerateSlimechunk(structureSeed, false)&&
                    GatewayChecker.gatewayChecker(structureSeed);

        }
    }

    public static class SeedCrackerTaskNoPillars extends RecursiveTask<Void> {
        private static final long THRESHOLD = 1024L;
        private StructureChecker desertTempleChecker;
        private StructureChecker jungleTempleChecker;
        private StructureChecker iglooChecker;
        private StructureChecker swampHutChecker;
        private StructureChecker outpostChecker;
        private StructureChecker shipwreckChecker;
        private StructureChecker ruinedPortalChecker;

        private StructureChecker ancientCityChecker;

        private StructureChecker mansionChecker;
        private StructureChecker chamberChecker;

        private StructureChecker villageChecker;

        private StructureChecker oceanruinChecker;

        private StructureChecker buriedChecker;

        private StructureChecker monumentChecker;

        private StructureChecker trailruinChecker;

        private StructureChecker structurefeatures1_12Checker;

        private StructureChecker village1_17Checker;
        private StructureChecker mineshaftChecker;

        private StructureChecker bedrock_genericChecker;

        private StructureChecker bedrock_mansionChecker;

        private StructureChecker bedrock_monumentChecker;

        private StructureChecker bedrock_outpostChecker;

        private StructureChecker bedrock_portalChecker;

        private StructureChecker bedrock_shipwreck1_17Checker;

        private StructureChecker bedrock_shipwreckChecker;

        private StructureChecker bedrock_treasureChecker;

        private StructureChecker bedrock_village1_17Checker;

        private StructureChecker bedrock_villageChecker;

        private StructureChecker Netherstructurechecker;
        private StructureChecker slimechunkChecker;

        private long gateWay;
        private boolean findStructureSeed;
        private List<Long> structureSeeds;
        private long start;
        private long end;

        public SeedCrackerTaskNoPillars(StructureChecker desertTempleChecker, StructureChecker jungleTempleChecker, StructureChecker iglooChecker, StructureChecker swampHutChecker, StructureChecker outpostChecker, StructureChecker shipwreckChecker, StructureChecker ruinedPortalChecker, StructureChecker ancientCityChecker, StructureChecker mansionChecker, StructureChecker chamberChecker, StructureChecker villageChecker, StructureChecker oceanruinChecker, StructureChecker buriedChecker, StructureChecker monumentChecker, StructureChecker trailruinChecker, StructureChecker structurefeatures1_12Checker, StructureChecker village1_17Checker,StructureChecker mineshaftChecker, StructureChecker bedrock_genericChecker, StructureChecker bedrock_mansionChecker, StructureChecker bedrock_monumentChecker, StructureChecker bedrock_outpostChecker, StructureChecker bedrock_portalChecker, StructureChecker bedrock_shipwreck1_17Checker, StructureChecker bedrock_shipwreckChecker, StructureChecker bedrock_treasureChecker, StructureChecker bedrock_village1_17Checker, StructureChecker bedrock_villageChecker, StructureChecker Netherstructurechecker, StructureChecker slimechunkChecker, long gateWay, boolean findStructureSeed, List<Long> structureSeeds, long start, long end) {
            this.desertTempleChecker = desertTempleChecker;
            this.jungleTempleChecker = jungleTempleChecker;
            this.iglooChecker = iglooChecker;
            this.swampHutChecker = swampHutChecker;
            this.outpostChecker = outpostChecker;
            this.shipwreckChecker = shipwreckChecker;
            this.ruinedPortalChecker = ruinedPortalChecker;
            this.ancientCityChecker = ancientCityChecker;
            this.mansionChecker = mansionChecker;
            this.chamberChecker = chamberChecker;
            this.villageChecker = villageChecker;
            this.oceanruinChecker = oceanruinChecker;
            this.buriedChecker = buriedChecker;
            this.monumentChecker = monumentChecker;
            this.trailruinChecker = trailruinChecker;
            this.structurefeatures1_12Checker = structurefeatures1_12Checker;
            this.village1_17Checker = village1_17Checker;
            this.mineshaftChecker = mineshaftChecker;
            this.bedrock_genericChecker = bedrock_genericChecker;
            this.bedrock_mansionChecker = bedrock_mansionChecker;
            this.bedrock_monumentChecker = bedrock_monumentChecker;
            this.bedrock_outpostChecker = bedrock_outpostChecker;
            this.bedrock_portalChecker = bedrock_portalChecker;
            this.bedrock_shipwreck1_17Checker = bedrock_shipwreck1_17Checker;
            this.bedrock_shipwreckChecker = bedrock_shipwreckChecker;
            this.bedrock_treasureChecker = bedrock_treasureChecker;
            this.bedrock_village1_17Checker = bedrock_village1_17Checker;
            this.bedrock_villageChecker = bedrock_villageChecker;
            this.Netherstructurechecker = Netherstructurechecker;
            this.slimechunkChecker = slimechunkChecker;
            this.gateWay = gateWay;
            this.findStructureSeed = findStructureSeed;
            this.structureSeeds = structureSeeds;
            this.start = start;
            this.end = end;
        }

        @Override
        protected Void compute() {
            List<Long> validSeeds = new ArrayList<>();
            if (edition) {
                float startTime = System.nanoTime();
                for (long halfseed = 3271699702L; halfseed < end; halfseed++) {
                    if (halfseed == 10000000) {
                        float stopTime = System.nanoTime() - startTime;
                        System.out.println("10 mil" + (stopTime / 1_000_000_000));
                    }
                    if (bedrock_canGenerate(halfseed)) {
                        System.out.println("Bedrock Halfseed:" + halfseed);
                    }
                }
                return null;

            } else if (end - start <= THRESHOLD) {
                for (long lower20bits = start; lower20bits < end; lower20bits++) {
                    if (canGenerateAtAll(lower20bits)) {
                        long nextSeed = lower20bits ^ 25214903917L;
                        nextSeed = (nextSeed * 25214903917L + 11) & ((1L << 32) - 1);
                        if (((nextSeed >> 17) & 3) == (gateWay & 3) || gateWay == -1) {
                            if(printPartialseeds){
                                writeSeedToFile(1,lower20bits);
                            }
                            validSeeds.add(lower20bits);
                            int amount = amountofpartialseeds.incrementAndGet();
                        }
                    }
                    int currentprogress = Seedcracker.partialprogress.incrementAndGet();
                    SwingUtilities.invokeLater(() -> Seedcracker.partialbar.setValue(currentprogress));
                }

                if (!validSeeds.isEmpty()) {
                    crackStructureSeeds(validSeeds);
                }
                return null;

            } else {
                long mid = (start + end) >>> 1;
                SeedCrackerTaskNoPillars left = new SeedCrackerTaskNoPillars(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericChecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17Checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker, gateWay, findStructureSeed, structureSeeds, start, mid);
                SeedCrackerTaskNoPillars right = new SeedCrackerTaskNoPillars(desertTempleChecker, jungleTempleChecker, iglooChecker, swampHutChecker, outpostChecker, shipwreckChecker, ruinedPortalChecker, ancientCityChecker, mansionChecker, chamberChecker, villageChecker, oceanruinChecker, buriedChecker, monumentChecker, trailruinChecker, structurefeatures1_12Checker, village1_17Checker, mineshaftChecker, bedrock_genericChecker, bedrock_mansionChecker, bedrock_monumentChecker, bedrock_outpostChecker, bedrock_portalChecker, bedrock_shipwreck1_17Checker, bedrock_shipwreckChecker, bedrock_treasureChecker, bedrock_village1_17Checker, bedrock_villageChecker, Netherstructurechecker, slimechunkChecker, gateWay, findStructureSeed, structureSeeds, mid, end);
                invokeAll(left, right);
                return null;
            }
        }

        private void processHalfSeed(long lower20bits) {
            partialSeeds.add(lower20bits);
            SwingUtilities.invokeLater(()-> Seedcracker.partiallabel.setText("Partial bruteforce: Liftseed/s: " + partialSeeds));
            if (findStructureSeed) {
                crackStructureSeed(lower20bits);
            }
        }

        private void crackStructureSeeds(List<Long> validSeeds) {

            ExecutorService executorService = Executors.newFixedThreadPool(4);
            List<Future<?>> futures = new ArrayList<>();
            for (Long seed : validSeeds) {
                executorService.submit(() -> {
                    processHalfSeed(seed);
                });
            }


            for (Future<?> future : futures) {
                try {
                    future.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }

            executorService.shutdown();
        }

        private boolean canGenerateAtAll(long lower20bits) {
            return desertTempleChecker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    jungleTempleChecker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    iglooChecker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    swampHutChecker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    outpostChecker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    village1_17Checker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    structurefeatures1_12Checker.canGenerateAtAll(lower20bits, false, false, false, false) &&
                    oceanruinChecker.canGenerateAtAll(lower20bits, false, false, false, true) &&
                    shipwreckChecker.canGenerateAtAll(lower20bits, true, false, false, false) &&
                    trailruinChecker.canGenerateAtAll(lower20bits, false, false, true, false) &&//method to bitlift chambers can be applied to trailruins without any changes
                    chamberChecker.canGenerateAtAll(lower20bits, false, false, true, false) &&
                    villageChecker.canGenerateAtAll(lower20bits, false, false, true, false) &&//method to bitlift chambers can be applied to villages without any changes
                    slimechunkChecker.canGenerateSlimechunk(lower20bits, true)&&
                    mansionChecker.canGenerateAtAll(lower20bits, false, true, false, false);
        }

        private void crackStructureSeed(long lower20bits) {
            for (long structureSeed = lower20bits; structureSeed < (1L << 48); structureSeed += (1L << 20)) {
                if (canActuallyGenerate(structureSeed)) {
                    long nextSeed = structureSeed ^ 25214903917L;
                    nextSeed = (nextSeed * 25214903917L + 11) & ((1L << 48) - 1);
                    if (((nextSeed >> 17) % 20) == gateWay || gateWay == -1) {
                        structureSeeds.add(structureSeed);
                        if(printStructureseeds){
                            writeSeedToFile(0,structureSeed);
                        }
                        SwingUtilities.invokeLater(()-> Seedcracker.fulllabel.setText("Complete bruteforce: Structureseed/s: "+structureSeeds));
                    }
                }
                long currentprogress = lastprogress.incrementAndGet();
                if((currentprogress%2684354)==0) {
                    int amountofpartialseed = amountofpartialseeds.get();
                    int actualprogress = (int)(currentprogress/amountofpartialseed);
                    SwingUtilities.invokeLater(() -> Seedcracker.fullbar.setValue(actualprogress));
                }
            }
        }

        private boolean canActuallyGenerate(long structureSeed) {
            return mansionChecker.canActuallyGenerate(structureSeed, false, false, false, true, false, false, false, false, false) &&
                    buriedChecker.canGenerateBuriedTreasure(structureSeed) &&
                    monumentChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, true, false) &&
                    villageChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, true, false, false, false) &&
                    trailruinChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, true, false, false, false) &&
                    ruinedPortalChecker.canActuallyGenerate(structureSeed, false, true, false, false, false, false, false, false, false) &&
                    desertTempleChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    jungleTempleChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    iglooChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    swampHutChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    outpostChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    village1_17Checker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    Netherstructurechecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, true) &&
                    chamberChecker.canActuallyGenerate(structureSeed, false, false, false, false, true, false, false, false, false) &&
                    shipwreckChecker.canActuallyGenerate(structureSeed, true, false, false, false, false, false, false, false, false) &&
                    structurefeatures1_12Checker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, false, false, false) &&
                    ancientCityChecker.canActuallyGenerate(structureSeed, false, false, true, false, false, false, false, false, false) &&
                    oceanruinChecker.canActuallyGenerate(structureSeed, false, false, false, false, false, false, true, false, false)&&
                    mineshaftChecker.canGenerateMineshaft(structureSeed)&&
                    slimechunkChecker.canGenerateSlimechunk(structureSeed, false)&&
                    GatewayChecker.gatewayChecker(structureSeed);
        }

        private boolean bedrock_canGenerate(long halfSeed) {
            return bedrock_genericChecker.bedrock_canGenerate(halfSeed, false, false, false, false, false, false, false, false, false, false);
        }
    }

    }
}

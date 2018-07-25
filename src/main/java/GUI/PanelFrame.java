package GUI;

import Transition.CommandChannel;

import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Color;

import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;

public class PanelFrame extends JFrame {

    private final static int PRE_WIDTH = 500;
    private final static int PRE_HEIGHT = 400;
    private final static int PRE_TEXT_HEIGHT = 100;
    private final static int[] DIGITS = new int[]{7, 8, 9, 4, 5, 6, 1, 2, 3, 0};

    private StringBuilder sb;
    private ActionListener changeInfo;
    private JTextField info;
    private CommandChannel channel;

    public PanelFrame(CommandChannel channel){
        this.setTitle("Room Control Panel");
        this.setSize(PanelFrame.PRE_WIDTH, PanelFrame.PRE_HEIGHT);
        this.setResizable(false);

        this.channel = channel;
        sb = new StringBuilder();

        // Base Panel
        JPanel basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout(10, 5));
        basePanel.setPreferredSize(new Dimension(PanelFrame.PRE_WIDTH, PanelFrame.PRE_HEIGHT));

        // TextField Panel
        JPanel textPanel = new JPanel();
        textPanel.add(this.info = getTextField());
        textPanel.setPreferredSize(new Dimension(PanelFrame.PRE_WIDTH, PanelFrame.PRE_TEXT_HEIGHT));

        // Buttons Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3, 5, 5));
        List<JButton> digitButtons = this.getDigitButtons();
        for(JButton button : digitButtons)
            buttonPanel.add(button);
        buttonPanel.add(this.getConfirmButton());
        buttonPanel.add(this.getClearButton());

        basePanel.add(textPanel, BorderLayout.NORTH);
        basePanel.add(buttonPanel, BorderLayout.CENTER);

        this.add(basePanel);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private JTextField getTextField(){
        JTextField info = new JTextField(channel.getInfo(), 20);

        GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontName = e.getAvailableFontFamilyNames();
        for (int i = 0; i < fontName.length; i++) {
            if(fontName[i].equals("微软雅黑")){
                Font font = new Font("微软雅黑", Font.BOLD, 25);
                info.setFont(font);   //设置字体
                System.out.println("字体设置: 微软雅黑");
                break;
            }
        }

        info.setPreferredSize(new Dimension(PanelFrame.PRE_WIDTH, PanelFrame.PRE_TEXT_HEIGHT));
        info.setEditable(false);
        return info;
    }

    private List<JButton> getDigitButtons(){
        List<JButton> digitButtons = new ArrayList<JButton>(10);
        for(int digit : PanelFrame.DIGITS){
            JButton digitButton = new JButton(""+digit);
            digitButton.setForeground(Color.blue);
            digitButton.addActionListener(getChangeInfo());
            digitButton.addActionListener((e) ->
            {
                if(sb.toString().equals(channel.getInfo())){
                    sb.setLength(0);
                }
                sb.append(digit);
            });
            digitButtons.add(digitButton);
        }
        return digitButtons;
    }

    private JButton getConfirmButton(){
        JButton confirm = new JButton("Confirm");
        confirm.setForeground(Color.red);
        confirm.addActionListener(getChangeInfo());
        confirm.addActionListener((event) -> {channel.sendByName(sb.toString()); sb.setLength(0); sb.append(channel.getInfo());});
        return confirm;
    }

    private JButton getClearButton(){
        JButton clear = new JButton("Clear");
        clear.setForeground(Color.red);
        clear.addActionListener(getChangeInfo());
        clear.addActionListener((e) -> sb.setLength(0));
        return clear;
    }

    private ActionListener getChangeInfo(){
        if(changeInfo == null){
            changeInfo = (event) ->{ info.setText(sb.toString());};
        }
        return changeInfo;
    }
}

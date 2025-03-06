/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MiscItem.swing;

import raven.alerts.MessageAlerts;
import raven.toast.Notifications;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.*;

/**
 *
 * @author RATUL
 */
public class FileLoader {
    
    public FileLoader(){
        
    }
    public static void loadFile(String description, JTextArea display, Component parent){
        JFileChooser chooser=new JFileChooser();
        chooser.addChoosableFileFilter(new FileNameExtensionFilter("Txt files", "txt"));
        chooser.setDialogTitle(description);
        int action = chooser.showOpenDialog(parent);
        if(action==JFileChooser.APPROVE_OPTION){
            File file=chooser.getSelectedFile();
            String path=file.getAbsolutePath();
            try {
                FileReader fr=new FileReader(path);
                BufferedReader br=new BufferedReader(fr);
                display.read(br, null);
                br.close();
            } catch (FileNotFoundException e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "File is not found.Please try again");
            } catch (IOException e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Error occurred while reading file. Please try again");
            }
        }

    }



    public static boolean saveFile(String description, Component parent){
        File file =showFileChooser(parent);
        boolean flag=false;

        if(file!=null){
            try{
                File path= new File(file.getAbsolutePath()+".txt");
                FileWriter fw = new FileWriter(path);
                fw.write(description);
                fw.flush();
                fw.close();
                flag=true;
            }
            catch (Exception e){
                Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Error while saving the text file. The File is not found ");
            }
        }
        return flag;
    }
    
    private static File showFileChooser(Component parent) {
        JFileChooser ch = new JFileChooser();
        int opt = ch.showSaveDialog(parent);
        if (opt == JFileChooser.APPROVE_OPTION) {
            return ch.getSelectedFile();
        } else {
            return null;
        }
    }

    public static void saved(String description, Component parent){
        if(saveFile(description, parent)){
            MessageAlerts.getInstance().showMessage("SUCCESSFULLY SAVED FILE", "Your Message has been saved Successfully as a text file.", MessageAlerts.MessageType.SUCCESS);
        }
        else {
            MessageAlerts.getInstance().showMessage("Failed to Save", "We are failed to save your message please try agian. Please try again later.", MessageAlerts.MessageType.ERROR);
        }
    }


}

package com.UnicSoftware.BoE.config;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import org.simpleyaml.configuration.file.YamlFile;

public class ConfigParser{
	int cellX,cellY,CellCount;
	public ConfigParser(int cellX, int cellY, int CellCount){
		this.CellCount = CellCount;
		this.cellX = cellX;
		this.cellY = cellY;
		
		
	
	     // Create new YAML file with relative path
        final YamlFile yamlFile = new YamlFile("resources/mapdata.yml");

        // Load the YAML file if is already created or create new one otherwise
        try {
            if (!yamlFile.exists()) {
                yamlFile.createNewFile();
           
                JOptionPane.showMessageDialog(null, "The file has been created: " + yamlFile.getFilePath() + "\n");
            } else {
                
            	JOptionPane.showMessageDialog(null,yamlFile.getFilePath() + " already exists, loading configurations...\n");
            }
            yamlFile.load(); // Loads the entire file
            // If your file has comments inside you have to load it with yamlFile.loadWithComments()
        } catch (final Exception e) {
            e.printStackTrace();
        }
        for (int x = 0; x != cellX; x++) {
			yamlFile.set("map.cell.x", x);
		
			}
        for (int y = 0; y != cellY; y++) {
        	yamlFile.set("map.cell.y", y);
		}
			
        
        final List<Integer> ints = yamlFile.getIntegerList("map.cell.x");
        for(int i : ints) {
        	System.out.print(i);
        }
    
        // Finally, save changes!
        try {
            yamlFile.save();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        // Now, you can restart this test and see how the file is loaded due to it's already created

        // You can delete the generated file uncommenting next line and catching the I/O Exception
        // yamlFile.deleteFile();
    }
}
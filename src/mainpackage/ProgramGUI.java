package mainpackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProgramGUI implements ActionListener  {
    // setup your instance variables
    private String compositionName = "";
    private String composerName = "";
    private String yearPublication = "";
    private String withoutMusic = "";
    // this is using a basic Swing GUI
    //1st phrase
    // create a GUI that you can type in the name of the piece of music, composer, date and if you know it well.
    // once the user has typed in there information, they can click the add button which will add to the arraylist
    //this will have validation
    //second
    // at the next section there will be a change record option, which will you to enter the piece of music and
    // once you click search, it will show the record on the console and you can use the textboxes below to change
    // the value you want changed.

    /*
    project did not complete, due to the usefulness of the program and problems with the data structure used, maybe hashtable may of been better.
     */

    // setup your instance variables
    private static JTextField compositionNameTextField;
    private static JTextField composerNameTextField;
    private static JTextField publicationYearTextField;
    private static JTextField withoutMusicTextField;
    private static JLabel successAdded;
    private static JButton addButton;
    private static JButton searchButton;
    private static JTextField searchTextField;
    private static JLabel searchResultsTextField;

    // create a array list and pass it the music compositions object
    private ArrayList<String> musicCompositions = new ArrayList<String>();

    public void setupGUI(){
        // create an instance of the of JFrame and the JPanel to use it
        // set the size of the panel (layout)
        JPanel myPanel = new JPanel();
        // this will setup the size of the window frame
        JFrame myFrame = new JFrame();
        // this will set the height of the frame
        myFrame.setSize(500, 600);
        // this will close the frame, once the program has exited
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // add the panel to the frame
        myFrame.add(myPanel);
        //configure the panel
        myPanel.setLayout(null);

        // create the label for the top of the panel
        JLabel titleLabel = new JLabel("Music Organiser");
        // this will set the size of the font to a larger size and set as bold
        titleLabel.setFont(titleLabel.getFont().deriveFont(Font.BOLD, 20));
        // set the x, y, width and height of the title
        titleLabel.setBounds(170, 20, 200, 30);
        // add the label to the panel
        myPanel.add(titleLabel);

        // set the label of the name of composition textbox
        JLabel compositionNameLabel = new JLabel("Name of composition: ");
        // set the x, y, width and height of the name label
        compositionNameLabel.setBounds(60, 80, 150, 20);
        // add the label to the panel
        myPanel.add(compositionNameLabel);

        // set the text field for the name of comp and set the length of text field
        compositionNameTextField = new JTextField(40);

        // set the position of the text field
        compositionNameTextField.setBounds(200, 80, 150, 20);
        // add it to the panel
        myPanel.add(compositionNameTextField);

        // set your label for the composer
        JLabel composerNameLabel = new JLabel("Name of composer: ");
        // set the x, y, width and height of the name label
        composerNameLabel.setBounds(60, 110, 150, 20);
        // add the label to the panel
        myPanel.add(composerNameLabel);

        // set the text box for the composer
        composerNameTextField = new JTextField(40);
        // set the position of the text field
        composerNameTextField.setBounds(200, 110, 150, 20);
        // add it to the panel
        myPanel.add(composerNameTextField);

        // create the label for the year
        JLabel dateLabel = new JLabel("Year of publication: ");
        // set the x, y, width and height of the name label
        dateLabel.setBounds(60, 140, 150, 20);
        // add the label to the panel
        myPanel.add(dateLabel);

        // set the text box for the year of publication
        publicationYearTextField = new JTextField(40);
        // set the position of the text field
        publicationYearTextField.setBounds(200, 140, 150, 20);
        // add it to the panel
        myPanel.add(publicationYearTextField);

        // create label for do you know the piece without music?
        JLabel withoutMusicLabel = new JLabel("Do you know without music? ");
        // set the x, y, width and height of the name label
        withoutMusicLabel.setBounds(60, 170, 180, 20);
        // add the label to the panel
        myPanel.add(withoutMusicLabel);

        // set the text box for know without music
        withoutMusicTextField = new JTextField(40);
        // set the position of the text field
        withoutMusicTextField.setBounds(250, 170, 100, 20);
        // add it to the panel
        myPanel.add(withoutMusicTextField);

        // set the add the button
        addButton = new JButton("Add to file");
        // set the position of the button
        addButton.setBounds(170, 220, 120, 20);
        // add the action listener for the button to work
        addButton.addActionListener(new ProgramGUI());
        // add the button to the panel
        myPanel.add(addButton);

        // create a successfully added message
        successAdded = new JLabel("");
        successAdded.setBounds(170, 250, 250, 20);
        myPanel.add(successAdded);

        // set the text box for the search piece
        searchTextField = new JTextField(40);
        // set the position of the text field
        searchTextField.setBounds(60, 280, 150, 20);
        // add it to the panel
        myPanel.add(searchTextField);

        // set the search the button
        searchButton = new JButton("Search");
        // set the position of the button
        searchButton.setBounds(220, 280, 80, 20);
        // add the action listener for the button to work
        searchButton.addActionListener(new ProgramGUI());
        // add the button to the panel
        myPanel.add(searchButton);

        // have a label to show the information searched for
        searchResultsTextField = new JLabel("");
        // set the position of the text field
        searchResultsTextField.setBounds(60, 320, 250, 20);
        // add it to the panel
        myPanel.add(searchResultsTextField);

        // the composition label to enter the composition name to reenter
        JLabel compositionNameUpdateLabel = new JLabel("Composition name: ");
        // set the x, y, width and height of the name label
        compositionNameUpdateLabel.setBounds(60, 360, 180, 20);
        // add the label to the panel
        myPanel.add(compositionNameUpdateLabel);

        // have a text box to show the information searched for
        JTextField compositionNameUpdateTextBox = new JTextField(40);
        // set the position of the text field
        compositionNameUpdateTextBox.setBounds(180, 360, 150, 20);
        // add it to the panel
        myPanel.add(compositionNameUpdateTextBox);

        // create a label to enter composer
        JLabel composerNameUpdateLabel = new JLabel("Composer name: ");
        // set the x, y, width and height of the name label
        composerNameUpdateLabel.setBounds(60, 390, 180, 20);
        // add the label to the panel
        myPanel.add(composerNameUpdateLabel);

        // have a textbox to reenter the information to update
        JTextField composerNameUpdateTextBox = new JTextField(40);
        // set the position of the text field
        composerNameUpdateTextBox.setBounds(180, 390, 150, 20);
        // add it to the panel
        myPanel.add(composerNameUpdateTextBox);

        // the label to let the user know
        JLabel publicationYearUpdateLabel = new JLabel("Year of publication: ");
        // set the x, y, width and height of the name label
        publicationYearUpdateLabel.setBounds(60, 420, 180, 20);
        // add the label to the panel
        myPanel.add(publicationYearUpdateLabel);

        // have a textbox to reenter the information to update
        JTextField publicationYearUpdateTextBox = new JTextField(40);
        // set the position of the text field
        publicationYearUpdateTextBox.setBounds(180, 420, 150, 20);
        // add it to the panel
        myPanel.add(publicationYearUpdateTextBox);

        // the do you know the music label reentry
        JLabel doYouKnowUpdateLabel = new JLabel("Do you know the music?: ");
        // set the x, y, width and height of the name label
        doYouKnowUpdateLabel.setBounds(60, 450, 180, 20);
        // add the label to the panel
        myPanel.add(doYouKnowUpdateLabel);

        // have a textbox to reenter the information to update
        JTextField doYouKnowUpdateTextBox = new JTextField(40);
        // set the position of the text field
        doYouKnowUpdateTextBox.setBounds(230, 450, 100, 20);
        // add it to the panel
        myPanel.add(doYouKnowUpdateTextBox);

        // set the update the button
        JButton updateButton = new JButton("Update");
        // set the position of the button
        updateButton.setBounds(170, 480, 120, 20);
        // add the action listener for the button to work
        updateButton.addActionListener(new ProgramGUI());
        // add the button to the panel
        myPanel.add(updateButton);


        // set the frame to visible (placed at the bottom)
        myFrame.setVisible(true);
    }

    // when the add button is clicked, this method will run
    @Override
    public void actionPerformed(ActionEvent e) throws NullPointerException
    {

        if(e.getSource() == addButton){
            // call the validate input method to check if all the inputs are correct.
            validateInput();
            // call the write to file method
            writeToFile();
        }
        else if(e.getSource() == searchButton) {
           // you must fill the array list with the contents of the file
            try {
                fillArray();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            // search each line array of the array list for a match
            searchArray();
    }


    }
    // this return the contents of the array
    private ArrayList<String> getMusic(){
        return musicCompositions;
    }
    // fill in the remaining music from the file
    private void fillArray() throws FileNotFoundException {

       // File myReader = new File("compositionfile.txt");
        try {
           // get access to the file
            File myFile = new File("compositionfile.txt");
            Scanner fileReader = new Scanner(myFile);

            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
               // add each line from the file to the arraylist
                musicCompositions.add(data);
            }
            // close the reader
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    private void searchArray(){

        /*
        search the arraylist to see if the search matches the the content, this function failed due to stopping of continuation of the project
         */
        int i = 0;

        for(String c : musicCompositions){
            i++;
            // you have already converted the object to a string, that was one of the main issues with your code
            // you want to convert it to an array, so you can access the
          //  String[] empty = new String[100];
           // empty[i] = c;



         //   String[] composeIndex = c;
           // System.out.println(composeIndex);
            if(searchTextField.getText().contains(c)){
                searchResultsTextField.setText(c);
            } else{
                searchResultsTextField.setText("none");
            }


           // searchResultsTextField.setText(String.valueOf(c));

          //  System.out.println(c);
          //  if(searchTextField.getText().equals(String.valueOf(c))){

          //  }
        }

    }
    private void writeToFile()
    {
        try {

            // create a new file to access the logfile
            File compositionFile = new File("compositionfile.txt");

            // this will prevent the file from being overwritten, it will pass in the file and a boolean value
            FileWriter myWriter = new FileWriter(compositionFile,true);

            // this will go to each line in the array list and replace the square brackets with nothing, to be more human readble and make sure the hashcode does not show
            for(String m: musicCompositions)
            {

                myWriter.write(String.valueOf(m).replace("[", "").replace("]", "") + '\n');
            }
            // this will prevent the contents of the arraylist to be added, if the user adds more items
            musicCompositions.clear();
            // close the writer
            myWriter.close();

            System.out.println("Successfully wrote to the file.");
        } catch (IOException es)
        {
            System.out.println("An error occurred.");
            es.printStackTrace();
        }
        // System.out.print(compositionName + composerName + yearPublication + withoutMusic);
        for(String d: musicCompositions)
        {
            System.out.println(d);
        }
    }


    private void validateInput(){

        // each of these variables will gain access to the individual text fields.
        compositionName = compositionNameTextField.getText();
        composerName = composerNameTextField.getText();
        yearPublication = publicationYearTextField.getText();
        withoutMusic = withoutMusicTextField.getText();

        // this boolean variable is used, as a conditions if the form is filled or not
        boolean isFilled = false;

        try
        {
            // this will makes sure there is a value entered in one of the text fields
            if(compositionName.isEmpty() || composerName.isEmpty() || yearPublication.isEmpty() || withoutMusic.isEmpty())
            {
                successAdded.setText("");
                successAdded.setText("No values entered in one text fields");
            }
            else
                {
                successAdded.setText("");
                isFilled = true;
                }

            // check if all conditions been met
            if(isFilled == true)
            {
                // create a new constructor, so you can add in each of the values to make up the array from the music composition class.
                musicCompositions.add( new MusicCompositions(compositionName, composerName, yearPublication, withoutMusic).toString());
                // this will let the user know it has been successful
                successAdded.setText("The composition added");
            }
        } catch (NullPointerException n)
        {
            System.out.print("Error has occurred");
        }
    }


}

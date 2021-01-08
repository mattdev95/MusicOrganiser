package mainpackage;

import java.util.ArrayList;

// create a music object that you add all the values of the textboxes to and you can then add the object to the array list
// Need to remove whitespace, will do this soon.
public class MusicCompositions extends ProgramGUI  {
    // setup your instance variables
    private String compositionName;
    private String composerName;
    private String todayDate;
    private String areFluent;

    //
  //  private ArrayList<MusicCompositions> musicCompositions = new ArrayList<>();

    // create a constructor
    public MusicCompositions(String compositionName, String composerName, String todayDate, String areFluent)
    {
        // this will ensure any Music composition object will be a bad state in memory
        setCompositionName(compositionName);
        setComposerName(composerName);
        setTodayDate(todayDate);
        setAreFluent(areFluent);

    }
    // overloaded constructor
    public MusicCompositions(String todayDate, String areFluent)
    {
        // get a reference from the first Music compostion object
        // do not remove the empty strings, they are to replace the empty parameters
        this("", "", todayDate, areFluent);

    }
    // this will return the composition name if called
    private String getCompositionName(){
        return compositionName;
    }

    // this will set the composition name in the constructor to the composition name specified
    private void setCompositionName(String compositionName) {
        if(compositionName.isEmpty()){
            // if there are no value entered in the text box
            throw new IllegalArgumentException("There are no values");
        }
        else {
            this.compositionName = compositionName;
        }

    }

    // this will return the composer name
    private String getComposerName(){
        return composerName;
    }

    // this will set the composer name to name in the parentheses
    private void setComposerName(String composerName){
        if(compositionName.isEmpty()){
            // if there are no value entered in the text box
            throw new IllegalArgumentException("There are no values");
        }
        else {
            this.composerName = composerName;
        }

    }



    // this will get the current today date input
    private String getTodayDate(){
        return todayDate;
    }

    // this will set the today's date
    private void setTodayDate(String todayDate){
        if(compositionName.isEmpty()){
            // if there are no value entered in the text box
            throw new IllegalArgumentException("There are no values");
        }
        else {
            this.todayDate = todayDate;
        }

    }

    // this will get the current are fluent input.
    private String getAreFluent(){
        return areFluent;
    }

    // this will get the are fluent.
    private void setAreFluent(String areFluent){
        if(compositionName.isEmpty()){
            // if there are no value entered in the text box
            throw new IllegalArgumentException("There are no values");
        }
        else {
            this.areFluent = areFluent;
        }

    }

    // this will prevent hashcode from appearing when being written to file
    @Override
    public String toString() {
        return (getCompositionName() + ", " + getComposerName() + ", " + getTodayDate() + ", " +
                getAreFluent());
    }

}

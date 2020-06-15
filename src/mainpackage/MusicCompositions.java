package mainpackage;

// create a music object that you add all the values of the textboxes to and you can then add the object to the array list
public class MusicCompositions  {
    // setup your instance variables
    private String compositionName;
    private String composerName;
    private String todayDate;
    private String areFluent;

    // create a constructor
    public MusicCompositions(String compositionName, String composerName, String todayDate, String areFluent)
    {
        this.compositionName = compositionName;
        this.composerName = composerName;
        this.todayDate = todayDate;
        this.areFluent = areFluent;

    }
    // this will return the composition name if called
    private String getCompositionName(){
        return compositionName;
    }

    // this will set the composition name in the constructor to the composition name specified
    private void setCompositionName(String compositionName){
        this.compositionName = compositionName;
    }

    // this will return the composer name
    private String getComposerName(){
        return composerName;
    }

    // this will set the composer name to name in the parentheses
    private void setComposerName(String composerName){
        this.composerName = composerName;
    }

    // this will get the current today date input
    private String getTodayDate(){
        return todayDate;
    }

    // this will set the today's date
    private void setTodayDate(String todayDate){
        this.todayDate = todayDate;
    }

    // this will get the current are fluent input.
    private String getAreFluent(){
        return areFluent;
    }

    // this will get the are fluent.
    private void setAreFluent(String areFluent){
        this.areFluent = areFluent;
    }

    // this will prevent hashcode from appearing when being written to file
    @Override
    public String toString() {
        return (getCompositionName() + ", " + getComposerName() + ", " + getTodayDate() + ", " +
                getAreFluent());
    }

}
